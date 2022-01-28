package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;


public class C06_FacebookSignUp extends TestBase {
@Test
public void test01(){
	//1- go to https://www.facebook.com
	driver.get("https://www.facebook.com");
	//2- Let's hit the create new account button
	WebElement createAccountButton=driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
	createAccountButton.click();
	//3- Write the value in the name, surname, e-mail and password boxes and press the register button.
	Actions actions=new Actions(driver);
	WebElement firstName=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
	WebElement dropdownMonthElement=driver.findElement(By.xpath("//select[@aria-label='Month']"));
	WebElement dropdownDayElement=driver.findElement(By.xpath("//select[@aria-label='Day']"));
	WebElement dropdownYearElement =driver.findElement(By.xpath("//select[@aria-label='Year']"));
	Select yil=new Select(dropdownYearElement);
	Select ay=new Select(dropdownMonthElement);
	Select gun=new Select(dropdownDayElement);
	actions.click(firstName);
	actions.sendKeys("Akilli").
			sendKeys(Keys.TAB).
			sendKeys("killi").
			sendKeys(Keys.TAB).
			sendKeys("+15719998841").
			sendKeys(Keys.TAB).
			sendKeys("123qweASD..."+Keys.ENTER).perform();
	ay.selectByValue("4");
	actions.sendKeys(Keys.TAB).perform();
	gun.selectByValue("26");
	actions.sendKeys(Keys.TAB).perform();
	yil.selectByValue("1980");
	actions.sendKeys(Keys.TAB).
			sendKeys(Keys.TAB).
			sendKeys(Keys.SPACE).
			sendKeys(Keys.TAB).
			sendKeys(Keys.TAB).
			sendKeys(Keys.TAB).
			sendKeys(Keys.TAB).
			sendKeys(Keys.ENTER).
			perform();
}
}
