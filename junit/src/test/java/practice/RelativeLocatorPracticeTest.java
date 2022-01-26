package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.time.Duration;

public class RelativeLocatorPracticeTest{
static WebDriver driver;
@BeforeClass
public static void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.bestbuy.com");
}
@Test
public void titleTest(){
	//go to http://www.bestbuy.com
	//test whether the title contains "Best"
	String title=driver.getTitle();
	Assert.assertTrue(title.contains("Best"));
}
@Test
public void logoTest(){
	// using Relative Locator;
	// Verify if the BestBuy logo is displayed
	WebElement heading1=driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
	WebElement logo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(heading1));
	Assert.assertTrue("logo is not displayed",logo.isDisplayed());
}
@Test
public void mexicoLinkTest(){
	// using relative locators , test mexicoLinkTest is displayed or not
	WebElement usLink=driver.findElement(By.xpath("(//h4[text()='United States'])[1]"));
	WebElement mexicoLink= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usLink));
	Assert.assertTrue(mexicoLink.isDisplayed());
}
@AfterClass
public static void teardown(){
driver.close();
}
}