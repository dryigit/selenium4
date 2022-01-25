package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Locators_css {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
	//	NOT: use cssSelector

//	a. Go to http://a.testaddressbook.com/sign_in
	driver.get("http://a.testaddressbook.com/sign_in");
//	b. Locate email textbox
	WebElement emailTextBox = driver.findElement(By.cssSelector("input[id='session_email']"));
//	c. Locate password textbox
	WebElement passwordTextBox = driver.findElement(By.cssSelector("input[id='session_password']"));
//	d. Locate signin button
	WebElement signInButton = driver.findElement(By.cssSelector("input[name='commit']"));
//	e. Enter the username and password below and click the sign in button
	emailTextBox.sendKeys("testtechproed@gmail.com");
	passwordTextBox.sendKeys("Test1234!");
	signInButton.click();
//	i. Username : testtechproed@gmail.com
//	ii. Password : Test1234!
}
}
