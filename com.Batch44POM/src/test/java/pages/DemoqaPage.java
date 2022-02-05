package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoqaPage {
public DemoqaPage(){
	PageFactory.initElements(Driver.getDriver(),this);
}

@FindBy(xpath = "//div[@class='rt-tr']")
public WebElement baslikSatiriElementi;

@FindBy (xpath = "//div[@class='rt-th rt-resizable-header -cursor-pointer']")
public List<WebElement> basliklarWebelementiListesi;

@FindBy (xpath = "//div[@class='rt-tbody']")
public WebElement bodyTekWebElement;

@FindBy (xpath = "//div[@class='rt-td']")
public List<WebElement> tumdataWebElement;

@FindBy (xpath = "//div[@class='rt-tr-group']")
public List<WebElement> tumSatirlarWebelementList;


public void sutunYazdir(int sutunNo) {
	// ((//div[@class='rt-tr-group'])[3]//div[@class='rt-td'])[4]
	
	int satirsayisi=tumSatirlarWebelementList.size();
	String dinamikXpath;
	WebElement geciciElement;
	System.out.println(basliklarWebelementiListesi.get(sutunNo-1).getText());
	for (int i=1; i<=satirsayisi; i++) {
		dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+sutunNo+"]";
		geciciElement=Driver.getDriver().findElement(By.xpath(dinamikXpath));
		System.out.println(geciciElement.getText());
		
	}
}

public void ismeGoreMaasYazdir(String isim) {
	int satirsayisi=tumSatirlarWebelementList.size();
	String dinamikXpath;
	String satirdakiIsim;
	String salary;
	
	for(int i=1; i<satirsayisi; i++){
		dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+1+"]";
		satirdakiIsim=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();
		dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+5+"]";
		salary=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();
		
		if(satirdakiIsim.equals(isim)){
			System.out.println(salary);
		}
	}
	
}

public void hucreYazdir(int satir, int sutun) {
	
	String dinamikXpath="((//div[@class='rt-tr-group'])["+satir+"]//div[@class='rt-td'])["+sutun+"]";
	System.out.println(Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText());
	
	
	
}
}
