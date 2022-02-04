package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp;
import utilities.ConfigReader;
import utilities.Driver;

import java.lang.module.Configuration;

public class C02_PropertiesFirstClass {

@Test
public void positiveLoginTest(){
	//go to hotel my camp webpage
	//do positive login test fully approppriate to POM
	
	//    https://www. hotelmycamp.com/ adresine git
	Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
	//    login butonuna bas
	HotelMyCamp hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.login.click();
	hotelMyCamp.wait(3);
	//    test data username: manager ,
	hotelMyCamp.username.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
	//    test data password : Manager1!
	hotelMyCamp.password.sendKeys((ConfigReader.getProperty("HMCValidPassword")));
	hotelMyCamp.loginButton.click();
	//    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
	Assert.assertTrue(hotelMyCamp.successfullyLoggedInElement.isDisplayed());
	
	Driver.closeDriver();
}
}
