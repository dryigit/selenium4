package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage { public RegisterPage(){
	PageFactory.initElements(Driver.getDriver(),this);
}

@FindBy (xpath="(//a[normalize-space()='Signup / Login'])[1]")
public WebElement loginButton;
	
	@FindBy (xpath = "//a[normalize-space()='Home']")
public WebElement homeButton;
	@FindBy (xpath = "//h2[normalize-space()='New User Signup!']")
public WebElement signUpYazisi;
	@FindBy (xpath = "//input[@placeholder='Name']")
public WebElement name;
	@FindBy (xpath="(//input[@type='email'])[2]")
public WebElement email;
}
