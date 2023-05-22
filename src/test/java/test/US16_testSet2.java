package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterMali;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class US16_testSet2 extends ReportMethods {
    LocaterMali locate=new LocaterMali();
    Actions actions;
    Select select;

    //Store Menager sayfası görüntülenir
    @Test (priority = -5)
    public void signIn() {

        extentTest=extentReports.createTest("US16","singIn");
        Driver.getDriver().get(ConfigReader.getProperty("storeMenagerPage"));
        extentTest.pass("hubcomfy.com sayfasına gidildi");

        locate.signInInputMail.sendKeys(ConfigReader.getProperty("mail"));
        extentTest.pass("geçerli mail adresi girildi");

        locate.signInInputPassword.sendKeys(ConfigReader.getProperty("password1"), Keys.PAGE_DOWN);
        extentTest.pass("geçerli şifre girildi");
        ReusableMethods.bekle(1);
        locate.signInButton.click();
        extentTest.pass("signIn button tıklandı ve giriş yapıldı");
        ReusableMethods.bekle(5);
        actions=new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(1);
        locate.storeManagerButton.click();
        extentTest.pass("store manager butonu tıklanarak sayfaya gidildi");
        ReusableMethods.bekle(2);



    }
    @Test (priority = -4)
    public void us16_tc01() {
        extentTest=extentReports.createTest("US16","tc02");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

        actions=new Actions(Driver.getDriver());
        actions.moveToElement(locate.productButton).perform();
        ReusableMethods.bekle(1);
        locate.addNewButton.click();
        extentTest.pass("Sol Menu seçeneklerinden 'Product button' tıklandı");
        ReusableMethods.bekle(2);
        Assert.assertTrue(locate.manageProductText.isDisplayed());
        extentTest.pass("Manage Product yazısının göründüğü ve sayfada olunulduğu test edildi");
        select=new Select(locate.ddMunuSimpleVariable);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Simple"));
        extentTest.pass("Product Box alanında 'Simple Product' seçimi default olarak geldiği test edildi");
    }
    @Test (priority = -3)
    public void us16_tc02_tc03() {
        extentTest=extentReports.createTest("US16","tc02-tc03");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Store Manager"));
        extentTest.pass(" store manager sayfa başlığı test edildi ");
        actions=new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        locate.checkboxVirtual.click();
        extentTest.pass("Virtual Checkbox kutusu seçildi ");
        Assert.assertTrue(locate.checkboxVirtual.isSelected());
        extentTest.pass("Virtual Checkbox kutusu seçiminin yapılıdığı test edildi ");
        ReusableMethods.bekle(1);
        locate.checkboxDownloadable.click();
        extentTest.pass("Downloadable Checkbox kutusu seçildi ");
        Assert.assertTrue(locate.checkboxDownloadable.isSelected());
        extentTest.pass("Downloadable Checkbox kutusu seçiminin yapılıdığı test edildi ");
        locate.checkboxDownloadable.click(); //EĞER seçili kalırsa submitte extre şeyler istiyor

    }

    @Test(priority = -2)
    public void us16_tc04() {
        extentTest=extentReports.createTest("US16","tc04");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

        locate.titleProduct.sendKeys("İsimlikli Dolma Kalem");
        extentTest.pass("Ürün başlığı alanına istenilen data girildi ");

        ReusableMethods.bekle(1);
        locate.priceBox.sendKeys("1200");
        extentTest.pass("Ürün fiyatı alanına istenilen data girildi ");
        ReusableMethods.bekle(1);
        locate.salePriceBox.sendKeys("1000",Keys.PAGE_DOWN);
        extentTest.pass("Ürün indirimli fiyat alanına istenilen data girildi ");
        ReusableMethods.bekle(1);}

    @Test  //foto yükleme
    public void us16_tc05 () throws FileNotFoundException, AWTException {
        extentTest=extentReports.createTest("US16","tc05");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

            locate.bigImg.click();
        extentTest.pass("Ürüne ait foto yükleme alanına tıklandı. ");

            //anlatım videosu hintli (https://www.youtube.com/watch?v=Tjo-U5_JBsU)
            Robot r = new Robot();
            String path = "\"C:\\Users\\Lenovo\\Desktop\\dolmakalem1.png\"";
            System.getProperty("Driver.getDriver()", path);
            extentTest.pass("Yüklenmesi istenen foto, localden seçimi yapıldı. ");

            locate.selectFile.click();

            r.delay(2000);
            StringSelection s = new StringSelection(path);


            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
            r.delay(1000);
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            ReusableMethods.bekle(1);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.delay(1000);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            ReusableMethods.waitForClickablility(locate.selectButton, 10);
            locate.selectButton.click();
            r.delay(5000);
            extentTest.pass("Yüklenmesi istenen foto, localden sayfaya transfer edildi. ");

            //küçük foto

        String path2="dolmakalem2";
        locate.smallImg1.click();
        extentTest.pass("Ürüne ait küçükfoto yükleme alanına tıklandı. ");
        r.delay(2000);
        locate.uploadFileButton.click();
        r.delay(2000);
        locate.selectFile2.click();
        StringSelection s2 = new StringSelection(path2);
        extentTest.pass("Yüklenmesi istenen foto, localden seçimi yapıldı. ");


        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s2, null);
        r.delay(1000);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        ReusableMethods.bekle(1);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.delay(1000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

       ReusableMethods.waitForClickablility(locate.addToGalaryButton, 10);
        locate.addToGalaryButton.click();
        extentTest.pass("Yüklenmesi istenen foto, localden sayfaya transfer edildi. ");
        r.delay(5000);



        }
    @Test  (priority = 1)//description iframe  alanı
    public void us16_tc06 () throws FileNotFoundException, AWTException {
        extentTest=extentReports.createTest("US16","tc06");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

            WebElement iframe = locate.descriptionIF;
            Driver.getDriver().switchTo().frame(iframe);
            extentTest.pass("Description İframe alanına  data girişi için geçiş yapıldı ");
            locate.description.sendKeys("max 30 karakter uzunluğunda isim yazılabilir");
            extentTest.pass("Description İframe alanına istenilen data girildi ");
            Driver.getDriver().switchTo().parentFrame();
            extentTest.pass("Description İframe alanından ana sayfa alanına dönüş yapıldı");
            ReusableMethods.bekle(1);
        }
    @Test  (priority = 2)//catagory checkbox alanı
    public void us16_tc07 () throws FileNotFoundException, AWTException {
        extentTest=extentReports.createTest("US16","tc07");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");


        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
        ReusableMethods.bekle(1);
        locate.checkboxAcc.click();
        extentTest.pass("Catagory checkbox alanından ilgili seçim yapıldı ");
        Assert.assertTrue(locate.checkboxAcc.isSelected());
        extentTest.pass("Yapılan seçimin 'seçili olarak' gözüktüğü test edildi ");
    }
    @Test  (priority = 3)//submit işlemi
    public void us16_tc08 () throws FileNotFoundException, AWTException {
        extentTest=extentReports.createTest("US16","tc08");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

        WebElement submit=locate.submitButton;
        extentTest.pass("Sayfa sonu Submit Button alanına gelindi ");
        ReusableMethods.scroll(submit);
        actions.moveToElement(submit);
        ReusableMethods.bekle(2);
        submit.click();
        extentTest.pass("Submit Button tıklaması yapıldı");

        ReusableMethods.scrollHome();
        extentTest.pass("Sayfa başına gelindi ");
        Assert.assertTrue(locate.publishedText.isDisplayed());

        extentTest.pass("Dataları girilen ürünün yayınlandığı 'published' yazısı ile test edildi ");
     //  JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
     //  WebElement  basariMesaji= (WebElement)js.executeScript("return document.querySelector(\"#wcfm_products_manage_js-js-extra\")");

     //  System.out.println("locate.lanetText.getText() = " + basariMesaji.getText());
     //  Assert.assertTrue(basariMesaji.isDisplayed());

    }

    @Test (priority = 5)//product sayfasında yüklenen ürün kontrolü (foto teyidi sayfa resmi çeekerek yaptım)
    public void us16_tc9() throws IOException {
        extentTest=extentReports.createTest("US16","tc09");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

        SoftAssert soft=new SoftAssert();
        locate.productButton.click();
        extentTest.pass("Product Button tıklandı ");

        soft.assertTrue(locate.publishedProductName.isDisplayed());
        extentTest.pass("yüklenen ürünün ismi yayınlanan ürünlerde görüntülendi ");

        ReusableMethods.bekle(2);
        ReusableMethods.getScreenshot("productYüklemeTeyid");
        extentTest.pass("yükleme işlemine ilişkin sayfa resmi alındı ");
        ReusableMethods.bekle(2);

        System.out.println(locate.price.getText());
        soft.assertTrue(locate.price.getText().equals("$1,000.00"));
        extentTest.pass("yüklenen ürünün ismi fiyat bilgisinin girilen data ile karşılaştırması yapıldı ");

        soft.assertTrue(locate.ınStock.isDisplayed());
        extentTest.pass("yüklenen ürünün stok durumu bilgisinin girilen data ile karşılaştırması yapıldı ");
        soft.assertAll();
        extentTest.pass("TestCase Tamamlandı ");



    }
}
