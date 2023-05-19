package test.ali_US20_US18_US07;

import org.checkerframework.common.initializedfields.qual.EnsuresInitializedFields;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US07_CompareTest {

    @Test
    public void testCompare() {
        LocaterAli locaterAli = new LocaterAli();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        locaterAli.signInButton.click();
        locaterAli.userNameTexti.sendKeys(ConfigReader.getProperty("userNameC"),
                Keys.TAB, ConfigReader.getProperty("passwordC"), Keys.ENTER);
        Assert.assertTrue(locaterAli.signInButton.isDisplayed());

        ReusableMethods.click(locaterAli.newArrivals);
       Driver.getDriver().getTitle().contains("New Arrivals");

        //Kullanıcı en fazla 4 ürünü karşılaştırmak için seçebilmeli
        //7 urun sectirdim ki 4 den fazla urun secmedigini gormek icin
        for (int i = 0; i <7 ; i++) {
            ReusableMethods.click(locaterAli.compareButton);
            Driver.getDriver().navigate().refresh();
        }
        ReusableMethods.click(locaterAli.compareButton);
       Assert.assertTrue(locaterAli.compareList.getText().contains("4 Products"));
        ReusableMethods.tumSayfaResmi();

       //Karşılaştıracağı ürünleri silip yeni ürünleri ekleyebilmeli
        for (int i = 1; i <=4 ; i++) {
            ReusableMethods.click(locaterAli.clear);
        }
       ReusableMethods.bekle(3);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(locaterAli.compareList.getText().contains("0 Products"));

        for (int i = 0; i <7 ; i++) {
            ReusableMethods.click(locaterAli.compareButton);
            Driver.getDriver().navigate().refresh();
        }
        ReusableMethods.click(locaterAli.compareButton);
        ReusableMethods.click(locaterAli.clearAll);
        ReusableMethods.bekle(3);
        Assert.assertTrue(locaterAli.compareList.getText().contains("0 Products"));

        for (int i = 0; i <7 ; i++) {
            ReusableMethods.click(locaterAli.compareButton);
            Driver.getDriver().navigate().refresh();
        }
        ReusableMethods.click(locaterAli.compareButton);
        Assert.assertTrue(locaterAli.compareList.getText().contains("4 Products"));

        //Seçtiği ürünleri karşılaştırabilmeli
        ReusableMethods.click(locaterAli.startCompare);
        ReusableMethods.tumSayfaResmi("Compare Page");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Compare"));
        //Urunler ve karsilastirma bilgileri gorunuyormu?
        for (int i = 0; i <17 ; i++) {
            Assert.assertTrue(locaterAli.compareProducts.isDisplayed());
        }



    }
}
