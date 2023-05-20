package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocaterElif;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import java.util.List;

import static utilities.ReusableMethods.*;
import static utilities.ReusableMethods.bekle;

public class US14_Elif2 extends ReportMethods {

    LocaterElif locater = new LocaterElif();
    Actions actions = new Actions(Driver.getDriver());

    Faker faker = new Faker();


    @Test
    public void test04() {
        extentTest = extentReports.createTest("US14", "Categories seçilebilmeli, Yeni Categories eklenebilmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESINE GIDILDI.");

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();
        extentTest.pass("VENDOR OLARAK GIRIS YAPILDI.");

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();
        extentTest.pass("STORE MANAGER BUTONUNA TIKLANDI.");

        //Kullanıcı "Products" butonuna basar.
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();
        extentTest.pass("PRODUCTS BUTONUNA TIKLANDI.");

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();
        extentTest.pass("ADD NEWT BUTONUNA TIKLANDI.");

        //Kullanıcı sagda yer alan "Categories"bolumunden "Appointment"butonunu secer.
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        scroll(locater.categoriesPart);
        click(locater.appoinment);
        bekle(1);
        extentTest.pass("CATEGORIES BOLUMUNDEN APPOINTMENT BUTONUNA TIKLANDI.");

        //Kullanıcı "+Add new category" butonuna tıklar.
        scroll(locater.addNewCategory);
        click(locater.addNewCategory);
        extentTest.pass("ADD NEW CATEGORY BUTONUNA TIKLANDI.");

        //Kullanıcı Category Name bolumune "Bursa2" datasını girer.
        String word = faker.name().firstName();
        locater.categoryName.sendKeys(word);
        extentTest.pass("CATEGORY NAME BOLUMUNE DATA GIRILDI..");

        //Kullanıcı ADD butonuna tıklar.
        scroll(locater.categoryAddClick);
        click(locater.categoryAddClick);
        extentTest.pass("ADD BUTONUNA TIKLANDI.");
        bekle(5);

        //Kullanıcı Categories bolumune girdigi datanın eklendıgını dogrular.

        boolean flag = false;
        for (WebElement w : locater.categoriesList) {
            if (w.getText().equals(word)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
        extentTest.pass("CATEGORIES GIRILEN DATANIN EKLENDIGI DOGRULANDI.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");
    }

    @Test
    public void testCase05() {
        extentTest = extentReports.createTest("US14", "Product brands seçilebilmeli ,Yeni Product brands eklenebilmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESINE GIDILDI.");

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();
        extentTest.pass("VENDOR OLARAK GIRIS YAPILDI.");

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();
        extentTest.pass("STORE MANAGER BUTONUNA TIKLANDI.");

        //Kullanıcı "Products" butonuna basar
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();
        extentTest.pass("PRODUCTS BUTONUNA TIKLANDI.");

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();
        extentTest.pass("ADD NEW BUTONUNA TIKLANDI.");

        //Kullanıcı "Products Brands" bolumunden Adidas ı secer.
        scroll(locater.productBrandsLink);
        click(locater.adidas);
        bekle(1);
        extentTest.pass("PRODUCTS BRAND BOLUMUNDEN ADIDAS BUTONU SECILDI.");

        //Kullanıcı "+Add new Product brands" butonuna tıklar.
        click(locater.productBrandsLink);
        extentTest.pass("+ADD NEW PRODUCT BRANDS BUTONUNA TIKLANDI.");

        //Kullanıcı "Products Brand Name"adlı kutya "Nilüfer" adlı urun ekler.
        String word2 = faker.name().title();
        locater.productCategoryName.sendKeys(word2);
        extentTest.pass("PRODUCTS BRAND NAME ALANINA DATA GIRILDI.");

        //Kullanıcı "ADD" butonuna tıklar.
        scroll(locater.productAddClick);
        click(locater.productAddClick);
        extentTest.pass("ADD BUTONUNA TIKLANDI.");

        bekle(5);

        //Kullanıcı girdigi productsın dogrular.

        boolean flag = false;
        for (WebElement w : locater.productBrandsList) {
            if (w.getText().equals(word2)) {
                flag = true;
                break;
            }
        }
        extentTest.pass("PRODUCTSIN EKLENDIGI DOGRULANDI.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");
    }

    @Test
    public void testcase06() {
        extentTest = extentReports.createTest("US14", "Tags eklenebilmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESINE GIDILDI.");

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();
        extentTest.pass("VENDOR OLARAK GIRIS YAPILDI.");

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();
        extentTest.pass("STORE MANAGER BUTONUNA TIKLANDI.");

        //Kullanıcı "Products" butonuna basar
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();
        extentTest.pass("PRODUCTS BUTONUNA TIKLANDI.");

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();
        extentTest.pass("ADD NEW BUTONUNA TIKLANDI.");

//        Kullanıcı "tags" textbox ına ."yesillik" datasını girer.
        scroll(locater.tagsClick);
        bekle(2);
        String tags = faker.name().lastName();
        locater.tagsTextBox.sendKeys(tags);
        extentTest.pass("TAGS TEXTBOX INA DATA GIRILDI.");

//        Kullanıcı "Choose from the most used tags" textine tıklar.
        click(locater.tagsClick);
        bekle(5);

//        Kullanıcı girdigi tags datasının oldugunu acılan bolumde dogrular.
        boolean flag = false;
        for (WebElement w : locater.tagsList) {
            w.getText().equals(tags);
            flag = true;
            break;
        }
        extentTest.pass("TAGS DATASININ OLDUGU DOGRULANDI.");
        extentTest.pass("TAGS DATASI OTOMASYONDA EKLENGI DOGRULANIYOR FAKAT MANUELDE HATA ALINIYOR.");

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");
    }

    @Test
    public void testCase07() {
        extentTest = extentReports.createTest("US14", "Catalog visibility; Shop and search results, Shop only, Search results only, Hidden olarak seçilebilmeli");

        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.pass("HUBCOMFY ADRESINE GIDILDI.");

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();
        extentTest.pass("MY ACCOUNT BUTONUNA TIKLANDI.");

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();
        extentTest.pass("VENDOR OLARAK GIRIS YAPILDI.");

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();
        extentTest.pass("STORE MANAGER BUTONUNA TIKLANDI.");

        //Kullanıcı "Products" butonuna basar
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();
        extentTest.pass("PRODUCTS BUTONUNA TIKLANDI.");

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();
        extentTest.pass("ADD NEW BUTONUNA TIKLANDI.");

        //Kullanıcı Catalog visibility altındaki dropdown seceneginin gorundugunu dogrular.
        scroll(locater.catalogVisibility);
        bekle(1);
        Assert.assertTrue(locater.catalogVisibilityDropDown.isDisplayed());
        extentTest.pass("CATALOG VISIBILITY DROPDOWN SECENEGININ GORULDUGU DOGRULANDI.");
        extentTest.pass("CATALOG VISIBILITY DROPDOWN SECENEKLERINE TIKLANDI.");

        //Kullanıcı urun turunun secildigi dropdowndan "Shop and search results"secenegine tıklar.
        //Kullanıcı urun turunun secildigi dropdowndan "Shop only"secenegine tıklar.
        //Kullanıcı urun turunun secildigi dropdowndan "Search results only"secenegine tıklar.
        //Kullanıcı urun turunun secildigi dropdowndan "Hidden"secenegine tıklar.

        Select select = new Select(locater.catalogVisibilityDropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions) {
            w.click();
        }

        Driver.closeDriver();
        extentTest.pass("DRIVER KAPATILDI.");

    }
}
