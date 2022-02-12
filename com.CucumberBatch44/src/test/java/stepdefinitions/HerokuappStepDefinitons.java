package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HerokuappPage;
import utilities.ReusableMethods;

public class HerokuappStepDefinitons {
HerokuappPage herokuapp = new HerokuappPage();

@When("Add Element butona basar")
public void add_element_butona_basar() {
herokuapp.addButonElement.click();

}
@Then("Delete butonu gorunur oluncaya kadar bekler")
public void delete_butonu_gorunur_oluncaya_kadar_bekler() {
	ReusableMethods.waitForVisibility(herokuapp.deleteButonElement, 20);

}
@Then("Delete butonunun gorunur oldugunu test eder")
public void delete_butonunun_gorunur_oldugunu_test_eder() {
Assert.assertTrue(herokuapp.deleteButonElement.isDisplayed());

}
@Then("Delete butonuna basarak butonu siler")
public void delete_butonuna_basarak_butonu_siler() {
herokuapp.deleteButonElement.click();

}
}
