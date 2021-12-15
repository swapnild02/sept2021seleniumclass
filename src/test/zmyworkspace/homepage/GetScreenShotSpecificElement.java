package homepage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetScreenShotSpecificElement {
	
	static WebElement element;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
//			element=driver.findElement(By.linkText("Register"));
//			element=driver.findElement(By.id("input-email"));
			try
			{
			element=driver.findElement(By.id("input-email"));
			}catch (Exception e) {
				getshoot(element);
				e.printStackTrace();	 
			}
			
//			 getshoot(element);

	}
	public static void getshoot(WebElement element) {
		File source=element.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/testscshots/"+System.currentTimeMillis()+".png";
		File DestFile=new File(path);
		try {
			FileUtils.copyFile(source, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
