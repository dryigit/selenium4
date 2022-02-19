package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuterClick extends TestBase {

//amazon.com anasayfaya git
//sell linkine javascript executer ile tıkla

@Test
public void test() throws InterruptedException {
	driver.get("https://www.amazon.com");
	
	//1. adım javascript exdcuter objesi oluşturalım ve driver'ı cast edelim
	
	JavascriptExecutor jse= (JavascriptExecutor) driver;
	
	//2. adımda ilgili web elemnti locate edelim
	
	WebElement sellelement=driver.findElement(By.xpath("//a[normalize-space()='Sell']"));
	
	//3. adomda ilgili script ve argument ile objemiz üzerinden
	//executeScript methodunu çalıştıralım
	
	jse.executeScript("arguments[0].click();",sellelement);
	Thread.sleep(3000);
	//ilgili sayfaya gittiğini test et
	
}
}
