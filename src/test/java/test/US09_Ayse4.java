package test;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.LocaterAyse;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utilities.ReusableMethods.*;

public class US09_Ayse4 extends ReportMethods {
    LocaterAyse locaterAyse = new LocaterAyse();
    US09_Ayse1 ac01 = new US09_Ayse1();
    static String code;
    static String mail;

    @Test
    public void test1() {
        extentTest = extentReports.createTest("Hubcomfy", "Girilen maile onay mailinin gitmesi");
        ac01.start();
        mailAl();


        // vendor rastgele bir code girer**********************************************************************
       bekle(2);
        locaterAyse.verificationCodeBox.sendKeys("000000");
        extentTest.info("Rastgele code girildi ");
        bekle(2);
        locaterAyse.password.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password kismina password girildi");
        bekle(2);
        //Vendor passwordu bir daha girer
        locaterAyse.password2.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Ayni Password ikinci kez girildi");
        click(locaterAyse.registerButton);
        extentTest.info("Register buttonu tiklandi");
        bekle(2);
        assertTrue(locaterAyse.emailVerificationCodeError.isDisplayed());
        extentTest.pass("Rastgele kodun sebep oldugu hata mesaji goruldu");
    }

    private void mailAl() {
        //Vendor yeni pencere acar
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.info("Yeni TAB acildi");
        //Vendor fakemail adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("fake"));
        extentTest.info("Acilan TAB'de www.fakemail.net sitesine gidildi");

        //Vendor fakemailden bir adres alir
        mail = locaterAyse.fakeCopyAlma.getText();
        extentTest.info("Fakemail sitesinden fake bir email alindi");
        //vendor pencere degistirir
        switchToWindow(0);
        extentTest.info("Ilk pencereye donuldu");
        //Vendor maili yazar
        locaterAyse.email.sendKeys(mail);
        extentTest.info("Fake mailden alinan email adresi mail kutusuna yapistirildi");
        //Vendor herhangi bir yere tiklar
        click(locaterAyse.herhangiBirYer);
        extentTest.info("Herhangi bir yer tiklandi");
        //vendor maile giden sifreyi almak icin fakemaile gider
        window(1);
        extentTest.info("Mail adresine yollanan sifrenin alinmasi icin diger sayfaya gecildi");
        //vendor gelen maili tiklar
        bekle(5);
        click(locaterAyse.clickMail);
        extentTest.info("Gelen mail acildi");
        //maildeki code'u alir

        Driver.getDriver().switchTo().frame(1);
        code = locaterAyse.takeCode.getText();
        extentTest.info("Maile gelen kod alindi");
        //vendor sayfa degistirir
        window(0);
        extentTest.info("Alinan sifreyi yapistirmak icin diger sayfaya gecildi");
    }

    @Test
    public void test2() {
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni islem yapmak icin sayfa yenilendi");
        locaterAyse.email.sendKeys(mail);
        extentTest.info("Mail adresi girildi");
        bekle(2);
        locaterAyse.verificationCodeBox.sendKeys(code);
        extentTest.info("Alinan kod sifre bolumune yapistirildi");
//kisa password girer
        bekle(2);
        locaterAyse.password.sendKeys("a12");

        extentTest.info("short Password girildi");
//ayni kisa passwordu yine girer
        locaterAyse.password2.sendKeys("a12");
        extentTest.info("Ayni short password bir daha girildi");
        bekle(2);
        //register buttonuna basar
        click(locaterAyse.registerButton);
        extentTest.info("Register buttonu tiklandi");
        bekle(2);
        //error mesajini gorur
        assertTrue(locaterAyse.errorPassword.isDisplayed());
        extentTest.pass("Short sifre icin error mesaji goruldu");
    }

