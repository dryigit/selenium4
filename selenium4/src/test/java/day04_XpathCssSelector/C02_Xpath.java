package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.util.Elements;
import java.time.Duration;

public class C02_Xpath {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
//	1- go to https://the-internet.herokuapp.com/add_remove_elements/
	
	driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//	2- Click Add Element button
	driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
//	3- Test that the Delete button is visible
	WebElement deleteButton=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

	if (deleteButton.isDisplayed()){
		System.out.println("Delete button display test is PASS");
	} else {
		System.out.println("Delete button dispaly test is FAILED");
	}
//	4- click Delete button
		deleteButton.click();
//	5- Test that “Add/Remove Elements” is visible
	
	WebElement addText=driver.findElement(By.xpath("//h3")); //xpath format
	WebElement addText2=driver.findElement(By.tagName("h3")); //tagname format
	
	if (addText.isDisplayed()){
		System.out.println("Add/Remove Elements display test is PASS");
	} else {
		System.out.println("Add/Remove Elements test is FAILED");
	}
	driver.quit();
}
}
