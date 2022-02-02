package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_FacebookTest {

FacebookPage facebookPage= new FacebookPage();
@Test
public void testFacebook() throws InterruptedException {
	//  1 - go to https://www.facebook.com/
	Driver.getDriver().get("https://www.facebook.com");
	//  2- Locate email, password boxes and login button in accordance with POM
	//  3- Using the Faker class, print the email and password values and press the login button.
	Faker faker=new Faker();
	facebookPage.facebookLoginEmail.sendKeys(faker.internet().emailAddress());
	facebookPage.facebookLoginPassword.sendKeys(faker.internet().password());
	facebookPage.facebookLoginButton.click();
	
	//  4- Test for unsuccessful login
	String errorMessage=facebookPage.errorMessage.getText();
	Assert.assertTrue(facebookPage.errorMessage.isDisplayed());
	
	Thread.sleep(3000);
	Driver.closeDriver();
}

}
