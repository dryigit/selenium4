package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_synchronization extends TestBase {

@Test
public void test() throws InterruptedException {
	// go to https://the-internet.herokuapp.com/dynamic_controls
	driver.get("https://the-internet.herokuapp.com/dynamic_controls");
	// click disable button
	driver.findElement(By.xpath("//button[text()='Enable']")).click();
	//driver.findElement(By.xpath("//button[text()='Disable']")).click();
	
	WebElement disabledText=driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
	Assert.assertTrue(disabledText.isDisplayed());
	
	
	//test that disabled text is displayed.
	
}
}
