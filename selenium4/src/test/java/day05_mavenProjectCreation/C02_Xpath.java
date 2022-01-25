package day05_mavenProjectCreation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//	1. go to http://zero.webappsecurity.com sayfasina gidin
	driver.get("http://zero.webappsecurity.com");
//	2. click Signin button
	driver.findElement(By.xpath("//button[@id='signin_button']")).click();

//	3. Type  “username” to login
	WebElement username=driver.findElement(By.xpath("(//input[@id='user_login'])[1]"));
	username.sendKeys("username");
//	4. Type “password”
	WebElement password=driver.findElement(By.xpath("(//input[@id='user_password'])[1]"));
	password.sendKeys("password");

//	5. click Sign in button
	driver.findElement(By.xpath("(//input[@name='submit'])[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"final-paragraph\"]")).click();
//	6. go to Pay Bills page
	driver.findElement(By.xpath("(//li[@id='pay_bills_tab'])[1]")).click();
//	7. Type any amount you want to deposit in the amount
	WebElement amount=driver.findElement(By.xpath("(//input[@id='sp_amount'])[1]"));
	amount.sendKeys("35");
//	8. type “2020-09-10” to date section
	WebElement date=driver.findElement(By.xpath("(//input[@id='sp_date'])[1]"));
	date.sendKeys("2020-09-10");
//	9. click Pay button
	driver.findElement(By.xpath("(//input[@id='pay_saved_payees'])[1]")).click();
//	10. Test that “The payment was successfully submitted.” message is displayed
	WebElement allertContent= driver.findElement(By.xpath("(//div[@id='alert_content'])[1]"));
	String expectedContent="The payment was successfully submitted.";
	String actualContent=allertContent.getText();
	if (actualContent.equals(expectedContent)){
		System.out.println("The allert test is PASS. \nThe message written on the page is: "+ actualContent);
	} else{
		System.out.println("The allert test is FAILED.");
	}
	
	driver.quit();
}
}
