package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Exercise3 {
static WebDriver driver;
@BeforeClass
public static void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
}
@Test
public void click100timesTest(){
	
    // click on the "Add Element" button 100 times
	WebElement addElementButton= driver.findElement(By.xpath("//button[text()='Add Element']"));
	int numOfClicks=0;
	for (int i = 0; i < 100; i++){
		addElementButton.click();
		numOfClicks++;
	}
	System.out.println("There are "+ numOfClicks + " Delete buttons now.");

	// write a function that takes a number, and clicks the "Delete" button
	int numOfDeleteClicks=0;
	for (int i = 1; i < 25; i++){
		WebElement deleteButton= driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteButton.click();
		numOfDeleteClicks++;
	}
	System.out.println("The delete button was clicked on "+ numOfDeleteClicks + " times.");
	
	// given number of times, and then validates that given number of
	// buttons was deleted
	
	List<WebElement>deleteButtonList= driver.findElements(By.xpath("//button[text()='Delete']"));
	System.out.println("The remaining number of Delete buttons is " + deleteButtonList.size());
}
}