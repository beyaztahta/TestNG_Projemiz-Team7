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
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class US17_testSet1 {
    LocaterMali locate=new LocaterMali();
    Actions actions;
    Select select;

    //Store Menager sayfası görüntülenir

    @Test(priority = -10) //giriş
    public void tc1_sıgnIn() {

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
    @Test (priority = -9) // add new product alanı geçişi
    public void tc1_addNew() {
        actions=new Actions(Driver.getDriver());
        actions.moveToElement(locate.productButton).perform();
        ReusableMethods.bekle(1);
        locate.addNewButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(locate.manageProductText.isDisplayed());

    }

    @Test (priority = -8)
    public void tc1_ddmVeriable() {
        select=new Select(locate.ddMunuSimpleVariable);
        select.selectByIndex(1);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Variable"));
    }
    @Test(priority = -7)
    public void tc2_titleGirisi() {
        locate.titleProduct.sendKeys("İsimlikli Dolma Kalem");
        ReusableMethods.bekle(1);
    }
    @Test (priority = -6)
    public void tc2_priceSalePrice() throws FileNotFoundException, AWTException {

        locate.priceBox.sendKeys("1200");
        ReusableMethods.bekle(1);
        locate.salePriceBox.sendKeys("1000",Keys.PAGE_DOWN);
        ReusableMethods.bekle(1);}

    @Test (priority = -5)
    public void tc2_uploadPictures () throws FileNotFoundException, AWTException {

        locate.bigImg.click();

        //Robot class anlatım videosu hintli (https://www.youtube.com/watch?v=Tjo-U5_JBsU)
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

    }
    @Test  (priority = -4)//description iframe  alanı
    public void tc2_description () throws FileNotFoundException, AWTException {

        WebElement iframe = locate.descriptionIF;
        Driver.getDriver().switchTo().frame(iframe);
        locate.description.sendKeys("max 30 karakter uzunluğunda isim yazılabilir");
        Driver.getDriver().switchTo().parentFrame();
        ReusableMethods.bekle(1);
    }
    @Test  (priority = -3)//catagory checkbox alanı
    public void tc2_catogory () throws FileNotFoundException, AWTException {
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
        ReusableMethods.bekle(1);
        locate.checkboxAcc.click();
        Assert.assertTrue(locate.checkboxAcc.isSelected());
    }
    @Test  (priority = -2)//submit işlemi
    public void tc2_submit () throws FileNotFoundException, AWTException {
        WebElement submit=locate.submitButton;
        ReusableMethods.scroll(submit);
        ReusableMethods.bekle(1);
        Assert.assertTrue(submit.isDisplayed());
        submit.click();
    }
    @Test (priority = -1)
    public void tc2_successfullyPublished() {

        ReusableMethods.scrollHome();
        Assert.assertTrue(locate.publishedText.isDisplayed());

        //  JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        //  WebElement  basariMesaji= (WebElement)js.executeScript("return document.querySelector(\"#wcfm_products_manage_js-js-extra\")");
        //  System.out.println("locate.lanetText.getText() = " + basariMesaji.getText());
        //  Assert.assertTrue(basariMesaji.isDisplayed());

    }



}
