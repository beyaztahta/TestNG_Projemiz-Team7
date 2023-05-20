package test.US_15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.*;
import static utilities.ReusableMethods.scrollEnd;

public class TC_03 {
    @Test
    public void tc_03() {


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

        //	Kullanici shipping menusunu tiklar
        click(locaterAyse.shipping);
        //	Kullanici weight bolumune veri girer
        locaterAyse.weight.sendKeys(ConfigReader.getProperty("weight"));
        assertEquals(locaterAyse.weight.getAttribute("value"), ConfigReader.getProperty("weight"));
        bekle(2);
        //	Kullanici Dimensions Length bolumune veri girer
        locaterAyse.dimensionsLength.sendKeys(ConfigReader.getProperty("length"));
        assertEquals(locaterAyse.dimensionsLength.getAttribute("value"), ConfigReader.getProperty("length"));
        bekle(2);
        //	Kullanici Dimensions Width bolumune veri girer
        locaterAyse.dimensionsWidth.sendKeys(ConfigReader.getProperty("width"));
        assertEquals(locaterAyse.dimensionsWidth.getAttribute("value"), ConfigReader.getProperty("width"));
        bekle(2);
        //	Kullanici Dimensions Height bolumune veri girer
        locaterAyse.dimensionsHeight.sendKeys(ConfigReader.getProperty("height"));
        assertEquals(locaterAyse.dimensionsHeight.getAttribute("value"), ConfigReader.getProperty("height"));
        //	Kullanici Shipping class dropdowna basar
        locaterAyse.shippingClassDdm.click();
        Select select = new Select(locaterAyse.shippingClassDdm);
        List<WebElement> ddm = select.getOptions();
        int size = ddm.size();
        //	Kullanici Shipping class dropdowda yeni secenekler gorur
        if (size > 1) {
            System.out.println("secenekler sunlardir:");
            ddm.forEach(t -> System.out.println(t.getText()));
        } else {
            System.out.println("herhangi bir secenek bulunmamaktadir");
        }
        for (WebElement w : ddm) {
            assertTrue(w.isEnabled());
        }

        //	Kullanici Processing Time'da Ready to ship in.. Dropdown'a basar
        locaterAyse.processingTimeDdm.click();
        select = new Select(locaterAyse.processingTimeDdm);
        List<WebElement> ddmMenu = select.getOptions();
        //	Kullanici Processing Time'da Ready to ship in.. Dropdown'da secenekler gorur
        int numOfDdm = ddmMenu.size();
        if (numOfDdm > 1) {
            System.out.println("icindeki secenekler sunlardir:");
            ddmMenu.forEach(t -> System.out.println(t.getText()));
        } else {
            System.out.println("herhangi bir secenek yoktur");
        }

        //	Kullanici Processing Time'da Ready to ship in.. Dropdown'da secenekler tiklar
        for (WebElement w : ddmMenu) {
            assertTrue(w.isDisplayed());
        }
        Driver.closeDriver();
    }
}
