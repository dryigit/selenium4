package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp;
import utilities.Driver;

public class C04_HotelMyCampPositivelogin {

HotelMyCamp hotelMyCamp=new HotelMyCamp();
@Test
public void positiveLoginTest() throws InterruptedException {
// go to https://www. hotelmycamp.com/
	Driver.getDriver().get("https://www.hotelmycamp.com");
// click login
	hotelMyCamp.login.click();
// test data username: manager ,
	hotelMyCamp.username.sendKeys("manager");
// test data password : Manager1!
	hotelMyCamp.password.sendKeys("Manager1!");
	hotelMyCamp.loginButton.click();
// test that you login successfully.
	String adminPageTitle=Driver.getDriver().getTitle();
	Assert.assertTrue(adminPageTitle.equals("Admin - ListOfUsers"));
}

}
