package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.TeknosaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TeknosaStepDefinitions {

    TeknosaPage teknosaPage = new TeknosaPage();

    @Given("Uygulama baslatilir")
    public void uygulama_baslatilir() {

        Driver.getAndroidDriver();
    }

    @When("Ilk ekran bolumunden atlaya tiklanir")
    public void ılk_ekran_bolumunden_atlaya_tiklanir() {

        teknosaPage.atlaButonu.click();
        ReusableMethods.bekle(2);
        teknosaPage.dontAllow.click();
        ReusableMethods.bekle(2);
    }

    @When("footer bolumunden {string} bolumune tiklanir")
    public void footer_bolumunden_bolumune_tiklanir(String string) {

        teknosaPage.kategorilerButonu.click();
        ReusableMethods.bekle(2);
    }

    @When("kategoriler bolumunden kaydirarak {string} bolumune tiklanir")
    public void kategoriler_bolumunden_kaydirarak_bolumune_tiklanir(String kategoriSecim) {

        ReusableMethods.dikeyKaydirma(Driver.getAndroidDriver(), 0.80, 0.20, 0.50, 100);
        ReusableMethods.bekle(2);
        ReusableMethods.scrollWithUiScrollableAndClick(kategoriSecim);
    }

    @When("acilan sayfadan {string} secimi yapilir")
    public void acilan_sayfadan_secimi_yapilir(String urun) {

        ReusableMethods.scrollWithUiScrollableAndClick(urun);
        ReusableMethods.bekle(2);
    }

    @When("filtrele bolumune tiklanir")
    public void filtrele_bolumune_tiklanir() {

        teknosaPage.filtreleButonu.click();
        ReusableMethods.bekle(2);
    }

    @Then("Marka {string} bolumunden marka secimi yapilir")
    public void marka_bolumunden_marka_secimi_yapilir(String marka) {

        teknosaPage.markaButonu.click();
        ReusableMethods.bekle(2);
        teknosaPage.markaMetinYazmaKutusu.sendKeys(marka);
        ReusableMethods.bekle(2);
        teknosaPage.filtrelenmisMarkaKutusu.click();
        ReusableMethods.bekle(2);
        teknosaPage.sonuclariGosterButonu.click();
        ReusableMethods.bekle(2);
    }

    @When("kategoriler bolumunden {string} bolumune tiklanir")
    public void kategoriler_bolumunden_bolumune_tiklanir(String kategori) {

        ReusableMethods.scrollWithUiScrollableAndClick(kategori);
        ReusableMethods.bekle(2);
    }

    @When("Siralama yapilarak {string} secilir")
    public void siralama_yapilarak_secilir(String siralamaSecimi) {

        teknosaPage.siralaButonu.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scrollWithUiScrollableAndClick(siralamaSecimi);
        ReusableMethods.bekle(2);
    }

    @Then("Fiyatlarin artan duzende oldugu test edilir")
    public void fiyatlarin_artan_duzende_oldugu_test_edilir() {

        String artanDusukFiyat = teknosaPage.artanDusukFiyat.getText();
        artanDusukFiyat = artanDusukFiyat.replaceAll("\\D", "");
        ReusableMethods.bekle(2);

        ReusableMethods.dikeyKaydirma(Driver.getAndroidDriver(), 0.80, 0.20, 0.50, 100);
        ReusableMethods.bekle(2);

        String artanYuksekFiyat = teknosaPage.artanYuksekFiyat.getText();
        artanYuksekFiyat = artanYuksekFiyat.replaceAll("\\D", "");

        Assert.assertTrue(Integer.parseInt(artanYuksekFiyat) > Integer.parseInt(artanDusukFiyat));
    }

    @When("{string} bolumune tiklanir")
    public void bolumune_tiklanir(String kategori) {

        ReusableMethods.scrollWithUiScrollableAndClick(kategori);
        ReusableMethods.bekle(2);
    }

    @Then("Kullanici ekran fotografi almak icin {string} secer")
    public void kullanici_ekran_fotografi_almak_icin_secer(String ekranGoruntusu) throws IOException {

        ReusableMethods.bekle(2);
        ReusableMethods.screenShotElement(ekranGoruntusu);
    }

}
