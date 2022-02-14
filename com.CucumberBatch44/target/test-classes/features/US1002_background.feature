
Feature: US1002 Background ile amazon search testi
  Background: amazon sayfasına gidiş
    Given kullanici amazon sayfasina gider
 # diyez ile yorum yapabiliriz.
  @paralel2
  Scenario: TC02_Amazon iPhone Search Testi

    And iPhone icin arama yapar
    Then sonuclarin iPhone icerdigini test eder
  @paralel2
  Scenario: TC03_Amazon tea pot Search Testi

    And tea pot icin arama yapar
    Then sonuclarin tea pot icerdigini test eder
  @paralel2
  Scenario: TC04_Amazon flower Search Testi

    And flower icin arama yapar
    Then sonuclarin flower icerdigini test eder