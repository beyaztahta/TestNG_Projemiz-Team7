package test.ali_US20_US18_US07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

public class US20_Coupons_NegativeTest {


    @DataProvider
    public static Object[][] test01() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/coupons.xlsx","Sayfa1");
        return excelUtils.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "test01")
    public void testaddNewCoupons(String code,String desc,String amaount,String date) {
        LocaterAli locaterAli = new LocaterAli();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        locaterAli.signInButton.click();
        locaterAli.userNameTexti.sendKeys(ConfigReader.getProperty("userNameV"),
                Keys.TAB, ConfigReader.getProperty("passwordV"), Keys.ENTER);
        Assert.assertTrue(locaterAli.signInButton.isDisplayed());

        locaterAli.signOut.click();

        locaterAli.storeManager.click();
        Assert.assertTrue(locaterAli.couponsButton.isDisplayed());
        ReusableMethods.click(locaterAli.couponsButton);
        ReusableMethods.click(locaterAli.addNewButton);

        //Code yazabilmeliyim & Description yazılabilmeli
        locaterAli.codeTexti.sendKeys(code,Keys.TAB,desc);

        //Coupon Amount yazılabilmeli
        locaterAli.coupon_amounTexti.clear();
        locaterAli.coupon_amounTexti.sendKeys(amaount);

        //Coupon expiry date girilebilmeli
        locaterAli.expiry_dateTexti.sendKeys(date,Keys.ESCAPE);

        //Discount Type; Percentage discount veya Fixed Product Discount olarak seçilebilmeli
        Select select = new Select(locaterAli.discount_typeDDM);
        select.selectByIndex(1);
        ReusableMethods.click(locaterAli.free_shippingRadioButton);
        ReusableMethods.click(locaterAli.show_on_storeRadioButton);
        ReusableMethods.click(locaterAli.submitButton);

        ReusableMethods.click(locaterAli.couponsButton);
       ReusableMethods.webElementResmi(locaterAli.coupons);
       ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}
