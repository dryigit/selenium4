package day03_WebElementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class C02_LoginTest {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	

//	2. Create main method and complete the following tasks.
//			a. go to http://a.testaddressbook.com.
	driver.get("http://a.testaddressbook.com");
	
//	b. Click Sign in
	
	WebElement signIn = driver.findElement(By.id("sign-in"));
	//we located it and assigned it to a variable.
	signIn.click();
	
//	c. locate email textbox,password textbox, and signin buttons
	
	WebElement emailTextbox=driver.findElement(By.id("session_email"));
	WebElement passwordTextbox = driver.findElement(By.id("session_password"));
	WebElement signInButton=driver.findElement(By.name("commit"));
	
//	d. Enter the username and password below and click the sign in button:
//	i. Username : testtechproed@gmail.com
//	ii. Password : Test1234!
	
	emailTextbox.sendKeys("testtechproed@gmail.com");
	passwordTextbox.sendKeys("Test1234!");
	Thread.sleep(2000);
	signInButton.click();
	
//			e. Verify that Expected user id is testtechproed@gmail.com

WebElement introTextElement=driver.findElement(By.tagName("h1"));
	System.out.println(introTextElement.getText());
	String actualIntroText=introTextElement.getText();
	String expectedIntroText="Welcome to Address Book";
	
	if(actualIntroText.equals(expectedIntroText)){
		System.out.println("The login test is PASS.");
	} else{
		System.out.println("The login test is FAILED.");
	}
	
//			f. Verify that “Addresses” and “Sign Out” texts are displayed

	WebElement addresWebElement=driver.findElement(By.linkText("Addresses"));
	WebElement signOutText=driver.findElement(By.linkText("Sign out"));
	
	addresWebElement.isDisplayed();
	if (addresWebElement.isDisplayed()){
		System.out.println("The address display test is PASS");
	} else{
		System.out.println("The address display test is FAILED ");
	}
	
	signOutText.isDisplayed();
	if (signOutText.isDisplayed()){
		System.out.println("The signout display test is PASS");
	} else{
		System.out.println("The signout display test is FAILED ");
	}
	
	
	
//	3. Find out how many links are on the page.
	
	List<WebElement> linkLists=driver.findElements(By.tagName("a"));
	
	System.out.println("There are " + linkLists.size() + " links in the page.");
	
	driver.close();
}
}
