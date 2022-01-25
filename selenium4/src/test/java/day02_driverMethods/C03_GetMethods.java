package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_GetMethods {



public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	//  1. Go to amazon. https://www.amazon.com/
	driver.get("https://www.amazon.com");
	
	System.out.println("================== Task 2 ================");
	
	//  2. Print the title
	System.out.println(driver.getTitle());
	
	//  3. Test that the page title contains "Amazon"
	System.out.println("================== Task 3 ================");
	String actualTitle = driver.getTitle();
	String searchedWord="Amazon";
	if (actualTitle.contains(searchedWord)) {
		System.out.println("The title test is PASS");
	} else {
		System.out.println("The title test is FAILED");
		System.out.println("The title of the page is "+ actualTitle);
	}
	
	
	//  4. Print the page address (url)
	System.out.println("================== Task 4 ================");
	System.out.println(driver.getCurrentUrl());
	
	
	//  5. Test that the page url contains "amazon".
	System.out.println("================== Task 5 ================");
	
	String actualUrl = driver.getCurrentUrl();
	String urlSearched="amazon";
	if(actualUrl.contains(urlSearched)) {
		System.out.println("The URL test is PASS");
	} else {
		System.out.println("The URL test is FAILED");
		System.out.println("The actual url is "+ actualUrl);
	}
	
	
	//  6. Print the page handle values
	System.out.println("================== Task 6 ================");
	
	System.out.println(driver.getWindowHandle());
	
	
	//  7. Test for the word "shopping" in the page HTML codes
	System.out.println("================== Task 7 ================");
	
	String actualPageSourse=driver.getPageSource();
	String searchedWordSource="shopping";
	if (actualPageSourse.contains(searchedWordSource)){
		System.out.println("The page source test is PASS");
	}else {
		System.out.println("The page source test is FAIL");
	}
	
	
	//  10. Close the page
	System.out.println("================== Task 8 ================");
	
	driver.close();
	
	
	
	
	
}





}
