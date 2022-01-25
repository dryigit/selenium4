package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C01_IlkClass {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	
	WebDriver driver = new ChromeDriver();
	// bi< bir driver objesi oluşturduğumuzda boş bir browser sayfası açılır
	
	driver.get("https://www.amazon.com");
	//driver.get methodu driver'a gidceği web adresini girmemizi sağlar.
	
	
	Thread.sleep(3000);
	//sayfa açılır 3 saniye bekler sonra kapatır sayfayı
	
	driver.close();
	//driver'ı kapatır.
	
	
}


}
