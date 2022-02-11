package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HMCPage;
import utilities.ConfigReader;

public class HotelMyCampStepDefinitions {
HMCPage hmcPage=new HMCPage();
@And("login linkine tiklar")
public void loginLinkineTiklar() {
hmcPage.mainPageLoginLinki.click();
}

@Then("kullanici adi olarak {string} girer")
public void kullaniciAdiOlarakGirer(String kullaniciTipi) {
	hmcPage.usernameTextBox.sendKeys(ConfigReader.getProperty(kullaniciTipi));
}

@And("password olarak {string} girer")
public void passwordOlarakGirer(String passwordTuru) {
	hmcPage.passwordTextBox.sendKeys(ConfigReader.getProperty(passwordTuru));
}

@And("Login butonuna basar")
public void loginButonunaBasar() {
	hmcPage.loginButonu.click();
}

@Then("basarili olarak giris yapildigini test eder")
public void basariliOlarakGirisYapildiginiTestEder() {
	Assert.assertTrue(hmcPage.basariliGirisYaziElementi.isDisplayed());
}

@And("giris yapilamadigini test eder")
public void girisYapilamadiginiTestEder() {
Assert.assertTrue(hmcPage.girisYapilamadiYaziElementi.isDisplayed());
}
}
