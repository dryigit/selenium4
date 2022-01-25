package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class C04_DropdownAmazon {
WebDriver driver;
WebElement searchBox;
Select select;
@BeforeClass
public void setup(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
//      https://www.amazon.com/ adresine gidin.
	driver.get("https://www.amazon.com");


}
@Test
public void test1(){
//   	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
	searchBox= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	select= new Select(searchBox);
	List<WebElement> categoryNumbers=select.getOptions();
	int actualSize=categoryNumbers.size();
	int expectedSize=45;
	Assert.assertEquals(actualSize,expectedSize);
}
@Test
public void test2(){
//   	1. Kategori menusunden Books secenegini  secin
	searchBox= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	select= new Select(searchBox);
	select.selectByValue("search-alias=stripbooks-intl-ship");
//   	2. Arama kutusuna Java yazin ve aratin
	WebElement searchBox2=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	searchBox2.sendKeys("Java");
	searchBox2.submit();
//   	3. Bulunan sonuc sayisini yazdirin
	WebElement resultsText=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
	System.out.println(resultsText.getText());
//   	4. Sonucun Java kelimesini icerdigini test edin
	String actualresult=resultsText.getText();
	String expectedResult="Java";
	if(actualresult.contains(expectedResult)){
		actualresult=expectedResult;
	}
	Assert.assertTrue(actualresult.contains(expectedResult),"The results do not have JAVA");

}
@AfterClass
public void teardown(){

}
}
