package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_ManageWindow {
public static void main(String[] args) throws InterruptedException {


	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	
// 2. Let's go to the Amazon . https://www.amazon.com/
	
	driver.get("https://www.amazon.com");
	
// 3. Print the position and dimensions of the page
	
	System.out.println("==================Task 3 ===================");
	System.out.println();
	System.out.println("The position of the window is " + driver.manage().window().getPosition());
	System.out.println("The size of the window is " +driver.manage().window().getSize());
	System.out.println();
// 4. Minimize the page
	driver.manage().window().minimize();
	
// 5. Wait 3 seconds in the icon state and maximize the page
	Thread.sleep(3000);
	driver.manage().window().maximize();
	
// 6. Print the position and dimensions of the page in maximized state
	System.out.println("==================Task 6 ===================");
	Thread.sleep(3000);
	System.out.println();
	System.out.println("The position of the window in maximized state is " +driver.manage().window().getPosition());
	System.out.println("The size of the window in minimized state is " +driver.manage().window().getSize());
	System.out.println();
// 7. Make the page fullscreen
	Thread.sleep(3000);
	driver.manage().window().maximize();
	
// 8. Print the position and dimensions of the page in fullscreen state
	System.out.println("==================Task 8 ===================");
	System.out.println();
	System.out.println("The position of the window in fullscreen is " +driver.manage().window().getPosition());
	System.out.println("The size of the window in fullscreen is " +driver.manage().window().getSize());
	
	// 9. close the page
	
	driver.close();
	
}
}
