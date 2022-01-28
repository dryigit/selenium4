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
	//amazon anasayfaya gidin
	driver.get("https://www.amazon.com");
	
	//sağ üstte hello sign in menüsünün üzerinde durup açın
	Actions actions=new Actions(driver);
	WebElement signIn = driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
	actions.moveToElement(signIn).perform();
	//driver.findElement(By.xpath("//span[@class='a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss']")).click();
	
	//açılan menüde new list linkine tıklayın
	
	WebElement listElement=driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
	actions.click(listElement).perform();
	
	//new list sayfasının açıldığını test edin
	
	String actualTitle= driver.getTitle();
	String searchedText="Your List";
	
	Assert.assertTrue(actualTitle.contains(searchedText));




}

}
