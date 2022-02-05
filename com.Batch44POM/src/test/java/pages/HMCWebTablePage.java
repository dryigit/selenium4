package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMCWebTablePage {
public HMCWebTablePage(){
	PageFactory.initElements(Driver.getDriver(),this);
}
@FindBy(xpath="//thead//tr[1]//th")
public List<WebElement> headerFirstRowDatas;

@FindBy (xpath = "//tbody")
public WebElement allBodyWebElements;

@FindBy (xpath = "//tbody//td")
public List <WebElement> allBodyDataList;

@FindBy (xpath = "//tbody//tr")
public List <WebElement> rowsListWebElementList;


public WebElement satirGetir(int satirNo){
	//satırları dinamik olarak locate etme metodu
	//ikinci satırın locatei şöyle olur:	 //tbody//tr[2]
	//yedinci satırı yazdırmak için          //tbody//tr[7]
	
	String satirDinamikXpath="//tbody//tr["+ satirNo + "]";
	WebElement satirElementi=Driver.getDriver().findElement(By.xpath(satirDinamikXpath));
	return satirElementi;
}


public String  hucreWebelementGetir(int satir, int sutun) {
	// 2.satirin 4.datasi   //tbody//tr[2]//td[4]
	// 4.satirin 5.datasi   //tbody//tr[4]//td[5]
	
	String dinamikHucreXpath="//tbody//tr["+ satir  +"]//td["+ sutun  +"]";
	WebElement istenenHucreElementi=Driver.getDriver().findElement(By.xpath(dinamikHucreXpath));
	String hucreDatasi=istenenHucreElementi.getText();
	
	return hucreDatasi;
}

public void sutunYazdir(int sutun) {
	// her bir satırdaki istenen sütun elementini yazdırabilmek için
	//önce satır sayısını bilmeye ihtiyacım var.
	
	int satirsayisi=rowsListWebElementList.size();
	for(int i=1; i<=satirsayisi; i++){
		System.out.println(hucreWebelementGetir(i,sutun));
	}
}
}
