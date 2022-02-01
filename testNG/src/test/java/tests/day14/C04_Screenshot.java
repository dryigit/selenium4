package tests.day14;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_Screenshot extends TestBase {

@Test
public void screenshot() throws IOException {
	
	driver.get("https://www.google.com");
	//1. adım: screenshoty almak için obje oluşturalım ve değer olarak driver'ımızı atayalım
	// değer olarak driver'ı kabul etmesi için casting yapmamız lazım
	TakesScreenshot tss = (TakesScreenshot) driver;
	
	//2. adım: tüm sayfanın ss almak için bir file oluşturalım ve dosya yolunu belirtelim
	
	File allPageSS=new File("src\\allPage.png");
	
	//3. adım: oluşturduğumuz file ile takesceenshot objesini ilişkilendirelim.
	
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(allPageSS, new File("src\\tumSayfa.png"));
}
}
