package test.serap_US05_US06_US21.US05;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LocaterSerap;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TC02 {

    //TC02  First name bilgilerini değiştirebilmeli
    LocaterSerap serap = new LocaterSerap();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Faker faker = new Faker();
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
    public void test01(){
        //2 Kullanıcı sağ üst köşede My Account butonuna tıklar.
        //3 Kullanıcı My Account profilini görüntüler.
        serap.myAccount.click(); //TestStep02
        assertTrue(serap.verifyMyAccountProfile.isDisplayed());
    }
    @Test
    public void test02(){
        //4 Kullanıcı sol tarafta Account Details sekmesini görüntüler.
        serap.myAccount.click();
        assertTrue(serap.verifyAccountDetails.isDisplayed());
    }
    @Test
    public void test03(){
        //5 Kullanıcı firstName kutucuğunu doldurur.
        serap.myAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(serap.AccountDetails));
        js.executeScript("arguments[0].scrollIntoView(true);",serap.AccountDetails);
        js.executeScript("arguments[0].click();",serap.AccountDetails);
        serap.firstName.clear();
        serap.firstName.sendKeys(faker.name().name().split(" ")[0]);
        js.executeScript("arguments[0].scrollIntoView(true);",serap.saveChangesButton);
        wait.until(ExpectedConditions.visibilityOf(serap.saveChangesButton));
        js.executeScript("arguments[0].click();",serap.saveChangesButton);
    }

    @Test
    public void test04(){
        //5 Kullanıcı lastName kutucuğunu doldurur.
        serap.myAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(serap.AccountDetails));
        js.executeScript("arguments[0].scrollIntoView(true);",serap.AccountDetails);
        js.executeScript("arguments[0].click();",serap.AccountDetails);
        WebElement lastname = Driver.getDriver().findElement(By.cssSelector("*[name='account_last_name']"));
        lastname.clear();
        lastname.sendKeys(faker.name().name().split(" ")[0]);
        js.executeScript("arguments[0].scrollIntoView(true);",serap.saveChangesButton);
        wait.until(ExpectedConditions.visibilityOf(serap.saveChangesButton));
        js.executeScript("arguments[0].click();",serap.saveChangesButton);
    }

    @Test
    public void testStep05() {
        //5 Kullanıcı lastName kutucuğunu doldurur.
        serap.myAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(serap.AccountDetails));
        js.executeScript("arguments[0].scrollIntoView(true);", serap.AccountDetails);
        js.executeScript("arguments[0].click();", serap.AccountDetails);
        WebElement displayName = Driver.getDriver().findElement(By.cssSelector("*[name='account_display_name']"));
        displayName.clear();
        displayName.sendKeys(faker.name().name().split(" ")[0]);
        js.executeScript("arguments[0].scrollIntoView(true);", serap.saveChangesButton);
        wait.until(ExpectedConditions.visibilityOf(serap.saveChangesButton));
        js.executeScript("arguments[0].click();", serap.saveChangesButton);
    }
    @Test
    public void test06(){
    //5 Kullanıcı email kutucuğunu doldurur.
        serap.myAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(serap.AccountDetails));
        js.executeScript("arguments[0].scrollIntoView(true);",serap.AccountDetails);
        js.executeScript("arguments[0].click();",serap.AccountDetails);
    WebElement email = Driver.getDriver().findElement(By.cssSelector("*[name='account_email']"));
        email.clear();
        email.sendKeys(faker.name().firstName().toLowerCase()+"@yahoo.com");
        js.executeScript("arguments[0].scrollIntoView(true);",serap.saveChangesButton);
        wait.until(ExpectedConditions.visibilityOf(serap.saveChangesButton));
        js.executeScript("arguments[0].click();",serap.saveChangesButton);
    }

    @Test
    public void test07(){
        //5 Kullanıcı biography kutucuğunu doldurur.
        serap.myAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(serap.AccountDetails));
        js.executeScript("arguments[0].scrollIntoView(true);",serap.AccountDetails);
        js.executeScript("arguments[0].click();",serap.AccountDetails);
        Driver.getDriver().switchTo().frame(0);
        WebElement biography = Driver.getDriver().findElement(By.cssSelector("*[data-id='user_description']"));
        biography.clear();
        biography.sendKeys(faker.funnyName().name());
        Driver.getDriver().switchTo().parentFrame();
        js.executeScript("arguments[0].scrollIntoView(true);",serap.saveChangesButton);
        wait.until(ExpectedConditions.visibilityOf(serap.saveChangesButton));
        js.executeScript("arguments[0].click();",serap.saveChangesButton);
    }

    @Test
    public void test08() {
        //5 Kullanıcı password u degistirebilmelidir.
        serap.myAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(serap.AccountDetails));
        js.executeScript("arguments[0].scrollIntoView(true);", serap.AccountDetails);
        js.executeScript("arguments[0].click();", serap.AccountDetails);
        WebElement password1 = Driver.getDriver().findElement(By.cssSelector("*[name='password_current']"));
        password1.clear();
        WebElement password2 = Driver.getDriver().findElement(By.cssSelector("*[id='password_1']"));
        password2.clear();
        WebElement password3 = Driver.getDriver().findElement(By.cssSelector("*[id='password_2']"));
        password3.clear();
        js.executeScript("arguments[0].scrollIntoView(true);", serap.saveChangesButton);
        wait.until(ExpectedConditions.visibilityOf(serap.saveChangesButton));
        js.executeScript("arguments[0].click();", serap.saveChangesButton);
    }

    @AfterClass
    public void afterClass() {
        Driver.getDriver().get(ConfigReader.getProperty("a2you_Url"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Sign Out']")).click();
        Driver.getDriver().findElement(By.xpath("//*[text()='Log out']")).click();
        ReusableMethods.bekle(5);
        Driver.getDriver().close();
    }
}