    @Test
    public void test3() {
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni islem yapmak icin sayfa yenilendi");
        locaterAyse.email.sendKeys(mail);
        extentTest.info("Mail adresi girildi");
        locaterAyse.verificationCodeBox.sendKeys(code);
        extentTest.info("Alinan kod sifre bolumune yapistirildi");
//kisa password girer
        locaterAyse.password.sendKeys("a12");
        extentTest.info("Weak Password girildi");
//ayni kisa passwordu yine girer
        locaterAyse.password2.sendKeys("a12");
        bekle(2);
        extentTest.info("Ayni weak password bir daha girildi");
        //register buttonuna basar
        click(locaterAyse.registerButton);
        extentTest.info("Register buttonu tiklandi");
        bekle(3);
        //error mesajini gorur
        assertTrue(locaterAyse.errorPassword.isDisplayed());
        extentTest.pass("Weak sifre icin error mesaji goruldu");
    }

    @Test
    public void test4() {
        locaterAyse = new LocaterAyse();
        extentTest = extentReports.createTest("Hubcomfy", "Vendor sifre girer");
        //vendor kucuk harf, büyük harf, rakam ve special karakter içeren Password yazar
        locaterAyse.password.clear();
        locaterAyse.password.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password kismina password girildi");
        //Vendor farkli password girer
        locaterAyse.password2.clear();
        locaterAyse.password2.sendKeys(ConfigReader.getProperty("sipsifre"));
        extentTest.info("Farkli password  girildi");
        click(locaterAyse.registerButton);
        bekle(3);
        assertTrue(locaterAyse.errorMessage.isDisplayed());
        extentTest.pass("Confirm passworde farkli sifre ile giris yapilamadi");
    }

    @Test
    public void test5() {
        locaterAyse = new LocaterAyse();
        extentTest = extentReports.createTest("Hubcomfy", "Vendor sifre girer");
        //vendor kucuk harf, büyük harf, rakam ve special karakter içeren Password yazar
        locaterAyse.password.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password kismina password girildi");
        //Vendor passwordu bir daha girer
        locaterAyse.password2.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password ikinci kez girildi");
    }


    @Test
    public void test6() {
        //kullanici register buttonuna tiklayarak vendor olarak kayiti tamamlamali
        extentTest = extentReports.createTest("Hubcomfy", "Vendor olarak kayit olur");
        click(locaterAyse.registerButton);
        extentTest.pass("kullanici kayit islemini basari ile tamamladi");

    }

    @Test
    public void test7() {
        //Kayıtlı bir e-mail adresi ile kayıt olmaya çalıştığında "This Email already exists. Please login to the site and apply as vendor." mesajını almalı
        locaterAyse = new LocaterAyse();
        extentTest = extentReports.createTest("Hubcomfy", "onceden Vendor olarak kayitli maille kaydolmaya calisir");
        ac01.start();
        //Kayıtlı bir e-mail adresi ile kayıt olmaya çalışir
        locaterAyse.email.sendKeys(ConfigReader.getProperty("ayse"));

        //kullanici bos bir yere tiklar
        click(locaterAyse.herhangiBirYer);

        //kullnici kodu girer
        locaterAyse.verificationCodeBox.sendKeys("12345");
        extentTest.info("Kullanici kodu yazar");
        //vendor kucuk harf, büyük harf, rakam ve special karakter içeren Password yazar
        locaterAyse.password.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password kismina password girildi");
        //Vendor passwordu bir daha girer
        locaterAyse.password2.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password ikinci kez girildi");
        //kullanici register buttonuna tiklayarak vendor olarak kayiti tamamlamali
        click(locaterAyse.registerButton);
        extentTest.info("Kullanic register buttonuna basar");
        //kullanici uyari yazisini gorur
        bekle(3);
        String actualResult = locaterAyse.errorText.getText();
        String expectedResult = "This Email already exists. Please login to the site and apply as vendor.";
        assertEquals(actualResult, expectedResult);

        extentTest.pass("kullanici ayni mail adresi ile yeniden kayit yapamadi ");

    }
}

