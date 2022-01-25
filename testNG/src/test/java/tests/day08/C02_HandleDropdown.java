package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {
WebDriver driver;
@BeforeMethod
		public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@Test
public void dropdownTest() throws InterruptedException {
	//to select one of the options in the dropdown
	//1- locate dropdown webelement and assign it to a variable
	driver.get("https://www.amazon.com");
	WebElement dropDownElement=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	
	//2- step: create an object from select class and
	//assign the webelement pamaeter we located as pamareter
	
	Select select = new Select(dropDownElement);
	//3rd step- using select object, we can select one of the options available in the dropdown
	// using 3 select methods in select class.
	//there three methods are void so they do not return anything. They just select.
	select.selectByIndex(3);
	//if we want to print the option value we select
	System.out.println(select.getFirstSelectedOption().getText());
	Thread.sleep(3000);
	select.selectByVisibleText("Books");
	Thread.sleep(3000);
	select.selectByValue("search-alias=arts-crafts-intl-ship");
	
	//print all options
	List<WebElement>optionList=select.getOptions();
	for(WebElement each:optionList){
		System.out.println(each.getText());
	}
}
@AfterMethod
public void teardown(){
	driver.close();
}
}
