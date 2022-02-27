Feature: register user functionality
  Scenario: TC01_register_page
    When kullanici tarayiciyi baslatir
    Then kullanici anasayfaya gider
    Then ana sayfanin gorunur oldugunu test eder
    Then kullanici signup-login butonuna tiklar
    And kullanici,New User Signup! in gorunur oldugunu test eder
    Then kullanici olarak isim ve maili girer