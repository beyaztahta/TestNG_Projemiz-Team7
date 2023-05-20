package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LocaterGonul {
    public LocaterGonul(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id=\"menu-item-1079\"]")
    public WebElement myAccountButonu;

    @FindBy(xpath = "//span[@class='icon-box-icon icon-addresses']")
    public WebElement adressButonu;

    @FindBy(id = "rememberme")
    public  WebElement rememberMe;

    @FindBy(xpath = "//input[@id='username']")
    public  WebElement siginuserName;

    @FindBy(id="password")
    public  WebElement siginpassword;

    @FindBy(xpath = "//button[@class='woocommerce-button button woocommerce-form-login__submit']")
    public  WebElement sigin;

    @FindBy(id="reg_username")
    public WebElement userNameBox;
    @FindBy(id = "reg_email")
    public WebElement e_mailBox;
    @FindBy(id = "reg_password")
    public WebElement userPasswordBox;
    @FindBy(id="register-policy")
    public WebElement policyAgreementBox;
    @FindBy(xpath = "//button[@name='register']")
    public WebElement userSignUpButton;


    @FindBy(css = "a[class='register inline-type'")
    public WebElement userRegisterButton;

    @FindBy(xpath = "(//a[@class='logo'])[1]")
    public WebElement homePageLogo;

    @FindBy(xpath = "//a[@href='https://hubcomfy.com/my-account-2/edit-address/shipping/']")
    public WebElement shippingaddButton;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement billingaddButton;

    @FindBy(id = "shipping_first_name")
    public WebElement shippingfirstName;

    @FindBy(id = "billing_first_name")
    public WebElement billingfirstName;

    @FindBy(id = "shipping_last_name")
    public WebElement shippinglastName;

    @FindBy(id = "billing_last_name")
    public WebElement billinglastName;

    @FindBy(id = "shipping_country")
    public WebElement shippingcountry;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
    public WebElement billingcountry;

    @FindBy(id = "shipping_address_1")
    public WebElement shippingstreet;

    @FindBy(id = "billing_address_1")
    public WebElement billingstreet;

    @FindBy(id="shipping_city")
    public WebElement shippingcity;

    @FindBy(id="billing_city")
    public WebElement billingcity;

    @FindBy(id="shipping_state")
    public WebElement shippingstate;

    @FindBy(id="billing_state")
    public WebElement billinggstate;

    @FindBy(id="shipping_postcode")
    public WebElement shippingpostcode;

    @FindBy(id="billing_postcode")
    public WebElement billingpostcode;

   @FindBy(id="billing_phone")
    public WebElement billingphone;

   @FindBy(id="billing_email")
    public WebElement billingemail;



    @FindBy(xpath = "//button[@class='btn btn-dark btn-rounded btn-sm']")
    public WebElement shippingsaveAdress;

    @FindBy(xpath = "//button[text()='Save address']")
    public WebElement billingsaveAdress;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement successMessage;

    @FindBy(xpath = "//*[@data-id='shipping_postcode']")
    public WebElement unsuccessMessage;


    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn_vendor;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut_vendor;

    @FindBy(xpath = "//a[text()='Sign Up']")
    public WebElement signUP;

   @FindBy(id = "select2-billing_state-container")
    public WebElement billingprovice;

   @FindBy(xpath = "//*[text()='Edit Your Billing Address']")
    public WebElement EditYourBillingAddress;


    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signoutButton;

    @FindBy(xpath = "//a[text()='Log out']")
    public WebElement logoutButton;


    @FindBy(id = "billing_country")
    public WebElement country;
   @FindBy(id = "billing_state")
    public WebElement ddmcounty;
@FindBy(id = "billing_first_name")
    public WebElement unsuccessMessageBilling;


}
