package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotWebElement extends TestBase {

@Test
public void nutellaTest() throws IOException {
	//amazon anasayfasına gidelim
	driver.get("https://www.amazon.com");
	//nutella için arama yapın
	WebElement searchbox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	searchbox.sendKeys("Nutella" + Keys.ENTER);
	//sonuçların nutella içerdiğini test edin
	WebElement resultText= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
	String resultText2=resultText.getText();
	Assert.assertTrue(resultText2.contains("Nutella"));
	
	//testin çalıştığını ispatı için sonuç yazısı web elementinin ekran resmi alın
	
	//ss çekeceğimiz web elementi locate edelim
	
	
	//ss kaydedeceğimiz bir dosya oluşturuyoruz
	File webelementss=new File("01_ScreenShots/webelement.jpg");
	//
	File tempoaryss=resultText.getScreenshotAs(OutputType.FILE);
	
	//
	FileUtils.copyFile(tempoaryss,webelementss);
	
	
}
}