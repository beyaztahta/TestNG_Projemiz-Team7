package test.US01_US02_US10_Sevcan;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerRegisterLocates;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.bekle;

public class US10 {
    CustomerRegisterLocates locaterSevcan = new CustomerRegisterLocates();

    @Test(priority = 1)
    public void tooshort() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        locaterSevcan.Register_Button.click();
        locaterSevcan.vendorButton.click();
        locaterSevcan.vendorEmail.sendKeys(ConfigReader.getProperty("fakemail"),Keys.TAB);
        locaterSevcan.verificationCode.sendKeys(ConfigReader.getProperty("fakecode"),Keys.TAB);
        locaterSevcan.reSendCode.click();
        locaterSevcan.vendorPassword1.sendKeys(("12345"),Keys.TAB);

        Assert.assertTrue(locaterSevcan.tooShort.isDisplayed());

        bekle(2);
        ReusableMethods.tumSayfaResmi();

    }

    @Test(priority = 2)
    public void weak() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        locaterSevcan.Register_Button.click();
        locaterSevcan.vendorButton.click();
        locaterSevcan.vendorEmail.sendKeys(ConfigReader.getProperty("fakemail"));
        locaterSevcan.verificationCode.sendKeys(ConfigReader.getProperty("fakecode"));
        locaterSevcan.reSendCode.click();
        locaterSevcan.vendorPassword1.sendKeys(("12345") + Keys.TAB);
        Assert.assertTrue(locaterSevcan.tooShort.isDisplayed());

        bekle(2);
        ReusableMethods.tumSayfaResmi();

    }

    @Test(priority = 3)
    public void good() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        locaterSevcan.Register_Button.click();
        locaterSevcan.vendorButton.click();
        locaterSevcan.vendorEmail.sendKeys(ConfigReader.getProperty("fakemail"));
        locaterSevcan.verificationCode.sendKeys(ConfigReader.getProperty("fakecode"));
        locaterSevcan.reSendCode.click();
        locaterSevcan.vendorPassword1.sendKeys(("AA.22aa")+Keys.TAB);

        Assert.assertTrue(locaterSevcan.good.isDisplayed());

        bekle(2);
        ReusableMethods.tumSayfaResmi();



    }

    @Test(priority = 4)
    public void strong() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        locaterSevcan.Register_Button.click();
        locaterSevcan.vendorButton.click();
        locaterSevcan.vendorEmail.sendKeys(ConfigReader.getProperty("fakemail"));
        locaterSevcan.verificationCode.sendKeys(ConfigReader.getProperty("fakecode"));
        locaterSevcan.reSendCode.click();
        locaterSevcan.vendorPassword1.sendKeys(("AA.22.aa.123456789") + Keys.TAB);

        Assert.assertTrue(locaterSevcan.strong.isDisplayed());

        bekle(2);
        ReusableMethods.tumSayfaResmi();
        Driver.closeDriver();


    }


}
