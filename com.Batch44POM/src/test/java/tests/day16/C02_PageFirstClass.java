package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageFirstClass {

//POM'de farklı classlara farklı sekilde ulasilmasi benimsenmiştir.
//Driver class'i için static yöntemi kullanıyoruz.
//page Class'ları için ise obje üzerinden kullanılması tercih edilmiştir.

@Test
public void test01(){
	//go to amazon
	Driver.getDriver().get("https://amazon.com");
	
	// search Nutella in the searchbox
	AmazonPage amazonPage= new AmazonPage();
	amazonPage.amazonSearchBox.sendKeys("nutella" + Keys.ENTER);
	// test that the results include Nutella
	String actualResult = amazonPage.amazonResultText.getText();
	Assert.assertTrue(actualResult.contains("nutella"));
	Driver.closeDriver();
}
@Test
public void test02(){
	//go to amazon
	Driver.getDriver().get("https://amazon.com");
	//search for Java
	AmazonPage amazonPage= new AmazonPage();
	amazonPage.amazonSearchBox.sendKeys("Java"+Keys.ENTER);
	//test that teh result contains java
	String actualResult=amazonPage.amazonResultText.getText();
	Assert.assertTrue(actualResult.contains("Java"));
	Driver.closeDriver();
}
}
