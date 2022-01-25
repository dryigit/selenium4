package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
//	1. “https://www.saucedemo.com” Adresine gidin
	driver.get("https://www.saucedemo.com");
//	2. Username kutusuna “standard_user” yazdirin
	WebElement username = driver.findElement(By.xpath("(//input[@id='user-name'])[1]"));
	username.sendKeys("standard_user");
//	3. Password kutusuna “secret_sauce” yazdirin
	WebElement password = driver.findElement(By.xpath(" (//input[@id='password'])[1]"));
	password.sendKeys("secret_sauce");
//	4. Login tusuna basin
	driver.findElement(By.xpath("(//input[@id='login-button'])[1]")).click();
//	5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
	WebElement firstContent=driver.findElement(By.xpath("(//a[@id='item_4_title_link'])[1]"));
	String firstElement=driver.findElement(By.xpath("(//a[@id='item_4_title_link'])[1]")).getText();
	System.out.println(firstElement);
	firstContent.click();
	
//	6. Add to Cart butonuna basin
	WebElement addToCart=driver.findElement(By.xpath("(//button[normalize-space()='Add to cart'])[1]"));
	addToCart.click();
	
//	7. Alisveris sepetine tiklayin
	WebElement cart=driver.findElement(By.xpath("(//div[@id='shopping_cart_container'])[1]"));
	cart.click();
//	8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

	WebElement addedProduct=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
	String addedElement=addedProduct.getText();
	if(addedElement.equals(firstElement)){
		System.out.println("The shopping test is PASS. The name of the product is "+addedElement);
		
	}else {
		System.out.println("The shopping test is FAILED");
	}
//	9. Sayfayi kapatin
	
	driver.quit();
}
}
