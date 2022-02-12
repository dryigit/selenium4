@SO
Feature:  US1008 Scenario outline kullanarak farli degerlerle negative login testi
  Scenario Outline: TC13 farkli kullanici adi ve password
    Given kullanici "HMCUrl" sayfasina gider
    And  login linkine tiklar
    Then scenario outline'dan kullanici adi olarak "<username>" yazar
    And scenario outline'dan password olarak "<password>" yazar
    And Login butonuna basar
    Then giris yapilamadigini test eder

    Examples:
    |username|password|
    |MANAGER |MANAGER1|
    |manager |maNager1|
    |maNager |manAGER2|