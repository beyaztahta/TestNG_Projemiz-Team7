package test.US_15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.AssertJUnit.assertEquals;
import static utilities.ReusableMethods.*;

public class TC_06 {
    @Test
    public void tc_06() {
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
        //Kullanici SEO menusunu tiklar
       click(locaterAyse.seo);
        //Kullanici enter a focus keyword textbox'ina veri girer
        locaterAyse.seoEnterF.sendKeys("sport");
        //Kullanici enter a focus keyword textbox'ina girdigi  veriyi gorur
        assertEquals(locaterAyse.seoEnterF.getAttribute("value"), "sport");
        //Kullanici meta description textbox'ina veri girer
        locaterAyse.seoMetaDesc.sendKeys("wonderful");
        //Kullanici meta description textbox'ina girdigi veriyi gorur
        assertEquals(locaterAyse.seoMetaDesc.getAttribute("value"), "wonderful");
    }

}
