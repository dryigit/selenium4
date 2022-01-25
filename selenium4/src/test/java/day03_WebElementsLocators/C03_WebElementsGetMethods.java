package day03_WebElementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementsGetMethods {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	// a. go to http://a.testaddressbook.com.
	
	driver.get("http://a.testaddressbook.com");
	
	// locate sign in link
	
	WebElement signInLink=driver.findElement(By.id("sign-in"));
	System.out.println("size "+ signInLink.getSize());
	System.out.println("Aria Role "+ signInLink.getAriaRole());
	System.out.println("Attribute "+ signInLink.getAttribute("id"));
	System.out.println("Location "+ signInLink.getLocation());
	System.out.println("Width "+ signInLink.getRect().width);
	System.out.println("Color "+ signInLink.getCssValue("color"));
	
	
	
	
	driver.close();
	
}
}
