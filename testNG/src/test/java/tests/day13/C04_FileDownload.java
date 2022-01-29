package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

//   2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )


@Test
public void isExist(){
//   4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
	String downloadedFile=System.getProperty("user.home") + "/Downloads/download.png";
	Assert.assertTrue(Files.exists(Paths.get(downloadedFile)));

}
@Test
public void downloadTest() throws InterruptedException {
	
	//   3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
	//   - https://the-internet.herokuapp.com/download adresine gidelim.
	driver.get("https://the-internet.herokuapp.com/download");
	
//  - download.png dosyasını indirelim
	driver.findElement(By.xpath("//a[text()='download.png']")).click();
	Thread.sleep(3000);

}
}
