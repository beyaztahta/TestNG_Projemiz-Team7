package test.tc_ayse;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReportMethods;

import java.util.List;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.*;

public class TC_04 extends ReportMethods {
    LocaterAyse locaterAyse = new LocaterAyse();
    TC_01 tc01 = new TC_01();

    @Test
    public void tc_04() {
        extentTest = extentReports.createTest("Hubcomfy", "Attribute bolumu");
        LocaterAyse locaterAyse = new LocaterAyse();
        tc01.start();

        //kullanici Attributes menusunu tiklar
        click(locaterAyse.attributes);
        extentTest.info("Attributes menusu tiklandi");
        //Kullanici color checkbox'ina tiklar
        locaterAyse.attributesColorCheckbox.click();
        extentTest.info("Color checkbox tiklandi");


        assertTrue(locaterAyse.attributesColorCheckbox.isSelected());
        extentTest.pass("Checkbox'in secilmis olmasi kontrol edildi");
        //Kullanici color checkbox'inin yanindaki oka tiklar
        locaterAyse.attributesActiveArrow.click();
        extentTest.pass("Active arrow'un aktifligi kontrol edildi");
        locaterAyse.attributesActiveArrow.click();
        assertTrue(locaterAyse.attributesActiveArrow.isDisplayed());
        //kullanici checkbox'in isaretli olmasini kontrol eder
        assertTrue(locaterAyse.attributesColorActiveCheckbox.isSelected());

        //kullanici text areaya icinde olan bir veri girer
        locaterAyse.attributesColorDdm.sendKeys(ConfigReader.getProperty("renk"));
        extentTest.info("Olan bir renk girildi");
        assertEquals(locaterAyse.attributesColorDdm.getAttribute("value"), ConfigReader.getProperty("renk"));
        extentTest.pass("Girilen rengin secildigi kontrol edildi");
        locaterAyse.attributesColorDdm.clear();
        extentTest.info("Menu temizlendi");
    }

    @Ignore
    @Test
    public void tc_04a() {
        LocaterAyse locaterAyse = new LocaterAyse();
        //kullanici Add new buttonunu tiklar
        click(locaterAyse.attributesColorAddNewButton);
        extentTest.info("Add new buttonu tiklanir");
        //kullanici cikan alert'e veri girer
        alertprompt("kapkara");
        extentTest.info("Alerte veri girildi");
        alertWait(5000);
        //kullanici cikan alert'e yazdigi rengi OK tusu ile kabul eder
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("Alert kabul edildi");
        //kullanici add new'e basar
        click(locaterAyse.attributesColorAddNewButton);
        extentTest.info("Add new buttonu tiklanir");
        bekle(3);
        //kullanici veri girmeden OK tusuna basar
        alertAccept();
        extentTest.info("Alert kabul edildi");
        bekle(5);
        //kullanici uyari yazisini gorur
        System.out.println("Uyari mesaji: " + Driver.getDriver().switchTo().alert().getText());
        extentTest.pass("Uyari mesaji goruldu");
        //kullanici uyari mesajini kabul eder
        alertAccept();
        extentTest.info("Uyari Alerti kabul edildi");
        bekle(2);
        //Kullanici yine Add New buttonuna tiklar
        click(locaterAyse.attributesColorAddNewButton);
        extentTest.info("Add new buttonuna tiklanir");
        bekle(2);
        //kullanici cikan alert'e veri girer
        alertprompt("kazandibi karasi");
        extentTest.info("Alerte yazi girilir");
        //kullanici cikan alert'e veri girme islemini iptal eder
        Driver.getDriver().switchTo().alert().dismiss();
        extentTest.info("Alert iptal edilir");
    }

