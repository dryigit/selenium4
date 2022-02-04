package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCamp;

import java.util.List;

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
	hotelMyCamp=new HotelMyCamp();
	hotelMyCamp.loginMethod();
	//○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
	//header kısmında birinci satır ve altındaki dataları locate edelim
	
	//thead /tr[1]//th
	//○ table body’sinde bulunan toplam satir(row) sayısını bulun.
	
	hmcWebTablePage= new HMCWebTablePage();
	List<WebElement> headerDataList=hmcWebTablePage.headerFirstRowDatas;
	System.out.println("number of rows is "+ headerDataList.size());
	
	//○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
	
	System.out.println(hmcWebTablePage.allBodyWebElements.getText());
	//eğer body yi tek bir webelement olarak locate edersek
	//içindeki tüm dataları gettext ile yazdırabiliriz
	//ancak bu durumda bu elementler ayrı ayro değil
	// body'nin içindeki tek bir stringin parçaları olur.
	
	List <WebElement> bodyAllDataList=hmcWebTablePage.allBodyDataList;
	System.out.println("body'deki data sayısı "+ bodyAllDataList.size());
}
@Test
public void printRows(){


}
}
