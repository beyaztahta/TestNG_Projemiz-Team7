package test;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterElif;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.*;
import static utilities.ReusableMethods.ddmVisibleText;

public class Elif_US03_TC02_TC03 {
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

        //Kullanicı"Email Address" text box'ında kayıt olduğu email adresinin otomatik olarak göründüğünü doğrular
        scroll(locater.billingEmailVerify);
        bekle(1);
        Assert.assertTrue(locater.billingEmailVerify.isDisplayed());

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
        locater.billingPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        //Kullanicı Save Address butonuna tıklar
        scroll(locater.billingAdressesPage);
        click(locater.billingAdressesPage);

        //Kullanici "Address changed successfully." yazisini  gorur
        bekle(3);
        Assert.assertTrue(locater.billing50FirstNameAlert.isDisplayed());

        //Kullanici "Billing Address" kismina bilgilerin eklendigini gorur
        bekle(3);
        Assert.assertTrue(locater.registrationPageText.isDisplayed());


    }
}
