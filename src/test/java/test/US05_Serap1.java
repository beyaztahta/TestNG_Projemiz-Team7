package test;

import org.openqa.selenium.interactions.Actions;
import pages.LocaterGonul;
import pages.LocaterMali;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import pages.LocaterSerap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
public class US05_Serap1 {

    //US05	TC01	Kullanıcı hesap detaylarını (Account Details) görebilmeli


    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));
    LocaterMali locate=new LocaterMali();

    Actions actions;

    @BeforeClass
    public void beforeClass() {
        LocaterSerap serap = new LocaterSerap();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
      //  Driver.getDriver().manage().window().maximize();
      //  Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        serap.signIn.click();
        serap.signInEmail.sendKeys(ConfigReader.getProperty("serapUserName"), Keys.TAB,ConfigReader.getProperty("serapPass"));
        ReusableMethods.bekle(3);
        //serap.signInButton.click();
        locate.signInButton.click();
        ReusableMethods.bekle(3);
    }

    @Test
    public void testStep02_03(){
        LocaterSerap serap = new LocaterSerap();
        LocaterGonul locaterGonul=new LocaterGonul();
        //2	Kullanıcı sağ üst köşede My Account butonuna tıklar.
        //3	Kullanıcı My Account profilini görüntüler.
        ReusableMethods.bekle(5);
        actions=new Actions(Driver.getDriver());
        actions.moveToElement(serap.sayfasonuText);

        //     Sayfanın en altındaki My Account butonuna tıklar.
        ReusableMethods.scroll(locaterGonul.myAccountButonu);
        ReusableMethods.bekle(3);
        locaterGonul.myAccountButonu.click();

        assertTrue(serap.verifyMyAccountProfile.isDisplayed());//TestStep03
    }

    @Test  (dependsOnMethods = "testStep02_03")
    public void testStep04_05_06(){
        LocaterSerap serap = new LocaterSerap();
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