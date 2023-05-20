package test;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.LocaterAyse;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;


import static org.testng.AssertJUnit.assertTrue;
import static utilities.ReusableMethods.*;

public class US15_Ayse1 extends ReportMethods {

    LocaterAyse locaterAyse = new LocaterAyse();
public void start(){

    //kullanici web sitesine gider
    Driver.getDriver().get(ConfigReader.getProperty("url"));
    extentTest.info("https://hubcomfy.com/ adresine gidildi");
    //signin tusuna basar
    locaterAyse.signIn.click();
    extentTest.info("Sign in buttonuna basildi");
    //kullanici mail adresini girer, passwordunu girer ve sign in buttonuna tiklar
    locaterAyse.email.sendKeys(ConfigReader.getProperty("ayse"), Keys.TAB, ConfigReader.getProperty("passAyse"), Keys.ENTER);
    extentTest.info("Mail ve sifre ile giris  yapildi");
    bekle(5);
    //kullanici sayfanin en altina gider
    scrollEnd();
    extentTest.info("Sayfanin altina gidildi");
    bekle(2);
    //kullanici my account linkine tiklar
    locaterAyse.myAccount.click();
    extentTest.info("My account'a tiklandi");

    //kullanici sol kisimdaki Store Manager'a tiklar
    locaterAyse.storeManager.click();
    extentTest.info("Store Manager bolumune gecildi");
    //Kullanci sol bolumdeki Products buttonuna gider
    Actions actions = new Actions(Driver.getDriver());
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    hover(locaterAyse.products);
    extentTest.info("Products'in uzerine gelindi");
    bekle(1);
    //Kullanici Add New Linkine tiklar
    click(locaterAyse.addNew);
    extentTest.info("Add new'a tiklandi");

    //Kullanici sayfayi biraz alta indirir
    extentTest.info("Sayfa asagi indirildi");
    actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
}
    @Test
    public void test01() {

        extentTest = extentReports.createTest("Hubcomfy", "Menulerin varliklari kontrol edildi");
       start();

        //Kullanici Inventory kutucugunu gorur
        assertTrue(locaterAyse.inventory.isDisplayed());
        extentTest.pass("Inventory menusunun varligi kontrol edildi");
        //Kullanici Shipping kutucugunu gorur
        assertTrue(locaterAyse.shipping.isDisplayed());
        extentTest.pass("Shipping menusunun varligi kontrol edildi");
        //kullanici Attributes kutucugunu gorur
        assertTrue(locaterAyse.attributes.isDisplayed());
        extentTest.pass(" Atributes menusunun varligi kontrol edildi");
        //kullanici Linked kutucugunu gorur
        assertTrue(locaterAyse.linked.isDisplayed());
        extentTest.pass("Linked menusunun varligi kontrol edildi");
        //kullanici SEO kutucugunu gorur
        assertTrue(locaterAyse.seo.isDisplayed());
        extentTest.pass("Seo menusunun varligi kontrol edildi");
        //kullanici toptan Urun Gosterme ayarlari kutucugunu gorur
        assertTrue(locaterAyse.toptanUrun.isDisplayed());
        extentTest.pass("Toptan urun menusunun varligi kontrol edildi");
        //kullanici Advanced munusunu gorur

        assertTrue(locaterAyse.advanced.isDisplayed());
        extentTest.pass("Advanced menusunun varligi kontrol edildi");


    }
}

