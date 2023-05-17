package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterMali;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US16_testSet1 {
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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        locate.checkboxVirtual.click();
        Assert.assertTrue(locate.checkboxVirtual.isSelected());
        ReusableMethods.bekle(1);
        locate.checkboxDownloadable.click();
        Assert.assertTrue(locate.checkboxDownloadable.isSelected());

    }

    @Test (priority = -2)
    public void us16_tc03() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Store Manager"));

        locate.priceBox.sendKeys("100");
        System.out.println(locate.priceBox.getText());
        //Assert.assertTrue(locate.priceBox.getText().equals(100));
        locate.priceBox.clear();

        locate.priceBox.sendKeys("100.50");
        //Assert.assertTrue(locate.priceBox.getText().equals(100.50));
        locate.priceBox.clear();

        locate.priceBox.sendKeys("ucuz");
        Assert.assertFalse(locate.priceBox.getText().equals("ucuz"));
        locate.priceBox.clear();

        locate.priceBox.sendKeys("-100");
        Assert.assertFalse(locate.priceBox.getText().equals(-100));
        locate.priceBox.clear();

        locate.salePriceBox.sendKeys("100");
        System.out.println(locate.salePriceBox.getText());
        //Assert.assertTrue(locate.salePriceBox.getText().equals(100));
        locate.salePriceBox.clear();

        locate.salePriceBox.sendKeys("100.50");
        //Assert.assertTrue(locate.salePriceBox.getText().equals(100.50));
        locate.salePriceBox.clear();

        locate.salePriceBox.sendKeys("ucuz");
        Assert.assertFalse(locate.salePriceBox.getText().equals("ucuz"));
        locate.salePriceBox.clear();

        locate.salePriceBox.sendKeys("-100");
        Assert.assertFalse(locate.salePriceBox.getText().equals(-100));
        locate.salePriceBox.clear();

    }
}
