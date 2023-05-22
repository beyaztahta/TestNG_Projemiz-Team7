package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterGonul;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

public class US12_Gonul extends ReportMethods {

    LocaterGonul locaterGonul = new LocaterGonul();
    Faker faker = new Faker();

    @Test
    public void testCase01() {
        extentTest=extentReports.createTest("Hubcomfy US-12-TC01,TC02","Billing Adress eklenebilmesi");
//      Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Hubcomfy sitesine gidildi");

//      Sing in butonuna tıklanir.
        locaterGonul.signIn_vendor.click();
        ReusableMethods.bekle(2);


//      Username ya da Email inputuna veri girilir.
        locaterGonul.siginuserName.sendKeys(ConfigReader.getProperty("VendorEmail"));

//      Password inputuna veri girilir.
        locaterGonul.siginpassword.sendKeys(ConfigReader.getProperty("VendorPassword"));
        ReusableMethods.bekle(2);

//      Sigin butonuna tıklar.
        locaterGonul.sigin.click();
        ReusableMethods.bekle(2);
        extentTest.info("Vendor olarak sign in işlemi yapıldı.");

//     Sayfanın en altındaki My Account butonuna tıklar.
        ReusableMethods.scroll(locaterGonul.myAccountButonu);
        ReusableMethods.bekle(3);
        locaterGonul.myAccountButonu.click();
        extentTest.info("MyAccount butonuna tıklandı.");

//      Acılan sayfada Adres butonuna tıklar.
        ReusableMethods.bekle(3);
        locaterGonul.adressButonu.click();
        extentTest.info("Adres butonuna tıklandı");

//      Kullanıcı Add (Edit Your Billing Address)butonunu tıklar.
        ReusableMethods.bekle(3);
        ReusableMethods.click(locaterGonul.EditYourBillingAddress);
        extentTest.info("Edit Your Billing Address butonuna tıklandı.");

//        Kullanıcı first name girer.
        ReusableMethods.bekle(2);
        locaterGonul.billingfirstName.clear();
        locaterGonul.billingfirstName.sendKeys(faker.name().firstName());

//        Kullanıcı last name girer.
        locaterGonul.billinglastName.clear();
        locaterGonul.billinglastName.sendKeys(faker.name().lastName()+ Keys.TAB+Keys.TAB);


//        Kullanıcı country girer.
        Select select = new Select(locaterGonul.country);
        select.selectByVisibleText("Albania");

//        Kullanıcı Street adress girer
        ReusableMethods.bekle(3);
        locaterGonul.billingstreet.clear();
        locaterGonul.billingstreet.sendKeys(faker.address().fullAddress());


//        Kullanıcı city girer.
        locaterGonul.billingcity.clear();
        locaterGonul.billingcity.sendKeys("Los Angeles");

//       Kullanıcı State girer
        Select select1 = new Select(locaterGonul.ddmcounty);
        select1.selectByIndex(1);


//       Kullanıcı postcode girer.
        ReusableMethods.bekle(3);
        locaterGonul.billingpostcode.clear();
        locaterGonul.billingpostcode.sendKeys(faker.address().zipCode());

//        Kullanıcı phone girer.
        ReusableMethods.bekle(3);
        locaterGonul.billingphone.clear();
        locaterGonul.billingphone.sendKeys("05431123456");
        extentTest.info("Adres sayfasında doldurulmasi gereken zorunlu alanlar eksiksiz dolduruldu.");


//       Kullanıcı Save Adress butonunu tıklar.
        ReusableMethods.bekle(2);
        ReusableMethods.click(locaterGonul.billingsaveAdress);


        ReusableMethods.bekle(4);
        locaterGonul.signoutButton.click();
        locaterGonul.logoutButton.click();


    }

    @Test
    public void testCase02() {

//      Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));


//      Sing in butonuna tıklanir.
        ReusableMethods.click(locaterGonul.signIn_vendor);
//      Username ya da Email inputuna veri girilir.
        locaterGonul.siginuserName.sendKeys(ConfigReader.getProperty("VendorEmail"));

//     Password inputuna veri girilir.
        locaterGonul.siginpassword.sendKeys(ConfigReader.getProperty("VendorPassword"));
        ReusableMethods.bekle(2);

//      Sigin butonuna tıklar.
        locaterGonul.sigin.click();
        ReusableMethods.bekle(2);



//     Sayfanın en altındaki My Account butonuna tıklar.
        ReusableMethods.scroll(locaterGonul.myAccountButonu);
        ReusableMethods.bekle(10);
        locaterGonul.myAccountButonu.click();


//      Acılan sayfada Adres butonuna tıklar.
        ReusableMethods.bekle(3);
        locaterGonul.adressButonu.click();


//      Kullanıcı Add (Edit Your Billing Address)butonunu tıklar.
        ReusableMethods.bekle(3);
        ReusableMethods.click(locaterGonul.EditYourBillingAddress);


//        Kullanıcı first name girer.
        ReusableMethods.bekle(2);
        locaterGonul.billingfirstName.clear();
        locaterGonul.billingfirstName.sendKeys(faker.name().firstName());

//        Kullanıcı last name girer.
        locaterGonul.billinglastName.clear();
        locaterGonul.billinglastName.sendKeys(faker.name().lastName()+ Keys.TAB+Keys.TAB);


//     Kullanıcı country girer.
        Select select = new Select(locaterGonul.country);
        select.selectByVisibleText("Albania");


//      Kullanıcı Street adress girer
        ReusableMethods.bekle(3);
        locaterGonul.billingstreet.clear();
        locaterGonul.billingstreet.sendKeys(faker.address().fullAddress());


//      Kullanıcı city girer.
        locaterGonul.billingcity.clear();
        locaterGonul.billingcity.sendKeys("Los Angeles");

//      Kullanıcı State girer
        Select select1 = new Select(locaterGonul.ddmcounty);
        select1.selectByIndex(1);

//      Kullanıcı postcode girer.
        ReusableMethods.bekle(3);
        locaterGonul.billingpostcode.clear();
        locaterGonul.billingpostcode.sendKeys(faker.address().zipCode());

//      Kullanıcı phone girer.
        ReusableMethods.bekle(3);
        locaterGonul.billingphone.clear();
        locaterGonul.billingphone.sendKeys("05431123456");



//     Kayıtlı email adresi sayfaya otomatik gelir
        ReusableMethods.bekle(3);
        Assert.assertEquals(ConfigReader.getProperty("VendorEmail"),"biolog3425@gmail.com");
        extentTest.info("mail adresinin kayit olunan email adresiyle ayni oldugu dogrulandı.");

//       Kullanıcı Save Adress butonunu tıklar.
        ReusableMethods.bekle(2);
        ReusableMethods.click(locaterGonul.billingsaveAdress);

//       Kayıt edilen adresin Billing adres olarak kayıt edildigi dogrulanır.
        ReusableMethods.bekle(3);
        Assert.assertTrue(locaterGonul.successMessage.getText().contains("Address changed successfully."));
        extentTest.info("Degişiklik billing adrese eklendi yazısının göründüğü doğrulandı.");


        ReusableMethods.bekle(4);
        locaterGonul.signoutButton.click();
        locaterGonul.logoutButton.click();
        extentTest.pass("Test işlemi bitti.");

    }

