package tests.day22;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.TestBaseRapor.extentReports;
import static utilities.TestBaseRapor.extentTest;

public class C02_FacebookTesti {

FacebookPage facebookPage= new FacebookPage();
@Test
public void testFacebook(){
	extentTest=extentReports.createTest("facebook", "fake isimle girilemediği test edili");
	//  1 - go to https://www.facebook.com/
	Driver.getDriver().get("https://www.facebook.com");
	extentTest.info("facebook sayfasına gidildi");
	//  2- Locate email, password boxes and login button in accordance with POM
	//  3- Using the Faker class, print the email and password values and press the login button.
	Faker faker=new Faker();
	facebookPage.facebookLoginEmail.sendKeys(faker.internet().emailAddress());
	facebookPage.facebookLoginPassword.sendKeys(faker.internet().password());
	facebookPage.facebookLoginButton.click();
	extentTest.info("facebook giriş bilgileri faker ile dolduruldu");
	
	//  4- Test for unsuccessful login
	String errorMessage=facebookPage.errorMessage.getText();
	Assert.assertTrue(facebookPage.errorMessage.isDisplayed());
	extentTest.pass("girilemediği test edildi");
	
}
}
