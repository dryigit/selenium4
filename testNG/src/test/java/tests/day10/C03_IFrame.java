package tests.day10;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
public class C03_IFrame {
WebDriver driver;
@BeforeClass
public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@Test
public void iFrameTesti(){
	//   go to https://the-internet.herokuapp.com/iframe
	driver.get("https://the-internet.herokuapp.com/iframe");
	//   test that “An IFrame containing….” text is enabled and print it
	WebElement searchedText=driver.findElement(By.tagName("h3"));
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertTrue(searchedText.isEnabled(),"Iframe text is not displayed");
	System.out.println(searchedText.getText());
	// Print Hello World to the text box.
	// Since the text box we want to write in is inside the iframe, we cannot access it directly.
	// First we need to locate the iframe and switch  into it.
	WebElement iFrame=driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(iFrame);
	WebElement textBox=driver.findElement(By.tagName("p"));
	textBox.clear();
	textBox.sendKeys("Hello World");
	// Click the "Elemental Selenium" link under the TextBox
	// Since we made the switch inside the iframe above, we have to return to the main page when we want to exit again
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
	// Verify that the text "Sponsored by Sauce Labs" is visible on the new page and print it in the console.
	// We could not locate the article because the sponsored text
	// was on the new page and the driver remained on the old page.
	WebElement sponsoredTextElement=driver.findElement(By.xpath("//p[text()='Sponsored by ']"));
	softAssert.assertTrue(sponsoredTextElement.isDisplayed(),"Sponsored text is not displayed");
	softAssert.assertAll();
}

@AfterClass
public void teardown(){
	driver.quit();
}

}