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
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class US16_testSet2 {
    LocaterMali locate=new LocaterMali();
    Actions actions;
    Select select;

    //Store Menager sayfası görüntülenir
    @Test (priority = -5)
    public void sıgnIn() {

        Driver.getDriver().get(ConfigReader.getProperty("storeMenagerPage"));
        locate.signInInputMail.sendKeys(ConfigReader.getProperty("mail"));
        locate.signInInputPassword.sendKeys(ConfigReader.getProperty("password"), Keys.PAGE_DOWN);
        ReusableMethods.bekle(1);
        locate.signInButton.click();
        ReusableMethods.bekle(5);
        actions=new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(1);
        locate.storeManagerButton.click();
        ReusableMethods.bekle(2);

    }
    @Test (priority = -4)
    public void us16_tc01() {
        actions=new Actions(Driver.getDriver());
        actions.moveToElement(locate.productButton).perform();
        ReusableMethods.bekle(1);
        locate.addNewButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(locate.manageProductText.isDisplayed());
        select=new Select(locate.ddMunuSimpleVariable);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Simple"));
    }
    @Test (priority = -3)
    public void us16_tc02() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Store Manager"));
        actions=new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        locate.checkboxVirtual.click();
        Assert.assertTrue(locate.checkboxVirtual.isSelected());
        ReusableMethods.bekle(1);
        locate.checkboxDownloadable.click();
        Assert.assertTrue(locate.checkboxDownloadable.isSelected());
        locate.checkboxDownloadable.click(); //EĞER seçili kalırsa submitte extre şeyler istiyor

    }

    @Test(priority = -2)
    public void us16_tc04() {
        locate.titleProduct.sendKeys("İsimlikli Dolma Kalem");
        ReusableMethods.bekle(1);
    }

    @Test (priority = -1)
    public void us16_tc05() throws FileNotFoundException, AWTException {


        locate.priceBox.sendKeys("1200");
        ReusableMethods.bekle(1);
        locate.salePriceBox.sendKeys("1000",Keys.PAGE_DOWN);
        ReusableMethods.bekle(1);}

    @Test  //foto yükleme
    public void us16_tc06 () throws FileNotFoundException, AWTException {

            locate.bigImg.click();

            //anlatım videosu hintli (https://www.youtube.com/watch?v=Tjo-U5_JBsU)
            Robot r = new Robot();
            String path = "\"C:\\Users\\Lenovo\\Desktop\\dolmakalem1.png\"";
            System.getProperty("Driver.getDriver()", path);

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

            //küçük foto
        String path2="dolmakalem2";
        locate.smallImg1.click();
        r.delay(2000);
        locate.uploadFileButton.click();
        r.delay(2000);
        locate.selectFile2.click();
        StringSelection s2 = new StringSelection(path2);


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
        r.delay(5000);


            /* foto yükleme alanı
     ***
        locate.bigImg.click();
        ReusableMethods.bekle(1);
        String path1="C:/Users/Lenovo/Desktop/dolmakalem1.png";
        locate.selectFile.sendKeys(path1);
        ReusableMethods.bekle(3);
        */
            //  String path2="resources/dolmakalem2.png";
            //  String path3="resources/dolmakalem3.png";

            //  locate.selectFile.sendKeys(path2);
            //  locate.selectFile.sendKeys(path3);
        }
    @Test  (priority = 1)//description iframe  alanı
    public void us16_tc07 () throws FileNotFoundException, AWTException {

            WebElement iframe = locate.descriptionIF;
            Driver.getDriver().switchTo().frame(iframe);
            locate.description.sendKeys("max 30 karakter uzunluğunda isim yazılabilir");
            Driver.getDriver().switchTo().parentFrame();
            ReusableMethods.bekle(1);
        }
    @Test  (priority = 2)//catagory checkbox alanı
    public void us16_tc08 () throws FileNotFoundException, AWTException {


        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
        ReusableMethods.bekle(1);
        locate.checkboxAcc.click();
        Assert.assertTrue(locate.checkboxAcc.isSelected());
    }
    @Test  (priority = 3)//submit işlemi
    public void us16_tc09 () throws FileNotFoundException, AWTException {
        WebElement submit=locate.submitButton;
        ReusableMethods.scroll(submit);
        actions.moveToElement(submit);
        ReusableMethods.bekle(2);
        submit.click();

    }

    //ürün yayınlandı yazısı assertion
    @Test (priority = 4)
    public void us16_tc10() {

        ReusableMethods.scrollHome();
        Assert.assertTrue(locate.publishedText.isDisplayed());
     //  JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
     //  WebElement  basariMesaji= (WebElement)js.executeScript("return document.querySelector(\"#wcfm_products_manage_js-js-extra\")");

     //  System.out.println("locate.lanetText.getText() = " + basariMesaji.getText());
     //  Assert.assertTrue(basariMesaji.isDisplayed());

    }

    @Test (priority = 5)//product sayfasında yüklenen ürün kontrolü (foto teyidi sayfa resmi çeekerek yaptım)
    public void us16_tc11() throws IOException {
        SoftAssert soft=new SoftAssert();
        locate.productButton.click();

        soft.assertTrue(locate.publishedProductName.isDisplayed());

        ReusableMethods.bekle(2);
        ReusableMethods.getScreenshot("productYüklemeTeyid");
        ReusableMethods.bekle(2);

        System.out.println(locate.price.getText());
        soft.assertTrue(locate.price.getText().equals("$1,000.00"));

        soft.assertTrue(locate.ınStock.isDisplayed());
        soft.assertAll();





    }
}
