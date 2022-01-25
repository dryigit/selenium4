package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_ImplicitlyWait {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	//The implicitlyWait determines the maximum time the driver will wait for the page to be opened and the element to be found during our test.
	// As soon as it finishes the task within this time, it moves on to the next step.
	// If it can't finish the task within this time, then it will throw an error.
	// The determined maximum time is not absolute waiting time like thread.sleep.
	
	driver.get("https://www.techproeducation.com");
	//Thread.sleep(3000);
	
	driver.close();
}
}