    @Test
    public void testCase03() {

        extentTest=extentReports.createTest("US12-TC03","Billing Adress ekleyebilme Testi");

//      Kullanici ana sayfaya gider.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Hubconfy sayfasına gidildi");

//      Sigin işlemi yapılır.
        ReusableMethods.bekle(3);
        ReusableMethods.click(locaterGonul.signIn_vendor);
        locaterGonul.sigin.click();
        ReusableMethods.bekle(2);

        locaterGonul.siginuserName.sendKeys(ConfigReader.getProperty("VendorEmail"));
        locaterGonul.siginpassword.sendKeys(ConfigReader.getProperty("VendorPassword"));
        ReusableMethods.bekle(2);
        locaterGonul.rememberMe.click();
        ReusableMethods.bekle(2);
        locaterGonul.sigin.click();
        ReusableMethods.bekle(2);
        extentTest.info("Vendor olarak sign in işlemi yapıldı.");

//     Sayfanın en altındaki My Account butonuna tıklar.
        ReusableMethods.scroll(locaterGonul.myAccountButonu);
        ReusableMethods.bekle(10);
        locaterGonul.myAccountButonu.click();
        extentTest.info("MyAccount sayfasında olunduğu doğrulandı.");

//      Acılan sayfada Adres butonuna tıklar.
        ReusableMethods.bekle(3);
        locaterGonul.adressButonu.click();
        extentTest.info("Adress butonuna tıklandı");

//      Kullanıcı Add butonunu tıklar.
        ReusableMethods.bekle(3);
        ReusableMethods.click(locaterGonul.EditYourBillingAddress);
        extentTest.info("Edit Your BillingAddress butonuna tıklandı");


//        Kullanıcı first butonunu boş bırakır.
        ReusableMethods.bekle(2);
        locaterGonul.billingfirstName.clear();
        locaterGonul.billingfirstName.sendKeys("");

//        Kullanıcı last name butonunu boş bırakır.
        locaterGonul.billinglastName.clear();
        locaterGonul.billinglastName.sendKeys("");

//        Kullanıcı city butonunu boş bırakır
        locaterGonul.billingcity.clear();
        locaterGonul.billingcity.sendKeys("");


//        Kullanıcı Street butonunu boş bırakır.
        locaterGonul.billingstreet.clear();
        locaterGonul.billingstreet.sendKeys("");

//        Kullanıcı postcode butonunu boş bırakır.
        locaterGonul.billingpostcode.clear();
        locaterGonul.billingpostcode.sendKeys("");

//        Kullanıcı phone butonunu boş bırakır.
        locaterGonul.billingphone.clear();
        locaterGonul.billingphone.sendKeys("");
        extentTest.info("Açilan adres sayfasında doldurulması zorunlu alanlar boş bırakıldı");



//        Kayıtlı email adresi sayfaya otomatik gelir
        ReusableMethods.bekle(3);
        Assert.assertTrue(locaterGonul.billingemail.isDisplayed());
        extentTest.info("mail adresinin kayit olunan email adresiyle ayni oldugu doğrulandı.");

//        Kullanıcı Save Adress butonunu tıklar.
        ReusableMethods.bekle(10);
        ReusableMethods.click(locaterGonul.billingsaveAdress);
        extentTest.info("Save adress butonuna tıklandı");


//      Kullanıcı girilmesi zorunlu alanların boş bırakaılamyacagı yazısını görmelidir

        Assert.assertTrue(locaterGonul.unsuccessMessageBilling.isDisplayed());
        extentTest.info("Doldurulması zorunlu alanların boş bırakılmayacağı uyarısı göründüğü test edilidi.");

        Driver.closeDriver();
        extentTest.pass("Test sonlandırıldı.");



    }
}
