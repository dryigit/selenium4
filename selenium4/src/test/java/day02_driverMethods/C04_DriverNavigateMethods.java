package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethods {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	driver.navigate().to("https://www.amazon.com");
	//is the same with driver.get but is faster
	
	driver.navigate().to("https://www.myigit.com");
	
	driver.navigate().back();
	//goes back to amazon
	
	driver.navigate().forward();
	//goes forward to myigit.com
	
	driver.navigate().refresh();
	//resresh the page
}
}
