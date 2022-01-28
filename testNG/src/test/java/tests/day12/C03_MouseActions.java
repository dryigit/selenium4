package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions extends TestBase {



@Test
public void mouseActions(){
	// go to https://the-internet.herokuapp.com/context_menu
	driver.get("https://the-internet.herokuapp.com/context_menu");
	
	//Let's right click on the drawn area
	
	Actions actions=new Actions(driver);
	WebElement spot=driver.findElement(By.xpath("//div[@id='hot-spot']"));
	actions.contextClick(spot).perform();
	
	// Let's test that the text in Alert is "You selected a context menu".
	driver.switchTo().alert();
	String actualtext=driver.switchTo().alert().getText();
	String expectedText="You selected a context menu";
	Assert.assertEquals(actualtext, expectedText);
	
	// click ok and close the alert
	driver.switchTo().alert().accept();
	
	// click on Elemental Selenium link
	String firstPageWindowHandleValue=driver.getWindowHandle();
	driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
	
	// Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.
	String secondPageHandleValue="";
	Set<String> handleSet=driver.getWindowHandles();
	for(String each:handleSet){
		if(!each.equals(firstPageWindowHandleValue)){
			secondPageHandleValue=each;
		}
	}
	driver.switchTo().window(secondPageHandleValue);
	WebElement secondPagetextElement=driver.findElement(By.xpath("//h1[text()='Elemental Selenium']"));
	String actualSecondPagetext=secondPagetextElement.getText();
	String actualSecondPageText="Elemental Selenium";
	
	Assert.assertEquals(actualSecondPageText,actualSecondPageText);
	
}
}
