package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenShotFolder extends TestBase {
// go to amazon
// with three test methods, search for Java, Nutella and Apple
//take ss of the result page

WebElement searchBox;
@Test
public void test01() throws IOException {
	driver.get("https://www.amazon.com");
	searchBox=driver.findElement(By.id("twotabsearchtextbox"));
	searchBox.sendKeys("Java" + Keys.ENTER);
	allPageSs();
}
@Test
public void test02() throws IOException {
	searchBox=driver.findElement(By.id("twotabsearchtextbox"));
	searchBox.clear();
	searchBox.sendKeys("nutella" + Keys.ENTER);
	allPageSs();
}
@Test
public void test03() throws IOException {
	searchBox=driver.findElement(By.id("twotabsearchtextbox"));
	searchBox.clear();
	searchBox.sendKeys("apple" + Keys.ENTER);
	allPageSs();
}
}