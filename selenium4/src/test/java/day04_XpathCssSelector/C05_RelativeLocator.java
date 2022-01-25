package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocator {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
//	1 ) go to https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
	driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
//	2 ) Locate Berlin with 3 different relative locators
	
	//first we need to locate the web elements on which we will describe
	WebElement sailor=driver.findElement(By.id("pid11_thumb"));
	WebElement boston=driver.findElement(By.id("pid6_thumb"));
	WebElement nyc=driver.findElement(By.id("pid3_thumb"));
	
	WebElement berlin1=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston));
	System.out.println(berlin1.getAttribute("id"));


}
}
