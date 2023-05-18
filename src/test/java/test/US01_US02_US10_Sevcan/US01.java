package test.US01_US02_US10_Sevcan;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerRegisterLocates;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.bekle;
import static utilities.ReusableMethods.fakerInput;

public class US01 {

    @Test
    public void TC_1 (){

        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();
        String username = fakerInput("username");
        String email = fakerInput("email");
        String password = fakerInput("password");

        customerRegesterPage.Register_Button.click();
        bekle(3);
        Assert.assertTrue(customerRegesterPage.E_Mail_Input.isEnabled());
        customerRegesterPage.User_Name_Input.sendKeys(username);
        bekle(3);
        Assert.assertTrue(customerRegesterPage.E_Mail_Input.isEnabled());
        customerRegesterPage.E_Mail_Input.sendKeys(email);
        bekle(3);
        Assert.assertTrue(customerRegesterPage.Password_Input.isEnabled());
        customerRegesterPage.Password_Input.sendKeys(password);
        bekle(3);
        Assert.assertTrue(customerRegesterPage.Register_Policy_Check.isEnabled());
        customerRegesterPage.Register_Policy_Check.click();
        bekle(3);
        Assert.assertTrue(customerRegesterPage.Singup_Button.isEnabled());
        customerRegesterPage.Singup_Button.click();
        bekle(3);
        Assert.assertTrue(customerRegesterPage.Profile.isEnabled());
//        customerRegesterPage.Profile.click();
//        bekle(3);
////
////        customerRegesterPage.Sing_Out.click();
////        bekle(3);
        Driver.closeDriver();


    }

    @Test
    public void TC_2 (){

        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();

        customerRegesterPage.Register_Button.click();
        bekle(3);

        customerRegesterPage.E_Mail_Input.sendKeys(fakerInput("email"));
        bekle(3);
        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        bekle(3);
        customerRegesterPage.Register_Policy_Check.click();
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        bekle(5);

        customerRegesterPage.User_Name_Input.sendKeys(fakerInput("username"));

        customerRegesterPage.E_Mail_Input.clear();
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        bekle(3);

        customerRegesterPage.E_Mail_Input.sendKeys(fakerInput("email"));

        customerRegesterPage.Password_Input.clear();
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        bekle(3);

        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        customerRegesterPage.Register_Policy_Check.click();
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        bekle(5);
        Driver.closeDriver();

    }

    @Test
    public void TC_3 (){

        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();

        customerRegesterPage.Register_Button.click();
        bekle(3);
        customerRegesterPage.User_Name_Input.sendKeys(fakerInput("username"));
        bekle(3);
        customerRegesterPage.E_Mail_Input.sendKeys(fakerInput("email"));
        bekle(3);
        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        bekle(3);
        customerRegesterPage.Register_Policy_Check.click();
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        bekle(10);

        Driver.closeDriver();

    }

    @Test
    public void TC_4() {
        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();

        customerRegesterPage.Register_Button.click();
        bekle(3);
        customerRegesterPage.User_Name_Input.sendKeys(fakerInput("username"));
        bekle(3);
        customerRegesterPage.E_Mail_Input.sendKeys("asdwre");
        bekle(3);
        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        bekle(3);
        customerRegesterPage.Register_Policy_Check.click();
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        bekle(5);

        customerRegesterPage.E_Mail_Input.clear();
        customerRegesterPage.E_Mail_Input.sendKeys("asdw@");
        customerRegesterPage.Singup_Button.click();
        bekle(5);

        customerRegesterPage.E_Mail_Input.clear();
        customerRegesterPage.E_Mail_Input.sendKeys("asdw@re");
        customerRegesterPage.Singup_Button.click();
        bekle(6);

        customerRegesterPage.E_Mail_Input.clear();
        customerRegesterPage.E_Mail_Input.sendKeys("as dw@re");
        customerRegesterPage.Singup_Button.click();
        bekle(10);

        customerRegesterPage.E_Mail_Input.clear();
        customerRegesterPage.Singup_Button.click();
        Driver.closeDriver();
    }

    @Test
    public void TC_5() {
        Driver.getDriver().get(ConfigReader.getProperty("Hubcomfy_Url"));
        CustomerRegisterLocates customerRegesterPage = new CustomerRegisterLocates();

        customerRegesterPage.Register_Button.click();
        bekle(3);
        customerRegesterPage.User_Name_Input.sendKeys(fakerInput("username"));
        bekle(3);
        customerRegesterPage.E_Mail_Input.sendKeys(fakerInput("email"));
        bekle(3);
        customerRegesterPage.Password_Input.sendKeys(fakerInput("password"));
        bekle(3);
        customerRegesterPage.Register_Policy_Check.click();
        bekle(3);
        customerRegesterPage.Singup_Button.click();
        bekle(5);

        Driver.closeDriver();
    }
}