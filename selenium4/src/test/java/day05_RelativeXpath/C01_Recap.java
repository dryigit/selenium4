package day05_RelativeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Recap {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
//	2- https://www.amazon.com/ adresine gidin
	driver.get("https://www.amazon.com");
//	3- Browseri tam sayfa yapin
	driver.manage().window().maximize();
//	4-Sayfayi “refresh” yapin
	driver.navigate().refresh();
//	5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
	String actualTitle=driver.getTitle();
	String expectedTitle="Spend less";
	
	if(actualTitle.contains(expectedTitle)){
		System.out.println("The title test is PASS. The title is: "+actualTitle);
	} else {
		System.out.println("The title pass if FAILED");
	}
//	6- Gift Cards sekmesine basin

	WebElement giftCard=driver.findElement(By.xpath("//a[text()='Gift Cards']"));
	giftCard.click();
	
//	7- Birthday butonuna basin
	
	driver.findElement(By.xpath("//img[@alt='Birthday Gift Cards']")).click();
	
//	8- Best Seller bolumunden ilk urunu tiklayin
	driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();
//	9- Gift card details’den 25 $’i  secin
	driver.findElement(By.xpath("//button[@value='25.00']")).click();
//	10-Urun ucretinin 25$ oldugunu test edin
	
	WebElement priceElement=driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));
	String expectedPrice="$25.00";
	String actualPrice=priceElement.getText();
	
	if(actualPrice.equals(expectedPrice)){
		System.out.println("Price test is PASS");
	}else{
		System.out.println("Price test is FAILED");
	}
//	10-close the page
	driver.close();

}
}
