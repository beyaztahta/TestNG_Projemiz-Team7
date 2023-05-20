package test;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterElif;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import static utilities.ReusableMethods.*;
import static utilities.ReusableMethods.ddmVisibleText;

public class US03_Elif2 extends ReportMethods {
    LocaterElif locater = new LocaterElif();
    Faker faker = new Faker();

    @Test
    public void testCase01() {
        extentTest = extentReports.createTest("US03", "Email addresi; kayıt olunan e-mail adresi olarak otomatik gelmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESİNE GİDİLDİ.");

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
        extentTest.pass("ADRESS BUTONUNA TIKLANDI.");

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
        extentTest.pass("FIRST NAME ALANI DOLDULRULDU.");

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());
        extentTest.pass("LAST NAME ALANI DOLDULRULDU.");

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());
        extentTest.pass("COMPANY NAME ALANI DOLDULRULDU.");

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");
        extentTest.pass("COUNTRY DROPDOWNDAN, ALANI DOLDULRULDU.");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());
        extentTest.pass("STREET ADDRESS ALANI DOLDULRULDU.");

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());
        extentTest.pass("TOWN/CITY ALANI DOLDULRULDU.");

        //Kullanici "Zip" alanina posta kodu girer
        // click(locater.billingZipCode);
        locater.billingZipCode.sendKeys(faker.address().countryCode());
        extentTest.pass("ZIP ALANI DOLDULRULDU.");

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        extentTest.pass("PHONE ALANI DOLDULRULDU.");

        //Kullanicı"Email Address" text box'ında kayıt olduğu email adresinin otomatik olarak göründüğünü doğrular
        scroll(locater.billingEmailVerify);
        bekle(1);
        Assert.assertTrue(locater.billingEmailVerify.isDisplayed());
        extentTest.pass("EMAIL TEXT BOX INDA KAYIT OLDUGU EMAIL ADDRESININ OTOMATIK OLARAK GELDIGI DOGRULANDI. ");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");

    }

    @Test
    public void testCase02() {
        extentTest = extentReports.createTest("US03", "Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESİNE GİDİLDİ.");

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
        extentTest.pass("COUNTRY DROPDOWNDAN, ALANI DOLDURULDU.");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());
        extentTest.pass("STREET ADRESS ALANI DOLDURULDU.");

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());
        extentTest.pass("TOWN/CITY ALANI DOLDURULDU.");

        //Kullanici "Zip" alanina posta kodu girer
        locater.billingZipCode.sendKeys(faker.address().countryCode());
        extentTest.pass("ZIP ALANI DOLDURULDU.");

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        extentTest.pass("PHONE ALANI DOLDURULDU.");

        //Kullanicı Save Address butonuna tıklar
        scroll(locater.billingAdressesPage);
        click(locater.billingAdressesPage);
        extentTest.pass("SAVE ADDRESS BUTONUNA TIKLANDI.");

        //Kullanici "Address changed successfully." yazisini  gorur
        bekle(3);
        Assert.assertTrue(locater.billing50FirstNameAlert.isDisplayed());
        extentTest.pass("ADRESIN BASARI ILE KAYDEDILDIGI DOGRULANDI.");

        //Kullanici "Billing Address" kismina bilgilerin eklendigini gorur
        bekle(3);
        Assert.assertTrue(locater.registrationPageText.isDisplayed());
        extentTest.pass("ADRESS BILGILERININ EKLENDIGI DOGRULANDI.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");
    }
}
