package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {



@Test
public void amazonList() throws InterruptedException {
	//go to amazon page
	driver.get("https://www.amazon.com");
	
	//hover over the hello sign in menu in the top right and open it
	Actions actions=new Actions(driver);
	WebElement signIn = driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
	actions.moveToElement(signIn).perform();
	
	//Click on the new list link in the drop-down menu
	
	WebElement listElement=driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
	actions.click(listElement).perform();
	
	//Test that the new list page opens
	
	String actualTitle= driver.getTitle();
	String searchedText="Your List";
	
	Assert.assertTrue(actualTitle.contains(searchedText));




}

}
