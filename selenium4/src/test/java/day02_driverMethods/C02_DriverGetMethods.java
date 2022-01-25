package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethods {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	
	driver.get("https://www.amazon.com");
	String currentHandle= driver.getWindowHandle();
	
	
	System.out.println(driver.getTitle());
	
	System.out.println("The URL of the page is:"	+driver.getCurrentUrl());
	
	System.out.println(driver.getWindowHandle()); // the id given to the current window by chrome.
	
	System.out.println(driver.getPageSource());
	
	
	
	
	
}
}
