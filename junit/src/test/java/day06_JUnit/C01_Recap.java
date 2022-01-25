package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Recap {

public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	//	2- Go to https://www.google.com/
	driver.get("https://google.com");
//	4-Test if the page title contains "Google"
	
	String title=driver.getTitle();
	String searcherWord="Google";
	
	if(title.contains(searcherWord)){
		System.out.println("Title test is PASS");
	} else {
		System.out.println("Title test is FAILED");
	}
	
//	5- Search “Nutella”
	WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
	search.sendKeys("Nutella");
	search.submit();
	
//	6-Print the number of results found. Test if the number of results is more than 10 million

	WebElement searchResults = driver.findElement(By.xpath("//div[@id='result-stats']"));
	String numOfResults=searchResults.getText();
	System.out.println(numOfResults);
	String numWords[]=numOfResults.split(" ");
	String resultsNutellaText=numWords[1];
	resultsNutellaText=resultsNutellaText.replace(".","");
	int nutellaresult=Integer.parseInt(resultsNutellaText);
	
	System.out.println(nutellaresult);
	
	if (nutellaresult>10000000){
		System.out.println("Nutella test PASSED");
	} else {
		System.out.println("Nutella test FAILED");
	}
	
//	8-Close the page
	driver.close();
	
}
}
