package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_FirstTestMethod {
	WebDriver driver;
	
	@Test
	public void test01() {
		//go to www.amazon.com and test that title contains "amazon"
		driver.get("https://www.amazon.com");
		String actualTitle= driver.getTitle();
		String expectedWord="amazon";
		
		if (actualTitle.contains(expectedWord)) {
			System.out.println("Amazon test PASSED");
		} else {
			System.out.println("Amazon test FAILED. The title is "+ actualTitle);
		}
	}
	
	
	@Test
	public void test02(){
		//go to www.google.com and test that th title contains "google"
		
		driver.get("https://google.com");
		String actualTitle=driver.getTitle();
		String searchedWord="google";
		if (actualTitle.contains(searchedWord)) {
			System.out.println("Goodle test PASSED");
		} else {
			System.out.println("Google test FAILED. The title is "+ actualTitle);
		}
	}
	
	
	@Before
	public void setUpSettings() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@After
	public void lastMethod(){
		
		driver.close();
	}
	
	
	
}
