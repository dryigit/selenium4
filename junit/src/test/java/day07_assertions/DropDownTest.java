package day07_assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class DropDownTest {
WebDriver driver;
@Before
    public void setUp() throws Exception {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
}
@Test
public void test(){
	driver.get("https://the-internet.herokuapp.com/dropdown");
	//Test that the first option is "Please select an option"
	String text=driver.findElement(By.xpath("(//option[@disabled='disabled'])[1]")).getText();
	String testedText="Please select an option";
	Assert.assertTrue("Please verify the text content",text.equals(testedText));
	
	//click dropdown
	WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
	dropdown.click();
	
	//click option 2
	WebElement select=driver.findElement(By.xpath("(//option[@value='2'])[1]"));
	select.click();
	
	//click the body to close the dropdown
	WebElement body=driver.findElement(By.xpath("//body"));
	body.click();
}
@After
public void tearDown(){
	//close the driver
	driver.close();
}
}