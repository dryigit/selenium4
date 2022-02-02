package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class AmazonPage {
//bir page class'ı açtığımızda ilk yapmamız gereken şey
//parametresiz bir contructor oluşturup
//bu constructor içinde PageFactory ile driver'a ilk değer atamasını yapmak olmalıdır.

public AmazonPage(){
	PageFactory.initElements(Driver.getDriver(),this);
	
}
@FindBy(id="twotabsearchtextbox")
public WebElement amazonSearchBox;

@FindBy (xpath="(//div[@class='sg-col-inner'])[1]")
public WebElement amazonResultText;
}
