package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCamp;

import java.util.List;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class C02_WebTables {
HotelMyCamp hotelMyCamp;
HMCWebTablePage hmcWebTablePage;

//● Bir class oluşturun : C02_WebTables
//● login( ) metodun oluşturun ve oturum açın.
//● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
//            ○ Username : manager
//            ○ Password : Manager1!
//● table( ) metodu oluşturun
//            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
//            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
//● printRows( ) metodu oluşturun //tr
//            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
//            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
//            ○ 4.satirdaki(row) elementleri konsolda yazdırın.

@Test
public void loginT(){
	//● Bir class oluşturun : C02_WebTables
	//● login( ) metodun oluşturun ve oturum açın.
	//● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
	//          ○ Username : manager
	//          ○ Password : Manager1!
	hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.loginMethod();
}
@Test (dependsOnMethods = "loginT")
public void table(){
	//● table( ) metodu oluşturun
	//          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
	// header kisminda birinci satir ve altindaki datalari locate edelim
	//   //thead//tr[1]//th
	hmcWebTablePage=new HMCWebTablePage();
	List<WebElement> headerDataList= hmcWebTablePage.headerFirstRowDatas;
	System.out.println("tablodaki sutun sayisi : " + headerDataList.size());
	//          ○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
	//       //tbody
	System.out.println(hmcWebTablePage.allBodyWebElements.getText());
	// Eger body'yi tek bir webelement olarak locate edersek
	// icindeki tum datalari getText() ile yazdirabiliriz
	// ancak bu durumda bu elementler ayri ayri degil,
	// body'nin icindeki tek bir String'in parcalari olurlar
	// dolayisiyla bu elementlere tek tek ulasmamiz mumkun olmaz
	// sadece contains method'u ile body'de olup olmadiklarini test edebiliriz.
	// eger her bir datayi ayri ayri almak istersek
	//  //tbody//td seklinde locate edip bir list'e atabiliriz
	List<WebElement> bodyTumDataList=hmcWebTablePage.allBodyDataList;
	System.out.println("body'deki data sayisi : " + bodyTumDataList.size());
}
@Test (dependsOnMethods = "loginT")
public void printRows(){
	//● printRows( ) metodu oluşturun //tr
	//          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
	// //tbody//tr
	hmcWebTablePage=new HMCWebTablePage();
	System.out.println(hmcWebTablePage.rowsListWebElementList.size());
	//          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
	List <WebElement> satirlarWebelementListesi=hmcWebTablePage.rowsListWebElementList;
	for (WebElement each: satirlarWebelementListesi
	) {
		System.out.println(each.getText());
	}
	//          ○ 4.satirdaki(row) elementleri konsolda yazdırın.
	System.out.println("4.satir : "+satirlarWebelementListesi.get(3).getText());
}
}