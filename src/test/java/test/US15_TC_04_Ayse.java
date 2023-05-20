package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LocaterAyse;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.*;

public class US15_TC_04_Ayse {
    @Test
    public void tc_04() {
        LocaterAyse locaterAyse = new LocaterAyse();
        //kullanici web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //signin tusuna basar
        locaterAyse.signIn.click();
        //kullanici mail adresini girer, passwordunu girer ve sign in buttonuna tiklar
        locaterAyse.email.sendKeys(ConfigReader.getProperty("ayse"), Keys.TAB, ConfigReader.getProperty("passAyse"), Keys.ENTER);
        bekle(5);
        //kullanici sayfanin en altina gider
        scrollEnd();
        bekle(2);
        //kullanici my account linkine tiklar
        locaterAyse.myAccount.click();
        //kullanici sol kisimdaki Store Manager'a tiklar
        locaterAyse.storeManager.click();
        //Kullanci sol bolumdeki Products buttonuna gider
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        hover(locaterAyse.products);
        //Kullanici Add New Linkine tiklar
        click(locaterAyse.addNew);

        //Kullanici sayfayi asagiya indirir
        scrollEnd();
        actions.sendKeys(Keys.PAGE_UP, Keys.ARROW_DOWN).perform();
        //kullanici Attributes menusunu tiklar
        click(locaterAyse.attributes);
        //Kullanici color checkbox'ina tiklar
        locaterAyse.attributesColorCheckbox.click();

        assertTrue(locaterAyse.attributesColorCheckbox.isSelected());
        //Kullanici color checkbox'inin yanindaki oka tiklar
        locaterAyse.attributesActiveArrow.click();
        locaterAyse.attributesActiveArrow.click();
        assertTrue(locaterAyse.attributesActiveArrow.isDisplayed());
        //kullanici checkbox'in isaretli olmasini kontrol eder

        assertTrue(locaterAyse.attributesColorActiveCheckbox.isSelected());

        //kullanici text areaya icinde olan bir veri girer
        locaterAyse.attributesColorDdm.sendKeys(ConfigReader.getProperty("renk"));
        assertEquals(locaterAyse.attributesColorDdm.getAttribute("value"), ConfigReader.getProperty("renk"));
        locaterAyse.attributesColorDdm.clear();
        //kullanici select all buttonunu tiklar
        click(locaterAyse.attributesColorSelectAllButton);

      /*  Select select = new Select(locaterAyse.attributesColorDdm);
        List<WebElement> ddm = select.getOptions();
        int size = ddm.size();
        if (size > 1) {
            System.out.println("farkli renkler mevcuttur renkler sunlardir:");
            ddm.forEach(t -> System.out.println(t.getText()));
        } else {
            System.out.println("menude renk bulunmamaktadir");
        }*/

        //kullanici select none buttonuna tiklar
        click(locaterAyse.attributesColourSelectNoneButton);
        //Select select = new Select(locaterAyse.attributesColorDdm);
        assertEquals(locaterAyse.attributesColorDdm.getAttribute("value"), "");
        //kullanici Add new buttonunu tiklar
        locaterAyse.attributesColorAddNewButton.click();
        bekle(2);
        //kullanici cikan alert'e veri girer
     Driver.getDriver().switchTo().alert().sendKeys("kapkara");

        //kullanici cikan alert'e yazdigi rengi OK tusu ile kabul eder
       Driver.getDriver().switchTo().alert().accept();

        //Kullanici yine Add New buttonuna tiklar
        locaterAyse.attributesColorAddNewButton.click();
        //kullanici cikan alert'e veri girer
        Driver.getDriver().switchTo().alert().sendKeys("kazandibi karasi");
        //kullanici cikan alert'e veri girme islemini iptal eder
        Driver.getDriver().switchTo().alert().dismiss();
        //kullanici add new'e basar
        locaterAyse.attributesColorAddNewButton.click();
        //kullanici veri girmeden OK tusuna basar
        Driver.getDriver().switchTo().alert().accept();
        bekle(5);
        //kullanici uyari yazisini gorur
        System.out.println("Uyari mesaji: " + Driver.getDriver().switchTo().alert().getText());
        //kullanici uyari mesajini kabul eder
        Driver.getDriver().switchTo().alert().accept();
        bekle(2);
        //Kullanici color'a basinca cikan visible on the product page checkbox'ini onayli mi kontrol eder
        assertTrue(locaterAyse.attributesVisibleOnTheProductPage1.isSelected());

        //Kullanici size checkbox'ina tiklar
        locaterAyse.attributesSizeCheckbox.click();
        assertTrue(locaterAyse.attributesSizeCheckbox.isSelected());
        //kullanici size textareasina veri girer
        locaterAyse.attributesSizeDdm.sendKeys("Large", Keys.ENTER);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locaterAyse.attributesSizeDdm.getAttribute("value"), "Large");
        //Kullanici size checkbox'inin yanindaki oka tiklar
        locaterAyse.attributesSizeArrow.click();
        assertTrue(locaterAyse.attributesSizeArrow.isDisplayed());
        //kullanici text areaya icinde olan bir veri girer
        locaterAyse.attributesSizeCheckbox.click();


