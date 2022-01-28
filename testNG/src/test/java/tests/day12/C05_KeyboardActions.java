package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {


@Test
public void keyboardActions() throws InterruptedException {
	// go to https://www.amazon.com

	driver.get("https://www.amazon.com");
	
	// Type the Samsung A71 using the actions methods in the search box and press Enter to search.
	
	WebElement searchBox=driver.findElement(By.xpath("(//input[@id='twotabsearchtextbox'])[1]"));
	Actions actions=new Actions(driver);
	actions.click(searchBox);
	actions.keyDown(Keys.SHIFT).
			sendKeys("s").
			keyUp(Keys.SHIFT).
			sendKeys("amsung ").
			keyDown(Keys.SHIFT).
			sendKeys("a").
			keyUp(Keys.SHIFT).
			sendKeys("71").
			sendKeys(Keys.ENTER).
			perform();
	
}
}
