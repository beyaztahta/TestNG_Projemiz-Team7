package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterSevcan;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US01 {

    @Test
    public void register() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker = new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(faker.name().username(), Keys.TAB);
        locaterSevcan.email.sendKeys(faker.internet().emailAddress(), Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();

        Assert.assertTrue(locaterSevcan.shopNowText.isDisplayed());
        Driver.closeDriver();


    }



    @Test
    public void usernameBos() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys((" "), Keys.TAB);
        locaterSevcan.email.sendKeys(faker.internet().emailAddress(),Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.webElementResmi(locaterSevcan.usernameUyariMesaji);
        Assert.assertTrue(locaterSevcan.usernameUyariMesaji.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void usernameBirKarakter() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(("m"), Keys.TAB);
        locaterSevcan.email.sendKeys(faker.internet().emailAddress(),Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi("bir karakter harf girildiğinde resiter olmamalı");
        Assert.assertTrue(locaterSevcan.usernameUyariMesaji.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void usernameSayiGirilirse() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker = new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(("122"), Keys.TAB);
        locaterSevcan.email.sendKeys(faker.internet().emailAddress(), Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi("sayi girildiğinde register olmamalı");
        Assert.assertTrue(locaterSevcan.usernameUyariMesaji.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void usernameSembolGirilirse() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker = new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(("/**!!"), Keys.TAB);
        locaterSevcan.email.sendKeys(faker.internet().emailAddress(), Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.webElementResmi(locaterSevcan.usernameUyariMesaji);
        Assert.assertTrue(locaterSevcan.usernameUyariMesaji.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void usernameEnFazlaKarakter() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker = new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(("" +
                "aaaaaaaaaa" +
                "bbbbbbbbbb" +
                "cccccccccc" +
                "dddddddddd" +
                "eeeeeeeeee" +
                "ffffffffffA"), Keys.TAB);
        locaterSevcan.email.sendKeys(faker.internet().emailAddress(), Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.webElementResmi(locaterSevcan.usernameFazlaysaUyariMesaji);
        Assert.assertTrue(locaterSevcan.usernameFazlaysaUyariMesaji.isDisplayed());
        Driver.closeDriver();

    }

    //////////////-------TC-2---------/////////////////
    @Test
    public void emailBos() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(faker.name().username(), Keys.TAB);
        locaterSevcan.email.sendKeys((" "),Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.tumSayfaResmi();
        //email boş oldugunda register olmaz ve shopnowtext yazısı görüntülenmez
        Assert.assertTrue(locaterSevcan.shopNowText.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void emaileSembolGirilirse() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(faker.name().username(), Keys.TAB);
        locaterSevcan.email.sendKeys(("//@gmail.com"),Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(3);

        //email SEMBOL GİRİLİRSE register olmaMALI ve shopnowtext yazısı görüntülenmez
        Assert.assertTrue(locaterSevcan.shopNowText.isDisplayed());
        ReusableMethods.tumSayfaResmi();

        Driver.closeDriver();

    }
    @Test
    public void emaileSadeceKarakterGirilirse() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(faker.name().username(), Keys.TAB);
        locaterSevcan.email.sendKeys(("aaaa"),Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi();

//        //emaileSadeceKarakterGirilirse register olmaMALI ve shopnowtext yazısı görüntülenmez
        Assert.assertFalse(locaterSevcan.shopNowText.isDisplayed());

//
        Driver.closeDriver();

    }
    @Test
    public void emaileSadeceKarakterVeAtSemboluGirilirse() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(faker.name().username(), Keys.TAB);
        locaterSevcan.email.sendKeys(("aaaa@"),Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi();
//        //emaileSadeceKarakterVeAtSemboluGirilirse register olmaMALI ve shopnowtext yazısı görüntülenmez
        Assert.assertFalse(locaterSevcan.shopNowText.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void emaileDogruGirilirse() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(faker.name().username(), Keys.TAB);
        locaterSevcan.email.sendKeys(("aaaa@gmail.com"),Keys.TAB);
        locaterSevcan.password.sendKeys(faker.internet().password());
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi();
//        //emaileDoğru Girilirse register olmaMALI ve shopnowtext yazısı görüntülenmez
        Assert.assertTrue(locaterSevcan.shopNowText.isDisplayed());
        Driver.closeDriver();

    }

    ////////////-----------------TC03------------////////////

    @Test
    public void psswordBos() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(faker.name().username(), Keys.TAB);
        locaterSevcan.email.sendKeys(faker.internet().emailAddress(),Keys.TAB);
        locaterSevcan.password.sendKeys(" ");
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
       ReusableMethods.bekle(2);
       ReusableMethods.tumSayfaResmi();
////        //password boş Girilirse register olmaMALI ve shopnowtext yazısı görüntülenmez
      Assert.assertFalse(locaterSevcan.shopNowText.isDisplayed());
      Driver.closeDriver();

    }
    @Test
    public void psswordBirKarakterGirilirse() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LocaterSevcan locaterSevcan = new LocaterSevcan();
        Faker faker=new Faker();

        locaterSevcan.register.click();
        locaterSevcan.username.sendKeys(faker.name().username(), Keys.TAB);
        locaterSevcan.email.sendKeys(faker.internet().emailAddress(),Keys.TAB);
        locaterSevcan.password.sendKeys("w");
        locaterSevcan.radioButton.click();
        locaterSevcan.signupButton.click();
//        ReusableMethods.bekle(2);
//        ReusableMethods.tumSayfaResmi();
//////        //password boş Girilirse register olmaMALI ve shopnowtext yazısı görüntülenmez
//        Assert.assertFalse(locaterSevcan.shopNowText.isDisplayed());
//        Driver.closeDriver();

    }




}




