package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterGonul;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

public class US04_Gonul extends ReportMethods {


    static LocaterGonul locaterGonul = new LocaterGonul();
    Faker faker = new Faker();


    @Test
    public void testCase01() {

        extentTest= extentReports.createTest("US4-TC01","Shipping adres ekleyebilme");

//      Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Faker faker = new Faker();
        extentTest.info("Hubconfy sayfasına gidildi");

//      Kullanıcı Register butonunu tıklar.
        ReusableMethods.bekle(3);
        ReusableMethods.click(locaterGonul.userRegisterButton);

//      UserName ,email,password kutularına valid bir deger girer.
        locaterGonul.userNameBox.sendKeys(faker.name().username());
        locaterGonul.e_mailBox.sendKeys(faker.internet().emailAddress());
        locaterGonul.userPasswordBox.sendKeys(faker.internet().password());


//      checkbox tıklar
        locaterGonul.policyAgreementBox.click();


//      Sıgn Up butonuna tıklar
        locaterGonul.userSignUpButton.click();
        extentTest.info("sign in işlemi yapıldı");


//      My account sayfasına erişildiği dogrulanır.
        Assert.assertTrue(locaterGonul.homePageLogo.isDisplayed());
        ReusableMethods.bekle(3);
        extentTest.info("MyAccount sayfasına erişildiği dogrulandı");


//     Sayfanın en altındaki My Account butonuna tıklar.

        ReusableMethods.scroll(locaterGonul.myAccountButonu);
        ReusableMethods.bekle(5);
        locaterGonul.myAccountButonu.click();
        extentTest.info("MyAccount butonuna tıklandı");

//      Acılan sayfada Adres butonuna tıklar.
        ReusableMethods.bekle(3);
        locaterGonul.adressButonu.click();
        extentTest.info("Adres butonuna tıklandı");


//     Kullanıcı Add butonunu tıklar.
        ReusableMethods.bekle(3);
        locaterGonul.shippingaddButton.click();
        extentTest.info("Add butonuna tıklandı");


//   First name, Last name, Country/Region, Street address, Town / City, State ve ZIP Code  girilmeli


//      Kullanıcı first name girer.
        locaterGonul.shippingfirstName.sendKeys(faker.name().firstName());

//     Kullanıcı last name girer.
        locaterGonul.shippinglastName.sendKeys(faker.name().lastName());

//     Kullanıcı city girer.
        locaterGonul.shippingcity.sendKeys(faker.address().city());

//     Kullanıcı Street adress girer.
        locaterGonul.shippingstreet.sendKeys(faker.address().fullAddress());

//     Kullanıcı country girer.
        Select select = new Select(locaterGonul.shippingcountry);
        select.selectByVisibleText("Turkey");

//      Kullanıcı postcode girer.
        locaterGonul.shippingpostcode.sendKeys(faker.address().zipCode());

//      Kullanıcı State girer
        Select select1 = new Select(locaterGonul.shippingstate);
        select1.selectByIndex(1);
        extentTest.info("Açılan adres sayfasında doldurulması zorunlu alanlar dolduruldu");


// Save Address butonuna tıklayarak Shipping Addrese (Teslimat Adresi) eklenmeli

//      Kullanıcı Save Adress butonunu tıklar.
        ReusableMethods.bekle(4);
//      locaterGonul.shippingsaveAdress.click();
        ReusableMethods.click(locaterGonul.shippingsaveAdress);
        extentTest.info("Save adress butonuna tıklandı ");

//      Kullanıcı Shipping Addrese (Teslimat Adresi) eklendi yazısını görmeli
        Assert.assertTrue(locaterGonul.successMessage.getText().contains("Address changed successfully."));
        extentTest.info("Shipping Addrese (Teslimat Adresi) eklendi yazısının göründüğü test edildi");

        locaterGonul.signoutButton.click();
        locaterGonul.logoutButton.click();



    }

    @Test
    public void testCase02() {

//First name, Last name, Country/Region, Street address, Town / City, State ve ZIP Code  boş bırakılır.

        extentTest=extentReports.createTest("US4-TC02","Shipping adres ekleyebilme");
//        Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Faker faker = new Faker();
        extentTest.info("Hubconfy sitesine gidildi");

//      Kullanıcı Register butonunu tıklar.
        locaterGonul.userRegisterButton.click();

//      UserName ,email,password kutularına valid bir deger girer.
        locaterGonul.userNameBox.sendKeys(faker.name().username());
        locaterGonul.e_mailBox.sendKeys(faker.internet().emailAddress());
        locaterGonul.userPasswordBox.sendKeys(faker.internet().password());


//      checkbox tıklar
        locaterGonul.policyAgreementBox.click();


//      Sıgn Up butonuna tıklar
        locaterGonul.userSignUpButton.click();
        extentTest.info("Sign in işlemi yapıldı.");


//      My account sayfasına erişildiği dogrulanır.
        Assert.assertTrue(locaterGonul.homePageLogo.isDisplayed());
        ReusableMethods.bekle(3);
        extentTest.info("MyAccount sayfasına erişildiği doğrulandı.");

//     Sayfanın en altındaki My Account butonuna tıklar.

        ReusableMethods.scroll(locaterGonul.myAccountButonu);
        ReusableMethods.bekle(10);
        locaterGonul.myAccountButonu.click();
        extentTest.info("MyAccount butonuna tıklandı.");

//      Acılan sayfada Adres butonuna tıklar.
        ReusableMethods.bekle(3);
        locaterGonul.adressButonu.click();
        extentTest.info("Adress butonuna tıklandı.");


//     Kullanıcı Add butonunu tıklar.
        ReusableMethods.bekle(3);
        locaterGonul.shippingaddButton.click();
        extentTest.info("Add butonuna tıklandı.");



//        Kullanıcı first name boş bırakılır
        ReusableMethods.bekle(5);

        locaterGonul.shippingfirstName.sendKeys("");

//        Kullanıcı last name boş bırakılır
        locaterGonul.shippinglastName.clear();
        locaterGonul.shippinglastName.sendKeys("");

//        Kullanıcı city boş bırakılır
        locaterGonul.shippingcity.clear();
        locaterGonul.shippingcity.sendKeys("");

//        Kullanıcı Street adress boş bırakılır
        locaterGonul.shippingstreet.clear();
        locaterGonul.shippingstreet.sendKeys("");

//        Kullanıcı postcode boş bırakılır
        locaterGonul.shippingpostcode.clear();
        locaterGonul.shippingpostcode.sendKeys("");
        extentTest.info("Doldurulması zorunlu alanlar boş bırakıldı.");


//     Kullanıcı Save Adress butonunu tıklar.
        ReusableMethods.bekle(3);
        //locaterGonul.shippingsaveAdress.click();
        ReusableMethods.click(locaterGonul.shippingsaveAdress);
        extentTest.info("Save adress butonuna tıklandı.");

//     Kullanıcı zorunlu alanlar boş bırakılamaz yazısını görmeli

        Assert.assertTrue(locaterGonul.unsuccessMessage.getText().contains("ZIP Code is a required field."));
        extentTest.info("Doldurulması zorunlu alanlar boş bırakılamaz yazısının göründüğü doğrulandı");


        locaterGonul.signoutButton.click();
        locaterGonul.logoutButton.click();
        Driver.closeDriver();
    }
}