package test.ac01;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import static org.testng.AssertJUnit.assertTrue;


public class AC01 extends ReportMethods {

    LocaterOguzhan locaterOguzhan;
    public  void   start() {
        locaterOguzhan = new LocaterOguzhan();
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        extentTest.info("https://hubcomfy.com/ sitesine gidildi");
        //register buttonuna tiklar
        locaterOguzhan.register.click();
        extentTest.info("Register sayfasina gecildi");
        //Become a vendor secenegini tiklar
        locaterOguzhan.becomeAVendor.click();
        extentTest.info("Vendor olmak icin vendor kayit olma bolumune gidildi");
    }


    @Test
    public void test1() {

        extentTest = extentReports.createTest("Hubcomfy", "Vendor olma");
        //Sign Up ekranından "Become a Vendor" linki ile giriş yapılabilmeli
       locaterOguzhan = new LocaterOguzhan();
        //Vendor siteye gider
        start() ;
        assertTrue(locaterOguzhan.vendorRegistration.isDisplayed());
        extentTest.pass("Vendor kayit sayfasinda oldugumuz kontrol edildi");
        extentTest.pass("Driver kapatildi");


    }

}
