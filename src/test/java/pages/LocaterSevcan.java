package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LocaterSevcan {
    public LocaterSevcan (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement register;
    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement email;
    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement password;
    @FindBy(xpath = "//label[text()='I agree to the privacy policy']")
    public WebElement radioButton;
    @FindBy (xpath = "(//button[@type='submit'])[2]")
    public WebElement signupButton;
    @FindBy(xpath = "(//a[text()='Shop Now'])[2]")
    public WebElement shopNowText;
    @FindBy(xpath = "//p[text()='Please enter a valid account username.']")
    public WebElement usernameUyariMesaji;
    @FindBy(xpath = "//p[text()='Username may not be longer than 60 characters.']")
    public WebElement usernameFazlaysaUyariMesaji;


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

}

