package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LocaterAyse;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import java.util.List;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.*;

public class US15_Ayse3 extends ReportMethods {
    LocaterAyse locaterAyse = new LocaterAyse();
    US15_Ayse1 tc01 = new US15_Ayse1();

    @Test
    public void tc_03() {
        extentTest = extentReports.createTest("Hubcomfy", "Shipping Bolumu");

        tc01.start();

        //	Kullanici shipping menusunu tiklar
        click(locaterAyse.shipping);
        extentTest.info("Shipping menusune gecildi");
        //	Kullanici weight bolumune veri girer
        locaterAyse.weight.sendKeys(ConfigReader.getProperty("weight"));
        extentTest.info("Weight bolumune veri girildi");
        bekle(2);
        assertEquals(locaterAyse.weight.getAttribute("value"), ConfigReader.getProperty("weight"));
        extentTest.pass("Verinin varligi kontrol edildi");
        bekle(2);
        //	Kullanici Dimensions Length bolumune veri girer
        locaterAyse.dimensionsLength.sendKeys(ConfigReader.getProperty("length"));
        extentTest.info("Length bolumune veri girildi");
        bekle(2);
        assertEquals(locaterAyse.dimensionsLength.getAttribute("value"), ConfigReader.getProperty("length"));
        extentTest.pass("Verinin varligi kontrol edildi");
        bekle(2);
        //	Kullanici Dimensions Width bolumune veri girer
        locaterAyse.dimensionsWidth.sendKeys(ConfigReader.getProperty("width"));
        extentTest.info("Width bolumune veri girildi");
        bekle(2);
        assertEquals(locaterAyse.dimensionsWidth.getAttribute("value"), ConfigReader.getProperty("width"));
        extentTest.pass("Verinin varligi kontrol edildi");
        bekle(2);
        //	Kullanici Dimensions Height bolumune veri girer
        locaterAyse.dimensionsHeight.sendKeys(ConfigReader.getProperty("height"));
        extentTest.info("Height bolumune veri girildi");
        bekle(2);
        assertEquals(locaterAyse.dimensionsHeight.getAttribute("value"), ConfigReader.getProperty("height"));
        extentTest.pass("Verinin varligi kontrol edildi");
        //	Kullanici Shipping class dropdowna basar
        click(locaterAyse.shippingClassDdm);
        extentTest.info("Shipping dropdown'una tiklandi");
        Select select = new Select(locaterAyse.shippingClassDdm);
        List<WebElement> ddm = select.getOptions();
        int size = ddm.size();
        //	Kullanici Shipping class dropdowda yeni secenekler gorur
        if (size > 1) {
            System.out.println("secenekler sunlardir:");
            ddm.forEach(t -> System.out.println(t.getText()));
            extentTest.pass("Dropdown'da degisik secenekler kontrol edildi");
        } else {

            extentTest.info("Dropdown'da secenek yoktur");
        }
        for (WebElement w : ddm) {
            assertTrue(w.isEnabled());
        }


        //	Kullanici Processing Time'da Ready to ship in.. Dropdown'a basar
        locaterAyse.processingTimeDdm.click();
        extentTest.info("Processing time dropdown'ina basildi");
        select = new Select(locaterAyse.processingTimeDdm);
        List<WebElement> ddmMenu = select.getOptions();
        //	Kullanici Processing Time'da Ready to ship in.. Dropdown'da secenekler gorur
        int numOfDdm = ddmMenu.size();
        if (numOfDdm > 1) {
            System.out.println("icindeki secenekler sunlardir:");
            ddmMenu.forEach(t -> System.out.println(t.getText()));
            extentTest.pass("Dropdown'da secenekler vardir");
        } else {
            extentTest.info("Ddm menude secenek yoktur");
        }

        //	Kullanici Processing Time'da Ready to ship in.. Dropdown'da seceneklerini kontrol eder
        for (WebElement w : ddmMenu) {
            assertTrue(w.isDisplayed());
        }
        extentTest.pass("Ddm deki secenekler tiklanabilir");
        Driver.closeDriver();
        extentTest.pass("Driver kapatildi");
    }
}
