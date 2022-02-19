package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q11 extends TestBase {

// http://amazon.com adresine gidiniz
// araba, ev, anahtarlik, ayakkabi, gomlek  kelimelerini arayiniz


@Test (dataProvider = "urunler")
public void amazonTest(String kelime){
	driver.get("https://www.amazon.com");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(kelime + Keys.ENTER);

}
@DataProvider(name="urunler")
public Object[][] getUrunler(){
	Object[][] urunler ={{"araba"}, {"ev"}, {"anahtarlik"}, {"ayakkabi"}, {"gomlek"}};
	return urunler;
}



}
