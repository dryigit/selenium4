Feature: US1011 WebUniversity window handle
  @web
  Scenario Outline: TC16 Reusable mthod ile window handle

    Given kullanici "WebUniversityUrl" sayfasina gider
    And Login Portal'a  kadar asagi iner
    And Login Portal'a tiklar
    Then Diger window'a gecer
    Then "<username>" ve  "<password>" kutularina deger yazar
    And 2 saniye bekler
    Then WebUniversity login butonuna basar
    And 2 saniye bekler
    Then Popup'ta cikan yazinin "validation failed" oldugunu test eder
    And 2 saniye bekler
    Then Ok diyerek Popup'i kapatir
    Then ilk sayfaya geri doner
    And ilk sayfaya donuldugunu test eder
    And sayfayi kapatir

    Examples:
    |username|password|
    |deneme  |deneme  |