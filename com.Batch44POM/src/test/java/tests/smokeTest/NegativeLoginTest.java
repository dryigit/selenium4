package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCamp;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
	//1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
	//3 Farkli test Methodunda 3 senaryoyu test et
//   - yanlisSifre
	//   - yanlisKulllanici
	//   - yanlisSifreKullanici
	//test data yanlis username: manager1 , yanlis password : manager1
	//2) https://www.hotelmycamp.com adresine git
	//3) Login butonuna bas
	//4) Verilen senaryolar ile giris yapilamadigini test et
	HotelMyCamp hotelMyCamp=new HotelMyCamp();

@Test
public void wrongPassword(){
	//2) https://www.hotelmycamp.com adresine git
	Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
	//3) Login butonuna bas
	hotelMyCamp.login.click();
	//   - yanlisSifre
	hotelMyCamp.username.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
	hotelMyCamp.password.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
	hotelMyCamp.loginButton.click();
	Assert.assertTrue(hotelMyCamp.successfullyLoggedInElement.isDisplayed());
	Driver.closeDriver();
}

@Test
public void wrongUsername(){
//2) https://www.hotelmycamp.com adresine git
	Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
	//3) Login butonuna bas
	hotelMyCamp.login.click();
	//   - wrongUsername
	hotelMyCamp.username.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
	hotelMyCamp.password.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
	hotelMyCamp.loginButton.click();
	Assert.assertTrue(hotelMyCamp.successfullyLoggedInElement.isDisplayed());
	Driver.closeDriver();
}
@Test
public void wrongUserandPassword(){
//2) https://www.hotelmycamp.com adresine git
	Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
	//3) Login butonuna bas
	hotelMyCamp.login.click();
	//   - wrongUsernameandPassword
	hotelMyCamp.username.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
	hotelMyCamp.password.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
	hotelMyCamp.loginButton.click();
	Assert.assertTrue(hotelMyCamp.successfullyLoggedInElement.isDisplayed());
	Driver.closeDriver();
}
	

}
