package test.ali_US20_US18_US07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US18_AddProduct_Test {
    @Test
    public void addProduct() {
        LocaterAli locaterAli = new LocaterAli();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        locaterAli.signInButton.click();
        locaterAli.userNameTexti.sendKeys(ConfigReader.getProperty("userNameV"),
                Keys.TAB, ConfigReader.getProperty("passwordV"), Keys.ENTER);
        Assert.assertTrue(locaterAli.signInButton.isDisplayed());

        locaterAli.signOut.click();

        locaterAli.storeManager.click();

        ReusableMethods.click(locaterAli.productsButton);

        ReusableMethods.click(locaterAli.addNewProduct);

        Select select = new Select(locaterAli.productDDM);
        select.selectByVisibleText("External/Affiliate Product");

        locaterAli.productUrl.sendKeys(ConfigReader.getProperty("prdouct_Url"),
                Keys.TAB, ConfigReader.getProperty("product_Button"),
                Keys.TAB, ConfigReader.getProperty("prdouct_Price"),
                Keys.TAB, ConfigReader.getProperty("prdouct_SalePrice"),Keys.ENTER);


    }
}
