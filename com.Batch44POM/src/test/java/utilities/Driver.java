package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

public static WebDriver driver;

public static WebDriver getDriver(){
	WebDriverManager.chromedriver().setup();
	
	if(driver==null){
		driver=new ChromeDriver();
	}
	//if sayesinde kod çalışırken bir kere new keyword ile driver oluşturulacak
	//diğer kullanımlarda driver oluşturulmayacak.
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	return driver;
}
public static void closeDriver(){
	if(driver!=null){
		driver.close();
	}
	driver = null;
}
}