    @Test
    public void tc_04b() {
        //kullanici select all buttonunu tiklar
        click(locaterAyse.attributesColorSelectAllButton);
        extentTest.info("Select All'a basildi");
        bekle(2);

        Select select = new Select(locaterAyse.attributesColorDdm);
        List<WebElement> ddm = select.getOptions();
        int size = ddm.size();
        if (size > 1) {
            System.out.println("farkli renkler mevcuttur renkler sunlardir:");
            ddm.forEach(t -> System.out.println(t.getText()));
            extentTest.pass("renkler secildi");
        } else {
            System.out.println("menude renk bulunmamaktadir");
            extentTest.info("Menude renk yoktur");
        }bekle(2);

        //kullanici select none buttonuna tiklar
        click(locaterAyse.attributesColourSelectNoneButton);
        extentTest.info("Select none buttonu tiklandi");
        //Select select = new Select(locaterAyse.attributesColorDdm);
        assertEquals(locaterAyse.attributesColorDdm.getAttribute("value"), "");
        extentTest.pass("menunun bos oldugu kontrol edildi");


        //Kullanici color'a basinca cikan visible on the product page checkbox'ini onayli mi kontrol eder
        assertTrue(locaterAyse.attributesVisibleOnTheProductPage1.isSelected());
        extentTest.pass("Checkbox'i kontrol etti");
        //Kullanici size checkbox'ina tiklar
       click( locaterAyse.attributesSizeCheckbox);
        extentTest.pass("Checkbox'in secildigi kontrol edildi");
        assertTrue(locaterAyse.attributesSizeCheckbox.isSelected());
        extentTest.pass("Checkbox kontrol edildi");
        //kullanici size textareasina veri girer
        locaterAyse.attributesSizeDdm.sendKeys("Large", Keys.ENTER);
        extentTest.info("size kismina veri girdi");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(locaterAyse.attributesSizeDdm.getAttribute("value"), "Large");
        extentTest.pass("Girinen verinin dogrulugu kontrol edildi");

        //Kullanici size checkbox'inin yanindaki oka tiklar
        locaterAyse.attributesSizeArrow.click();
        extentTest.info("Attributes size Arrow'a tiklandi");
        assertTrue(locaterAyse.attributesSizeArrow.isDisplayed());
        extentTest.pass("Arrowun varligi kontrol edildi");
        locaterAyse.attributesSizeCheckbox.click();
        //kullanici select all buttonunu tiklar
        locaterAyse.attributesSizeSelectAllButton.click();
        extentTest.info("Select All buttonu tiklandi");
        select = new Select(locaterAyse.attributesSizeDdm);
        List<WebElement> sizeDdm = select.getOptions();
        int numOfSize = sizeDdm.size();
        if (numOfSize > 0) {
            System.out.println("size icin degisik secenekler mevcuttur");
            sizeDdm.forEach(t -> System.out.println(t.getText()));
            extentTest.info("Degisik secenekler mevcut oldugu goruldu");
        } else {
            System.out.println("size icin secenek yoktur");
        }
        for (WebElement w : sizeDdm) {
            assertTrue(w.isDisplayed());
        }extentTest.pass("seceneklerin goruldugu dogrulandi");
        //kullanici select none buttonuna tiklar
        locaterAyse.attributesSizeSelectNoneButton.click();
        extentTest.info("Select None tiklandi");
        select = new Select(locaterAyse.attributesSizeDdm);
        sizeDdm = select.getOptions();
        numOfSize = sizeDdm.size();
        if (numOfSize > 0) {
            System.out.println("size icin degisik secenekler mevcuttur");
            sizeDdm.forEach(t -> System.out.println(t.getText()));
            extentTest.info("Degisik secenekler mevcut oldugu goruldu");
        } else {
            System.out.println("size icin secenek yoktur");
            extentTest.info("Secenek bulunmamaktadir");
        }
    }
@Ignore
    @Test
    public void test04c() {
        //kullanici Add new buttonunu tiklar
        click( locaterAyse.attributesSizeAddNewButton);
        extentTest.info("Add New buttonu tiklandi");
        //kullanici cikan alert'e veri girer
       alertprompt("XXX");
        extentTest.info("Cikan alert'e text gonderildi");
        //kullanici cikan alert'e yazdigi size'i OK tusu ile kabul eder
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("Alerte gonderilen yazi kabul edildi");
        //Kullanici yine Add New buttonuna tiklar
        locaterAyse.attributesSizeAddNewButton.click();
        extentTest.info("Add New buttonu tiklandi");

        //kullanici cikan alert'e veri girer
        Driver.getDriver().switchTo().alert().sendKeys("EXXX");
        extentTest.info("Cikan alert'e text gonderildi");
        //kullanici cikan alert'e veri girme islemini iptal eder
        Driver.getDriver().switchTo().alert().dismiss();
        extentTest.info("Gonderdigi yaziyi iptal etti");
        //Kullanici yine Add New buttonuna tiklar
        locaterAyse.attributesSizeAddNewButton.click();
        extentTest.info("Add New buttonu tiklandi");
        //Kullanici veri girmeden OK tusuna basar
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("Alert'e veri gondermeden OK tusuna basti");
        bekle(5);
        //Kullanici uyari mesaji alir
        assertEquals(Driver.getDriver().switchTo().alert().getText(), ConfigReader.getProperty("uyari"));
        extentTest.pass("Uyari mesajini aldi");
        //Uyari mesajini onayladi
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("Alert uyarisini kapatti");
    }

    @Test
    public void test04d() {


        //Kullanici color'a basinca cikan visible on the product page checkbox'ini onayli olmsini kontrol eder
        assertTrue(locaterAyse.attributesVisibleOnTheProductPage2.isEnabled());
        extentTest.pass("Checkbox'in secili oldugu kontrol edildi");
        //Kullanici Add attribute icin Add tusuna basar
      click(  locaterAyse.getAttributesAddAttributeAddButton);
        extentTest.info("Add attribute bolumu secildi");
        //Kullanici Add buttonuna basinca cikan name text areasina veri girer
        locaterAyse.getAttributesAddAttributeAddName.sendKeys("giysi");
        extentTest.info("Attribute'e veri girildi");
        assertEquals(locaterAyse.getAttributesAddAttributeAddValue.getAttribute("value"), "giysi");
        extentTest.pass("Girilen verinin varligi konrol edildi");
        //Kullanici Add buttonuna basinca cikan values text areasina veri girer
        locaterAyse.getAttributesAddAttributeAddValue.sendKeys("cuval");
        extentTest.info("Attribute Value'ya veri girildi");
        assertEquals(locaterAyse.getAttributesAddAttributeAddValue.getAttribute("value"), "cuval");
        extentTest.info("Girilen verinin varligi kontrol edildi");
        //Kullanici Visible on the product page checkbox'ini tikli mi bakar
        assertTrue(locaterAyse.attributesVisibleOnTheProductPage.isSelected());
        extentTest.pass("Attributes visible on the product page checkbox'in secili olmasi kontrol edildi");
        //kullanici veri girdigi textbox'in uzerindeki oka tiklar
        locaterAyse.arrow.click();
        //Kullanici ekledigi attribute"u gorur
        assertEquals(locaterAyse.addNewProduct.getAttribute("value"), "cuval");
        extentTest.info("eklenen productin varligi kontrol edildi");
        Driver.closeDriver();
        extentTest.pass("Driver kapatildi");
    }
}

