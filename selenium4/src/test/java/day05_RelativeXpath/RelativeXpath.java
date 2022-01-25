package day05_RelativeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class RelativeXpath {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	
	//	1 ) go to https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
	driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
//	2 ) Locate Berlin with 3 different relative locators
	
	//first we need to locate the web elements on which we will describe
	WebElement sailor=driver.findElement(By.id("pid11_thumb"));
	WebElement boston=driver.findElement(By.id("pid6_thumb"));
	WebElement nyc=driver.findElement(By.id("pid3_thumb"));
	WebElement byArea=driver.findElement(By.id("pid8_thumb"));
	
	
	WebElement berlin1=driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor).toLeftOf(byArea));
	WebElement berlin2=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston).toLeftOf(byArea));
	WebElement berlin3=driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc).above(sailor));
	

//	3 ) Test that relative locators work correctly

	String expectedIdValue="pid7_thumb";
	String actualIdValue1=berlin1.getAttribute("id");
	String actualIdValue2=berlin2.getAttribute("id");
	String actualIdValue3=berlin3.getAttribute("id");
	
	if(expectedIdValue.equals(actualIdValue1)){
		System.out.println("First relative locate test is PASS");
	} else{
		System.out.println("First relative locate test is FAILED");
	}
	
	if(expectedIdValue.equals(actualIdValue2)){
		System.out.println("Second relative locate test is PASS");
	} else{
		System.out.println("Second relative locate test is FAILED");
	}
	
	if(expectedIdValue.equals(actualIdValue3)){
		System.out.println("Third relative locate test is PASS");
	} else{
		System.out.println("Third relative locate test is FAILED");
	}
	
	
	driver.quit();
	
	
}
}
