package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

}
