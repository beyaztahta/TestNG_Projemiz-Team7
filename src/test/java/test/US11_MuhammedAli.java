package test;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterMuhammedAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

public class US11_MuhammedAli extends ReportMethods {
    WebDriver driver;

    @Test(priority = 1)     // WEB SİTESİNE GİT
    public void US11_TC01_1_WebAdresineErisim() {
        extentTest = extentReports.createTest("US11_TC01_1_WebAdresineErisim");
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        extentTest.pass("US11_TC01_1_WebAdresineErisim");
    }

    @Test(priority = 2)     // SIGN IN BUTONUNA TIKLA
    public void US11_TC01_2_LoginButonuCalisir() {
        extentTest = extentReports.createTest("US11_TC01_2_LoginButonuCalisir");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.signInButton.click();
        extentTest.pass("US11_TC01_2_LoginButonuCalisir");
    }

    @Test(priority = 3)     // PENCERE GÖRÜNTÜLENMELİ - GÖRÜNTÜLENEMEDİ - EKRAN RESMİ KAYDEDİLDİ
    public void US11_TC01_3_LoginEkranResmi() {
        extentTest = extentReports.createTest("US11_TC01_3_LoginEkranResmi");
        ReusableMethods.tumSayfaResmi("_US11_LoginResmi");
        extentTest.pass("US11_TC01_3_LoginEkranResmi");
    }

    @Test(priority = 4)     // KULLANICI İSMİ GİR
    public void US11_TC01_4_UserNameGirisi() {
        extentTest = extentReports.createTest("US11_TC01_4_UserNameGirisi");
        extentTest.pass(" ");
        LocaterMuhammedAli kullanici = new LocaterMuhammedAli();
        kullanici.userNameGir.sendKeys(ConfigReader.getProperty("userName_M"));
        extentTest.pass("US11_TC01_4_UserNameGirisi");
    }

    @Test(priority = 5)     // ŞİFRE GİR
    public void US11_TC01_5_SifreGirisi() {
        extentTest = extentReports.createTest("US11_TC01_5_SifreGirisi");
        LocaterMuhammedAli sifre = new LocaterMuhammedAli();
        sifre.sifreGir.sendKeys(ConfigReader.getProperty("password_M"));
        extentTest.pass("US11_TC01_5_SifreGirisi");
    }

