package test;

import org.testng.annotations.Test;
import pages.LocaterAyse;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import static org.testng.AssertJUnit.assertTrue;


public class US09_Ayse1 extends ReportMethods {

    LocaterAyse locaterAyse;
    public  void   start() {
        locaterAyse = new LocaterAyse();
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        extentTest.info("https://hubcomfy.com/ sitesine gidildi");
        //register buttonuna tiklar
        locaterAyse.register.click();
        extentTest.info("Register sayfasina gecildi");
        //Become a vendor secenegini tiklar
        locaterAyse.becomeAVendor.click();
        extentTest.info("Vendor olmak icin vendor kayit olma bolumune gidildi");
    }


    @Test
    public void test1() {

        extentTest = extentReports.createTest("Hubcomfy", "Vendor olma");
        //Sign Up ekranından "Become a Vendor" linki ile giriş yapılabilmeli
       locaterAyse = new LocaterAyse();
        //Vendor siteye gider
        start() ;
        assertTrue(locaterAyse.vendorRegistration.isDisplayed());
        extentTest.pass("Vendor kayit sayfasinda oldugumuz kontrol edildi");
        extentTest.pass("Driver kapatildi");


    }

}
