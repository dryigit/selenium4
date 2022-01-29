package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

@Test
public void isExist(){
//   4. Then, let's test whether the file was downloaded successfully in the isExist( ) method.
	String downloadedFile=System.getProperty("user.home") + "/Downloads/download.png";
	Assert.assertTrue(Files.exists(Paths.get(downloadedFile)));

}
@Test
public void downloadTest() throws InterruptedException {
	
	//go to https://the-internet.herokuapp.com/download
	driver.get("https://the-internet.herokuapp.com/download");
	
	
//  - Download download.png file
	driver.findElement(By.xpath("//a[text()='download.png']")).click();
	Thread.sleep(3000);

}
}
