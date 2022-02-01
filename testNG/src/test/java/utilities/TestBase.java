package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static jdk.jfr.internal.handlers.EventHandler.timestamp;


public abstract class TestBase {

protected WebDriver driver;

@BeforeClass
public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}

@AfterClass
public void teardown(){
	driver.close();
}

public void allPageSs() throws IOException {
	TakesScreenshot tss=(TakesScreenshot) driver;
	String date=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
	File wholePageSs= new File("01_ScreenShots/allpage_"+date+".png");
	File temporaryPageSs=tss.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(temporaryPageSs,wholePageSs);
}
}