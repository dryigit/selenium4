package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_YoutubeAssertions{
		
	
		static WebDriver driver;
		
		@BeforeClass
		public static void setUp(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		//go to youtube.com
		driver.get("https://youtube.com");
		}
		@Test
		public void titleTest(){
			//  ○ titleTest   => Test that the  title is “YouTube”
			
			String actualTitle=driver.getTitle();
			String searchedTitle="YouTube";
			
			Assert.assertTrue("The title is not YouTube",actualTitle.equals(searchedTitle));
		}
		@Test
		public void imageTest(){
			//  ○ imageTest   => Test that YouTube logo is (isDisplayed())
			WebElement logo=driver.findElement(By.xpath("(//ytd-topbar-logo-renderer[@id='logo'])[1]"));
			Assert.assertTrue("Logo is not enabled",logo.isDisplayed());
		}
		@Test
		public void searchBoxTest(){
			//   ○ Test that Search Box is (isEnabled())
			WebElement searchBox=driver.findElement(By.xpath("(//input[@id='search'])[1]"));
			Assert.assertTrue("Search box is not enabled",searchBox.isEnabled());
		}
		@Test
		public void wrongTitleTest(){
			//  ○ wrongTitleTest  => Test that title is not “youtube”
			String actualTitle2=driver.getTitle();
			String undesiredTitle="youtube";
			
			Assert.assertFalse("The title is youtube",actualTitle2.equals(undesiredTitle));
			
		}
		@AfterClass
		public static void teardown(){
		driver.close();
		}

	
}
