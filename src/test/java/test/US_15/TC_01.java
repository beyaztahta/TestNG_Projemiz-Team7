package test.US_15;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;


import static org.testng.AssertJUnit.assertTrue;
import static utilities.ReusableMethods.*;

public class TC_01 {
    public TC_01() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @Test
    public void test01() {

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
        bekle(1);
        //Kullanici Add New Linkine tiklar
        click(locaterAyse.addNew);

        //Kullanici sayfayi en alta indirir

        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        //Kullanici Inventory kutucugunu gorur
        assertTrue(locaterAyse.inventory.isDisplayed());
        //Kullanici Shipping kutucugunu gorur
        assertTrue(locaterAyse.shipping.isDisplayed());
        //kullanici Attributes kutucugunu gorur
        assertTrue(locaterAyse.attributes.isDisplayed());
        //kullanici Linked kutucugunu gorur
        assertTrue(locaterAyse.linked.isDisplayed());
        //kullanici SEO kutucugunu gorur
        assertTrue(locaterAyse.seo.isDisplayed());
        //kullanici toptan Urun Gosterme ayarlari kutucugunu gorur
        assertTrue(locaterAyse.toptanUrun.isDisplayed());
        //kullanici Advanced munusunu gorur

        assertTrue(locaterAyse.advanced.isDisplayed());


    }
}

