package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

@Test
public void test() throws InterruptedException {
	//go to https://the-internet.herokuapp.com/upload
	
	driver.get("https://the-internet.herokuapp.com/upload");
	
	//Let's press the chooseFile button. Let's choose the file you want to upload.
	
	WebElement fileSelectButton = driver.findElement(By.id("file-upload"));
	//Let's prepare the dynamic path of the file we will upload
	String filePath=System.getProperty("user.home")+ "/Desktop/deneme/deneme.rtf";
	//Let's send the dynamic path to the select file button with the send keys method
	fileSelectButton.sendKeys(filePath);
	//click Upload
	
	driver.findElement(By.id("file-submit")).click();
	//test that “File Uploaded!” text is displayed
	WebElement resultText=driver.findElement(By.tagName("h3"));
	Assert.assertTrue(resultText.isDisplayed());
	Thread.sleep(5000);
}
}
