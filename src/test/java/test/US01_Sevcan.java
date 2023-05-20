package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerRegisterLocates;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.fakerInput;

public class US01_Sevcan extends ReportMethods {

    @Test
    public void TC_1() {
        extentTest = extentReports.createTest("TC-01", "Test Raporu");

        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");

        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();
        String username = fakerInput("username");
        String email = fakerInput("email");
        String password = fakerInput("password");

        customerRegesterPage.Register_Button.click();
        bekle(3);
        extentTest.info("Register Butonu tıklandı");

        Assert.assertTrue(customerRegesterPage.User_Name_Input.isEnabled());
        extentTest.info("Username kutusu görüntülendi");
        customerRegesterPage.User_Name_Input.sendKeys(username);
        extentTest.info("Username kutusuna username girildi");
        bekle(3);

        Assert.assertTrue(customerRegesterPage.E_Mail_Input.isEnabled());
        extentTest.info("Email kutusu görüntülendi");
        customerRegesterPage.E_Mail_Input.sendKeys(email);
        extentTest.info("Email kutusuna email girildi");
        bekle(3);

        Assert.assertTrue(customerRegesterPage.Password_Input.isEnabled());
        extentTest.info("Password kutusu görüntülendi");
        customerRegesterPage.Password_Input.sendKeys(password);
        extentTest.info("Password kutusuna password girildi");
        bekle(3);

        Assert.assertTrue(customerRegesterPage.Register_Policy_Check.isEnabled());
        extentTest.info("Register Policy Checkbox kutusu görüntülendi");
        customerRegesterPage.Register_Policy_Check.click();
        extentTest.info("Register Policy Checkbox kutusu tıklandı");
        bekle(3);

        Assert.assertTrue(customerRegesterPage.Singup_Button.isEnabled());
        extentTest.info("signup butonu görüntülendi");
        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup butonu tıklandı");
        bekle(3);

        Assert.assertTrue(customerRegesterPage.shopNowText.isDisplayed());
        extentTest.info("shop now yazısı görüntülendi");
        bekle(3);

        Assert.assertTrue(customerRegesterPage.signoutButton.isDisplayed());
        extentTest.info("sign out butonu görüntülendi");
        customerRegesterPage.signoutButton.click();
        extentTest.info("signout butonu tıklandı");
        bekle(3);

        Assert.assertTrue(customerRegesterPage.logoutButton.isDisplayed());
        extentTest.info("logout butonu görüntülendi");
        customerRegesterPage.logoutButton.click();
        extentTest.info("logout butonu tıklandı");
        extentReports.flush();

        Driver.closeDriver();
    }

    @Test
    public void TC_2() {
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();
        extentTest = extentReports.createTest("TC-02", "Test Raporu");

        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");

        customerRegesterPage.Register_Button.click();
        extentTest.info("Register Butonu tıklandı");
        bekle(3);

        extentTest.info("username boş bırakıldı");

        customerRegesterPage.E_Mail_Input.sendKeys(fakerInput("email"));
        extentTest.info("email girildi");
        bekle(3);

        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        extentTest.info("password girildi");
        bekle(3);

        customerRegesterPage.Register_Policy_Check.click();
        extentTest.info("checkbox tıklandı");
        bekle(3);

        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup buton tıklandı");
        bekle(3);

        ReusableMethods.tumSayfaResmi("username_bos");
        extentTest.info("tum sayfa resmi alındı");

        customerRegesterPage.User_Name_Input.sendKeys(fakerInput("username"));
        extentTest.info("username girildi");
        bekle(3);

        customerRegesterPage.E_Mail_Input.clear();

        customerRegesterPage.E_Mail_Input.sendKeys(fakerInput("email"));
        extentTest.info("email girildi");
        bekle(3);

        customerRegesterPage.Password_Input.clear();
        extentTest.info("girilmiş olan password silinidi");
        bekle(3);

        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup butonu tıklandı");
        bekle(3);

        ReusableMethods.tumSayfaResmi("password bos");
        extentTest.info("tum sayfa resmi alındı");

        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        extentTest.info("password girildi");

        customerRegesterPage.Register_Policy_Check.click();
        extentTest.info("checkbox tıklandı");
        bekle(3);

        ReusableMethods.tumSayfaResmi("checkbok tıklanmalı");
        extentTest.info("tum sayfa resmi alındı");

        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup butonu tıklandı");
        bekle(5);

        customerRegesterPage.Register_Policy_Check.click();
        extentTest.info("checkbox tıklandı");
        bekle(3);

        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup butonu tıklandı");
        bekle(5);

        extentReports.flush();
        Driver.closeDriver();
    }

