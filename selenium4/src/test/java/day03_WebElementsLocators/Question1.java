package day03_WebElementsLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Question1 {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
 
 
	// 4-got to https://github.com/
	driver.navigate().to("https://github.com/");
	
	// 5-Then go to https://www.hepsiburada.com/
	driver.navigate().to("https://www.hepsiburada.com/");
	
	
	// 6-Print title and url in console and again in title and url
	//Let's check if it contains the word "burada"
	
	System.out.println("The title of the page is: " + driver.getTitle());
	System.out.println("The URL of the page is: " + driver.getCurrentUrl());
	
	String actualUrl=driver.getCurrentUrl();
	String actualTitle=driver.getTitle();
	
	if (actualTitle.contains("burada") && actualUrl.contains("burada")){
		System.out.println("The title and URL test is PASS. \nThe title of teh page is "+actualTitle +"\nThe URL of the page is "+actualUrl);
	} else{
		System.out.println("The title and URL test is FAILED");
	}
	
	// 7-The go back to  https://github.com/ and refresh the page
	driver.navigate().back();
	driver.navigate().refresh();
	
	// 8-Close all pages
	driver.quit();
}
}
