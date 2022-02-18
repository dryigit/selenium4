Feature: US1003 Kullanıcı DB util ile database'e bağlanıp istediği field bilgilerini listeler

  Scenario: TC03 Kullanici email listelerini görebilmeli
Given kullanici DBUtil ile HMC veri tabanina baglanir
And kullanici DBUtil ile "tHOTEL" tablosundaki "Email" verilerini alir
And DBUtil ile tum "Email" degerlerini sira numarasi ile yazdirir