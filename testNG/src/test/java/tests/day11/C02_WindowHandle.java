package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_WindowHandle {

//      		● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//      		● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//      		● Click Here butonuna basın.
//      		● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//      		● Sayfadaki textin “New Window” olduğunu doğrulayın.
//      		● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

WebDriver driver;
@BeforeClass
public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@Test
public void handleWindows(){
	//      ● https://the-internet.herokuapp.com/windows adresine gidin.
	driver.get("https://the-internet.herokuapp.com/windows");
}
}
