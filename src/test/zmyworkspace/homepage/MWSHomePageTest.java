package homepage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MWSHomePageTest {
	
	 WebDriver driver;
//	  ElementsUlility eu;

	public static void main(String[] args) 
	{
		MWSHomePageTest hp=new MWSHomePageTest();
		hp.t();

	}
	
	public void t() {
//	By Menuitems=By.xpath("(//div[@class='row'])[7]/div//a");
	
//	By Menuitems=By.xpath("(//div[@class='row'])[last()]//ul//a");
	
//	(//div[@class='row'])[7]/div//a[text()='Contact Us']
//	(//div[@class='row'])[last()]
	
	By Menuitems=By.xpath("(//div[@class='container'])[5]/p");
//	By Menuitems=By.xpath("//p/br");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		// ElementsUlility eu =new ElementsUlility(driver);
		driver.get("https://demo.opencart.com/");
		
		
		boolean b=driver.findElement(Menuitems).isDisplayed();
		System.out.println("*************************************************8");
		System.out.println("The elemet  "+b);
		System.out.println("*************************************************8");
//		driver.findElement(Menuitems).click();
		
//		List<String> menuText=eu.getTextFromList(Menuitems);
//		for(String s:menuText) {
//			System.out.println(s);
//		}
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		String text=driver.findElement(By.xpath("Menuitems")).getText();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(Menuitems));
		String text=ele.getText();
		
		System.out.println(text);
		System.out.println(text.length());
		System.out.println(text.substring(0, 10));
		System.out.println(text.substring(19, 37));
		
		driver.close();
	}

}
