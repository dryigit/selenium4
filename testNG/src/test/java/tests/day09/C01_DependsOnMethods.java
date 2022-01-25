package tests.day09;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
public class C01_DependsOnMethods {

WebDriver driver;
@BeforeClass
public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@Test
public void logoTest(){
	// go to https://www.amazon.com/
	// Test that you go to Amazon main page
	driver.get("https://www.amazon.com/");
	WebElement logoElement=driver.findElement(By.id("nav-logo-sprites"));
	Assert.assertTrue(logoElement.isDisplayed());
}
@Test (dependsOnMethods = "logoTest")
public void aramaTesti(){
	//  If the 1st test is successful, use the search box for "Nutella".
	// search and test that your search works
	WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
	searchBox.sendKeys("Nutella"+ Keys.ENTER);
	String actualTitle=driver.getTitle();
	String searchedText="Nutella";
	Assert.assertTrue(actualTitle.contains(searchedText));
}

@Test(dependsOnMethods = "aramaTesti")
public void fiyatTesti(){
	//  3.Test : If you searched for "Nutella", click the first product and test the price is $14.99
	driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
	WebElement productPrice=driver.findElement(By.xpath("(//span[@class='a-declarative'])[21]"));
	String pricetag=productPrice.getText();
	String searchedPrice="$14.99";
	Assert.assertTrue(pricetag.contains(searchedPrice));
	
}
@AfterClass
public  void  teardown(){
	driver.quit();
}
}