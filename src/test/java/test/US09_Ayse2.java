package test;

import org.testng.annotations.Test;
import pages.LocaterOguzhan;
import utilities.Driver;
import utilities.ReportMethods;

import static org.testng.AssertJUnit.assertTrue;
import static utilities.ReusableMethods.*;

public class US09_Ayse2 extends ReportMethods {
    LocaterOguzhan locaterOguzhan = new LocaterOguzhan();
    US09_Ayse1 ac01 = new US09_Ayse1();

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Hubcomfy", "Vendor olarak mail alma");
        ac01.start();
        //Vendor gecersiz mail girer
        locaterOguzhan.email.sendKeys("asd");
        extentTest.info("gecersiz email adresi girildi");

        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);

        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugun icin  hata mesaji goruldu");
    }

    @Test
    public void test02() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde $ isareti kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor $ sembolunu girer
        locaterOguzhan.email.sendKeys("a$r@gmail.com");
        extentTest.info("Mailde $ sembolu kullanildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugu icin  hata mesaji goruldu");
    }

    @Test
    public void test03() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde bosluk kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor bosluk girer
        locaterOguzhan.email.sendKeys("a b@gmail.com");
        extentTest.info("Mail adresine bosluk karakter olarak girildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugun icin  hata mesaji goruldu");
    }

    @Test
    public void test04() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde * sembolu kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor * sembolunu girer
        locaterOguzhan.email.sendKeys("a*b@gmail.com");
        extentTest.info("Mailde * sembolu kullanildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugun icin  hata mesaji goruldu");
    }

    @Test
    public void test05() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde % sembolu kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor % sembolunu girer
        locaterOguzhan.email.sendKeys("a%b@gmail.com");
        extentTest.info("Mailde % sembolu kullanildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugun icin  hata mesaji goruldu");
    }

    @Test
    public void test06() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde iki tane @ sembolu kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor iki tane @ isareti girer
        locaterOguzhan.email.sendKeys("afgt@gtyb@@gmail.com");
        extentTest.info("Mailde iki tane @ sembolu kullanildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugun icin  hata mesaji goruldu");
    }

    @Test
    public void test07() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde sadece nokta kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor sadece noktalardan olusan mail adresi girer
        locaterOguzhan.email.sendKeys("......@gmail.com");
        extentTest.info("Mail adresine @ sembolunden once sadece nokta girisi yapildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());

        extentTest.pass("Gecersiz email oldugun icin  hata mesaji goruldu");
    }

    @Test
    public void test08() {
        Driver.getDriver().navigate().refresh();
        extentTest = extentReports.createTest("Hubcomfy", "Vendor olmaysan emailden hesap acmaya calisir");
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor hic olmayan bir web sitesinin mail adresi varmis girer
        locaterOguzhan.email.sendKeys("asde@homiligirtlak.com");
        extentTest.info("Olmayan bir web sitesinden mail adresi varmis gibi giris yapildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugun icin  hata mesaji goruldu");
    }


    @Test
    public void test09() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde eksik mail kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor mailde eksik  adres  girer
        locaterOguzhan.email.sendKeys("a.b@com");
        extentTest.info("Mail adresinde eksik bilgi girisi yapti(a.b@gmail)");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugun icin  hata mesaji goruldu");
    }


    @Test
    public void test10() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde _ isaretini kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor mailde alt cizgi girer(_) girer
        locaterOguzhan.email.sendKeys("a_b@gmail.com");
        extentTest.info("Mail adresinde alt tire kullanildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.verify.isDisplayed());
        extentTest.pass("Onay mesaji goruldu");
    }

    @Test
    public void test11() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde - isaretini kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor mailde nduz cizgi girer
        locaterOguzhan.email.sendKeys("a-b@gmail.com");
        extentTest.info("Mail adresinde duz cizgi kullanildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.verify.isDisplayed());
        extentTest.pass("Onay mesaji goruldu");
    }

    @Test
    public void test12() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor ingilizce disi karakter kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");

        bekle(3);
        //Vendor ingilizce disi bir karakter girer
        locaterOguzhan.email.sendKeys("aşğ-b@gmail.com");
        extentTest.info("Mail adresinde ingilizce disi karakterler kullanildi");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.error.isDisplayed());
        extentTest.pass("Gecersiz email oldugun icin hata mesaji goruldu");
    }
    @Test
    public void test13() {
        extentTest = extentReports.createTest("Hubcomfy", "Vendor mailde . isaretini kullanir");
        Driver.getDriver().navigate().refresh();
        extentTest.info("Yeni bilgi girmek icin sayfa refresh yapildi");
        bekle(3);
        //Vendor mailde eksik  adres  girer
        locaterOguzhan.email.sendKeys("a.b@gmail.com");
        extentTest.info("Mail adresinde nokta kullandi)");
        //Vendor herhangi bir yere tiklar
        click(locaterOguzhan.herhangiBirYer);
        extentTest.info("Herhangi bir bosluk tiklandi");
        bekle(3);
        //Vendor hata mesajini gorur
        assertTrue(locaterOguzhan.verify.isDisplayed());
        extentTest.pass("Onay mesaji goruldu");
    }

}