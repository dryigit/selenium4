package practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Q1 {

static WebDriver driver;
@BeforeClass
public static void setUp(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@AfterClass
public static void tearDown(){
	driver.close();
}
@Before
public void testtenOnce(){
	// go to http://www.google.com
	driver.get("http://www.google.com");
}
@After
public void testtenSonra(){
	System.out.println( "sonuc yazisi :" + (driver.findElement(By.xpath("//div[@id ='result-stats']")).getText()));
}
@Test
public void test1(){
	//search "Green Mile" , and print the number of results
	
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Green Mile" + Keys.ENTER);
}
@Test
public void test2(){
	//search "Premonition" , and print the number of results
	
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premonition" + Keys.ENTER);
}
@Test
public void test3(){
	//search "The Curious Case of Benjamin Button" , and print the number of results
	
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
}
}