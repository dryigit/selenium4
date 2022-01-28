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
	//       2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
	driver.get("https://the-internet.herokuapp.com/context_menu");
	
	//       		3- Cizili alan uzerinde sag click yapalim
	
	Actions actions=new Actions(driver);
	WebElement spot=driver.findElement(By.xpath("//div[@id='hot-spot']"));
	actions.contextClick(spot).perform();
	
	//       4- Alert’te cikan yazinin “You selected a context menu” oldugunu
//       test edelim.
	driver.switchTo().alert();
	String actualtext=driver.switchTo().alert().getText();
	String expectedText="You selected a context menu";
	Assert.assertEquals(actualtext, expectedText);
	
	//       		5- Tamam diyerek alert’I kapatalim
	driver.switchTo().alert().accept();
	
	//       6- Elemental Selenium linkine tiklayalim
	String firstPageWindowHandleValue=driver.getWindowHandle();
	driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
	
	//       7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
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
