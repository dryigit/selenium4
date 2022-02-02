package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverFirstTest {
@Test
public void test01(){
	
	//go to amazon
	Driver.getDriver().get("https://www.amazon.com");
	
	//test that you went to amazon page.
	String actualTitle=Driver.getDriver().getTitle();
	String actualUrl=Driver.getDriver().getCurrentUrl();
	Assert.assertTrue(actualTitle.contains("Amazon"));
	
	//Driver.getDriver method'u her calistiginda
	//driver=new ChromeDriver(); komutundan dolayi yeni bir driver olusturuyor
	//Biz Driver class'dan getDriver'i calsitirdigimizda new atamasi olsun
	//sonraki calistirmalarda atama olmasin istiyoruz
	//bunun icin driver= new ChromeDriver(); satiri bir if blogu iicine alacagiz
	Driver.closeDriver();
}

@Test
public void test02() throws InterruptedException {
	//go to bestbuy main page
	Driver.getDriver().get("https://bestbuy.com");
	//test that you went to bestbuy
	String url = Driver.getDriver().getCurrentUrl();
	Assert.assertTrue(url.contains("bestbuy.com"));
	Driver.closeDriver();
}

}
