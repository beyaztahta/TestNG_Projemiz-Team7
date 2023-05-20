package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterAyse;
import utilities.ReportMethods;

import static org.testng.AssertJUnit.assertEquals;
import static utilities.ReusableMethods.*;

public class US15_Ayse5_6 extends ReportMethods {
    LocaterAyse locaterAyse = new LocaterAyse();
    US15_Ayse1 tc01 = new US15_Ayse1();

    @Test
    public void tc_05() {
        extentTest = extentReports.createTest("Hubcomfy", "Linked'e veri girildi");
        tc01.start();

        //Kullanici Linked menusune tiklar
        click(locaterAyse.linked);
        extentTest.info("Linked'e basildi");
        //kullanici up-sells kutucuguna veri girer
        locaterAyse.linkedUpSells.sendKeys("saglam");
        extentTest.info("Upsell bolumune yazi gonderildi");
        //kullanici up-sells kutucuguna girdigi veriyi gorur
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locaterAyse.linkedUpSells.getAttribute("value"), "saglam");
        bekle(2);
        extentTest.pass("Girilen veri kontrol edildi");
        //kullanici cross-sells kutucuguna veri girer
        locaterAyse.linkedCrossSells.sendKeys("dayanikli");
        extentTest.info("Linked cross sell bolumune veri girildi");
        bekle(2);
        //kullanici cross-sells kutucuguna girdigi veriyi gorur
        softAssert.assertEquals(locaterAyse.linkedCrossSells.getAttribute("value"), "dayanikli");
        extentTest.pass("girilen yazi kontrol edildi");
        extentTest.pass("Driver kapatildi");
        softAssert.assertAll();

    }  @Test
    public void tc_06() {
        extentTest = extentReports.createTest("Hubcomfy", "SEO'ya veri girildi");

        //Kullanici SEO menusunu tiklar
        click(locaterAyse.seo);
        bekle(3);
        extentTest.info("SEO menusune gidildi");
        //Kullanici enter a focus keyword textbox'ina veri girer
        locaterAyse.seoEnterF.sendKeys("sport");
        bekle(2);
        extentTest.info("Focus keyword girildi");
        //Kullanici enter a focus keyword textbox'ina girdigi  veriyi gorur
        assertEquals(locaterAyse.seoEnterF.getAttribute("value"), "sport");
        extentTest.pass("Girilen verinin varligi kontrol edildi");
        //Kullanici meta description textbox'ina veri girer
        locaterAyse.seoMetaDesc.sendKeys("wonderful");
        bekle(2);
        extentTest.info("Meta descriptiona veri girildi");
        //Kullanici meta description textbox'ina girdigi veriyi gorur
        assertEquals(locaterAyse.seoMetaDesc.getAttribute("value"), "wonderful");
        extentTest.pass("Girilen verinin varligi kontrol edildi");
        extentTest.pass("Driver kapatildi");
    }
}
