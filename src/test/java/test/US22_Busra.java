package test;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocatorBusra;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US22_Busra {

    LocatorBusra locatorBusra;

    @Test
    public void testWithCouponShoppingVendor() {
        locatorBusra = new LocatorBusra();

        Driver.getDriver().get(ConfigReader.getProperty("hubcomUrl"));
        locatorBusra.signIn.click();
        locatorBusra.userNameBox.sendKeys("avcibusranur00@gmail.com");
        ReusableMethods.bekle(2);
        locatorBusra.passwordBox.sendKeys("vendor123");
        locatorBusra.signInButton.submit();

        ReusableMethods.bekle(10);
        locatorBusra.searchBox.sendKeys("NIKE BAG", Keys.ENTER);
        ReusableMethods.bekle(5);
        locatorBusra.addCartButton.click();
        ReusableMethods.bekle(5);
        locatorBusra.cartIcon.click();
        locatorBusra.checkOutButton.click();
        ReusableMethods.bekle(5);

        Assert.assertTrue(locatorBusra.reviewOrderButton.isDisplayed());

        locatorBusra.enterYourCoupon.click();
        locatorBusra.couponCodeBox.sendKeys("nike20");
        locatorBusra.couponApplyButton.submit();
        ReusableMethods.bekle(2);


        locatorBusra.firstnameBox.sendKeys("Mary",Keys.TAB,"Jane",Keys.TAB,Keys.TAB,Keys.TAB,"Hollywood Blv." ,Keys.TAB,"Celebrity St.",Keys.TAB,
                Keys.TAB,"NY",Keys.TAB,Keys.TAB,"12345",Keys.TAB,"123456789");

        ReusableMethods.bekle(5);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        locatorBusra.placeOrderButton.submit();
        ReusableMethods.bekle(5);

        Assert.assertTrue(locatorBusra.successfulText.isDisplayed(), "Successful!");

        ReusableMethods.extentReport();

        Driver.closeDriver();

    }

}
