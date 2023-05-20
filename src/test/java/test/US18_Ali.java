package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterAli;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

public class US18_Ali extends ReusableMethods {
    LocaterAli locaterAli = new LocaterAli();
    ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/Description e-tablo.xlsx","Sayfa2");
    Select select;
    Actions actions;


    @Test
    public void addProduct() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        locaterAli.signInButton.click();//
        locaterAli.userNameTexti.sendKeys(ConfigReader.getProperty("userNameV"),
                Keys.TAB, ConfigReader.getProperty("passwordV"), Keys.ENTER);
        Assert.assertTrue(locaterAli.signInButton.isDisplayed());
        locaterAli.signOut.click();
        locaterAli.storeManager.click();
        click(locaterAli.productsButton);
        click(locaterAli.addNewProduct);

    }
    @Test(dependsOnMethods = "addProduct")
    public void addProduct01() {
        Select select = new Select(locaterAli.productDDM);
        select.selectByVisibleText("External/Affiliate Product");

        locaterAli.productTitle.sendKeys(ConfigReader.getProperty("urun_Adi"),
                Keys.TAB,ConfigReader.getProperty("prdouct_Url"),
                Keys.TAB, ConfigReader.getProperty("product_Button"),
                Keys.TAB, ConfigReader.getProperty("prdouct_Price"),
                Keys.TAB, ConfigReader.getProperty("prdouct_SalePrice"));
    }


    @Test(dependsOnMethods = "addProduct")
    public void addProduct02() {


        click(locaterAli.productImg);
        click(locaterAli.productImgMedia);
        bekle(5);
        click(locaterAli.productDambil);
        click(locaterAli.productImgSelect);
        bekle(1);
        click(locaterAli.productLittleImg);
        click(locaterAli.productImgMedia);
        click(locaterAli.productLittleDambil);
        click(locaterAli.productImgGalery);

    }
    @Test(dependsOnMethods = "addProduct")
    public void addProduct03() {
        Driver.getDriver().switchTo().frame(locaterAli.productShortIframe);
        locaterAli.productShortDesc.sendKeys(excelUtils.getCellData(1,1));
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(locaterAli.productDescIframe);
        locaterAli.productShortDesc.sendKeys(excelUtils.getCellData(2,1));
        Driver.getDriver().switchTo().defaultContent();

    }
    @Test(dependsOnMethods = "addProduct")
    public void addProduct04() {
        click(locaterAli.productSportsButton);
        click(locaterAli.productAmazonBasicsButton);
        locaterAli.productTags.sendKeys(excelUtils.getCellData(3,1));
        select=new Select(locaterAli.productCatalogDDM);
        select.selectByIndex(3);

    }
    @Test(dependsOnMethods = "addProduct")
    public void addProduct05() {
        locaterAli.productSkuText.sendKeys(excelUtils.getCellData(4,1));
        //ReusableMethods.click(locaterAli.productmanage_stockRadioButton);
        select=new Select(locaterAli.productstock_status);
        select.selectByIndex(0);
        click(locaterAli.sold_individuallyRadioButton);
    }

    @Test(dependsOnMethods = "addProduct")
    public void addProduct06() {
        click(locaterAli.productSubmit);
        Assert.assertEquals(locaterAli.verifyMessage.getText(), "Product Successfully Published.");
        click(locaterAli.productsButton);
    }






}
