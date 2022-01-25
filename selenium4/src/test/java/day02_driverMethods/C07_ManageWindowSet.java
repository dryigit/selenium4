package day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ManageWindowSet {
public static void main(String[] args) throws InterruptedException {

	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	
//2. Let's go to the Amazon page. https://www.amazon.com/
	driver.get("https://www.amazon.com");
//3. Print the position and dimensions of the page
	System.out.println("==================Task 3 ===================");
	System.out.println("The position of the page is :" +driver.manage().window().getPosition());
	System.out.println("The size of the page is :" + driver.manage().window().getSize());
	
//4. Adjust the position and size of the page as desired
	System.out.println("==================Task 4 ===================");
	driver.manage().window().setPosition(new Point(800, 600));
	driver.manage().window().setSize(new Dimension(400,300));
	System.out.println("The position is "+ driver.manage().window().getPosition());
	System.out.println("The size is "+ driver.manage().window().getSize());
	

//5. Test that the page is in the position and size you want
	
	int xPositions = driver.manage().window().getPosition().getX();
	int yPositions = driver.manage().window().getPosition().getY();
	int width = driver.manage().window().getSize().getWidth();
	int height = driver.manage().window().getSize().getHeight();
	
	Thread.sleep(5000);
	if (xPositions ==800 && yPositions==600 && width ==300 && height ==500){
		System.out.println("The set task is PASS");
	} else {
		System.out.println("The set task is FAILED");
	}


//6. Close the page
	driver.close();



}
}
