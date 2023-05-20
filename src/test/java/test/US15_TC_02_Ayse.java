package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LocaterAyse;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.*;

import java.util.List;

public class US15_TC_02_Ayse {
    @Test
    public void testName() {


        LocaterAyse locaterAyse = new LocaterAyse();
        //kullanici web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //signin tusuna basar
        locaterAyse.signIn.click();
        //kullanici mail adresini girer, passwordunu girer ve sign in buttonuna tiklar
        locaterAyse.email.sendKeys(ConfigReader.getProperty("ayse"), Keys.TAB, ConfigReader.getProperty("passAyse"), Keys.ENTER);
        bekle(5);
        //kullanici sayfanin en altina gider
        scrollEnd();
        bekle(2);
        //kullanici my account linkine tiklar
        locaterAyse.myAccount.click();
        //kullanici sol kisimdaki Store Manager'a tiklar
        locaterAyse.storeManager.click();
        //Kullanci sol bolumdeki Products buttonuna gider
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        hover(locaterAyse.products);
        //Kullanici Add New Linkine tiklar
        click(locaterAyse.addNew);

        //Kullanici sayfayi en alta indirir
        scrollEnd();
        actions.sendKeys(Keys.PAGE_UP).perform();


        //Kullanici Inventory menusunu tiklar
        //locaterAyse.inventory.click();
        //Kullanici SKU'nun yanindaki kutucuga veri girisi yapar
        locaterAyse.skuBox.sendKeys(ConfigReader.getProperty("skuValue"));
        assertEquals(locaterAyse.skuBox.getAttribute("value"), ConfigReader.getProperty("skuValue"));
        //Kullanici Stock Statusun yanindaki kutucukta in stock gorur
        assertTrue(locaterAyse.stockStatus.isDisplayed());
        Select select = new Select(locaterAyse.stockStatus);
        List<WebElement> options = select.getOptions();
        int numOfOptions = options.size();
        if (numOfOptions > 1) {
            System.out.println("Icinde secenek var");
            options.forEach(t -> System.out.println(t.getText()));
        } else {
            System.out.println("icinde secenek yok");
        }
        for (WebElement option : options) {

            assertTrue(option.isEnabled());
        }
        //Kullanici Stock Statusun yanindaki kutucuktaki oku tiklar*************
        assertTrue(locaterAyse.manageStockCheckbox.isEnabled());

        locaterAyse.manageStockCheckbox.click();

        //Kullanici Manage Stock'un yanindaki checkbox a tiklar
        assertTrue(locaterAyse.soldIndividually.isEnabled());
        //Manage Stock'un checkboxini tiklayinca Stock Qty cikar
        assertTrue(locaterAyse.stockQtyBox.isDisplayed());
        //Stock Qty 'e veri gonderilebilmeli
        locaterAyse.stockQtyBox.clear();
        locaterAyse.stockQtyBox.sendKeys(ConfigReader.getProperty("stockQtyBox"));
        assertEquals(locaterAyse.skuBox.getAttribute("value"), ConfigReader.getProperty("skuValue"));
        assertEquals(locaterAyse.stockQtyBox.getAttribute("value"), ConfigReader.getProperty("stockQtyBox"));
        //Manage Stock'un checkboxini tiklayinca Allow Backorders cikar
        select = new Select(locaterAyse.allowBackOrderddm);
        List<WebElement> allowBackorders = select.getOptions();
        int size = allowBackorders.size();
        if (size > 1) {
            System.out.println("icinde secenek var");
            allowBackorders.forEach(t -> System.out.println(t.getText()));
        } else {
            System.out.println("icinde secenek yok");
        }
        //Allow Backorders'in yaninda kutucukta Do not Allow yazisini gormeli
        //Allow Backorders'in yaninda kutucukta Allow, but notify customer yazisini gormeli
        //Allow Backorders'in yaninda kutucukta Allow yazisini gormeli
        for (WebElement option : allowBackorders) {

            assertTrue(option.isEnabled());
        }


        //manage stock checkbox'a tiklayinca stock status  kaybolur
        assertFalse(locaterAyse.stockStatusTitle.isDisplayed());
        //sold individually checkbox'ini tiklar
        locaterAyse.soldIndividually.click();
        assertTrue(locaterAyse.soldIndividually.isSelected());
    }
}