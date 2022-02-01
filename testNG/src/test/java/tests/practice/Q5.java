package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
public class Q5 {

WebDriver driver;
@BeforeClass
public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
}
@Test
public void test() throws InterruptedException {

//go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
	driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
//maximize the window
	driver.manage().window().maximize();
//click on action dialog button
	driver.findElement(By.xpath("//button[@id='action']")).click();
//if need use explicitly wait
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
//click on the ok button
	
	WebElement okButton= driver.findElement(By.xpath("//button[@id='dialog-mycodemyway-action']"));
	wait.until(ExpectedConditions.elementToBeClickable(okButton));
	//Thread.sleep(4000);
	okButton.click();
//accept the iframe message
	driver.switchTo().alert().accept();
}

@AfterClass
public void tearDown(){
	driver.close();
}
}
