   package stepdefinitions;
   import com.github.javafaker.Faker;
   import io.cucumber.java.en.Then;
   import io.cucumber.java.en.When;
   import org.junit.Assert;
   import org.openqa.selenium.Keys;
   import pages.RegisterPage;
   import utilities.ConfigReader;
   import utilities.Driver;
   public class RegisterUserStepDefs {
       RegisterPage registerPage= new RegisterPage();
       //steps
       @When("kullanici tarayiciyi baslatir")
       public void kullanici_tarayiciyi_baslatir() {
           Driver.getDriver();
       }
       @Then("kullanici anasayfaya gider")
       public void kullanici_anasayfaya_gider() {
           Driver.getDriver().get(ConfigReader.getProperty("siteUrl"));
       }
       @Then("ana sayfanin gorunur oldugunu test eder")
       public void ana_sayfanin_gorunur_oldugunu_test_eder() {
       Assert.assertTrue(registerPage.homeButton.isDisplayed());
       }
       @Then("kullanici signup-login butonuna tiklar")
       public void kullaniciSignupLoginButonunaTiklar() {
           registerPage.loginButton.click();
       }
       @Then("kullanici,New User Signup! in gorunur oldugunu test eder")
       public void kullanici_new_user_signup_in_gorunur_oldugunu_test_eder() {
           Assert.assertTrue(registerPage.signUpYazisi.isDisplayed());
       }
       @When("kullanici olarak isim ve maili girer")
       public void kullaniciOlarakIsimVeMailiGirer() {
           Faker faker=new Faker();
           registerPage.name.sendKeys(faker.name().name());
           registerPage.name.sendKeys(Keys.TAB);
           registerPage.email.sendKeys(faker.internet().emailAddress());
       
       }
       @Then("signup butonuna tiklar")
       public void signupButonunaTiklar() {
       }
       @Then("acilan sayfada ENTER ACCOUNT INFORMATION yazisinn gorunur oldugunu test eder")
       public void acilanSayfadaENTERACCOUNTINFORMATIONYazisinnGorunurOldugunuTestEder() {
       }
   }