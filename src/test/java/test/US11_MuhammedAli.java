package test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterAli;
import pages.LocaterMuhammedAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US11_MuhammedAli {
    WebDriver driver;

    @Test(priority = 1)
    public void US11_TC01_1_WebAdresineErisim() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Test(priority = 2)
    public void US11_TC01_2_LoginButonuCalisir() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.signInButton.click();
    }
    @Test(priority = 3)
    public void US11_TC01_3_LoginEkranResmi() {
        ReusableMethods.tumSayfaResmi("_US11_LoginResmi");
    }
    @Test(priority = 4)
    public void US11_TC01_4_UserNameGirisi() {
        LocaterMuhammedAli kullanici = new LocaterMuhammedAli();
        kullanici.userNameGir.sendKeys(ConfigReader.getProperty("userNameV"));
    }
    @Test(priority = 5)
    public void US11_TC01_5_SifreNameGirisi() {
        LocaterMuhammedAli sifre = new LocaterMuhammedAli();
        sifre.sifreGir.sendKeys(ConfigReader.getProperty("passwordV"));
    }
    @Test(priority = 6)
    public void US11_TC01_6_LoginPenceresiOnay() {
        LocaterMuhammedAli LogIn = new LocaterMuhammedAli();
        LogIn.loginOnay.click();
    }
    @Test(priority = 6)
    public void US11_TC01_7_AccountSayfasiTeyid() {
        Assert.assertTrue(driver.getTitle().contains("hubcomfy"));
    }
}


