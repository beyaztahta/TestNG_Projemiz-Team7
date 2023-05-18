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

public class TC_05 {
    @Test
    public void tc_05() {
        LocaterAyse locaterAyse= new LocaterAyse();
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
        //Kullanici Linked menusune tiklar
      click( locaterAyse.linked);
        //kullanici up-sells kutucuguna veri girer
        locaterAyse.linkedUpSells.sendKeys("saglam");
        //kullanici up-sells kutucuguna girdigi veriyi gorur
        SoftAssert softAssert= new SoftAssert();
       softAssert.assertEquals(locaterAyse.linkedUpSells.getAttribute("value"),"saglam");
        //kullanici cross-sells kutucuguna veri girer
        locaterAyse.linkedCrossSells.sendKeys("dayanikli");
        //kullanici cross-sells kutucuguna girdigi veriyi gorur
      softAssert.assertEquals(locaterAyse.linkedCrossSells.getAttribute("value"),"dayanikli");

      softAssert.assertAll();

    }
}
