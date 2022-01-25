package day03_WebElementsLocators;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C01_Recap {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
//	2. Go to the youtube web page and verify if the page title is "youtube", if not, print the correct title
//	(Actual Title) in the console.
	System.out.println("===============Task 2 ==============");
	driver.navigate().to("http://www.youtube.com");
	String actualTitle=driver.getTitle();
	String querry="youtube";
	if (actualTitle.equals(querry)){
		System.out.println("The test is PASS. The actual title of the page is " + actualTitle);
	} else {
		System.out.println("The test is FAILED. \nThe actual title of the pasge is " + actualTitle);
	}
	
//	3. Verify if the page URL contains “youtube”, otherwise print the correct URL.
	
	System.out.println("===============Task 3 ==============");

	String actualUrl= driver.getCurrentUrl();
	String expectedUrl="youtube";
	
	if(actualUrl.contains(expectedUrl)){
		System.out.println("The URL test is PASS. \nThe URL of the page is "+ actualUrl);
	} else {
		System.out.println("The URL test is FAILED. \nThe URL of the page is " + actualUrl);
	}

//	4. Then go to Amazon page https://www.amazon.com/
	

	driver.navigate().to("https://www.amazon.com");
	
	
//	5. Go back to Youtube page
	driver.navigate().back();

//	6. Refresh the page
	
	driver.navigate().refresh();
	
//	7. Return to Amazon page
	driver.navigate().forward();
	
//	8. Make the page full page
	driver.manage().window().maximize();
	
//	9. Then verify if the page title contains "Amazon", otherwise print the correct title (Actual Title).
	
	System.out.println("===============Task 9 ==============");

	String actualTitle2=driver.getTitle();
	String expectedTitle2="Amazon";
	
	if(actualTitle2.contains(expectedTitle2)){
		System.out.println("Amazon title test is PASS. \nThe title of the page is " + actualTitle2);
	} else{
		System.out.println("Amazon title test is FAILED. \nThe title of the page is "+ actualTitle2);
	}
//	10. Verify if the page URL is https://www.amazon.com/, otherwise print the correct URL
	System.out.println("===============Task 10 ==============");
	
	
	String actualAmazonUrl=driver.getCurrentUrl();
	String expectedAmazonUrl="https://www.amazon.com/";
	
	if (actualAmazonUrl.equals(expectedAmazonUrl)){
		System.out.println("The Amazon URL test is PASS. \nThe actual URL is " + actualAmazonUrl);
	} else{
		System.out.println("The Amazon URL test is FAILED. \nThe actual URL is " + actualAmazonUrl);
	}
//	11.Close page
	
	driver.close();
	
}
}
