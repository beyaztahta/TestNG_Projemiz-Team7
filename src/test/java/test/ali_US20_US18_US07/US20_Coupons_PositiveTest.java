package test.ali_US20_US18_US07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US20_Coupons_PositiveTest extends ReusableMethods {


    @Test
    public void testaddNewCoupons() {
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
        locaterAli.codeTexti.sendKeys("ABC1234", Keys.TAB, "Indirim Kuponu");
        Select select = new Select(locaterAli.discount_typeDDM);
        select.selectByIndex(1);
        locaterAli.coupon_amounTexti.clear();
        locaterAli.coupon_amounTexti.sendKeys("5");
        locaterAli.expiry_dateTexti.sendKeys("2023-05-17", Keys.ESCAPE);
        click(locaterAli.free_shippingRadioButton);
        click(locaterAli.show_on_storeRadioButton);
        click(locaterAli.submitButton);
        Assert.assertEquals(locaterAli.verifyMessage.getText(), "Coupon Successfully Published.");

    }


}
