package test.ac01_ayse;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.LocaterOguzhan;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utilities.ReusableMethods.*;

public class AC04 extends ReportMethods {
    LocaterOguzhan locaterOguzhan = new LocaterOguzhan();
    AC01 ac01 = new AC01();
    static String code;
    static String mail;

    @Test
    public void test1() {
        extentTest = extentReports.createTest("Hubcomfy", "Girilen maile onay mailinin gitmesi");
        ac01.start();
        mailAl();


        // vendor rastgele bir code girer**********************************************************************
       bekle(2);
        locaterOguzhan.verificationCodeBox.sendKeys("000000");
        extentTest.info("Rastgele code girildi ");
        bekle(2);
        locaterOguzhan.password.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password kismina password girildi");
        bekle(2);
        //Vendor passwordu bir daha girer
        locaterOguzhan.password2.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Ayni Password ikinci kez girildi");
        click(locaterOguzhan.registerButton);
        extentTest.info("Register buttonu tiklandi");
        bekle(2);
        assertTrue(locaterOguzhan.emailVerificationCodeError.isDisplayed());
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
        mail = locaterOguzhan.fakeCopyAlma.getText();
        extentTest.info("Fakemail sitesinden fake bir email alindi");
        //vendor pencere degistirir
        switchToWindow(0);
        extentTest.info("Ilk pencereye donuldu");
        //Vendor maili yazar
        locaterOguzhan.email.sendKeys(mail);
        extentTest.info("Fake mailden alinan email adresi mail kutusuna yapistirildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir yer tiklandi");
        //vendor maile giden sifreyi almak icin fakemaile gider
        window(1);
        extentTest.info("Mail adresine yollanan sifrenin alinmasi icin diger sayfaya gecildi");
        //vendor gelen maili tiklar
        bekle(5);
        click(locaterOguzhan.clickMail);
        extentTest.info("Gelen mail acildi");
        //maildeki code'u alir

        Driver.getDriver().switchTo().frame(1);
        code = locaterOguzhan.takeCode.getText();
        extentTest.info("Maile gelen kod alindi");
        //vendor sayfa degistirir
        window(0);
        extentTest.info("Alinan sifreyi yapistirmak icin diger sayfaya gecildi");
    }

    @Test
    public void test2() {
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni islem yapmak icin sayfa yenilendi");
        locaterOguzhan.email.sendKeys(mail);
        extentTest.info("Mail adresi girildi");
        bekle(2);
        locaterOguzhan.verificationCodeBox.sendKeys(code);
        extentTest.info("Alinan kod sifre bolumune yapistirildi");
//kisa password girer
        bekle(2);
        locaterOguzhan.password.sendKeys("a12");

        extentTest.info("short Password girildi");
//ayni kisa passwordu yine girer
        locaterOguzhan.password2.sendKeys("a12");
        extentTest.info("Ayni short password bir daha girildi");
        bekle(2);
        //register buttonuna basar
        click(locaterOguzhan.registerButton);
        extentTest.info("Register buttonu tiklandi");
        bekle(2);
        //error mesajini gorur
        assertTrue(locaterOguzhan.errorPassword.isDisplayed());
        extentTest.pass("Short sifre icin error mesaji goruldu");
    }

    @Test
    public void test3() {
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni islem yapmak icin sayfa yenilendi");
        locaterOguzhan.email.sendKeys(mail);
        extentTest.info("Mail adresi girildi");
        locaterOguzhan.verificationCodeBox.sendKeys(code);
        extentTest.info("Alinan kod sifre bolumune yapistirildi");
//kisa password girer
        locaterOguzhan.password.sendKeys("a12");
        extentTest.info("Weak Password girildi");
//ayni kisa passwordu yine girer
        locaterOguzhan.password2.sendKeys("a12");
        bekle(2);
        extentTest.info("Ayni weak password bir daha girildi");
        //register buttonuna basar
        click(locaterOguzhan.registerButton);
        extentTest.info("Register buttonu tiklandi");
        bekle(3);
        //error mesajini gorur
        assertTrue(locaterOguzhan.errorPassword.isDisplayed());
        extentTest.pass("Weak sifre icin error mesaji goruldu");
    }

    @Test
    public void test4() {
        locaterOguzhan = new LocaterOguzhan();
        extentTest = extentReports.createTest("Hubcomfy", "Vendor sifre girer");
        //vendor kucuk harf, büyük harf, rakam ve special karakter içeren Password yazar
        locaterOguzhan.password.clear();
        locaterOguzhan.password.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password kismina password girildi");
        //Vendor farkli password girer
        locaterOguzhan.password2.clear();
        locaterOguzhan.password2.sendKeys(ConfigReader.getProperty("sipsifre"));
        extentTest.info("Farkli password  girildi");
        click(locaterOguzhan.registerButton);
        bekle(3);
        assertTrue(locaterOguzhan.errorMessage.isDisplayed());
        extentTest.pass("Confirm passworde farkli sifre ile giris yapilamadi");
    }

    @Test
    public void test5() {
        locaterOguzhan = new LocaterOguzhan();
        extentTest = extentReports.createTest("Hubcomfy", "Vendor sifre girer");
        //vendor kucuk harf, büyük harf, rakam ve special karakter içeren Password yazar
        locaterOguzhan.password.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password kismina password girildi");
        //Vendor passwordu bir daha girer
        locaterOguzhan.password2.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password ikinci kez girildi");
    }


    @Test
    public void test6() {
        //kullanici register buttonuna tiklayarak vendor olarak kayiti tamamlamali
        extentTest = extentReports.createTest("Hubcomfy", "Vendor olarak kayit olur");
        click(locaterOguzhan.registerButton);
        extentTest.pass("kullanici kayit islemini basari ile tamamladi");

    }

    @Test
    public void test7() {
        //Kayıtlı bir e-mail adresi ile kayıt olmaya çalıştığında "This Email already exists. Please login to the site and apply as vendor." mesajını almalı
        locaterOguzhan = new LocaterOguzhan();
        extentTest = extentReports.createTest("Hubcomfy", "onceden Vendor olarak kayitli maille kaydolmaya calisir");
        ac01.start();
        //Kayıtlı bir e-mail adresi ile kayıt olmaya çalışir
        locaterOguzhan.email.sendKeys(ConfigReader.getProperty("ayse"));

        //kullanici bos bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);

        //kullnici kodu girer
        locaterOguzhan.verificationCodeBox.sendKeys("12345");
        extentTest.info("Kullanici kodu yazar");
        //vendor kucuk harf, büyük harf, rakam ve special karakter içeren Password yazar
        locaterOguzhan.password.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password kismina password girildi");
        //Vendor passwordu bir daha girer
        locaterOguzhan.password2.sendKeys(ConfigReader.getProperty("paso"));
        extentTest.info("Password ikinci kez girildi");
        //kullanici register buttonuna tiklayarak vendor olarak kayiti tamamlamali
        click(locaterOguzhan.registerButton);
        extentTest.info("Kullanic register buttonuna basar");
        //kullanici uyari yazisini gorur
        bekle(3);
        String actualResult = locaterOguzhan.errorText.getText();
        String expectedResult = "This Email already exists. Please login to the site and apply as vendor.";
        assertEquals(actualResult, expectedResult);

        extentTest.pass("kullanici ayni mail adresi ile yeniden kayit yapamadi ");

    }
}

