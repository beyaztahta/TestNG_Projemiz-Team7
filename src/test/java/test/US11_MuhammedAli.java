package test;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterMuhammedAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US11_MuhammedAli {
    WebDriver driver;

    @Test(priority = 1)     // WEB SİTESİNE GİT
    public void US11_TC01_1_WebAdresineErisim() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
    }

    @Test(priority = 2)     // SIGN IN BUTONUNA TIKLA
    public void US11_TC01_2_LoginButonuCalisir() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.signInButton.click();
    }

    @Test(priority = 3)     // WEB SAYFASININ RESMİNİ KAYDET
    public void US11_TC01_3_LoginEkranResmi() {
        ReusableMethods.tumSayfaResmi("_US11_LoginResmi");
    }

    @Test(priority = 4)     // KULLANICI İSMİ GİR
    public void US11_TC01_4_UserNameGirisi() {
        LocaterMuhammedAli kullanici = new LocaterMuhammedAli();
        kullanici.userNameGir.sendKeys(ConfigReader.getProperty("userName_M"));
    }

    @Test(priority = 5)     // ŞİFRE GİR
    public void US11_TC01_5_SifreGirisi() {
        LocaterMuhammedAli sifre = new LocaterMuhammedAli();
        sifre.sifreGir.sendKeys(ConfigReader.getProperty("password_M"));
    }

    @Test(priority = 6)     // AÇILAN LOGİN PENCERESİNDE SIGN IN BUTONUNA BAS
    public void US11_TC01_6_LoginPenceresiOnay() throws InterruptedException {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.loginOnay.click();

        // Sayfanın en altına git
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);     //  5 saniye bekleyecek
    }

    @Test(priority = 7)     // SAYFA BAŞLIĞINI KONTROL ET
    public void US11_TC01_7_MyAccountSayfasiGoruntulenmeli() throws InterruptedException {
        driver = Driver.getDriver();
        System.out.println("Title Başlık İçeriği:        " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("account"));
    }

    @Test(priority = 8)     // MY ACCOUNT SAYFASINA GİT
    public void ____My_Account_SayfasinaTikla() {
        LocaterMuhammedAli yeni = new LocaterMuhammedAli();
        yeni.MyAccountTikla.click();
    }

    @Test(priority = 9)     // ORDERS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC02_1_AccoundSayfasindaOrdersGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.OrdersGorulmeli.getText().contains("ORDERS"));
    }

    @Test(priority = 10)    // DOWNLOADS GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_2_AccoundSayfasindaDownloadsGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.MyAccount_Download_Gorulmeli.getText().contains("DOWNLOADS"));
    }

    @Test(priority = 11)    // ADDRESSES GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_3_AccoundSayfasindaAddressesGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.AddressesVarmi.getText().contains("ADDRESSES"));
    }

    @Test(priority = 12)    // ACCOUNT DETAILS GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_4_AccoundSayfasindaAccount_detailsGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.Account_detailsVarmi.getText().contains("ACCOUNT DETAILS"));
    }

    @Test(priority = 13)    // ACCOUNT WISHLIST GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_5_AccoundSayfasindaWishlistGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.WishlistVarmi.getText().contains("WISHLIST"));
    }

    @Test(priority = 14)    // ACCOUNT LOGOUT GÖRÜNTÜLENDİ Mİ
    public void US11_TC02_6_AccoundSayfasindaLogoutGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.LogoutVarmi.getText().contains("LOGOUT"));
    }

    @Test(priority = 15)    // STORE MANAGER GÖRÜNTÜLENDİ Mİ
    public void US11_TC03_1_DashboardAltindaStoreManagerGoruntullenemeli() throws InterruptedException{
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaStore_ManagerVarmi.getText().contains("Store Manager"));
    }

    @Test(priority = 16)    // DASHBOARD ALTINDA ORDERS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_2_DashboardAltindaOrdersGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaOrdersVarmi.getText().contains("Orders"));
    }

    @Test(priority = 17)    // DASHBOARD ALTINDA DOWNLOADS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_3_DashboardAltindaDownloadsGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaDownloadsVarmi.getText().contains("Downloads"));
    }

    @Test(priority = 18)    // DASHBOARD ALTINDA ADDRESS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_4_DashboardAltindaAddressesGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaAddressesVarmi.getText().contains("Addresses"));
    }

    @Test(priority = 19)    // DASHBOARD ALTINDA ACCOUNT DETAILS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_5_DashboardAltindaAccountDetailsGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaAccount_detailsVarmi.getText().contains("Account details"));
    }

    @Test(priority = 20)    // DASHBOARD ALTINDA WISHLIST GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_6_DashboardAltindaWishlistGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaWishlistVarmi.getText().contains("Wishlist"));
    }

    @Test(priority = 21)    // DASHBOARD ALTINDA SUPPORT TICKETS GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_7_DashboardAltindaSupport_TicketsGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaSupport_TicketslistVarmi.getText().contains("Support Tickets"));
    }

    @Test(priority = 22)    // DASHBOARD ALTINDA FOLLOWING GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_8_DashboardAltindaFollowingsGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaFollowingslistVarmi.getText().contains("Followings"));
    }

    @Test(priority = 23)    // DASHBOARD ALTINDA LOGOUT GÖRÜNTÜLENEBİLDİ Mİ
    public void US11_TC03_9_DashboardAltindaLogoutGoruntulenmeli() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        Assert.assertTrue(LogIn.DashboardAltindaLogoutlistVarmi.getText().contains("Logout"));
    }
}
