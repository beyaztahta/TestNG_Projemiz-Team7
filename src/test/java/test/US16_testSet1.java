package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterMali;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;
import utilities.ReusableMethods;

public class US16_testSet1 extends ReportMethods {
    LocaterMali locate=new LocaterMali();
    Actions actions;
    Select select;

    //Store Menager sayfası görüntülenir
    @Test (priority = -5)
    public void signIn() {
        extentTest=extentReports.createTest("US16","singIn");


        Driver.getDriver().get(ConfigReader.getProperty("storeMenagerPage"));
        extentTest.pass("hubcomfy.com sayfasına gidildi");

        locate.signInInputMail.sendKeys(ConfigReader.getProperty("mail"));
        extentTest.pass("geçerli mail adresi girildi");

        locate.signInInputPassword.sendKeys(ConfigReader.getProperty("password1"), Keys.PAGE_DOWN);
        extentTest.pass("geçerli şifre girildi");
        ReusableMethods.bekle(1);
        locate.signInButton.click();
        extentTest.pass("signIn button tıklandı ve giriş yapıldı");
        ReusableMethods.bekle(5);
        actions=new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(1);
        locate.storeManagerButton.click();
        extentTest.pass("store manager butonu tıklanarak sayfaya gidildi");
        ReusableMethods.bekle(2);


    }

    @Test (priority = -4)
    public void us16_tc01() {
        extentTest=extentReports.createTest("US16","tc01");
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

        actions=new Actions(Driver.getDriver());
        actions.moveToElement(locate.productButton).perform();
        ReusableMethods.bekle(1);
        locate.addNewButton.click();
        extentTest.pass("Sol Menu seçeneklerinden 'Product button' tıklandı");
        ReusableMethods.bekle(2);
        Assert.assertTrue(locate.manageProductText.isDisplayed());
        extentTest.pass("Manage Product yazısının göründüğü ve sayfada olunulduğu test edildi");
        select=new Select(locate.ddMunuSimpleVariable);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Simple"));
        extentTest.pass("Product Box alanında 'Simple Product' seçimi default olarak geldiği test edildi");
    }

    @Test (priority = -3)
    public void us16_tc02() {
        extentTest=extentReports.createTest("US16","tc02");

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Store Manager"));
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");
        actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        locate.checkboxVirtual.click();
        extentTest.pass("Checkbox Virtual alanı tıklandı ");
        Assert.assertTrue(locate.checkboxVirtual.isSelected());
        extentTest.pass("CheckboxVirtual alanının seçili olduğu test edildi ");
        ReusableMethods.bekle(1);
        locate.checkboxDownloadable.click();
        extentTest.pass("Checkbox Downloadable alanı tıklandı ");
        Assert.assertTrue(locate.checkboxDownloadable.isSelected());
        extentTest.pass("Checkbox Downloadalble alanının seçili olduğu test edildi ");

    }

    @Test (priority = -2)
    public void us16_tc03() {

        extentTest=extentReports.createTest("US16","tc03");


        Assert.assertTrue(Driver.getDriver().getTitle().contains("Store Manager"));
        extentTest.pass("Kullanıcı store manager sayfasına geldi ");

        locate.priceBox.sendKeys("100",Keys.TAB);
        extentTest.pass("Price alanına '100' olarak değer gönderildi ");
        ReusableMethods.bekle(1);

        extentTest.pass("Price alanına gönderilen değerin kabul edildiği test edildi ");
        locate.priceBox.clear();
        extentTest.pass("Price alanı temizlendi ");


        locate.priceBox.sendKeys("100.50",Keys.TAB);
        extentTest.pass("Price alanına '100.50' olarak double değer gönderildi ");
        ReusableMethods.bekle(1);
        System.out.println(locate.priceBox.getText());

        extentTest.pass("Price alanına gönderilen değerin kabul edildiği test edildi ");
        locate.priceBox.clear();
        extentTest.pass("Price alanı temizlendi ");

        locate.priceBox.sendKeys("ucuz",Keys.TAB);
        extentTest.pass("Price alanına 'ucuz' olarak String değer gönderildi ");

        ReusableMethods.bekle(1);
        extentTest.pass("Price alanına gönderilen string değerin  kabul EDİLMEDİĞİ test edildi ");
        locate.priceBox.clear();
        extentTest.pass("Price alanı temizlendi ");


        locate.priceBox.sendKeys("-100",Keys.TAB);
        extentTest.pass("Price alanına 'negatif int' olarak  değer gönderildi ");
        ReusableMethods.bekle(1);
        extentTest.pass("Price alanına gönderilen negatif değerin  kabul EDİLMEDİĞİ test edildi ");
        locate.priceBox.clear();
        extentTest.pass("Price alanı temizlendi ");

        locate.salePriceBox.sendKeys("100",Keys.TAB);
        extentTest.pass("SalePrice alanına '100' olarak değer gönderildi ");

        ReusableMethods.bekle(1);
        extentTest.pass("SalePrice alanına gönderilen değerin kabul edildiği test edildi ");

        locate.salePriceBox.clear();
        extentTest.pass("SalePrice alanı temizlendi ");

        locate.salePriceBox.sendKeys("100.50",Keys.TAB);
        extentTest.pass("SalePrice alanına '100.50' olarak değer gönderildi ");
        ReusableMethods.bekle(1);
        extentTest.pass("SalePrice alanına gönderilen değerin kabul edildiği test edildi ");
        locate.salePriceBox.clear();
        extentTest.pass("SalePrice alanı temizlendi ");


        locate.salePriceBox.sendKeys("ucuz",Keys.TAB);
        extentTest.pass("SalePrice alanına 'ucuz' olarak değer gönderildi ");
        ReusableMethods.bekle(1);
        extentTest.pass("SalePrice alanına gönderilen string değerin  kabul EDİLMEDİĞİ test edildi ");
        locate.salePriceBox.clear();
        extentTest.pass("SalePrice alanı temizlendi ");


        locate.salePriceBox.sendKeys("-100",Keys.TAB);
        extentTest.pass("SalePrice alanına 'negatif int' olarak  değer gönderildi ");
        ReusableMethods.bekle(1);
        extentTest.pass("SalePrice alanına 'negatif int' olarak  değerin kabul EDİLMEDİĞİ Test edildi ");
        locate.salePriceBox.clear();
        extentTest.pass("SalePrice alanı temizlendi ");


    }
}
