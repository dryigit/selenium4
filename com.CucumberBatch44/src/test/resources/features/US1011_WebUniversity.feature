Feature: US1011 WebUniversity window handle
  Scenario Outline: TC16 Reusable mthod ile window handle

    Given kullanici "WebUniversityUrl" sayfasina gider
    And Login Portal'a  kadar asagi iner
    And Login Portal'a tiklar
    Then Diger window'a gecer
    Then "<username>" ve  "<password>" kutularina deger yazar
    Then WebUniversity login butonuna basar
    Then Popup'ta cikan yazinin "validation failed" oldugunu test eder
    Then Ok diyerek Popup'i kapatir
    Then ilk sayfaya geri doner
    And ilk sayfaya donuldugunu test eder

    Examples:
    |username|password|
    |deneme  |deneme  |