package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {
@Test
public void facebookKayitTesti() throws InterruptedException {
	//go to "https://facebook.com"
	driver.get("https://facebook.com");
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//button[text()='Allow All Cookies']")).click();
	//click “create new account”  button
	driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
	//write a name on “firstName” section
	WebElement nameBox= driver.findElement(By.xpath("//input[@name='firstname']"));
	Actions actions=new Actions(driver);
	Faker faker=new Faker();
	String email=faker.internet().emailAddress();
	actions.click(nameBox)
			.sendKeys(faker.name().name())
			//write a name on “surname” section
			.sendKeys(Keys.TAB)
			.sendKeys(faker.name().lastName())
			//type “email”
			.sendKeys(Keys.TAB)
			.sendKeys(email)
			//type “email” again
			.sendKeys(Keys.TAB)
			.sendKeys(email)
			//enter a password
			.sendKeys(Keys.TAB)
			.sendKeys(faker.internet().password())
			//select date
			.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
			.sendKeys("Jan")
			//select day
			.sendKeys(Keys.TAB)
			.sendKeys("15")
			//select year
			.sendKeys(Keys.TAB)
			.sendKeys("1972")
			//select gender
			.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
			.sendKeys(Keys.ARROW_RIGHT)
			.perform();
	//Test if the gender you ticked is selected and the other gender box is not
	WebElement genderMale=driver.findElement(By.xpath("//input[@value='2']"));
	WebElement genderFemale=driver.findElement(By.xpath("//input[@value='1']"));
	Assert.assertTrue(genderMale.isSelected());
	Assert.assertFalse(genderFemale.isSelected());
	Thread.sleep(10000);
}
}
