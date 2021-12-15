package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	ChromeOptions co;
	FirefoxOptions fo;
	Properties prop;
	
	public OptionManager(Properties prop) {
		this.prop=prop;
	}
	
	
	
	public ChromeOptions getchromeOptions() {
		co=new ChromeOptions();
		co.setHeadless(Boolean.parseBoolean(prop.getProperty("headless")));
		if( Boolean.parseBoolean(prop.getProperty("inconito"))) co.addArguments("--incognito");
		return co;
	}
	
	public FirefoxOptions getfirefoxOptions() {
		fo=new FirefoxOptions();
		fo.setHeadless(Boolean.parseBoolean(prop.getProperty("headless")));
		if( Boolean.parseBoolean(prop.getProperty("inconito"))) fo.addArguments("--incognito");
		return fo;
	}

}
