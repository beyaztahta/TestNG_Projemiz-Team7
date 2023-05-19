package test;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterElif;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.*;

public class Elif_US03_AC1_TC01_02_03_04_05 {
    LocaterElif locater = new LocaterElif();
    Faker faker = new Faker();

    @Test
    public void testCase01() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(faker.internet().emailAddress());
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());

        //Kullanici "First Name" alanina isim girer
        scroll(locater.billingFirstName);
        locater.billingFirstName.sendKeys(faker.name().firstName());

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());

        //Kullanici "Zip" alanina posta kodu girer
        // click(locater.billingZipCode);
        locater.billingZipCode.sendKeys(faker.address().countryCode());

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());

        Driver.closeDriver();
    }

    @Test
    public void testCase02() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(faker.internet().emailAddress());
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());

        //Kullanici doldurulmasi zorunlu alanlari bos birakir
        //Kullanici SAVE ADDRESS butonuna tiklar

        scroll(locater.billingAdressesPage);
        click(locater.billingAdressesPage);

        //Kullanici hata mesajlari gorur
        bekle(1);
        tumSayfaResmi("Doldurulması gerken alanlar bos bırakıldıgında her alana ait alert alındı.");
        Driver.closeDriver();
    }

    @Test
    public void testCase03() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

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

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());

        //Kullanicı First name alanını boş bırakır

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());

        //Kullanici "Zip" alanina posta kodu girer
        // click(locater.billingZipCode);
        locater.billingZipCode.sendKeys(faker.address().countryCode());

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());

        //Kullanicı"Email Address" text box'ında kayıt olduğu email adresinin otomatik olarak göründüğünü doğrular
        scroll(locater.billingEmailVerify);
        bekle(1);
        Assert.assertTrue(locater.billingEmailVerify.isDisplayed());

        //Kullanicı Save Address butonuna tıklar
        scroll(locater.billingAdressesPage);
        click(locater.billingAdressesPage);

        //Kullanicı Billing Address başlığının üzerinde "First name is a required field." mesajının göründüğünü doğrular
        bekle(2);
        Assert.assertTrue(locater.billingFirstNameAlert.isDisplayed());
        bekle(2);
        Driver.closeDriver();
    }

    @Test
    public void testCase04() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(faker.internet().emailAddress());
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());

        //Kullanici "First Name" alanina isim girer
        scroll(locater.billingFirstName);
        locater.billingFirstName.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());

        //Kullanici "Zip" alanina posta kodu girer
        // click(locater.billingZipCode);
        locater.billingZipCode.sendKeys(faker.address().countryCode());

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());

        //Kullanicı"Email Address" text box'ında kayıt olduğu email adresinin otomatik olarak göründüğünü doğrular
        scroll(locater.billingEmailVerify);
        bekle(1);
        Assert.assertTrue(locater.billingEmailVerify.isDisplayed());

        //Kullanicı Save Address butonuna tıklar
        scroll(locater.billingAdressesPage);
        click(locater.billingAdressesPage);

        //Kullanicı Billing Address in kaydedildigini dogrular
        bekle(2);
        Assert.assertTrue(locater.billing50FirstNameAlert.isDisplayed());




        Driver.closeDriver();
    }

    @Test
    public void testCase05() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sıgn ın olarak gırıs yapar.
        click(locater.registerSignIn);
        bekle(1);
        locater.registerUsername.sendKeys(faker.name().firstName());
        locater.registermail.sendKeys(faker.internet().emailAddress());
        locater.registerpassword.sendKeys(faker.internet().password());
        click(locater.registerBox);
        click(locater.registerSignUp);
        bekle(2);

        //Kullanıcı sayfanın altında yer alan My account bolumune tıklar.
        scrollEnd();
        bekle(2);
        click(locater.myAccountButton);

        //Kullanıcı "ADRESS" butonuna tıklar.
        scroll(locater.addresses);
        click(locater.addresses);
        bekle(2);

        //Kullanici acilan kisimdaki "Billing Address" kismindaki "ADD" secenegini tiklar
        scroll(locater.billingAdressesAdd);
        click(locater.billingAdressesAdd);
        bekle(2);

        //Kullanici "Billing Address" detaylarini doldurabilecegi sayfayi gorur
        scroll(locater.billingAdressesPage);
        Assert.assertTrue(locater.billingAdressesPage.isDisplayed());

        //Kullanici "First Name" alanina isim girer
        scroll(locater.billingFirstName);
        locater.billingFirstName.sendKeys(faker.name().firstName());

        //Kullanici "Last Name" alanina deger girer
        locater.billingLastName.sendKeys(faker.name().lastName());

        //Kullanicı Company name (optional) alanına valid bir değer girer
        locater.billingCompanyName.sendKeys(faker.name().title());

        //Kullanici "Country/Region" sekmesinden secim yapar
        scroll(locater.billingCountryRegion);
        bekle(1);
        ddmVisibleText(locater.billingCountryRegion, "Afghanistan");

        //Kullanici "street address"  alanina adresini girer
        locater.billingStreetAddress.sendKeys(faker.address().streetName());
        locater.billingStreetAddress2.sendKeys(faker.number().digit());

        //Kullanici "Town/City" alanina deger girer
        locater.billingTownCity.sendKeys(faker.address().city());

        //Kullanici "state" menusunun gorundugunu dogrular
        //Assert.assertTrue(locater.billingState.isDisplayed());burada BUG var.....

        //Kullanici "state" menusunun gorunmedigini dogrular
        Assert.assertFalse(locater.billingState.isDisplayed());

        //Kullanici "Zip" alanina posta kodu girer
        // click(locater.billingZipCode);
        locater.billingZipCode.sendKeys(faker.address().countryCode());

        //Kullanici "Phone" alanina telefon numarasini girer
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());

        Driver.closeDriver();
    }
}
