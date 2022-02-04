package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp;
import utilities.Driver;

public class C01_HotelMyCampNegativeLoginTest {

// 1 ) Bir Class olustur : NegativeTest
// 2) Bir test method olustur NegativeLoginTest()
// https://www. hotelmycamp.com/ adresine git
// login butonuna bas
// test data username: manager1 ,
// test data password : manager1!
// Degerleri girildiginde sayfaya girilemedigini test et
@Test
public void test01(){
	// https://www.hotelmycamp.com/ adresine git
	Driver.getDriver().get("https://www.hotelmycamp.com/");
// login butonuna bas
	HotelMyCamp hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.login.click();
// test data username: manager1 ,
	hotelMyCamp.username.sendKeys("manager1");
// test data password : manager1!
	hotelMyCamp.password.sendKeys("manager1!");
	hotelMyCamp.loginButton.click();
// Degerleri girildiginde sayfaya girilemedigini test et
	Assert.assertTrue(hotelMyCamp.unableToLoginScreen.isDisplayed());

	Driver.closeDriver();
}
}
