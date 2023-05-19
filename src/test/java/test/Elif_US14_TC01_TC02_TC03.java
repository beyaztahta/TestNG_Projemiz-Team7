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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static utilities.ReusableMethods.*;


public class Elif_US14_TC01_TC02_TC03 {
    LocaterElif locater = new LocaterElif();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testCase01() {

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();

        //Kullanıcı "Products" butonuna basar.
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();

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
        Driver.closeDriver();
    }

    @Test
    public void testCase02() throws AWTException {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();

        //Kullanıcı "Products" butonuna basar.
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();

        //Kullanıcı fotograf butonuna basar.
        bekle(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        click(locater.newFiles);

        //Kullanıcı acılan sayfada "Select Files"butonuna tıklar.
        bekle(1);
        click(locater.selectFiles);

        //Kullanıcı urun resmını upload eder.
        String path = "C://Users//hp//Desktop//wallpaperbetter.com_1920x1080 (1).jpg/";
        System.getProperty("Driver.getDriver()", path);
        StringSelection s = new StringSelection(path);
        Robot r = new Robot();

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        bekle(1);

        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.delay(2000);

        //Kullanıcı urun resmının basarıyla yuklandıgını dogrular
        System.out.println("File Uploaded Successfully");
        Driver.closeDriver();



    }

    @Test
    public void testCase03() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();

        //Kullanıcı "Products" butonuna basar.
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();

        //Kullanıcı Product Title"a bir yazı girer.
        scroll(locater.productTitle);
        bekle(2);
        locater.productTitle.sendKeys(ConfigReader.getProperty("product_title_leyla"));

        //Kullanıcı "Product Title"a text girildigini dogrular;
        bekle(2);
        Assert.assertEquals(locater.productTitle.getAttribute("value"), ConfigReader.getProperty("product_title_leyla"));

        //Kullanıcı Short Description"a bir yazı girer.
        //locater.empty.click();

        //scroll(locater.shortDescription);
        Driver.getDriver().switchTo().frame(0);
        locater.shortDescriptionTextBox.sendKeys(ConfigReader.getProperty("shortdescription_leyla"));
        bekle(2);


        //Kullanıcı "Short Description"a text girildigini dogrular.
        bekle(1);
        Assert.assertEquals(locater.shortDescriptionTextBox.getText(), ConfigReader.getProperty("shortdescription_leyla"));
        Driver.getDriver().switchTo().defaultContent();


        //Kullanıcı "Description"a bir yazı girer.
        Driver.getDriver().switchTo().frame(locater.description);
        bekle(2);
        locater.descriptionTextBox.sendKeys(ConfigReader.getProperty("description_leyla"));

        //Kullanıcı "Description"a text girildigini dogrular.
        bekle(1);
        System.out.println(locater.descriptionTextBox.getText());
        assert locater.descriptionTextBox.getText().equals("Volvo");

        Driver.getDriver().switchTo().defaultContent();
        Driver.closeDriver();
    }
}
