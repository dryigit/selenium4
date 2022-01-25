package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_CheckBox {

WebDriver driver;

@Before
public void  setup(){
	
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
}

@Test
public void test01() throws InterruptedException {

	// a. go to the page https://the-internet.herokuapp.com/checkboxes
	driver.get("https://the-internet.herokuapp.com/checkboxes");
	
	// b. Locate Checkbox1 and checkbox2 elements
	
	WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
	WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
	
	Thread.sleep(5000);
	// c. Click the checkbox if Checkbox1 is not selected
	if(!checkbox1.isSelected()){
		checkbox1.click();
	}
	// d. Click the checkbox if Checkbox2 is not selected
	if(!checkbox2.isSelected()){
		checkbox2.click();
	}
}

@After
public void teardown(){
driver.close();
}

}
