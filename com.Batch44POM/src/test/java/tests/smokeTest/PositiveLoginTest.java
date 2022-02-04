package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

// Bir test method olustur positiveLoginTest()
@Test
public void testPositiveLogin(){
	//https://www.hotelmycamp.com adresine git
	Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

	//login butonuna bas
	HotelMyCamp hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.login.click();
	//test data username: manager ,
	hotelMyCamp.username.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
	//test data password : Manager1!
	hotelMyCamp.password.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
	hotelMyCamp.loginButton.click();
	//Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
	Assert.assertTrue(hotelMyCamp.successfullyLoggedInElement.isDisplayed());
	
	Driver.closeDriver();
	
}
}
