package test;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerRegisterLocates;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.bekle;

public class US10_Sevcan extends ReportMethods {

    CustomerRegisterLocates locaterSevcan = new CustomerRegisterLocates();

    @Test(priority = 1)
    public void tooshort() {
        extentTest=extentReports.createTest("tooshort","Test Raporu");

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");

        locaterSevcan.Register_Button.click();
        locaterSevcan.vendorButton.click();
        locaterSevcan.vendorEmail.sendKeys(ConfigReader.getProperty("fakemail"),Keys.TAB);
        locaterSevcan.verificationCode.sendKeys(ConfigReader.getProperty("fakecode"),Keys.TAB);
        locaterSevcan.reSendCode.click();
        locaterSevcan.vendorPassword1.sendKeys(("12345"),Keys.TAB);
        extentTest.info("password 5 rakam girildi");

        Assert.assertTrue(locaterSevcan.tooShort.isDisplayed());
        extentTest.info("tooshort yazısı görüldü");

        bekle(2);
        ReusableMethods.tumSayfaResmi();
        extentTest.info("tüm sayfa resmi alındı");
        extentReports.flush();

    }

    @Test(priority = 2)
    public void weak() {
        extentTest=extentReports.createTest("weak","Test Raporu");

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");
        locaterSevcan.Register_Button.click();
        locaterSevcan.vendorButton.click();
        locaterSevcan.vendorEmail.sendKeys(ConfigReader.getProperty("fakemail"));
        locaterSevcan.verificationCode.sendKeys(ConfigReader.getProperty("fakecode"));
        locaterSevcan.reSendCode.click();
        locaterSevcan.vendorPassword1.sendKeys(("123456") + Keys.TAB);
        extentTest.info("password 6 rakam girildi");

        Assert.assertTrue(locaterSevcan.Weak.isDisplayed());
        extentTest.info("weak yazısı görüldü");

        bekle(2);
        ReusableMethods.tumSayfaResmi();
        extentTest.info("tüm sayfa resmi alındı");
        extentReports.flush();

    }

    @Test(priority = 3)
    public void good() {
        extentTest=extentReports.createTest("good","Test Raporu");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");

        locaterSevcan.Register_Button.click();
        locaterSevcan.vendorButton.click();
        locaterSevcan.vendorEmail.sendKeys(ConfigReader.getProperty("fakemail"));
        locaterSevcan.verificationCode.sendKeys(ConfigReader.getProperty("fakecode"));
        locaterSevcan.reSendCode.click();
        locaterSevcan.vendorPassword1.sendKeys(("AA.22aa")+Keys.TAB);
        extentTest.info("password büyük küçük harf noktalama işareti ve rakam girildi");

        Assert.assertTrue(locaterSevcan.good.isDisplayed());
        extentTest.info("good yazısı görüldü");

        bekle(2);
        ReusableMethods.tumSayfaResmi();
        extentTest.info("tüm sayfa resmi alındı");
        extentReports.flush();



    }

    @Test(priority = 4)
    public void strong() {
        extentTest=extentReports.createTest("strong","Test Raporu");

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");

        locaterSevcan.Register_Button.click();
        locaterSevcan.vendorButton.click();
        locaterSevcan.vendorEmail.sendKeys(ConfigReader.getProperty("fakemail"));
        locaterSevcan.verificationCode.sendKeys(ConfigReader.getProperty("fakecode"));
        locaterSevcan.reSendCode.click();
        locaterSevcan.vendorPassword1.sendKeys(("AA.22.aa.123456789") + Keys.TAB);
        extentTest.info("password 12 karakterden oluşan büyük küçük harf noktalama işareti ve rakam girildi");

        Assert.assertTrue(locaterSevcan.strong.isDisplayed());
        extentTest.info("strong yazısı görüldü");

        bekle(2);
        ReusableMethods.tumSayfaResmi();
        extentTest.info("tüm sayfa resmi alındı");
        extentReports.flush();
        Driver.closeDriver();


    }


}
