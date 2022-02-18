Feature: US1002 Kullanıcı DB util ile database'e bağlanıp istediği field bilgilerini okur

  Scenario: TC02 Kullanici tablo ve field ismi ile sorgu yapabilmeli

    Given kullanici DBUtil ile HMC veri tabanina baglanir
    And kullanici DBUtil ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtil ile "Price" sutunundaki verileri okur
    And DBUtil ile tum "Price" degerlerini sira numarasi ile yazdirir
    Then DBUtill ile 4. "Price" in 425 oldugunu test eder