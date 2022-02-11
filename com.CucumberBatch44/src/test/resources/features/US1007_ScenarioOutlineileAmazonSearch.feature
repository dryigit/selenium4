Feature: US1007 Scenario outline ile amazon search

  Scenario Outline: TC12 Amazonda bir listedeki tüm elementleri aratma
    Given kullanici "AmazonUrl" sayfasina gider
    Then "<aranacakEleman>" icin arama yapar
    And sonuclarin "<aranacakEleman>" icerdigini test eder

    Examples:
    |aranacakEleman|
    |Apple|
    |Java|
    |Samsung|
    |Armut|
    |Nutella|