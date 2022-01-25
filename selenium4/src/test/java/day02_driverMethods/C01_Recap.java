package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Recap {
	
// normally selenium also has its own IDE, but we use intelliJ because it is more useful.
// When we open a new project in IntelliJ, we first need to add the Selenium libraries to the project.// biz en ilkel haliyle projemize kütüphaneleri jar dosyaları alarak yükledik.

public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	//system set property is a property from java.
	// set property requests two parameters.
	// the first : the driver name of browser we will use
	// the second parameter is the path of the chrome driver that we downloaded from the selenium site and added to our project
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.amazon.com");
	
	Thread.sleep(5000);
// It comes from Java. It stops the code from running until the millisecond written into it.
	driver.close();
	//driver.close is written at the end of the class. because when this code runs, our driver closes
	//If we want to open a browser again after this code, we must assign a new value to the driver.
	
	
	

}
}
