package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {


WebDriver driver;
@BeforeClass
public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@Test
public void handleWindows(){
	// go to https://the-internet.herokuapp.com/windows
	driver.get("https://the-internet.herokuapp.com/windows");
	
	// Verify that the text on the page is "Opening a new window".
	WebElement textInPage=driver.findElement(By.xpath("//h3"));
	String actualText=textInPage.getText();
	String expectedText="Opening a new window";
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals(actualText,expectedText,"the text is different");
	softAssert.assertAll();
	
// Verify that the page title is "The Internet"
	String actualPageTitle=driver.getTitle();
	String expectedPageTitle="The Internet";
	Assert.assertEquals(actualPageTitle,expectedPageTitle);
	
	// Click Here button
	WebElement clickButton=driver.findElement(By.xpath("//a[text()='Click Here']"));
	//In the question, a page whose value I do not know has a window handle value.
	//I have to save this value so I can use it later.
	String windowHandleValue1=driver.getWindowHandle();
	clickButton.click();
	
	// Verify that the title of the new window that opens is “New Window”.
	
	//first i have to get the window handle value of the new opened page.
	//First, let's put all the handle values in a set'
	Set<String>handleValuesSet=driver.getWindowHandles();
	String windowHandleValue2="";
	for (String each : handleValuesSet){
		if(!each.equals(windowHandleValue1)){
			windowHandleValue2=each;
		}
	}
	//I can now switch to the new page
	driver.switchTo().window(windowHandleValue2);
	softAssert.assertEquals(driver.getTitle(), "New Window", "new page title is different");
	
	// Verify that the text on the page is "New Window".
	
	WebElement textElementindSecondPage=driver.findElement(By.tagName("h3"));
	softAssert.assertEquals(textElementindSecondPage,"New Window", "the text in the second page is different");
	
	//  After returning to the previous window, verify that the page title is "The Internet".
	driver.switchTo().window(windowHandleValue1);
	softAssert.assertEquals(driver.getTitle(),"The Internet","the title is different");
}

}
