package tests.day21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.Set;

public class C01_WindowHandleReusableMethods {

@Test
public void test(){
	//https://the-internet.herokuapp.com/windows adresine gidin
	//new tab butonuna tıklayın
	//new taba gidip title ı test edin
	
	Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
	String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
	Driver.getDriver().findElement(By.linkText("Click Here")).click();
	Set<String> handleSeti= Driver.getDriver().getWindowHandles();
	String ikinciSayfaHandle="";
	for (String each : handleSeti){
		if (!each.equals(ilkSayfaWindowHandle)){
			ikinciSayfaHandle=each;
		}
	}
	Driver.getDriver().switchTo().window(ikinciSayfaHandle);
	String expectedTitle="New Window";
	String actualTitle=Driver.getDriver().getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
	Driver.closeDriver();
}

@Test
public void windowHandleReusableWindow() throws IOException {
	Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
	Driver.getDriver().findElement(By.linkText("Click Here")).click();
	ReusableMethods.switchToWindow("New Window");
	String expectedTitle="New Window";
	String actualTitle=Driver.getDriver().getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
	ReusableMethods.getScreenshot("Window Switch");
	Driver.closeDriver();
}
}
