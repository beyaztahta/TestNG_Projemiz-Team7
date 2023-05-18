package test.US01_US02_US10_Sevcan;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerRegisterLocates;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.bekle;

public class US02 extends ReportMethods {

        @Test
        public void kayitliKullaniciKayitYapamamali() {
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            CustomerRegisterLocates locaterSevcan = new CustomerRegisterLocates();
            locaterSevcan.Register_Button.click();
            locaterSevcan.User_Name_Input.sendKeys(
                    ConfigReader.getProperty("username"), Keys.TAB,
                    ConfigReader.getProperty("email"), Keys.TAB,
                    ConfigReader.getProperty("password"));
            locaterSevcan.Register_Policy_Check.click();
            locaterSevcan.Singup_Button.click();
            Assert.assertTrue(locaterSevcan.emailHataMesaji.isDisplayed());
            bekle(3);
            ReusableMethods.tumSayfaResmi();
            Driver.closeDriver();

        }
    }


