package test.tc_ayse;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterAyse;
import utilities.ReportMethods;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.*;

public class TC_07_08 extends ReportMethods {
    LocaterAyse locaterAyse = new LocaterAyse();
    TC_01 tc01 = new TC_01();

    @Test
    public void tc_07() {
        extentTest = extentReports.createTest("Hubcomfy", "Toptan Urun Gosterme Ayarlari");
        tc01.start();
        LocaterAyse locaterAyse = new LocaterAyse();
         //kullanici Toptan Urun Gosterme Ayarlarini tiklar
        click(locaterAyse.toptanUrun);
        extentTest.info("Toptan Urun Gosterme Ayarlari menusune girildi");
        //Kullanici Piece Type dropdown menuyu tiklar
        locaterAyse.pieceTypeDdm.click();
        extentTest.info("Dropdown'a basildi");
        //Kullanici ddm deki piece secenegini tiklar
        Select select = new Select(locaterAyse.pieceTypeDdm);
        select.selectByVisibleText("Piece");

        bekle(2);
        assertEquals(select.getFirstSelectedOption().getText(), locaterAyse.pieceTypeDdm.getAttribute("value"));
        extentTest.pass("Secilen secenegin gorundugu kontrol edilir");
        //Kullanici ddm deki carton secenegini tiklar
        select.selectByVisibleText("Carton");
        extentTest.info("Carton secilir");
        bekle(2);
        assertEquals(select.getFirstSelectedOption().getText(), "Carton");
        extentTest.pass("Secilen secenegin gorundugu kontrol edilir");
        //Kullanici ddm deki kg secenegini tiklar
        select.selectByVisibleText("Kg");
        extentTest.info("Kg secilir");
        bekle(2);
        assertEquals(select.getFirstSelectedOption().getText(), "Kg");
        extentTest.pass("Secilen secenegin gorundugu kontrol edilir");
        //Kullanici units per piece kutucuguna deger girer
        locaterAyse.unitsPerPiece.clear();
        locaterAyse.unitsPerPiece.sendKeys("12");
        extentTest.info("Unit per piede bolumune veri girildi");
        bekle(2);
        //Kullanici girdigi degeri gorur
        assertEquals(locaterAyse.unitsPerPiece.getAttribute("value"), "12");
        extentTest.pass("Secilen secenegin gorundugu kontrol edilir");
        //kullanici min order quantity bolumune deger girer
        locaterAyse.minOrderQuantity.clear();
        locaterAyse.minOrderQuantity.sendKeys("12");
        extentTest.info("Min Order Quantity bolumune veri girildi");
        bekle(2);
        //kullanici girdigi degeri gorur
        assertEquals(locaterAyse.minOrderQuantity.getAttribute("value"), "12");
        extentTest.pass("Driver kapatildi");

    }
    @Test
    public void tc_08() {
        extentTest = extentReports.createTest("Hubcomfy", "Advanced Bolumu");

        //Kullanici Advanced menusunu tiklar
        click(locaterAyse.advanced);
        bekle(2);
        extentTest.info("Advanced menusu tiklandi");
        //kullanici enable review checkbox'ina tiklar
        locaterAyse.enableReviews.click();
        extentTest.info("Enable reviews tiklandi");
        //kullanici Menu Oder text area'sina veri girer
        locaterAyse.menuOrder.sendKeys("e12345");
        extentTest.info("Menu Order'a veri girildi");
        bekle(2);
        //kullanici Menu Order text areasina girdigi veriyi gorur
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locaterAyse.menuOrder.getAttribute("value"), "e12345");
        extentTest.pass("Girilen degerin varligi kontrol edildi");
        //kullanici purchase note textbox'ina veri girer
        locaterAyse.purchaseNote.sendKeys("saglam");
        bekle(2);
        extentTest.info("Purchace Note bolumune veri girildi");
        //Kullanici purchase noter textbox'ina girdigi veriyi gorur
        assertEquals(locaterAyse.purchaseNote.getAttribute("value"), "saglam");
        extentTest.pass("Girilen degerin varligi kontrol edildi");
        softAssert.assertAll();
        extentTest.pass("Driver kapatildi");
    }
}