    @Test
    public void TC_3() {
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();

        extentTest = extentReports.createTest("TC-03", "Test Raporu");

        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");


        customerRegesterPage.Register_Button.click();
        extentTest.info("Register butonuna tıklandı");
        bekle(3);
        customerRegesterPage.User_Name_Input.sendKeys(fakerInput("username"));
        extentTest.info("username girildi");
        bekle(3);
        customerRegesterPage.E_Mail_Input.sendKeys(fakerInput("email"));
        extentTest.info("email girildi");
        bekle(3);
        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        extentTest.info("password girildi");
        bekle(3);
        customerRegesterPage.Register_Policy_Check.click();
        extentTest.info("checkbox tıklandı");
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup tıklandı");
        bekle(10);

        Driver.closeDriver();

    }

    @Test
    public void TC_4() {
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();

        extentTest = extentReports.createTest("TC-04", "Test Raporu");

        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");

        customerRegesterPage.Register_Button.click();
        extentTest.info("Register butonu tıklandı");
        bekle(3);
        customerRegesterPage.User_Name_Input.sendKeys(fakerInput("username"));
        extentTest.info("username girildi");
        bekle(3);
        customerRegesterPage.E_Mail_Input.sendKeys("asdwre");
        extentTest.info("email girildi");
        bekle(3);
        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        extentTest.info("password girildi");
        bekle(3);
        customerRegesterPage.Register_Policy_Check.click();
        extentTest.info("checkbox tıklandı");
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup tıklandı");
        bekle(5);

        customerRegesterPage.E_Mail_Input.clear();
        extentTest.info("bir önceki girilen email silindi");
        customerRegesterPage.E_Mail_Input.sendKeys("asdw@");
        extentTest.info("email girildi");
        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup butonu tıklandı");
        bekle(5);

        customerRegesterPage.E_Mail_Input.clear();
        extentTest.info("bir önceki girilen email silindi ");
        customerRegesterPage.E_Mail_Input.sendKeys("asdw@re");
        extentTest.info("email girildi");
        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup butonu tıklandı");
        bekle(6);

        customerRegesterPage.E_Mail_Input.clear();
        extentTest.info("bir önceki girilen email silindi ");
        customerRegesterPage.E_Mail_Input.sendKeys("as dw@re");
        extentTest.info("email girildi");
        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup butonu tıklandı");
        bekle(10);

        customerRegesterPage.E_Mail_Input.clear();
        extentTest.info("bir önceki girilen email silindi ");
        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup butonu tıklandı");
       Driver.closeDriver();
    }

    @Test
    public void TC_5() {
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();

        extentTest = extentReports.createTest("TC-05", "Test Raporu");

        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        extentTest.info("https://hubcomfy.com/ adresine gidildi");

        customerRegesterPage.Register_Button.click();
        extentTest.info("Register butonuna tıklandı");
        bekle(3);
        customerRegesterPage.User_Name_Input.sendKeys(fakerInput("username"));
        extentTest.info("username girildi");
        bekle(3);
        customerRegesterPage.E_Mail_Input.sendKeys(fakerInput("email"));
        extentTest.info("email girildi");
        bekle(3);
        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        extentTest.info("password girildi");
        bekle(3);
        customerRegesterPage.Register_Policy_Check.click();
        extentTest.info("checkbox tıklandı");
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        extentTest.info("signup tıklandı");
        bekle(10);

        Driver.closeDriver();

    }
}