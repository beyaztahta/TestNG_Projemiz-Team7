package test;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US07_Ali {
    LocaterAli locaterAli = new LocaterAli();
    @Test
    public void testCompare() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        locaterAli.signInButton.click();
        locaterAli.userNameTexti.sendKeys(ConfigReader.getProperty("userNameC"),
                Keys.TAB, ConfigReader.getProperty("passwordC"), Keys.ENTER);
        Assert.assertTrue(locaterAli.signInButton.isDisplayed());
        ReusableMethods.click(locaterAli.newArrivals);
        Driver.getDriver().getTitle().contains("New Arrivals");
        for (int i = 0; i <5; i++) {
            ReusableMethods.click(locaterAli.compareButton);
        }
        Assert.assertTrue(locaterAli.compareList.getText().contains("4 Products"));
    }

    @Test(dependsOnMethods = "testCompare")
    public void testUrunleriSilebilmeli() {

        for (int i = 1; i <= 4; i++) {
            ReusableMethods.click(locaterAli.clear);
            ReusableMethods.bekle(3);
        }
        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi("Silinemeyen Urun");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(locaterAli.compareList.getText().contains("0 Products"));
    }
    @Test(dependsOnMethods = "testCompare")
    public void testUrunlerininTamaminiSilebilmeli() {
        ReusableMethods.click(locaterAli.clearAll);
        ReusableMethods.bekle(3);
        Assert.assertTrue(locaterAli.compareList.getText().contains("0 Products"));

    }
    @Test(dependsOnMethods = "testCompare",priority = 4)
    public void testUrunleriKarsilastirabilmeli() {
        for (int i = 0; i <4; i++) {
            ReusableMethods.click(locaterAli.compareButton);
        }
        ReusableMethods.click(locaterAli.startCompare);
        ReusableMethods.tumSayfaResmi("Compare Page");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Compare"));
        for (int i = 0; i <= 18; i++) {
            Assert.assertTrue(locaterAli.compareProducts.isDisplayed());
        }
    }
}
