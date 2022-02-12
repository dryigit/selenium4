Feature: US1009 Scenario outline ile Editor database sayfasına kayit
@editor
Scenario Outline: TC14 yeni kayit ekleyebilmeli

  When kullanici editor.datatables.net adresine gider
  Then new butonuna basar
  And firstname olarak "<firstname>" girer
  And lastname olarak "<lastname>" girer
  And position olarak "<position>" girer
  And office olarak "<office>" girer
  And extension olarak "<extension>" girer
  And start date olarak "<startdate>" girer
  And 1 saniye bekler
  And salary olarak "<salary>" girer
  And 1 saniye bekler
  And Create tusuna basar
  And 1 saniye bekler
  When kullanici "<firstname>" ile arama yapar
  Then isim bolumunde "<firstname>" oldugunu dogrular

  Examples:
  |firstname|lastname|position|office|extension|startdate|salary|
  |mehmet   |bulutlu |amele   |amsterdam|1234  |2022-02-16|200  |

