package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCamp;
import utilities.Driver;

public class C01_WebTableDynamicLocates {
//3 test methodu oluşturalım

//birinci method satır numarası verdiğimde bana o satırdaki dataları yazdırsın
//ikinci method satır no ve data numarası girdiğimde verdiğim datayı yazdırsın
//üçüncü method sütun numarası verdiğimde bana tüm sütunu yazdırsın
HMCWebTablePage hmcWebTablePage;
HotelMyCamp hotelMyCamp;

@Test
public void satirYazdirTest(){
	hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.loginMethod();
	//birinci method satır numarası verdiğimde bana o satırdaki dataları yazdırsın
	//ikinci satırın locatei şöyle olur:	 //tbody//tr[2]
	//yedinci satırı yazdırmak için          //tbody//tr[7]
	hmcWebTablePage=new HMCWebTablePage();
	
	WebElement ucuncuSatirElementi=hmcWebTablePage.satirGetir(3);
	System.out.println(ucuncuSatirElementi.getText());
	Driver.closeDriver();
}
@Test
public void hucreGetirTesting(){
	//ikinci method satır no ve data numarası girdiğimde verdiğim datayı yazdırsın
	hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.loginMethod();
	hmcWebTablePage=new HMCWebTablePage();
	
	//2. satırın 4. datasi  //tbody//tr[2]//td[4]
	//4. satırın 5. datası  //tbody//tr[4]//td[5]
	System.out.println(" girdiğiniz hücredeki elementler "+hmcWebTablePage.hucreWebelementGetir(3,5));
	
	Driver.closeDriver();
}

@Test
public void sutunYazdirTesti(){
	//üçüncü method sütun numarası verdiğimde bana tüm sütunu yazdırsın
	hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.loginMethod();
	hmcWebTablePage=new HMCWebTablePage();
	
	hmcWebTablePage.sutunYazdir(4);
Driver.closeDriver();
}


}
