package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBase {

@Test
public void nutellaTest() throws IOException {
	//amazon anasayfasına gidelim
	driver.get("https://www.amazon.com");
	//unutella için arama yapın
	WebElement searchbox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	searchbox.sendKeys("Nutella" + Keys.ENTER);
	//sonuçların nutella içerdiğini test edin
	WebElement resultText= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
	String resultText2=resultText.getText();
	Assert.assertTrue(resultText2.contains("Nutella"));
	
	//testin çalıştığını ispatı için ekran resmi alın
	
	//tüm sayfanın ss almak için 4 adım
	//1: adımda TakeScreenShot objesi oluşturalım
	
	TakesScreenshot tss=(TakesScreenshot) driver;
	//2- kaydedeceğimiz dosyayı oluşturalım
	
	File allPageSs=new File("01_ScreenShots/allpage.png");
	
	//3- bir dosya daha oluşturup ss objesi ile ss alalım
	
	File temporaryPageSs=tss.getScreenshotAs(OutputType.FILE);
	
	//4- gecici resmi kaydetmek istediğimiz asıl dosyaya kopyalayalım
	
	FileUtils.copyFile(temporaryPageSs,allPageSs);
}
}
