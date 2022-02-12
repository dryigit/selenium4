package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.EditorPage;
import utilities.Driver;

public class EditorStepDefinitions {
EditorPage editorPage= new EditorPage();
@When("kullanici editor.datatables.net adresine gider")
public void kullaniciEditorDatatablesNetAdresineGider() {
	Driver.getDriver().get("https://editor.datatables.net");
}
@Then("new butonuna basar")
public void new_butonuna_basar() {
	editorPage.newButonu.click();
	
}
@Then("firstname olarak {string} girer")
public void firstname_olarak_girer(String firstname) {
	editorPage.firstNameBox.sendKeys(firstname);
}
@Then("lastname olarak {string} girer")
public void lastname_olarak_girer(String lastname) {
	editorPage.lastNameBox.sendKeys(lastname);
}
@Then("position olarak {string} girer")
public void position_olarak_girer(String position) {
	editorPage.possitionBox.sendKeys(position);
	
}
@Then("office olarak {string} girer")
public void office_olarak_girer(String office) {
	editorPage.officeBox.sendKeys(office);
}
@Then("extension olarak {string} girer")
public void extension_olarak_girer(String extension) {
	editorPage.officeBox.sendKeys(extension);
}
@Then("start date olarak {string} girer")
public void start_date_olarak_girer(String startDate) {
	editorPage.dateBox.sendKeys(startDate + Keys.ENTER);
}
@Then("salary olarak {string} girer")
public void salary_olarak_girer(String salary) {
	editorPage.salary.sendKeys(salary);
}
@Then("Create tusuna basar")
public void create_tusuna_basar() {
	editorPage.createButonElement.click();
}
@When("kullanici {string} ile arama yapar")
public void kullanici_ile_arama_yapar(String firstname) {
	editorPage.searchBoxElement.sendKeys(firstname);
}
@Then("isim bolumunde {string} oldugunu dogrular")
public void isim_bolumunde_oldugunu_dogrular(String firstname) {
	String sonucStr=editorPage.aramasonucuElement.getText();
	Assert.assertTrue(sonucStr.contains(firstname));
}

@And("{int} saniye bekler")
public void saniyeBekler(int sure) {
	try {
		Thread.sleep(sure*1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
