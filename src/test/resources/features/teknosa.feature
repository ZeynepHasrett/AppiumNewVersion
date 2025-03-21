Feature: Kullanici uygulama gorevlerini yerine getirir

  Scenario: Kullanici uygulama uzerinde ilgili bolumu test eder
    Given Uygulama baslatilir
    When Ilk ekran bolumunden atlaya tiklanir
    And footer bolumunden "Kategoriler" bolumune tiklanir
    And kategoriler bolumunden kaydirarak "Ev ve Yaşam" bolumune tiklanir
    And acilan sayfadan "Aydınlatma" secimi yapilir
    And filtrele bolumune tiklanir
    Then Marka "Orbus" bolumunden marka secimi yapilir


  Scenario: Kullanici uygulama uzerinde ilgili bolumu test eder
    Given Uygulama baslatilir
    When Ilk ekran bolumunden atlaya tiklanir
    And footer bolumunden "Kategoriler" bolumune tiklanir
    And kategoriler bolumunden "Kişisel Bakım" bolumune tiklanir
    And acilan sayfadan "Saç Bakım" secimi yapilir
    And filtrele bolumune tiklanir
    Then Marka "Arzum" bolumunden marka secimi yapilir
    When Siralama yapilarak "Artan Fiyat" secilir
    Then Fiyatlarin artan duzende oldugu test edilir

  @teknosa
  Scenario: Kullanici ekran fotografi alma gorevini yerine getirir
    Given Uygulama baslatilir
    When Ilk ekran bolumunden atlaya tiklanir
    When "Kategoriler" bolumune tiklanir
    Then Kullanici ekran fotografi almak icin "Kampanyalar" secer


