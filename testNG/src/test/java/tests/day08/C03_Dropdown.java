package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {

WebDriver driver;
@BeforeMethod
public void setup(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
}
@Test
public void test() throws InterruptedException {
	//  go to https://the-internet.herokuapp.com/dropdown
	driver.get("https://the-internet.herokuapp.com/dropdown");
	// using Index, select Option 1) and print
	WebElement dropdown= driver.findElement(By.xpath("//select[@id='dropdown']"));
	Select select= new Select(dropdown);
	select.selectByIndex(1);
	System.out.println(select.getFirstSelectedOption().getText());;
	Thread.sleep(3000);
	//using Value, select Option 2and print
	select.selectByValue("2");
	System.out.println(select.getFirstSelectedOption().getText());
	Thread.sleep(3000);
	//using Visible Text, select Option 1and print
	select.selectByVisibleText("Option 1");
	System.out.println(select.getFirstSelectedOption().getText());
	// Print all dropdown values
	List<WebElement> allValues=select.getOptions();
	for(WebElement each:allValues){
		System.out.println(each.getText());
	}
	
	// Find the Dropdown size and test that there are 4 elements
	
	int actualSize=allValues.size();
	int expectedSize=4;
	Assert.assertEquals(actualSize, expectedSize,"The actuals size is "+actualSize);
	
}
@AfterMethod
public void teardown(){
driver.close();
}
}
