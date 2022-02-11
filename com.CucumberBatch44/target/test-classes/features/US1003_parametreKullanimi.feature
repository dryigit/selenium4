@parametreliTest
Feature: US1003 parametre ile stepdefinition olusturmak

  Scenario: TC05_parametre kullanimi
    Given kullanici amazon sayfasina gider
    And "macbook" icin arama yapar
    Then sonuclarin "macbook" icerdigini test eder
    And sayfayi kapatir