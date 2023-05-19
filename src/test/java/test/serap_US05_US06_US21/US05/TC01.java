package test.serap_US05_US06_US21.US05;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import pages.LocaterSerap;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
public class TC01 {

    //US05	TC01	Kullanıcı hesap detaylarını (Account Details) görebilmeli

    LocaterSerap serap = new LocaterSerap();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));

    @BeforeClass
    public void beforeClass() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        serap.signIn.click();
        serap.signInEmail.sendKeys(ConfigReader.getProperty("serapUserName"), Keys.TAB,ConfigReader.getProperty("serapPass"));
        serap.signInButton.click();
        ReusableMethods.bekle(3);
    }

    @Test
    public void testStep02_03(){
        //2	Kullanıcı sağ üst köşede My Account butonuna tıklar.
        //3	Kullanıcı My Account profilini görüntüler.
        serap.myAccount.click(); //TestStep02
        assertTrue(serap.verifyMyAccountProfile.isDisplayed());//TestStep03
    }

    @Test
    public void testStep04_05_06(){
        //4	Kullanıcı sol tarafta Account Details sekmesini görüntüler.
        //5	Kullanıcı sol tarafta Account Details sekmesine tıklar.
        //6	Kullanıcı başarılı bir şekilde hesap detaylarını görüntüler.
        ReusableMethods.extentReport();

        assertTrue(serap.verifyAccountDetails.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(serap.AccountDetails));
        js.executeScript("arguments[0].scrollIntoView(true);",serap.AccountDetails);
        js.executeScript("arguments[0].click();",serap.AccountDetails);
        ReusableMethods.bekle(3);
        assertTrue(serap.verifyAccountDetailsProfile.isDisplayed());
    }
    @AfterClass
    public void afterClass() {
        ReusableMethods.bekle(5);
        Driver.getDriver().close();
        ReusableMethods.bekle(5);
    }
}