        //kullanici select all buttonunu tiklar
        locaterAyse.attributesSizeSelectAllButton.click();
        Select select = new Select(locaterAyse.attributesSizeDdm);
        List<WebElement> sizeDdm = select.getOptions();
        int numOfSize = sizeDdm.size();
        if (numOfSize > 0) {
            System.out.println("size icin degisik secenekler mevcuttur");
            sizeDdm.forEach(t -> System.out.println(t.getText()));
        } else {
            System.out.println("size icin secenek yoktur");
        }
        for (WebElement w : sizeDdm) {
            assertTrue(w.isDisplayed());
        }
        //kullanici select none buttonuna tiklar
        locaterAyse.attributesSizeSelectNoneButton.click();
        select = new Select(locaterAyse.attributesSizeDdm);
        sizeDdm = select.getOptions();
        numOfSize = sizeDdm.size();
        if (numOfSize > 0) {
            System.out.println("size icin degisik secenekler mevcuttur");
            sizeDdm.forEach(t -> System.out.println(t.getText()));
        } else {
            System.out.println("size icin secenek yoktur");
        }
        //kullanici Add new buttonunu tiklar
        locaterAyse.attributesSizeAddNewButton.click();
        //kullanici cikan alert'e veri girer
        Driver.getDriver().switchTo().alert().sendKeys("XXX");
        //kullanici cikan alert'e yazdigi size'i OK tusu ile kabul eder
        Driver.getDriver().switchTo().alert().accept();
        //Kullanici yine Add New buttonuna tiklar
        locaterAyse.attributesSizeAddNewButton.click();

        //kullanici cikan alert'e veri girer
        Driver.getDriver().switchTo().alert().sendKeys("EXXX");
        //kullanici cikan alert'e veri girme islemini iptal eder
        Driver.getDriver().switchTo().alert().dismiss();
        //Kullanici yine Add New buttonuna tiklar
        locaterAyse.attributesSizeAddNewButton.click();
        //Kullanici veri girmeden OK tusuna basar
        Driver.getDriver().switchTo().alert().accept();
        bekle(5);
        //Kullanici uyari mesaji alir
        assertEquals(Driver.getDriver().switchTo().alert().getText(), ConfigReader.getProperty("uyari"));

        //Kullanici color'a basinca cikan visible on the product page checkbox'ini onaylar
        assertTrue(locaterAyse.attributesVisibleOnTheProductPage2.isEnabled());

        //Kullanici Add attribute icin Add tusuna basar
        locaterAyse.getAttributesAddAttributeAddButton.click();
        //Kullanici Add buttonuna basinca cikan name text areasina veri girer
        locaterAyse.getAttributesAddAttributeAddName.sendKeys("giysi");
        assertEquals(locaterAyse.getAttributesAddAttributeAddValue.getAttribute("value"), "giysi");
        //Kullanici Add buttonuna basinca cikan values text areasina veri girer
        locaterAyse.getAttributesAddAttributeAddValue.sendKeys("cuval");
        assertEquals(locaterAyse.getAttributesAddAttributeAddValue.getAttribute("value"), "cuval");
        //Kullanici Visible on the product page checkbox'ini tikli mi bakar
        assertTrue(locaterAyse.attributesVisibleOnTheProductPage.isSelected());
        //kullanici veri girdigi textbox'in uzerindeki oka tiklar
        locaterAyse.arrow.click();
        //Kullanici ekledigi attribute"u gorur
        assertEquals(locaterAyse.addNewProduct.getAttribute("value"), "cuval");

        Driver.closeDriver();
    }
}

