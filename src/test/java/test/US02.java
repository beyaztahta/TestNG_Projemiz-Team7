package test;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterSevcan;
import utilities.ConfigReader;
import utilities.Driver;

public class US02 {

        @Test
        public void kayitliKullaniciKayitYapamamali() {
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            LocaterSevcan locaterSevcan = new LocaterSevcan();
            locaterSevcan.register.click();
            locaterSevcan.username.sendKeys(
                    ConfigReader.getProperty("username"), Keys.TAB,
                    ConfigReader.getProperty("email"), Keys.TAB,
                    ConfigReader.getProperty("password"));
            locaterSevcan.radioButton.click();
            locaterSevcan.signupButton.click();
            Assert.assertTrue(locaterSevcan.emailHataMesaji.isDisplayed());
            Driver.closeDriver();

        }
    }


