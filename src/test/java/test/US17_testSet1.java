package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterMali;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class US17_testSet1 extends ReportMethods {
    LocaterMali locate=new LocaterMali();
    Actions actions;
    Select select;

    //Store Menager sayfası görüntülenir

    @Test(priority = -10) //giriş
    public void tc1_signIn() {

        extentTest=extentReports.createTest("US17","sıngIn");


        Driver.getDriver().get(ConfigReader.getProperty("storeMenagerPage"));
        extentTest.pass("hubcomfy.com sayfasına gidildi");

        locate.signInInputMail.sendKeys(ConfigReader.getProperty("mail"));
        extentTest.pass("geçerli mail adresi girildi");

        locate.signInInputPassword.sendKeys(ConfigReader.getProperty("password"), Keys.PAGE_DOWN);
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
    @Test (priority = -9) // add new product alanı geçişi
    public void tc1_addNew() {
        extentTest=extentReports.createTest("US17","addNew");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

        actions=new Actions(Driver.getDriver());
        actions.moveToElement(locate.productButton).perform();
        ReusableMethods.bekle(1);
        locate.addNewButton.click();
        extentTest.pass("Sol Menu seçeneklerinden 'Product button' tıklandı");
        ReusableMethods.bekle(2);
        Assert.assertTrue(locate.manageProductText.isDisplayed());
        extentTest.pass("Manage Product yazısının göründüğü ve sayfada olunulduğu test edildi");

        extentTest.pass("Product Box alanında 'Simple Product' seçimi default olarak geldiği test edildi");
    }

    @Test (priority = -8)
    public void tc1_ddmVeriable() {
        extentTest=extentReports.createTest("US17","ddmVariable");
        extentTest.pass("Kullanıcı menage product sayfasına geldi ");
        select=new Select(locate.ddMunuSimpleVariable);
        select.selectByIndex(1);
        extentTest.pass("DDM menüden 'Variable' seçeneği seçildi ");
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Variable"));
        extentTest.pass("DDM menüde 'Variable' seçeneğinin seçili durumda olduğu test edildi ");

    }
    @Test(priority = -7)
    public void tc2_titleGirisi() {
        extentTest=extentReports.createTest("US17","Title Girisi");
        extentTest.pass("Kullanıcı menage product sayfasına geldi ");
        locate.titleProduct.sendKeys("İsimlikli Dolma Kalem");
        extentTest.pass("İstenilen data giirişinin yapılabilindiği test edildi ");
        ReusableMethods.bekle(1);
    }

    @Test (priority = -5)
    public void tc2_uploadPictures () throws FileNotFoundException, AWTException {

        extentTest=extentReports.createTest("US16","upload pictures");
        extentTest.pass("Kullanıcı menage product sayfasına geldi ");

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
    @Test  (priority = -4)//description iframe  alanı
    public void tc2_description () throws FileNotFoundException, AWTException {

        extentTest=extentReports.createTest("US16","description");
        extentTest.pass("Kullanıcı menage product sayfasına geldi ");

        WebElement iframe = locate.descriptionIF;
        Driver.getDriver().switchTo().frame(iframe);
        extentTest.pass("Description İframe alanına  data girişi için geçiş yapıldı ");
        locate.description.sendKeys("max 30 karakter uzunluğunda isim yazılabilir");
        extentTest.pass("Description İframe alanına istenilen data girildi ");
        Driver.getDriver().switchTo().parentFrame();
        extentTest.pass("Description İframe alanından ana sayfa alanına dönüş yapıldı");
        ReusableMethods.bekle(1);
    }
    @Test  (priority = -3)//catagory checkbox alanı
    public void tc2_catogory () throws FileNotFoundException, AWTException {
        extentTest=extentReports.createTest("US16","Catagory");
        extentTest.pass("Kullanıcı menage product sayfasına geldi ");


        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
        ReusableMethods.bekle(1);
        locate.checkboxAcc.click();
        extentTest.pass("Catagory checkbox alanından ilgili seçim yapıldı ");
        Assert.assertTrue(locate.checkboxAcc.isSelected());
        extentTest.pass("Yapılan seçimin 'seçili olarak' gözüktüğü test edildi ");
    }
    @Test  (priority = -2)//submit işlemi
    public void tc2_submit () throws FileNotFoundException, AWTException {
        extentTest=extentReports.createTest("US16","submit");
        extentTest.pass("Kullanıcı menage product sayfasına geldi ");

        WebElement submit=locate.submitButton;

        ReusableMethods.scroll(submit);
        extentTest.pass("Sayfa sonu submit button alanına gelindi ");

        ReusableMethods.bekle(1);
        Assert.assertTrue(submit.isDisplayed());
        extentTest.pass("Submit button görünürlüğü test edildi ");
        submit.click();
        extentTest.pass("Submit button tıklaması yapıldı ");
    }
    @Test (priority = -1)
    public void tc2_successfullyPublished() {
        extentTest=extentReports.createTest("US16","PublishedProduct");
        extentTest.pass("Kullanıcı menage product sayfasına geldi ");

        ReusableMethods.scrollHome();
        Assert.assertTrue(locate.publishedText.isDisplayed());
        extentTest.pass("Bilgileri girilen ürünün 'Published' yazısı görüntülendi ");
        extentTest.pass("TestCase Tamamlandı ");





        //  JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        //  WebElement  basariMesaji= (WebElement)js.executeScript("return document.querySelector(\"#wcfm_products_manage_js-js-extra\")");
        //  System.out.println("locate.lanetText.getText() = " + basariMesaji.getText());
        //  Assert.assertTrue(basariMesaji.isDisplayed());

    }




}
