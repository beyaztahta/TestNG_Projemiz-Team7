package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CustomerRegisterLocates {
    //US_01_02

    public CustomerRegisterLocates() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='header']/div/div/div/div/div/div[9]/div/div/a[2]/span")

    public WebElement Register_Button;

    @FindBy(xpath = "/html/body/div[2]/header/div/div/div/div/div/div[9]/div/div/a[1]")

    public WebElement sign_In_Buton;

    @FindBy(id = "reg_username")
    public WebElement User_Name_Input;

    @FindBy(xpath = "//*[@id='reg_email']")
    public WebElement E_Mail_Input;

    @FindBy(xpath = "//*[@id='reg_password']")
    public WebElement Password_Input;

    @FindBy(xpath = "//*[@id='register-policy']")
    public WebElement Register_Policy_Check;

    @FindBy(xpath = "//*[@id='signup']/form/button")
    public WebElement Singup_Button;

    @FindBy(id = "e9b716e")
    public WebElement Profile;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signoutButton;

    @FindBy(xpath = "(//a[text()='Shop Now'])[2]")
    public WebElement shopNowText;
    @FindBy(xpath = "//a[text()='Log out']")
    public WebElement logoutButton;


    //////////..............US-02...................//////////////

    @FindBy (xpath = "(//p[@class='submit-status'])[2]")
    public WebElement emailHataMesaji;


    /////////////...............US-10................./////////////
    @FindBy(xpath = "//a[text()='Become a Vendor']")
    public WebElement vendorButton;
    @FindBy (xpath = "//input[@id='user_email']")
    public WebElement vendorEmail;
    @FindBy (xpath = "(//input[@type='text'])[2]")
    public WebElement verificationCode;
    @FindBy (xpath = "//input[@type='button']")
    public WebElement reSendCode;
    @FindBy (xpath = "(//input[@type='password'])[1]")
    public WebElement vendorPassword1;
    @FindBy (xpath = "(//input[@type='password'])[2]")
    public WebElement vendorPassword2;
    @FindBy (xpath = "//input[@type='submit']")
    public WebElement vendorRegister;


    @FindBy(xpath = "//*[text()='Too short']")//passwordda kisa oldu dogrulama
    public WebElement tooShort;
    @FindBy(xpath = "//*[text()='Weak']")//passwordda zayif oldugunu dogrulama
    public WebElement Weak;
    @FindBy(xpath = "//*[@id='password_strength']")//paasword kisminda olan paralo gucu en az good seviyesinde olmalidir dogrulama
    public WebElement good;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement zayifveyakisaOlanPass;//zayif veya kisa oldugu durumlarda cikan uyari
    @FindBy(xpath = "//div[@class='strong']")
    public WebElement strong;


}

