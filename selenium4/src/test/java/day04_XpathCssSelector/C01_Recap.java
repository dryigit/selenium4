package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Recap {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
//	a.go to https://www.amazon.com/
	
	driver.get("https://www.amazon.com");
	
//	b. Search(ara) “city bike”
	WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	search.sendKeys("city bike" + Keys.ENTER);
	//search.submit();
	

//	c. Print the number of related results displayed on Amazon
	
	System.out.println("====================Task C ==============");
	//WebElement resultsText = driver.findElement(By.className("sg-col-inner"));
	
	WebElement resultsText = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
	//Although we could not locate this element with the class name before
	//We were able to locate with xpath using the class attribute.
	System.out.println(resultsText.getText());
	
	
	
//	d. Then click on the picture of the first result that appears.
	// WebElement firstImage = driver.findElement(By.className("s-image"));
	// firstImage.click();
	
	// for simple web elements like  click
	// We can locate directly without creating a variable and do the operation we want.
	
	driver.findElement(By.className("s-image")).click();
	Thread.sleep(3000);
	
	//driver.quit();



}
}
