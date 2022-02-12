Feature: US1010 Herokuapp sayfasinda add butonu testi
@hero
  Scenario: TC15 sonradan gmrünen elemanlar calismali

  Given kullanici "HerokuappAddElementUrl" sayfasina gider
  When Add Element butona basar
  Then Delete butonu gorunur oluncaya kadar bekler
  And Delete butonunun gorunur oldugunu test eder
  Then Delete butonuna basarak butonu siler
  And 5 saniye bekler
  And sayfayi kapatir