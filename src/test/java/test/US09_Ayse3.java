package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LocaterAyse;
import utilities.Driver;
import utilities.ReportMethods;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static utilities.ReusableMethods.click;
import static utilities.ReusableMethods.visibleWait;


public class US09_Ayse3 extends ReportMethods {
    @Test
    public void test1() {
        LocaterAyse locaterAyse = new LocaterAyse();
        US09_Ayse1 ac01 = new US09_Ayse1();

        extentTest = extentReports.createTest("Hubcomfy", "Girilen maile onay mailinin gitmesi");
        ac01.start();
        //Vendor abc@abc.com adresini girer
        locaterAyse.e_mail.sendKeys("abc@abc.com");
        extentTest.info("Mail adresi girildi");
        //Vendor herhangi bir yere tiklar
        click(locaterAyse.herhangiBirYer);
        extentTest.info("Herhangi bir yer tiklandi");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOf(locaterAyse.verificationCodeText));
        extentTest.info("Verification bilgisinin gorulmesi icin beklendi");
        String actualResult = locaterAyse.verificationCodeText.getText();
        String expectedResult = "Verification code sent to your email: abc@abc.com.";
        assertEquals(expectedResult, actualResult);
        extentTest.pass("Verification kodunun maile gonderildigi yazisi goruldu");
        extentTest.pass("Driver kapatildi");
    }
}
