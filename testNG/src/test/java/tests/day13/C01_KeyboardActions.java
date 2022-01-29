package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {

@Test
public void test() throws InterruptedException {
	// go to https://html.com/tags/iframe/
	driver.get("https://html.com/tags/iframe/");
	// scroll down till you see the video
	Actions actions=new Actions(driver);
	actions.sendKeys(Keys.PAGE_DOWN).perform();
			
	// click play video
	WebElement iframe= driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
	driver.switchTo().frame(iframe);
	driver.findElement(By.xpath("//div[@id='player']")).click();
	
	// test that the video is played.
	WebElement pauseButton=driver.findElement(By.xpath("//button[@title='Pause (k)']"));
	Assert.assertTrue(pauseButton.isEnabled());
	
	Thread.sleep(5000);
}
}
