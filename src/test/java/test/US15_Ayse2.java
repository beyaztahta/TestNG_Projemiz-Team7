package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LocaterAyse;
import utilities.*;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.click;

import utilities.ConfigReader;

import java.util.List;

public class US15_Ayse2 extends ReportMethods {
    LocaterAyse locaterAyse = new LocaterAyse();
    US15_Ayse1 tc01 = new US15_Ayse1();

    @Test
    public void tc02() {

        extentTest = extentReports.createTest("Hubcomfy", "Inventory bolumu");
        tc01.start();


        //Kullanici SKU'nun yanindaki kutucuga veri girisi yapar
        locaterAyse.skuBox.sendKeys(ConfigReader.getProperty("skuValue"));
        extentTest.info("SKU kutusuna veri girildi");
        assertEquals(locaterAyse.skuBox.getAttribute("value"), ConfigReader.getProperty("skuValue"));
        extentTest.pass("Kutudaki verinin varligi kontrol edildi");

        //Kullanici Stock Statusun yanindaki kutucukta in stock gorur
        assertTrue(locaterAyse.stockStatus.isDisplayed());
        extentTest.pass("Stokta secenegi kontrol edildi");
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
        extentTest.pass("Seceneklerin varligi kontrol edildi");
        //Kullanici Stock Statusun yanindaki kutucuktaki oku tiklar*************
        assertTrue(locaterAyse.manageStockCheckbox.isEnabled());
        extentTest.pass("Manage Stock checkbox'i kontrol edildi");
        click(locaterAyse.manageStockCheckbox);
      extentTest.pass("Checkbox tiklandi");
        //Kullanici Manage Stock'un yanindaki checkbox a tiklar
        assertTrue(locaterAyse.soldIndividually.isEnabled());
        extentTest.pass("Sold individually checkbox'i kontrol edildi");
        //Manage Stock'un checkboxini tiklayinca Stock Qty cikar
        assertTrue(locaterAyse.stockQtyBox.isDisplayed());
        extentTest.pass("Stock Qty nin varligi kontrol edildi");
        //Stock Qty 'e veri gonderilebilmeli
        locaterAyse.stockQtyBox.clear();
        extentTest.info("StockQty kutusundeki veri silindi");
        locaterAyse.stockQtyBox.sendKeys(ConfigReader.getProperty("stockQtyBox"));
        extentTest.info("StockQty kutusuna yeni veri girildi");
        assertEquals(locaterAyse.stockQtyBox.getAttribute("value"), ConfigReader.getProperty("stockQtyBox"));
        extentTest.pass("Girilen verinin varligi kontrol edildi");


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

        extentTest.pass("Allow Backorders'taki ddm menudekilerin varligi kontrol edildi");
        //manage stock checkbox'a tiklayinca stock status  kaybolur
        assertFalse(locaterAyse.stockStatusTitle.isDisplayed());
        extentTest.pass("Manage Stock'un checkbox'ina tiklayinca Stock statusun kayboldugu kontrol edildi ");
        //sold individually checkbox'ini tiklar
        locaterAyse.soldIndividually.click();
        extentTest.info("Sold individually checkbox'i tiklandi");
        assertTrue(locaterAyse.soldIndividually.isSelected());
        extentTest.pass("Secilen checkbox'in tikli oldugu kontrol edildi");
        extentTest.pass("Driver kapatildi");
    }
}