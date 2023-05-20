package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LocaterAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

public class US20_Ali_CouponNegative extends ReusableMethods {


    @DataProvider
    public static Object[][] test01() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/coupons.xlsx", "Sayfa1");
        return excelUtils.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "test01")
    public void testaddNewCoupons(String code, String desc, String amaount, String date) {
        LocaterAli locaterAli = new LocaterAli();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        locaterAli.signInButton.click();
        locaterAli.userNameTexti.sendKeys(ConfigReader.getProperty("userNameV"),
                Keys.TAB, ConfigReader.getProperty("passwordV"), Keys.ENTER);
        Assert.assertTrue(locaterAli.signInButton.isDisplayed());
        locaterAli.signOut.click();
        locaterAli.storeManager.click();
        Assert.assertTrue(locaterAli.couponsButton.isDisplayed());
        click(locaterAli.couponsButton);
        click(locaterAli.addNewButton);
        locaterAli.codeTexti.sendKeys(code, Keys.TAB, desc);
        locaterAli.coupon_amounTexti.clear();
        locaterAli.coupon_amounTexti.sendKeys(amaount);
        locaterAli.expiry_dateTexti.sendKeys(date, Keys.ESCAPE);
        Select select = new Select(locaterAli.discount_typeDDM);
        select.selectByIndex(1);
        click(locaterAli.free_shippingRadioButton);
        click(locaterAli.show_on_storeRadioButton);
        click(locaterAli.submitButton);
        click(locaterAli.signOut);
        click(locaterAli.storeManager);
        click(locaterAli.couponsButton);
        scroll(locaterAli.refundButton);
        tumSayfaResmi("hatali kuponlar");
        webElementResmi(locaterAli.coupons);
        bekle(3);
        Driver.closeDriver();
    }
}
