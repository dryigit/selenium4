package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class Exercise01 extends TestBase {

@Test
public void test() throws InterruptedException {
	// 1) go to "https://www.facebook.com/"
	driver.get("https://www.facebook.com");
	// 2) CLICK THE CREATE NEW ACCOUNT BUTTON
	driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
	Thread.sleep(3000);
	// 3) GET LIST OF DAYS IN THE BIRTH DATE SECTION
	WebElement birthday = driver.findElement(By.xpath("//select[@name='birthday_day']"));
	Select select = new Select(birthday);
	List<WebElement>days=select.getOptions();
	String daysList="";
	for(WebElement each : days){
		System.out.print(each.getText() + " ,");
	}
	System.out.println();
	
	// 4) GET LIST OF MONTHS IN THE BIRTH DATE SECTION
	WebElement birthMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
	Select select2 = new Select(birthMonth);
	List<WebElement>months = select2.getOptions();
	String monthList="";
	for(WebElement each : months){
		System.out.print(each.getText() + ", ");
	}
	System.out.println();
	
	// 5) GET LIST OF YEARS IN THE BIRTH DATE SECTION
	WebElement birthYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
	Select select3=new Select(birthYear);
	List<WebElement> birthdayYear = select3.getOptions();
	String birthYearList="";
	for(WebElement each :birthdayYear ){
		System.out.print(each.getText() + ", ");
	}
}
}

