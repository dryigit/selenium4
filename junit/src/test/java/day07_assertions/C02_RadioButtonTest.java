package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public  class C02_RadioButtonTest {
WebDriver driver;
@Before
public void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();

}

@Test
public void test01(){

//  2. go to https://www.facebook.com
	driver.get("https://www.facebook.com");
	
//  click “Create an Account” button
	WebElement createAccount = driver.findElement(By.xpath("(//a[normalize-space()='Create New Account'])[1]"));
	createAccount.click();
	
//  locate “radio buttons” element
//  If it is not selected, choose the one that suits you from the gender button.
	driver.findElement(By.xpath("(//label[normalize-space()='Male'])[1]")).click();

}

@After
public void teardown() {

	driver.close();
}
}
