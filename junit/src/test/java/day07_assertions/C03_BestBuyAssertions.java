package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertions {



static WebDriver driver;
@BeforeClass
public static void setup(){
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.manage().window().maximize();
	//      2)go to  https://www.bestbuy.com/
	driver.get("https://www.bestbuy.com/");
}
@Test
public void URLTest(){


//		○ Test that the page URL is equal to https://www.bestbuy.com/
	String actualUrl=driver.getCurrentUrl();
	String expectedUrl="https://www.bestbuy.com/";
	
	Assert.assertEquals("Please review test values",expectedUrl, actualUrl);
}
@Test
public void pageTitle(){
	
	//		○ titleTest => Test if the page title does not contain "Rest"
	String actualTitle=driver.getTitle();
	String unExpectedTitle="Rest";
	
	Assert.assertFalse(actualTitle.contains(unExpectedTitle));
	
}
@Test
public void logoTest(){
	
	//		○ logoTest => Test that the BestBuy logo is displayed
	WebElement logo=driver.findElement(By.xpath("//div[@lang='en']//img[@alt='Best Buy Logo']"));
	Assert.assertTrue("Logo is not displayed",logo.isDisplayed());
	

}
@Test
public void LinkTest(){
	//		○ FrancaisLinkTest => Test that the FrancaisLink is displayed
	WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));
	Assert.assertTrue("link is not displayed",francais.isDisplayed());
}

@AfterClass
public static void tearDown(){
	
	driver.close();
}
}
