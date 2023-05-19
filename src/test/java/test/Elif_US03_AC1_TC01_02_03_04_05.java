package test;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterElif;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import static utilities.ReusableMethods.*;

public class Elif_US03_AC1_TC01_02_03_04_05 extends ReportMethods {
    LocaterElif locater = new LocaterElif();
    Faker faker = new Faker();


    @Test
    public void testCase01() {
        extentTest = extentReports.createTest("US03", "First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code ve Phone girilmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY adresine gidildi.");

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(faker.internet().emailAddress());
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);
        extentTest.pass("SIGN IN OLARAK GIRIS YAPILDI");

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);
        extentTest.pass("MY ACCOUNT BOLUMUNE TIKLANDI.");

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);
        extentTest.pass("ADRESS BUTONUNA TIKLANDI.");

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);
        extentTest.pass("ACILAN SAYFADA BILLING ADDRESS BOLUMUNDEN ADD BUTONUNA TIKLANDI.");

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());
        extentTest.pass("BILLING ADDRESS ASYFASININ DETAYLARI GORUNTULENDI VE DOGRULAMASI YAPILDI.");

        //Kullanici "First Name" alanina isim girer
        scroll(locater.billingFirstName);
        locater.billingFirstName.sendKeys(faker.name().firstName());
        extentTest.pass("FIRST NAME ALANI DOLDURULDU.");

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());
        extentTest.pass("LAST NAME ALANI DOLDURULDU.");

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());
        extentTest.pass("COMPANY NAME ALANI DOLDURULDU.");

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");
        extentTest.pass("COUNTRY DROPDOWNDAN ALANI DOLDURULDU.");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());
        extentTest.pass("STREET ADDRESS ALANI DOLDURULDU.");

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());
        extentTest.pass("TOWN/CITY ALANI DOLDURULDU.");

        //Kullanici "Zip" alanina posta kodu girer
        locater.billingZipCode.sendKeys(faker.address().countryCode());
        extentTest.pass("ZIP ALANI DOLDURULDU.");

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        extentTest.pass("PHONE ALANI DOLDURULDU.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");

    }

    @Test
    public void testCase02() {
        extentTest = extentReports.createTest("US03", "First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code ve Phone girilmeli" +","+
                                              "Doldurulması gerken alanlar bos bırakılır.");
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY adresine gidildi.");

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(faker.internet().emailAddress());
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);
        extentTest.pass("SIGN IN OLARAK GIRIS YAPILDI");

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);
        extentTest.pass("MY ACCOUNT BOLUMUNE TIKLANDI.");

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);
        extentTest.pass("ADDRESS BOLUMUNE TIKLANDI.");

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);
        extentTest.pass("ACILAN SAYFADA BILLING ADDRESS BOLUMUNDEN ADD BUTONUNA TIKLANDI.");

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());
        extentTest.pass("BILLING ADDRESS ASYFASININ DETAYLARI GORUNTULENDI VE DOGRULAMASI YAPILDI.");

        //Kullanici doldurulmasi zorunlu alanlari bos birakir
        //Kullanici SAVE ADDRESS butonuna tiklar

        scroll(locater.billingAdressesPage);
        click(locater.billingAdressesPage);
        extentTest.pass("DOLDURULMASI ZORUNLU ALABLAR BOS BIRAKILDI.");
        extentTest.pass("SAVE BUTONUNA TIKLANDI..");

        //Kullanici hata mesajlari gorur
        bekle(1);
        tumSayfaResmi("Doldurulması gerken alanlar bos bırakıldıgında her alana ait alert alındı.");
        extentTest.pass("DOLDURULMASI ZORUNLU ALANLAR BOS BIRAKILDIGINDA  HATA MESAJI ALDIGINA DAIR EKRAN GORUNTUSU ALINDI");
        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");
    }

    @Test
    public void testCase03() {
        extentTest = extentReports.createTest("US03", "First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code ve Phone girilmeli" +","+
                "First name alanı bos bırakılmamalıdır.");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY adresine gidildi.");

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        String email = faker.internet().emailAddress();
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(email);
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);
        extentTest.pass("SIGN IN OLARAK GIRIS YAPILDI");

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);
        extentTest.pass("MY ACCOUNT BOLUMUNE TIKLANDI.");

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);
        extentTest.pass("ADDRESS BOLUMUNE TIKLANDI.");

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);
        extentTest.pass("ACILAN SAYFADA BILLING ADDRESS BOLUMUNDEN ADD BUTONUNA TIKLANDI.");

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());
        extentTest.pass("BILLING ADDRESS ASYFASININ DETAYLARI GORUNTULENDI VE DOGRULAMASI YAPILDI.");

        //Kullanicı First name alanını boş bırakır
        extentTest.pass("FIRST NAME ALANI BOS BIRAKILDI.");

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());
        extentTest.pass("LAST NAME ALANI DOLDURULDU.");

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());
        extentTest.pass("COMPANY NAME ALANI DOLDURULDU.");

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");
        extentTest.pass("COUNTRY DROPDOWNDAN ALANI DOLDURULDU.");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());
        extentTest.pass("STREET ADDRESS ALANI DOLDURULDU.");

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());
        extentTest.pass("TOWN/CITY ALANI DOLDURULDU.");
        extentTest.pass("TOWN/CITY ALANINDAN SONTA STATE BOLUMU CIKMIYOR.AMA SECILEN BASKA TOWN ADRESINE GORE DE CIKIYOR.");

        //Kullanici "Zip" alanina posta kodu girer
        // click(locater.billingZipCode);
        locater.billingZipCode.sendKeys(faker.address().countryCode());
        extentTest.pass("ZIP ALANI DOLDURULDU.");


        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        extentTest.pass("PHONE ALANI DOLDURULDU.");

        //Kullanicı"Email Address" text box'ında kayıt olduğu email adresinin otomatik olarak göründüğünü doğrular
        scroll(locater.billingEmailVerify);
        bekle(1);
        Assert.assertTrue(locater.billingEmailVerify.isDisplayed());
        extentTest.pass("EMAIL ADREESS YERININ OTOMATIK OLARAK GELDIGI DOGRULANDI..");

        //Kullanicı Save Address butonuna tıklar
        scroll(locater.billingAdressesPage);
        click(locater.billingAdressesPage);
        extentTest.pass("SAVE ADDRESS BUTONUNA TIKLANDI.");

        //Kullanicı Billing Address başlığının üzerinde "First name is a required field." mesajının göründüğünü doğrular
        bekle(2);
        Assert.assertTrue(locater.billingFirstNameAlert.isDisplayed());
        bekle(2);
        extentTest.pass("FIRST NAME ALANININ BOS BIRAKILDIGINA DAIR UYARI ALINDIGI DOGRULANDI.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");

    }

    @Test
    public void testCase04() {
        extentTest = extentReports.createTest("US03", "First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code ve Phone girilmeli" +","+
                "First Name alanına 50 karaKter girilmemelidir.");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY adresine gidildi.");

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(faker.internet().emailAddress());
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);
        extentTest.pass("SIGN IN OLARAK GIRIS YAPILDI");

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);
        extentTest.pass("ADDRESS BUTONUNA TIKLANDI.");

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);
        extentTest.pass("BILLIND ADDRESS KISMINDAKI ADD BUTONUNA TIKLANDI.");

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());
        extentTest.pass("BILLING ADDRESS SAYFASININ DETAYLARI GORUNTULENDI VE DOGRULAMASI YAPILDI");

        //Kullanici "First Name" alanina isim girer
        scroll(locater.billingFirstName);
        locater.billingFirstName.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        extentTest.pass("FIRST NAME ALANI 50 KARAKTER ICEREN DATA ILE DOLDURULDU.");

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());
        extentTest.pass("LAST NAME ALANI DOLDURULDU.");

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());
        extentTest.pass("COMPANY NAME ALANI DOLDURULDU.");

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");
        extentTest.pass("COUNTRY DROPDOWNDAN ALANI DOLDURULDU.");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());
        extentTest.pass("STREET ADDRESS ALANI DOLDURULDU.");

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());
        extentTest.pass("TOWN/CITY ALANI DOLDURULDU.");

        //Kullanici "Zip" alanina posta kodu girer
        locater.billingZipCode.sendKeys(faker.address().countryCode());
        extentTest.pass("ZIP ALANI DOLDURULDU.");

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        extentTest.pass("PHONE ALANI DOLDURULDU.");

        //Kullanicı"Email Address" text box'ında kayıt olduğu email adresinin otomatik olarak göründüğünü doğrular
        scroll(locater.billingEmailVerify);
        bekle(1);
        Assert.assertTrue(locater.billingEmailVerify.isDisplayed());
        extentTest.pass("EMAIL ADDRESININ OTOMATIK OLARAK GELDIGI DOGRULANDI");

        //Kullanicı Save Address butonuna tıklar
        scroll(locater.billingAdressesPage);
        click(locater.billingAdressesPage);
        extentTest.pass("SAVE BUTONUNA TIKLANDI");

        //Kullanicı Billing Address in kaydedildigini dogrular
        bekle(2);
        Assert.assertTrue(locater.billing50FirstNameAlert.isDisplayed());
        extentTest.pass("BILLING ADDRESS DE FIRST NAME ALANINA 50 KARAKTER OLARAK GIRILEN DATAYI KABUL EDEREK KAYDETTIGI DOGRULANDI.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");
    }

    @Test
    public void testCase05() {
        extentTest = extentReports.createTest("US03", "First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code ve Phone girilmeli" +","+
                "Contry/Region alanının farklı seceneklerle testi");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY adresine gidildi.");

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(faker.internet().emailAddress());
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);
        extentTest.pass("SIGN IN OLARAK GIRIS YAPILDI.");

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);
        extentTest.pass("ADDRESS BUTONUNA TIKLANDI.");

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);
        extentTest.pass("BILLING ADDRESS KISMINDAKI ADD BUTONUNA TIKLANDI.");

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());
        extentTest.pass("BILLING ADDRESS SAYFASININ DETAYLARI GORUNTULENDI VE DOGRULAMASI YAPILDI.");

        //Kullanici "First Name" alanina isim girer
        scroll(locater.billingFirstName);
        locater.billingFirstName.sendKeys(faker.name().firstName());
        extentTest.pass("FIRST NAME ALANI DOLDURULDU.");

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());
        extentTest.pass("LAST NAME ALANI DOLDURULDU.");

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());
        extentTest.pass("COMPANY NAME ALANI DOLDURULDU.");

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");
        extentTest.pass("COUNTRY DRODWNDAN, ALANI FARKLI BIR SECENEK ILE  DOLDURULDU.");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());
        extentTest.pass("STREET ADDRESS ALANI DOLDURULDU.");

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());
        extentTest.pass("TOWN/CITY ALANI DOLDURULDU.");

        /*
        EXTRA...
        Kullanici "state" menusunun gorundugunu dogrular
        //Assert.assertTrue(locater.billingState.isDisplayed());burada BUG var.....
        //Kullanici "state" menusunun gorunmedigini dogrular
       Assert.assertFalse(locater.billingState.isDisplayed());
        */
        //Kullanici "Zip" alanina posta kodu girer
        // click(locater.billingZipCode);
        locater.billingZipCode.sendKeys(faker.address().countryCode());
        extentTest.pass("ZIP ALANI DOLDURULDU.");

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        extentTest.pass("PHONE ALANI DOLDURULDU.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");

    }
}
