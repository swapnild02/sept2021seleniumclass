package homepage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T2 {
	 WebDriver driver;

	public static void main(String[] args) {
		T2 t=new T2();
		t.test();

	}
	//div[@class='alert alert-danger alert-dismissible' and text()=' Warning: No match for E-Mail Address and/or Password.']
	
	public void test() {
		 By username_id=By.id("input-email");
		 By password_id=By.id("input-password");
		 By clickonloginbtn_xpath=By.xpath("//input[@value='Login']");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.findElement(username_id).sendKeys("hhhhh");
		driver.findElement(password_id).sendKeys("eeee");
		driver.findElement(clickonloginbtn_xpath).click();
	
		String text=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible' and text()=' Warning: No match for E-Mail Address and/or Password.']")).getText();
		
//		String text=driver.findElement(By.tagName("h2")).getText();
		System.out.println("Text is   "+text);
		
	}

}
