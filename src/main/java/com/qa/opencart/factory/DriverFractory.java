package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.utility.ElementsUlility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFractory {

	WebDriver driver;
	Properties prop;
	public static String highlight;
	OptionManager optionmanager;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	ElementsUlility eu;

	/**
	 * This method just initinalized the web driver
	 * 
	 * @param browserName
	 * @return driver
	 */

	public WebDriver init_Driver(String browserName) {
		optionmanager = new OptionManager(prop);

		highlight = prop.getProperty("highlight");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver(optionmanager.getchromeOptions());
			tldriver.set(new ChromeDriver(optionmanager.getchromeOptions()));
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver(optionmanager.getfirefoxOptions());
			tldriver.set(new FirefoxDriver(optionmanager.getfirefoxOptions()));
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Please provide right browser name");
		}

		setUrl();
		windowMaximized();

//		return driver;
		return getdriver();

	}

	public static synchronized WebDriver getdriver() {
		return tldriver.get();
	}

	public void quitDriver() {
		getdriver().quit();
	}

	public void setUrl() {
		getdriver().get(prop.getProperty("url"));
	}

	public Properties init_properties() {
		prop = new Properties();
		FileInputStream fis = null;

		String environment = System.getProperty("env");

		if (environment == null) {
			try {
				fis = new FileInputStream("./src/test/resource/config/prod.config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			
			try {
				switch (environment.toLowerCase()) {
				case "qa":
					fis = new FileInputStream("./src/test/resource/config/qa.config.properties");

					break;
				case "dev":
					fis = new FileInputStream("./src/test/resource/config/dev.config.properties");

					break;
				case "stage":
					fis = new FileInputStream("./src/test/resource/config/stage.config.properties");

					break;
				case "uat":
					fis = new FileInputStream("./src/test/resource/config/uat.config.properties");

					break;

				default:
					System.out.println("Please assingn correct environment name");
					break;
				}
				
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}

		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return prop;

	}

	public void windowMaximized() {
		getdriver().manage().window().maximize();
		System.out.println("Windows Maxamized   " + getdriver());
	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) getdriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File DestFile = new File(path);
		try {
			FileUtils.copyFile(src, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

//	public String getScreenshot() {
//		return getSpectficWebElementScreenshot();
//	}

	public String getSpectficWebElementScreenshot() {
		File source = eu.getSpecificWebElementScreenshoot();
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File DestFile = new File(path);
		try {
			FileUtils.copyFile(source, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
