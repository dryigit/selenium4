package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
WebDriver driver;
@BeforeClass
public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@Test
public void handleWindows() throws InterruptedException {
	driver.get("https://www.amazon.com");
	String windowHandleValue1=driver.getWindowHandle();
	System.out.println("The windows handle value of the first page: " + driver.getWindowHandle());
	
	driver.switchTo().newWindow(WindowType.WINDOW); //a new window opens
	driver.get("https://www.bestbuy.com");
	String windowHandleValue2=driver.getWindowHandle();
	System.out.println("The windows handle value of the second page: " + driver.getWindowHandle());
	
	Set<String> handleValuesSet=driver.getWindowHandles();
	System.out.println(handleValuesSet);
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.facebook.com");
	
	//amazonun açık olduğu sayfaya geçin ve nutella için arama yapın
	driver.switchTo().window(windowHandleValue1);
	WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	searchBox.sendKeys("nutella" + Keys.ENTER);
	
	//go to the page with bestbuy open and test if the title contains Best Buy
	
	driver.switchTo().window(windowHandleValue2);
	String title=driver.getTitle();
	Assert.assertTrue(title.contains("Best Buy"));
	
	//facebook açık olan sayfaya geçin ve url'nin https://www.facebook.com olduğunu test edin.
	//eğer açık olan pencerelerden sadece b,rtanesinin window handle değeri bilinmiyorsa
	//önce tüm handle değerlerini bulup bir set'e koyarız.
	
	handleValuesSet=driver.getWindowHandles();
	
	
	
	//bu soru için şu anda sette 3 window handle değeri var.
	//1. ve ikinci sayfanın window handle değerlerini biliyoruz.
	// set'imizde olup ilk iki sayfa olmayan handle değeri 3. sayfanın handle değeri olacaktır.
	
	String windowHandleValue3="";
	for(String each: handleValuesSet)
	{
		if(!(each.equals(windowHandleValue1) || each.equals(windowHandleValue2))){
			windowHandleValue3=each;
		}
	}
	System.out.println(windowHandleValue3);
	System.out.println(handleValuesSet);
	
	driver.switchTo().window(windowHandleValue3);
	Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
	
	Thread.sleep(5000);
	
}

@AfterClass
public void tearDown(){
	driver.quit();
}

}
