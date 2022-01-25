package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AmazonTest {

static WebDriver driver;
@BeforeClass
public static void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.get("https://www.amazon.com");
}
@Test
public void test01(){
	//    Test that the number of categories in the category menu next to the search box is 45
	List<WebElement> categorySize=driver.findElements(By.xpath("(//option)"));
	String categorySize1= String.valueOf(categorySize.size());
	String categorySize2="45";
	Assert.assertEquals("The actual number of category is different from expected",categorySize2,categorySize1);
}
@Test
public void test02(){
//1. Select Books from category
	driver.findElement(By.xpath("(//option)[6]")).click();
//2. Search for Java
	WebElement search=driver.findElement(By.xpath("(//input[@id='twotabsearchtextbox'])[1]"));
	search.sendKeys("Java");
	search.submit();
//3. print the number of results
	WebElement resultsText=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
	System.out.println(resultsText.getText());
	String resultsText2=resultsText.getText();
	String resultsText3="Java";
//4. Test that the results contain "Java"
	if(resultsText2.contains("Java")){
		resultsText3=resultsText2;
	}
	Assert.assertEquals("Results do not contain JAVA",resultsText3,resultsText2);
}
@AfterClass
public static void  teardown(){
driver.quit();
}
}
