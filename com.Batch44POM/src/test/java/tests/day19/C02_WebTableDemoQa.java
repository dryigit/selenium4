package tests.day19;

import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTableDemoQa {

@Test
public void demoQaTest(){
	//  1. “https://demoqa.com/webtables” sayfasina gidin
	Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));
	//  2. Headers da bulunan department isimlerini yazdirin
	//	normalde //thead//th olurdu ancak bu tablo class isimleri ile organize edilmiş
	DemoqaPage demoqaPage = new DemoqaPage();
	System.out.println(" Başlık satırı elementi:   "+ demoqaPage.baslikSatiriElementi.getText());
	
	//ikinci yöntem olarak başlıkları bir listeye koyabilirim.
	
	//  3. sutunun basligini yazdirin
	System.out.println("3. sütun başlığı "+demoqaPage.basliklarWebelementiListesi.get(2).getText());
	
	//  4. Tablodaki tum datalari yazdirin
	System.out.println("----------tüm body------");
	System.out.println(demoqaPage.bodyTekWebElement.getText());
	//  5. Tabloda kac cell (data) oldugunu yazdirin
	System.out.println("tablodaki data sayısı "+ demoqaPage.tumdataWebElement.size());
	//  6. Tablodaki satir sayisini yazdirin
	System.out.println("Tüm satır sayısı "+demoqaPage.tumSatirlarWebelementList.size());
	//  7. Tablodaki sutun sayisini yazdirin
		//farklı yollardan hesaplanabilir ama biz hücr sayısı / satır sayısı yapalım
	System.out.println("tablodaki sütun sayısı: "+ (demoqaPage.tumdataWebElement.size()/demoqaPage.tumSatirlarWebelementList.size()));
	//  8. Tablodaki 3.kolonu yazdirin
	demoqaPage.sutunYazdir(3);
	//  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
	demoqaPage.ismeGoreMaasYazdir("Kierra");
	//10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
	demoqaPage.hucreYazdir(2,3);
}


}
