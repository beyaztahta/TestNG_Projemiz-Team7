package test.US_15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterAyse;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.AssertJUnit.assertEquals;
import static utilities.ReusableMethods.*;

public class TC_08 {
    @Test
    public void tc_08() {
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

        //Kullanici sayfayi asagiya indirir
        scrollEnd();
        actions.sendKeys(Keys.PAGE_UP, Keys.ARROW_DOWN).perform();
        //Kullanici Advanced menusunu tiklar
        click(locaterAyse.advanced);
        //kullanici enable review checkbox'ina tiklar
        locaterAyse.enableReviews.click();
        //kullanici Menu Oder text area'sina veri girer
        locaterAyse.menuOrder.sendKeys("e12345");
        //kullanici Menu Order text areasina girdigi veriyi gorur
        SoftAssert softAssert= new SoftAssert();
       softAssert.assertEquals(locaterAyse.menuOrder.getAttribute("value"),"e12345");
        //kullanici purchase note textbox'ina veri girer
        locaterAyse.purchaseNote.sendKeys("saglam");
        //Kullanici purchase noter textbox'ina girdigi veriyi gorur
        assertEquals(locaterAyse.purchaseNote.getAttribute("value"),"saglam");
        softAssert.assertAll();
    }
}