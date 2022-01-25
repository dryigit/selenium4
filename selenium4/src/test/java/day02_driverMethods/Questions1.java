package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Questions1 {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	
//	Question1

//	1.Go to https://www.youtube.com
	driver.get("https://www.youtube.com");
//	2.Print the title
	System.out.println("==============Task 2 ===============");
	System.out.println(driver.getTitle());
	System.out.println();
//	3.If title is equal to “YouTube” print “correct title” otherwise “print incorrect title”
	System.out.println("==============Task 3 ===============");
	String title = driver.getTitle();
	String query="YouTube";
	if(title.equals(query)){
		System.out.println("The title of the page is correct. The title is " + title);
	}else {
		System.out.println("The title of the pase is incorrect. It is not equal to YouTube");
		System.out.println( "The title is " + title);
	}
	
//	4.Close the page
	driver.close();
	
//	5.Close the window
	driver.quit();
//	6.Print “Test completed”
	System.out.println();
	System.out.println("==============Task 6 ===============");
	System.out.println("Test completed");
	
}
}
