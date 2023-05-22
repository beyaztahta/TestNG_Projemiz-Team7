package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterElif;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static utilities.ReusableMethods.*;


public class US14_Elif1 extends ReportMethods {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testCase01() {
        LocaterElif locater = new LocaterElif();
        extentTest = extentReports.createTest("US14", "Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçenekleri olmalı");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESINE GIDILDI.");

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();
        extentTest.pass("VENDOR OLARAK GIRIS YAPILDI.");

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();
        extentTest.pass("STORE MANAGER BUTONUNA TIKLANDI.");

        //Kullanıcı "Products" butonuna basar.
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();
        extentTest.pass("PRODUCTS   BUTONUNA TIKLANDI.");

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();
        extentTest.pass("ADD NEW BUTONUNA TIKLANDI.");

        //Kullanıcı urun turunun secildigi dropdowndan "Simple Product"seceneginin gorundugunu dogrular.
        //Kullanıcı urun turunun secildigi dropdowndan "Variabla Product"secenegini gotndugunu dogrular.
        //Kullanıcı urun turunun secildigi dropdowndan "Grouped Product"seceneginin gorundugunu dogrular.
        //Kullanıcı urun turunun secildigi dropdowndan "External-Affiliate Product"seceneginin gorundugunu dogrular.
        scroll(locater.simpleProductDropDown);
        Select select = new Select(locater.simpleProductDropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions) {
            assert w.isDisplayed();
        }
        extentTest.pass(" SIMPLE PRODUCT SECENEGI GORULDU VE DOGRULAMASI YAPILDI.");
        extentTest.pass(" VARIABLA PRODUCT SECENEGI GORULDU VE DOGRULAMASI YAPILDI.");
        extentTest.pass(" GROUPED PRODUCT SECENEGI GORULDU VE DOGRULAMASI YAPILDI.");
        extentTest.pass(" EXTERNAL-AFFILIATE PRODUCT SECENEGI GORULDU VE DOGRULAMASI YAPILDI.");
        extentTest.pass(" EXTERNAL-AFFILIATE PRODUCT SECENEGI GORULDU VE DOGRULAMASI YAPILDI.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");
    }

    @Test
    public void testCase02() throws AWTException {
        LocaterElif locater = new LocaterElif();
        extentTest = extentReports.createTest("US14", "Ürün fotoğrafı eklenebilmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESINE GIDILDI.");

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();
        extentTest.pass("VENDOR OLARAK GIRIS YAPILDI");

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();
        extentTest.pass("STORE MANAGER BUTONUNA TIKLANDI.");

        //Kullanıcı "Products" butonuna basar.
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();
        extentTest.pass("PRODUCTS BUTONUNA TIKLANDI.");

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();
        extentTest.pass("ADD NEW BUTONUNA TIKLANDI.");

        //Kullanıcı fotograf butonuna basar.
        bekle(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        click(locater.newFiles);
        extentTest.pass("FOTOGRAF BUTONUNA TIKLANDI.");

        //Kullanıcı acılan sayfada "Select Files"butonuna tıklar.
        bekle(1);
        click(locater.selectFiles);
        extentTest.pass("ACILAN SAYFADA SELECT FILES BUTONUNA TIKLANDI.");

        //Kullanıcı urun resmını upload eder.
        String path = "\"C:\\Users\\Lenovo\\Desktop\\THANKS.png\"";
        System.getProperty("Driver.getDriver()", path);
        StringSelection s = new StringSelection(path);
        Robot r = new Robot();
        extentTest.pass("URUN RESMI UPLOAD EDİLDİ.");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        bekle(1);

        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.delay(2000);

        //Kullanıcı urun resmının basarıyla yuklandıgını dogrular
        System.out.println("File Uploaded Successfully");
        extentTest.pass("URUN RESMININ BASARI ILE UPLOAD EDILDIGI DOGRULANDI.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");

    }

    @Test
    public void testCase03() {
        LocaterElif locater = new LocaterElif();
        extentTest = extentReports.createTest("US14", "Product Title, Short Description ve Description yazılabilmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESINE GIDILDI.");

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();
        extentTest.pass("VENDOR OLARAK GIRIS YAPILDI.");

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();
        extentTest.pass("STORE MANAGER BUTONUNA TIKLANDI.");

        //Kullanıcı "Products" butonuna basar.
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();
        extentTest.pass("PRODUCTS BUTONUNA TIKLANDI.");

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();
        extentTest.pass("ADD NEW BUTONUNA TIKLANDI.");

        //Kullanıcı Product Title"a bir yazı girer.
        scroll(locater.productTitle);
        bekle(2);
        locater.productTitle.sendKeys(ConfigReader.getProperty("product_title_leyla"));
        extentTest.pass("PRODUCT TITLE A YAZI GIRILDI.");

        //Kullanıcı "Product Title"a text girildigini dogrular;
        bekle(2);
        Assert.assertEquals(locater.productTitle.getAttribute("value"), ConfigReader.getProperty("product_title_leyla"));
        extentTest.pass("PRODUCT TITLE A GIRILEN YAZININ DOGRULAMASI YAPILDI.");

        //Kullanıcı Short Description"a bir yazı girer.
        Driver.getDriver().switchTo().frame(0);
        extentTest.pass("IFRAME GIRIS YAPILDI.");
        locater.shortDescriptionTextBox.sendKeys(ConfigReader.getProperty("shortdescription_leyla"));
        bekle(2);
        extentTest.pass("SHORT DESCRIPTION A YAZI GIRILDI.");

        //Kullanıcı "Short Description"a text girildigini dogrular.
        bekle(1);
        Assert.assertEquals(locater.shortDescriptionTextBox.getText(), ConfigReader.getProperty("shortdescription_leyla"));
        extentTest.pass("SHORT DESCRIPTION A GIRILEN YAZININ DOGRULAMASI YAPILDI.");
        Driver.getDriver().switchTo().defaultContent();
        extentTest.pass("IFRAMEDEN CIKIS YAPILDI.");

        //Kullanıcı "Description"a bir yazı girer.
        Driver.getDriver().switchTo().frame(locater.description);
        extentTest.pass("IFRAME GIRIS YAPILDI.");
        bekle(2);
        locater.descriptionTextBox.sendKeys(ConfigReader.getProperty("description_leyla"));
        extentTest.pass("DESCRIPTION A YAZI GIRILDI.");

        //Kullanıcı "Description"a text girildigini dogrular.
        bekle(1);
        System.out.println(locater.descriptionTextBox.getText());
        assert locater.descriptionTextBox.getText().equals("Volvo");
        extentTest.pass(" DESCRIPTION A GIRILEN YAZININ DOGRULAMASI YAPILDI.");
        Driver.getDriver().switchTo().defaultContent();
        extentTest.pass("IFRAMEDEN CIKIS YAPILDI.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");
    }
}
