package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Allerts {

WebDriver driver;
WebElement resultTextElement;

@BeforeClass
public void setup(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	
}
@Test
public void acceptAllerTest() throws InterruptedException {
    //    Click the 1st button, click the OK button in the alert
	//    Test that you see the allert message “You successfully clicked an alert”.
	
	driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	driver.switchTo().alert().accept();
	resultTextElement=driver.findElement(By.xpath("//p[@id='result']"));
	Thread.sleep(3000);
	String actualResult=resultTextElement.getText();
	String expectedresult="You successfully clicked an alert";
	Assert.assertEquals(actualResult, expectedresult);
}
@Test
public void dismissAllerTest() throws InterruptedException {
	//  Click the 2nd button. Click the Cancel button in the alert and the result message
	//  Test that it does not contain “successfuly”.
	driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	Thread.sleep(3000);
	driver.switchTo().alert().dismiss();
	resultTextElement=driver.findElement(By.xpath("//p[@id='result']"));
	String actualResultText=resultTextElement.getText();
	String expectedresult="successfuly";
	Assert.assertTrue(!actualResultText.contains(expectedresult));
	
	
}
@Test
public void sendKeysAlertTest() throws InterruptedException {
	// Click the 3rd button, write your name in the text box in the alert, click the OK button.
	// click and verify that your name is displayed in the result message.
	
	driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	driver.switchTo().alert().sendKeys("Yildiz");
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	resultTextElement=driver.findElement(By.xpath("//p[@id='result']"));
	String actualResultText=resultTextElement.getText();
	String expectedresult="Yildiz";
	Assert.assertTrue(actualResultText.contains(expectedresult));
}

@AfterClass
public void teardown(){
driver.quit();
}
}
