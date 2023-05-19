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

import java.util.List;

import static utilities.ReusableMethods.*;
import static utilities.ReusableMethods.bekle;

public class Elif_US14_TC04_TC05_TC06_TC07 {

    LocaterElif locater = new LocaterElif();
    Actions actions = new Actions(Driver.getDriver());

    Faker faker = new Faker();


    @Test
    public void test04() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();

        //Kullanıcı "Products" butonuna basar.
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();

        //Kullanıcı sagda yer alan "Categories"bolumunden "Appointment"butonunu secer.
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        scroll(locater.categoriesPart);
        click(locater.appoinment);
        bekle(1);

        //Kullanıcı "+Add new category" butonuna tıklar.
        scroll(locater.addNewCategory);
        click(locater.addNewCategory);

        //Kullanıcı Category Name bolumune "Bursa2" datasını girer.
        String word = faker.name().firstName();
        locater.categoryName.sendKeys(word);


        //Kullanıcı ADD butonuna tıklar.
        scroll(locater.categoryAddClick);
        click(locater.categoryAddClick);

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
        Driver.closeDriver();
    }

    @Test
    public void testCase05() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();

        //Kullanıcı "Products" butonuna basar
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();

        //Kullanıcı "Products Brands" bolumunden Adidas ı secer.
        scroll(locater.productBrandsLink);
        click(locater.adidas);
        bekle(1);

        //Kullanıcı "+Add new Product brands" butonuna tıklar.
        click(locater.productBrandsLink);

        //Kullanıcı "Products Brand Name"adlı kutya "Nilüfer" adlı urun ekler.
        String word2 = faker.name().title();
        locater.productCategoryName.sendKeys(word2);

        //Kullanıcı "ADD" butonuna tıklar.
        scroll(locater.productAddClick);
        click(locater.productAddClick);

        bekle(5);

        //Kullanıcı girdigi productsın dogrular.

        boolean flag = false;
        for (WebElement w : locater.productBrandsList) {
            if (w.getText().equals(word2)) {
                flag = true;
                break;
            }
        }
        Driver.closeDriver();
    }

    @Test
    public void testcase06() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();

        //Kullanıcı "Products" butonuna basar
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();

//        Kullanıcı "tags" textbox ına ."yesillik" datasını girer.
        scroll(locater.tagsClick);
        bekle(2);
        String tags = faker.name().lastName();
        locater.tagsTextBox.sendKeys(tags);

//        Kullanıcı "Choose from the most used tags" textine tıklar.
        click(locater.tagsClick);
        bekle(5);

//        Kullanıcı girdigi tegs datasının oldugunu acılan bolumde dogrular.
        boolean flag = false;
        for (WebElement w : locater.tagsList) {
            w.getText().equals(tags);
            flag = true;
            break;
        }
        Driver.closeDriver();
    }

    @Test
    public void testCase07() {
        //Kullaınıcı https:// www.hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Kullanıcı sayfanın en altındaki "My Account"butonuna basar.
        scrollEnd();
        bekle(2);
        locater.myAccountButton.click();

        //Kullanıcı vendor olarak giris yapar.
        scroll(locater.signInLogin);
        bekle(1);
        locater.userName.sendKeys(ConfigReader.getProperty("username_leyla"));
        locater.password.sendKeys(ConfigReader.getProperty("password_leyla"));
        locater.rememberMe.click();
        locater.signInLogin.click();

        //Kullanıcı "Store Manager" butonuna basar
        scrollHome();
        bekle(2);
        locater.storeManagerButton.click();

        //Kullanıcı "Products" butonuna basar
        scroll(locater.productsButton);
        bekle(2);
        locater.productsButton.click();

        //Kullanıcı "Add New" butonuna basar.
        bekle(1);
        locater.addNewButton.click();

        //Kullanıcı Catalog visibility altındaki dropdown seceneginin gorundugunu dogrular.
        scroll(locater.catalogVisibility);
        bekle(1);
        Assert.assertTrue(locater.catalogVisibilityDropDown.isDisplayed());

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

    }
}
