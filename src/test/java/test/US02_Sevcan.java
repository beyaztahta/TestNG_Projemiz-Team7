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
import static utilities.ReusableMethods.tumSayfaResmi;

public class US02_Sevcan extends ReportMethods {

        @Test
        public void kayitliKullaniciKayitYapamamali() {
            CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();
            extentTest = extentReports.createTest("US-02", "Test Raporu");

            Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
            extentTest.info("https://hubcomfy.com/ adresine gidildi");

            customerRegesterPage.Register_Button.click();
            extentTest.info("Resgister butonu tıklandı");

            customerRegesterPage.User_Name_Input.sendKeys(
                    ConfigReader.getProperty("username"), Keys.TAB,
                    ConfigReader.getProperty("email"), Keys.TAB,
                    ConfigReader.getProperty("password"));
            extentTest.info("username, email ve password girildi");

            customerRegesterPage.Register_Policy_Check.click();
            extentTest.info("checkbox tıklandı");

            customerRegesterPage.Singup_Button.click();
            extentTest.info("signup butonu tıklandı");

            Assert.assertTrue(customerRegesterPage.emailHataMesaji.isDisplayed());
            extentTest.info("hata mesajı görüntülendi");
            bekle(3);

            ReusableMethods.tumSayfaResmi();
            extentTest.info("tüm sayfa resmi alındı");
            bekle(3);

            Driver.closeDriver();

        }
    }