    @Test(priority = 6)     // AÇILAN LOGİN PENCERESİNDE SIGN IN BUTONUNA BAS
    public void US11_TC01_6_LoginPenceresiOnay() throws InterruptedException {
        extentTest = extentReports.createTest("US11_TC01_6_LoginPenceresiOnay");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.loginOnay.click();

        // Sayfanın en altına git
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);     //  5 saniye bekleyecek
        extentTest.pass("US11_TC01_6_LoginPenceresiOnay");
    }

    @Test(priority = 7)     // SAYFA BAŞLIĞINI KONTROL ET
    public void US11_TC01_7_MyAccountSayfasiGoruntulenmeli() throws InterruptedException {
        extentTest = extentReports.createTest("US11_TC01_7_MyAccountSayfasiGoruntulenmeli");
        driver = Driver.getDriver();
        System.out.println("Title Başlık İçeriği:        " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("account"));
        extentTest.pass("US11_TC01_7_MyAccountSayfasiGoruntulenmeli");
    }

    @Test(priority = 8)     // MY ACCOUNT SAYFASINA GİT
    public void ____My_Account_SayfasinaTikla() {
        LocaterMuhammedAli yeni = new LocaterMuhammedAli();
        yeni.MyAccountTikla.click();
    }

    @Test(priority = 9)     // ORDERS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC02_1_AccoundSayfasindaOrdersGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC02_1_AccoundSayfasindaOrdersGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.OrdersGorulmeli.getText().contains("ORDERS"));
        extentTest.pass("US11_TC02_1_AccoundSayfasindaOrdersGoruntulenmeli");
    }

    @Test(priority = 10)    // DOWNLOADS GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_2_AccoundSayfasindaDownloadsGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC02_2_AccoundSayfasindaDownloadsGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.MyAccount_Download_Gorulmeli.getText().contains("DOWNLOADS"));
        extentTest.pass("US11_TC02_2_AccoundSayfasindaDownloadsGoruntulenmeli");
    }

    @Test(priority = 11)    // ADDRESSES GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_3_AccoundSayfasindaAddressesGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC02_3_AccoundSayfasindaAddressesGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.AddressesVarmi.getText().contains("ADDRESSES"));
        extentTest.pass("US11_TC02_3_AccoundSayfasindaAddressesGoruntulenmeli");
    }

    @Test(priority = 12)    // ACCOUNT DETAILS GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_4_AccoundSayfasindaAccount_detailsGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC02_4_AccoundSayfasindaAccount_detailsGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.Account_detailsVarmi.getText().contains("ACCOUNT DETAILS"));
        extentTest.pass("US11_TC02_4_AccoundSayfasindaAccount_detailsGoruntulenmeli");
    }

    @Test(priority = 13)    // ACCOUNT WISHLIST GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_5_AccoundSayfasindaWishlistGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC02_5_AccoundSayfasindaWishlistGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.WishlistVarmi.getText().contains("WISHLIST"));
        extentTest.pass("US11_TC02_5_AccoundSayfasindaWishlistGoruntulenmeli");
    }

    @Test(priority = 14)    // ACCOUNT LOGOUT GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_6_AccoundSayfasindaLogoutGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC02_6_AccoundSayfasindaLogoutGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.LogoutVarmi.getText().contains("LOGOUT"));
        extentTest.pass("US11_TC02_6_AccoundSayfasindaLogoutGoruntulenmeli");
    }

    @Test(priority = 15)    // STORE MANAGER GÖRÜNTÜLENDİ Mİ
    public void US11_TC03_1_DashboardAltindaStoreManagerGoruntullenemeli() throws InterruptedException{
        extentTest = extentReports.createTest("US11_TC03_1_DashboardAltindaStoreManagerGoruntullenemeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaStore_ManagerVarmi.getText().contains("Store Manager"));
        extentTest.pass("US11_TC03_1_DashboardAltindaStoreManagerGoruntullenemeli");
    }

    @Test(priority = 16)    // DASHBOARD ALTINDA ORDERS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_2_DashboardAltindaOrdersGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC03_2_DashboardAltindaOrdersGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaOrdersVarmi.getText().contains("Orders"));
        extentTest.pass("US11_TC03_2_DashboardAltindaOrdersGoruntulenmeli");
    }

    @Test(priority = 17)    // DASHBOARD ALTINDA DOWNLOADS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_3_DashboardAltindaDownloadsGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC03_3_DashboardAltindaDownloadsGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaDownloadsVarmi.getText().contains("Downloads"));
        extentTest.pass("US11_TC03_3_DashboardAltindaDownloadsGoruntulenmeli");
    }

    @Test(priority = 18)    // DASHBOARD ALTINDA ADDRESS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_4_DashboardAltindaAddressesGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC03_4_DashboardAltindaAddressesGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaAddressesVarmi.getText().contains("Addresses"));
        extentTest.pass("US11_TC03_4_DashboardAltindaAddressesGoruntulenmeli");
    }

    @Test(priority = 19)    // DASHBOARD ALTINDA ACCOUNT DETAILS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_5_DashboardAltindaAccountDetailsGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC03_5_DashboardAltindaAccountDetailsGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaAccount_detailsVarmi.getText().contains("Account details"));
        extentTest.pass("US11_TC03_5_DashboardAltindaAccountDetailsGoruntulenmeli");
    }

    @Test(priority = 20)    // DASHBOARD ALTINDA WISHLIST GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_6_DashboardAltindaWishlistGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC03_6_DashboardAltindaWishlistGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaWishlistVarmi.getText().contains("Wishlist"));
        extentTest.pass("US11_TC03_6_DashboardAltindaWishlistGoruntulenmeli");
    }

    @Test(priority = 21)    // DASHBOARD ALTINDA SUPPORT TICKETS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_7_DashboardAltindaSupport_TicketsGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC03_7_DashboardAltindaSupport_TicketsGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaSupport_TicketslistVarmi.getText().contains("Support Tickets"));
        extentTest.pass("US11_TC03_7_DashboardAltindaSupport_TicketsGoruntulenmeli");
    }

    @Test(priority = 22)    // DASHBOARD ALTINDA FOLLOWING GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_8_DashboardAltindaFollowingsGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC03_8_DashboardAltindaFollowingsGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaFollowingslistVarmi.getText().contains("Followings"));
        extentTest.pass("US11_TC03_8_DashboardAltindaFollowingsGoruntulenmeli");
    }

    @Test(priority = 23)    // DASHBOARD ALTINDA LOGOUT GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_9_DashboardAltindaLogoutGoruntulenmeli() {
        extentTest = extentReports.createTest("US11_TC03_9_DashboardAltindaLogoutGoruntulenmeli");
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaLogoutlistVarmi.getText().contains("Logout"));
        extentTest.pass("US11_TC03_9_DashboardAltindaLogoutGoruntulenmeli");
    }
}
