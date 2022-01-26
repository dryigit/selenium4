package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
public class C02_BasicAuthentication {

WebDriver driver;
@BeforeClass
public void setup(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
}
@Test
public void test(){
	// Go to https://the-internet.herokuapp.com/basic_auth
	// Authenticate using the following method and test data
	// Html  : https://username:password@URL
	// Username     : admin
	// password      : admin
	driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	// 4- Verify that the page has been successfully entered
	WebElement congratMessageElement=driver.findElement(By.tagName("p"));
	Assert.assertTrue(congratMessageElement.isDisplayed());
}

@AfterClass
public void teardown(){
driver.quit();
}
}
