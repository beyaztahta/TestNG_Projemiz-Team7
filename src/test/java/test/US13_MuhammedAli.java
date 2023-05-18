package test;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterMuhammedAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US13_MuhammedAli {
    WebDriver driver;

    @Test(priority = 24)     // WEB SİTESİNE GİT
    public void ____Web_Sitesine_Giris() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));                            // Web sitesine git.

        LocaterMuhammedAli giris = new LocaterMuhammedAli();
        giris.signInButton.click();                                             // Sign In butonunu tıkla
        giris.userNameGir.sendKeys(ConfigReader.getProperty("userName_M"));      // Kullanıcı adını gir
        giris.sifreGir.sendKeys(ConfigReader.getProperty("password_M"));         // Şifreyi gir
        giris.loginOnay.click();                                                // Sign Butonuna tıkla

        // Sayfanın en altına git
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);                                               //  5 saniye bekleyecek
        giris.MyAccountTikla.click();                                           // My Account sayfasını aç
    }
    @Test(priority = 25)     // MY ACCOUNT SAYFASINDAKİ ADDRESSES SEÇENEĞİ TIKLANMALI
    public void US13_TC01_01_AdresSecenegiTiklanmali() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.AdresSecenegiTik.click();
    }

    @Test(priority = 26)     // ADDRESSES SAYFASI AÇILMALI
    public void US13_TC01_02_AdresSayfasiAcilmali() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.AdresSayfasiAc.getText().contains("Addresses"));
    }

    @Test(priority = 27)     // SHIPPING ADRESS ALTINDAKİ ADD TIKLANLI
    public void US13_TC01_03_ShippingAdresADD_Tiklanmali() throws InterruptedException {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.ShippingAdresADD_Tikla.click();
        Thread.sleep(1000);
        ReusableMethods.tumSayfaResmi("_US13_Status_Icin_Ekran_Goruntusu_Ust");     // "Status ekranda görünmüyor" görüntüsü sayfa üst kısmı
    }

    @Test(priority = 28)     // FIRST NAME ALANINA İSİM GİRİLMELİ
    public void US13_TC01_04_FirstNameAlaninaIsimGirilmeli() throws InterruptedException {
        LocaterMuhammedAli isim = new LocaterMuhammedAli();
        isim.FirstNameAlaninaIsimGir.clear();
        isim.FirstNameAlaninaIsimGir.sendKeys(ConfigReader.getProperty("isim_M"));
        Thread.sleep(1000);
    }

    @Test(priority = 29)     // LAST NAME ALANINA SOYİSİM GİRİLMELİ
    public void US13_TC01_05_LastNameAlaninaIsimGirilmeli() throws InterruptedException {
        LocaterMuhammedAli soyisim = new LocaterMuhammedAli();
        soyisim.LastNameAlaninaIsimGir.clear();
        soyisim.LastNameAlaninaIsimGir.sendKeys(ConfigReader.getProperty("soyad_M"));
        Thread.sleep(1000);
    }

    @Test(priority = 30)     // COUNTRY REGION ALANINA ÜLKE İSMİ SEÇİLMELİ
    public void US13_TC01_06_CountryRegionAlaniUlkeSecilmeli() throws InterruptedException {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.CountrRegionAlaniUlkeSec.click();
        LogIn.FirstNameAlaninaIsimGir.sendKeys("Turkey" + Keys.ENTER);
        Thread.sleep(1000);
    }

    @Test(priority = 31)     // STREET ADDRESS ALANINA ADRES GİRLMELİ
    public void US13_TC01_07_StreatAddressAlaninaAdresGirilmeli() throws InterruptedException {
        LocaterMuhammedAli adres1 = new LocaterMuhammedAli();
        adres1.StreatAddressAlaninaAdresGir.clear();
        adres1.StreatAddressAlaninaAdresGir.sendKeys("Adres alanı 1.satır");
        Thread.sleep(1000);
    }

    @Test(priority = 32)     // STREET ADDRESS 2 ALANINA ADRESİN DEVAMI GİRİLMELİ
    public void US13_TC01_08_StreatAddress2AlaninaAdresGirilmeli() throws InterruptedException {
        LocaterMuhammedAli adres2 = new LocaterMuhammedAli();
        adres2.StreatAddress2AlaninaAdresGir.clear();
        adres2.StreatAddress2AlaninaAdresGir.sendKeys("Adres alanı 2.satır");
        Thread.sleep(1000);
    }

    @Test(priority = 33)     // TOWN ŞEHİR ALANINA ŞEHİR İSMİ GİRİLMELİ
    public void US13_TC01_09_TownCityAlaninaSehirGirilmeli() throws InterruptedException {
        LocaterMuhammedAli town = new LocaterMuhammedAli();
        town.TownCityAlaninaSehirGir.clear();
        town.TownCityAlaninaSehirGir.sendKeys("Trabzon");
        Thread.sleep(1000);


        // Sayfanın en altına git
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);     //  5 saniye bekleyecek

        ReusableMethods.tumSayfaResmi("_US13_Status_Icin_Ekran_Goruntusu_Alt");     // "Status ekranda görünmüyor" görüntüsü sayfa alt kısmı
    }

    @Test(priority = 34)     // STATE ALANINA BİLGİ GİRİLMELİ
    public void US13_TC01_10_StateAlaninaBilgiGirilmeli() {
        WebElement element = driver.findElement(By.tagName("body"));
        String elementText = element.getText();
        String wordToFind = "state";      // SAYFADA TIRNAK İÇİNDE VERİLEN İFADEYİ ARATIP SONUCU VERİR.
        Assert.assertTrue(elementText.contains(wordToFind));
    }

    @Test(priority = 35)     // ZIP CODE ALANINA BİLGİ GİRİLMELİ
    public void US13_TC01_11_ZipCodeAlaninaBilgiGirilmeli() throws InterruptedException {
        LocaterMuhammedAli ZipCode = new LocaterMuhammedAli();
        ZipCode.ZipCodeAlaninaBilgiGir.clear();
        ZipCode.ZipCodeAlaninaBilgiGir.sendKeys("61900");
        Thread.sleep(1000);
    }

    @Test(priority = 36)     // SAVE ADDRESS ALANINA TIKLANMALI
    public void US13_TC02_01_SaveaddressButonuTıklanmali() throws InterruptedException {
        LocaterMuhammedAli SaveButonu = new LocaterMuhammedAli();
        SaveButonu.SaveaddressButonuTikla.click();
        Thread.sleep(1000);
    }

    @Test(priority = 37)     // KAYDEDİLEN SAYFA GÖRÜNTÜLENMELİ
    public void US13_TC02_02_KayitliSayfaGoruntulenmeli() throws InterruptedException {
        WebElement element2 = driver.findElement(By.tagName("body"));
        String elementText2 = element2.getText();
        String wordToFind2 = "successfully";      // SAYFADA TIRNAK İÇİNDE VERİLEN İFADEYİ ARATIP SONUCU VERİR.
        Assert.assertTrue(elementText2.contains(wordToFind2));

        ReusableMethods.tumSayfaResmi("_US13_Kayit_Goruntusu");     // Kayıt ekran görüntüsünü alır
    }




}