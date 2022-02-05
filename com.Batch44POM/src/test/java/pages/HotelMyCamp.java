package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCamp {
public HotelMyCamp(){
	PageFactory.initElements(Driver.getDriver(),this);
	
}

@FindBy (xpath = "(//a[normalize-space()='Log in'])[1]")
public WebElement login;

@FindBy(xpath = "//input[@id='UserName']")
public WebElement username;

@FindBy(xpath = "//input[@id='Password']")
public  WebElement password;

@FindBy(xpath = "//input[@type='submit']")
public WebElement loginButton;

@FindBy (xpath = "//div[@class='validation-summary-errors']")
public WebElement unableToLoginScreen;

@FindBy(xpath="//span[text()='ListOfUsers']")
public WebElement successfullyLoggedInElement;

@FindBy(xpath = "(//span[normalize-space()='Hotel Management'])[1]")
public WebElement hotelManagementLink;

@FindBy (xpath = "(//a[normalize-space()='Hotel List'])[1]")
public WebElement hotelListLink;

@FindBy (xpath = "//a[@class='btn btn-circle btn-default']")
public WebElement addHotelLink;

@FindBy (xpath = "//input[@id='Code']")
public WebElement addHotelCodeBox;

@FindBy ( xpath="//select[@id='IDGroup']")
public WebElement addHotelTypeSelectBox;

@FindBy (xpath="//button[@id='btnSubmit']")
public WebElement addHotelSaveButton;

public void wait(int seconds) {
	
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}

public void loginMethod(){
	Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
	login.click();
	username.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
	password.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
	loginButton.click();
}


}
