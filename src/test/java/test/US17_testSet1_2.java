package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LocaterMali;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.KeyEvent;

public class US17_testSet1_2 {
    LocaterMali locate=new LocaterMali();
    Actions actions;
    Select select;

    //Store Menager sayfası görüntülenir

    @Test(priority = -10) //giriş
    public void tc3_sıgnIn() {

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
    public void tc3_addNew() {
        actions=new Actions(Driver.getDriver());
        actions.moveToElement(locate.productButton).perform();
        ReusableMethods.bekle(1);
        locate.addNewButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(locate.manageProductText.isDisplayed());

    }

    @Test (priority = -8)
    public void tc3_ddmVeriable() {
        select=new Select(locate.ddMunuSimpleVariable);
        select.selectByIndex(1);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Variable"));
        ReusableMethods.bekle(1);
    }
    @Test (priority = -7)
    public void tc3_attrabute() {

        ReusableMethods.scroll(locate.attributesButton);
        Assert.assertTrue(locate.attributesButton.isDisplayed());
        ReusableMethods.bekle(1);
        locate.attributesButton.click();

    }

    @Test (priority = -6)
    public void tc3_colorSize() {
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(locate.catalogVisibility);
        ReusableMethods.bekle(1);
        locate.colorCheckBox.click();
        ReusableMethods.bekle(1);
        //color send keys ile size ise DDM menüden seçilerek yapıyorum
        locate.colorInputBox.sendKeys("Black");
        actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.bekle(2);
        locate.sizeCheckBox.click();
        ReusableMethods.bekle(1);
        select=new Select(locate.sizeInputDDM);
        select.selectByValue("44");
        System.out.println("locate.sizeText.getText() = " + locate.sizeText.getText());
        Assert.assertTrue(locate.sizeText.getText().contains("Large"));

    }
    @Test (priority = -5)
    public void tc4_addColorSize() throws AWTException {
        ReusableMethods.bekle(1);
        locate.addNewColorButton.click();
        ReusableMethods.bekle(3);
        //arada olması gereken kodlar aşağıda
        ReusableMethods.alertAccept();


       // Bu alanlardaki kodlar başka bilgisayarda çalışıyor ancak şuan burada çalışmadığı için yoruma alındı

        /*


         alert prompt metodu sendKeys ile


        ReusableMethods.alertprompt("Rengarenk");
        ReusableMethods.alertAccept();

        Alert alert=Driver.getDriver().switchTo().alert();

        locate.addNewColorButton.click();
        ReusableMethods.bekle(3);
        alert.sendKeys("9999999");
        ReusableMethods.alertAccept();

        locate.addNewColorButton.click();
        ReusableMethods.bekle(3);
        alert.sendKeys("sarımtıraksarımtıraksarımtıraksarımtıraksarımtıraksarımtıraksarımtıraksarımtıraksarımtıraksarımtırak");
        ReusableMethods.alertAccept();

        locate.addNewSizeButton.click();
        ReusableMethods.bekle(3);
        alert.sendKeys("serçe");
        ReusableMethods.alertAccept();

        locate.addNewSizeButton.click();
        ReusableMethods.bekle(3);
        alert.sendKeys("27x27");
        ReusableMethods.alertAccept();

        locate.addNewSizeButton.click();
        ReusableMethods.bekle(3);
        alert.sendKeys("12345*987612345*987612345*987612345*987612345*987612345*987612345*987612345*987612345*987612345*9876");
        ReusableMethods.alertAccept();

        //Robot class ile
        String text="Rengarenk";
        Alert alert=Driver.getDriver().switchTo().alert();

        Robot robot = new Robot();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        */

    }



}
