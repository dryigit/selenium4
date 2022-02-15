package tests.day27;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {
@DataProvider
public static Object[][] aranacakKelimeListesi() {
	String aranacaklar [][]={{"nutella"}, {"java"}, {"cucumber"}};
	return aranacaklar;
}

@Test(dataProvider = "aranacakKelimeListesi")
public void amazonSearch(String aranacaklar){
	//amazona gidip nutella için ara yapalım
	//sonuçların nutella içerdiğini test edelim
	
	Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
	AmazonPage amazonPage = new AmazonPage();
	amazonPage.amazonSearchBox.sendKeys(aranacaklar + Keys.ENTER);
	Assert.assertTrue(amazonPage.amazonResultText.getText().contains(aranacaklar));
	Driver.closeDriver();
}
}
