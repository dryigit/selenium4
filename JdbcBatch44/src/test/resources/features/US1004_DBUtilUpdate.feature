Feature: US1004 Kullanıcı kayıtlları update eder
  @hoscakal
  Scenario: TC04 Kullanıcı IDHotel değeri verilen emaili update edebilmeli
    Given kullanici DBUtil ile HMC veri tabanina baglanir
    Then tHOTEL tablosunda IDHotel degeri 1016 olan kaydin Email bilgisini "siziozleyecegiz@gmail.com" yapar