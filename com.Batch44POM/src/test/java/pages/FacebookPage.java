package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static org.openqa.selenium.By.xpath;

public class FacebookPage {
public FacebookPage(){
	PageFactory.initElements(Driver.getDriver(),this);
	
}
@FindBy(xpath=("(//a[normalize-space()='Create New Account'])[1]"))
public WebElement facebookCreateNewAccount;

@FindBy(xpath = "firstname")
public WebElement facebookFirstName;

@FindBy (xpath = "lastname")
public WebElement facebookSurname;

@FindBy (xpath = "(//input[@id='email'])[1]")
public WebElement facebookLoginEmail;

@FindBy (xpath = "(//input[@id='pass'])[1]")
public WebElement facebookLoginPassword;

@FindBy (xpath = "(//button[normalize-space()='Log In'])[1]")
public WebElement facebookLoginButton;

@FindBy(xpath = "(//a[normalize-space()='Find your account and log in.'])[1]")
public WebElement errorMessage;


}
