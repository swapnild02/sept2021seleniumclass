package homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.opencart.utility.ElementsUlility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T1 {
	 WebDriver driver;
		String value;

	public static void main(String[] args) {
		T1 t1=new T1();
	t1.t("My Account");

	}
	
	public void t(String value) {
		String footerBeforeS="//div[@class='row'])[last()]//li/a[text()='";
	
		String footerAeforeS="']";
		
//		By footerBefore=By.xpath(footerBeforeS);
//		By footerAefore=By.xpath(footerAeforeS);
//		By.xpath: By.xpath: //div[@class='row'])[last()]//li/a[text()='valueBy.xpath: ']
		By click=By.xpath(footerBeforeS+value+footerAeforeS);
		System.out.println(click);
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/");
		ElementsUlility eu =new ElementsUlility(driver);
		WebElement ele=eu.findElement(click);
//		driver.get("https://demo.opencart.com/");
//		WebElement ele=driver.findElement(click);
		System.out.println(ele);
	}

}
