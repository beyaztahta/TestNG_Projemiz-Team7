package test.serap_US05_US06_US21.US21;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LocaterSerap;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.ReusableMethods.bekle;

public class TC01 {

    LocaterSerap serap = new LocaterSerap();
    Actions actions;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public void beforeTest() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/extentReport/AOK/US21" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("QA", "Serap Kilinc");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Raporu");
        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

        //Kullanici url e gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfy_Url"));
        extentTest.info("Kullanicinin url e gittigi gorulur");
        //Kullanici sayfanin sag ustunde bulunan sign in butonuna tiklar
        serap.signInButton.click();
        extentTest.info("Kullanicinin sign-in butonuna tikladigi gorulur");
        //Kullanici username or adress box ina  valid bir deger girer  Kullanici password box ina valid deger girer
        serap.signInUsername.sendKeys(ConfigReader.getProperty("serap"), Keys.TAB);
        serap.signInPassword.sendKeys(ConfigReader.getProperty("kilinc"));
        extentTest.info("Kullanicinin username ve password boxlarina valid deger girdigi gorulur");
        // Kullanici turuncu renkteki Sign-in box ina tiklar
        serap.login.click();
        extentTest.info("Kullanicinin log-in boxina tikladigi gorulur");
        bekle(2);
        //Kullanici sayfasinin ustunde bulunan search box ina "pencil" yazar ve Enter tusuna basar
        serap.searchbox.click();
        serap.searchbox.sendKeys("pencil", Keys.ENTER);
        extentTest.info("Kullanicinin search box ina pencil yazdigi ve enter tusuna tikladigi gorulur");
    }

    @Test
    public void testCase01() {
        LocaterSerap serap = new LocaterSerap();
        actions = new Actions(Driver.getDriver());
        // Kullanici acilan url de turuncu renkteki ADD TO CART boxina tiklar
        serap.addToCart.click();
        extentTest.info("Kullanicinin ADD TO CART  boxina tikladigi gorulur");
//        Kullanici sayfanin sag ustunde bulunan Cart box inda turuncu renkte cikan 1 rakamini gorur
        bekle(3);
        ReusableMethods.webElementResmi(serap.cart);
        extentTest.info("Kullanicinin cart box ta eklenilen urun adeti sayisini gorur");
        // Kullanici sayfanin sag ustunde bulunan Cart box ina tiklar
        serap.cart.click();
        extentTest.info("Kullanicinin cart iconuna tikladigi gorulur");
        // Kullanici sayfanin sag kisminda acilan pop-up ta ekledigi urunleri gorur
        ReusableMethods.tumSayfaResmi();
        //Kullanici sayfanin sag kismindaki pop-up ta WIEW CART box ina tiklar
        serap.viewCart.click();
        extentTest.info("Kullanicinin pop-up ta WIEW CART box ina tikladigi gorulur");
        //Kullanici acilan sayfada Quantity yazisinin altinda + isaretine tiklar daha sonra - isaretine tiklar
        Assert.assertTrue(serap.quantity.isDisplayed());
        bekle(2);
        serap.quantityplus.click();
        bekle(2);
        extentTest.info("Kullanicinin Quantity yazisinin altinda + isaretine tikladigi gorulur");
        serap.quantityminus.click();
        bekle(2);
        extentTest.info("Kullanicinin Quantity yazisinin altinda - isaretine tikladigi gorulur");
        //Kullanici acilan sayfanin sag alt kisminda Siyah renkteki PROCEED TO CHECKOUT box ina tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        extentTest.info("Kullanicinin sayfanin en altina indigi  gorulur");
        serap.proceedCheckout.click();
        extentTest.info("Kullanicinin PROCEED TO CHECKOUT box ina tikladigi gorulur");
        //Kullanici fatura Adresini acilan https://hubcomfy.com/checkout-2/ url de goruntuler
        ReusableMethods.tumSayfaResmi();
//        Kullanici fatura Adresi sayfasindaki kirmizi renkte olan * li box lara valid deger girer
        serap.billingDetailsFirstName.sendKeys("serap", Keys.TAB, "kilinc");
        serap.billingDetailsApartmantName.sendKeys("long no:3", Keys.TAB, Keys.TAB, "New york", Keys.TAB, Keys.TAB, "123", Keys.TAB, "5455440192");
        extentTest.info("Kullanicinin fatura Adresi sayfasindaki kirmizi renkte olan * li box lara valid deger girdigi gorulur");
//        "Kullanici sayfanin saginda bulunan ""Payment Methods""  yazisinin altinda bulunan  ""Wire transfer/EFT"" ve ""Pay at the door""
//        yazilarinin oldugu kutucuklara tiklar"
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(5);
        extentTest.info("Kullanicinin sayfanin en altina indigi  gorulur");
        serap.kapidaOdeme.click();
        bekle(3);
        extentTest.info("Kullanicinin pay at the door boxina tikladigi  gorulur");
        serap.placeOrder.click();
        bekle(5);
        extentTest.info("Kullanicinin place order box ina tikladigi  gorulur");
        Driver.closeDriver();
        extentTest.pass("Test basarili bir sekilde sonlandirildi");
        extentReports.flush();
    }

    @Test
    public void testCase02() {
        LocaterSerap serap = new LocaterSerap();
        actions = new Actions(Driver.getDriver());
        serap.searchbox.sendKeys("monster", Keys.ENTER);
        extentTest.info("Kullanicinin search box ina monster yazdigi ve enter tusuna tikladigi gorulur");
        // Kullanici acilan url de turuncu renkteki ADD TO CART boxina tiklar
        serap.addToCart.click();
        extentTest.info("Kullanicinin ADD TO CART  boxina tikladigi gorulur");
        //        Kullanici sayfanin sag ustunde bulunan Cart box inda turuncu renkte cikan 1 rakamini gorur
        bekle(3);
        ReusableMethods.webElementResmi(serap.cart);
        extentTest.info("Kullanicinin cart box ta eklenilen urun adeti sayisini gorur");
        // Kullanici sayfanin sag ustunde bulunan Cart box ina tiklar
        serap.cart.click();
        extentTest.info("Kullanicinin cart iconuna tikladigi gorulur");
        // Kullanici sayfanin sag kisminda acilan pop-up ta ekledigi urunleri gorur
        ReusableMethods.tumSayfaResmi();
//        Kullanici acilan sayfanin sag alt kisminda Siyah renkteki PROCEED TO CHECKOUT box ina tiklar
        serap.proceedCheckout.click();
        extentTest.info("Kullanicinin PROCEED TO CHECKOUT box ina tikladigi gorulur");
//Kullanici sayfanin ustunde bulunan "Have a coupon? ENTER YOUR CODE" kisminda ki ENTER YOUR CODE yazisina tiklar
        serap.enterYourCode.click();
        extentTest.info("Kullanicinin Have a coupon? ENTER YOUR CODE kisminda ki ENTER YOUR CODE yazisina tikladigi gorulur");
        //        Kullanici acilan box a valid code girer ve APPLY COUPON box ina tiklar
        serap.couponCode.sendKeys("");
        extentTest.info("Kullanicinin Have a coupon? ENTER YOUR CODE kisminda ki ENTER YOUR CODE BOX INA team04 yazdigi gorulur");
        serap.couponCode.click();
        extentTest.info("Kullanicinin apply coupon boxina tikladigi gorulur");
        //        Kullanici fatura Adresi sayfasindaki kirmizi renkte olan * li box lara valid deger girer
        serap.billingDetailsFirstName.sendKeys("serap", Keys.TAB, "kilinc");
        serap.billingDetailsAdress.sendKeys("yesil sokak", Keys.TAB, Keys.TAB, "New york", Keys.TAB, Keys.TAB, "123",
                Keys.TAB, "123456789");
        extentTest.info("Kullanicinin fatura Adresi sayfasindaki kirmizi renkte olan * li box lara valid deger girdigi gorulur");
        //  Kullanici sayfanin saginda bulunan ""Payment Methods""  yazisinin altinda bulunan  ""Pay at the door""
        //yazsinin oldugu kutucuga tiklar"
        serap.kapidaOdeme.click();
        ReusableMethods.tumSayfaResmi();
        extentTest.info("Kullanicinin pay at the door boxina tikladigi  gorulur");
        bekle(3);
        extentTest.pass("Test basarili bir sekilde sonlandirildi");
        extentReports.flush();


    }
}
