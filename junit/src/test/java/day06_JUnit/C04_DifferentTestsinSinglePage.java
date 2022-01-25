package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_DifferentTestsinSinglePage {
	
	static WebDriver driver;
	static WebElement searchBox;
	static WebElement resultsText;
	
	@Test
	public void test1() {
		//search for "Nutella" in amazon and test that the results text contains "nutella"
		searchBox.sendKeys("nutella" + Keys.ENTER) ;
		resultsText=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
		String actualNutellaResult=resultsText.getText();
		String searchedWord="nutella";
		
		if(actualNutellaResult.contains(searchedWord)){
			System.out.println("Nutella test is PASS");
		} else {
			System.out.println("Nutella test is FAILED");
		}
	}


	@Test
	public void test2() {
		
		//search for "Java" in amazon and test that the results text contains "java"
		searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		
		searchBox.clear();
		searchBox.sendKeys("java" + Keys.ENTER) ;
		resultsText=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
		
		String actualNutellaResult=resultsText.getText();
		String searchedWord="java";
		
		if(actualNutellaResult.contains(searchedWord)){
			System.out.println("Java test is PASS");
		} else {
			System.out.println("Java test is FAILED");
		}
}

	@Test
	public void test3() {
	//search for "Ali" in amazon and test that the results text contains "ali"
		searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		
		searchBox.clear();
		searchBox.sendKeys("ali" + Keys.ENTER) ;
		resultsText=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
		
		String actualNutellaResult=resultsText.getText();
		String searchedWord="ali";
		
		if(actualNutellaResult.contains(searchedWord)){
			System.out.println("Java test is PASS");
		} else {
			System.out.println("Java test is FAILED");
		}
	
}

@BeforeClass
public static void setUpSettings() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.amazon.com");
	searchBox=driver.findElement(By.id("twotabsearchtextbox"));
}

@AfterClass
public static void lastMethod(){
	
	driver.close();
}
}
