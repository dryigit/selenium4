package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HotelMyCamp;

import static utilities.Driver.driver;

public class C01_E2ETesting {
@Test
public void createHotel(){

//3. https://www.hotelmycamp.com adresine git.
//4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
//    a. Username : manager
//    b. Password  : Manager1!
//5. Login butonuna tıklayın.
	HotelMyCamp hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.loginMethod();
//6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
	hotelMyCamp.wait(6);
	hotelMyCamp.hotelManagementLink.click();
	hotelMyCamp.hotelListLink.click();
	hotelMyCamp.addHotelLink.click();
//7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
	Actions actions=new Actions(driver);
	Faker faker=new Faker();
	actions.click(hotelMyCamp.addHotelCodeBox)
			.sendKeys(faker.address().zipCode())
			.sendKeys(Keys.TAB)
			.sendKeys(faker.name().fullName())
			.sendKeys(Keys.TAB)
			.sendKeys(faker.address().fullAddress())
			.sendKeys(Keys.TAB)
			.sendKeys(faker.phoneNumber().phoneNumber())
			.sendKeys(Keys.TAB)
			.sendKeys(faker.internet().emailAddress())
			.sendKeys(Keys.PAGE_DOWN)
			.sendKeys(Keys.TAB)
			.perform();
	Select select=new Select(hotelMyCamp.addHotelTypeSelectBox);
	select.selectByVisibleText("Hotel Type2");
	//8. Save butonuna tıklayın.
	hotelMyCamp.addHotelSaveButton.click();

}

}
