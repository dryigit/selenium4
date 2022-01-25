package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigateMethods {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	
//	1. Go to the youtube page. https://www.youtube.com/
	System.out.println("=================Task 1 ==================");

	driver.navigate().to("https://www.youtube.com");
	
//	2. go to the Amazon page. https://www.amazon.com/
	System.out.println("=================Task 2 ==================");

	driver.navigate().to("https://www.amazon.com");
	
//	3. go to YouTube page again
	System.out.println("=================Task 3 ==================");

	driver.navigate().back();
	
//	4. go to Amazon page again
	System.out.println("=================Task 4 ==================");
	
	driver.navigate().forward();
	
//	5.  Refresh the page
	
	System.out.println("=================Task 5 ==================");
	
	driver.navigate().refresh();
	
//	6. Let's close the page / Close all the pages
	System.out.println("=================Task 5 ==================");
	
	driver.quit();
	//if there is quit, all the opened windows are closed.
	// driver.close closes the last page that the driver visits.
}
}
