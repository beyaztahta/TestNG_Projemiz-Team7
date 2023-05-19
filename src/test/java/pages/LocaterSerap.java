package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class LocaterSerap {


    @FindBy(css = "*[id=\"menu-item-1079\"]")
    public WebElement myAccount;

    public LocaterSerap(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    //    1   llk Kayit
    @FindBy(xpath = "//*[@id='reg_username']")//username
    public WebElement username;

    @FindBy(xpath="//*[@id = 'reg_email']")//email
    public WebElement email;
    @FindBy(xpath = "//*[@id='reg_password']")
    public WebElement password;

    @FindBy(xpath = "(//*//*[@id='register-policy']")//register
    public WebElement registerPolicy;

    @FindBy(xpath = "//*[@name='register']")
    public WebElement signUp;

    //a[text()='Sign In']
    //    2    ARAMA KUTUSU
    @FindBy(xpath = "(//*[@class='form-control __web-inspector-hide-shortcut__']")//searchbox
    public WebElement searchbox;
    @FindBy(xpath = "//*[@class='w-icon-search']")
    public WebElement searchButton;

    //*[@class='w-icon-search']

//*[@name='register']    //span[text()='Sign In']

    //*[@for='password']

    //       3   SignIn

    @FindBy (css = "*[class=\"login inline-type\"]")
    public WebElement signIn;

    @FindBy(css = "*[id='username']")
    public WebElement signInEmail;


    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInButton;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement signInUsername;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement signInPassword;

    @FindBy(xpath = "//*[@value='Sign In']")
    public WebElement login;
    //*[@name='login']

    @FindBy(xpath = "//h2']")
    public WebElement MyAccounttitle;







    //(//*[@type='checkbox'])[1]

    //*[@id='register-policy']

    @FindBy(xpath = "//*[@id='\"header\"]/div/div/div/div/div/div/[9]/div/div/a[1]/span")//register
    public WebElement registerPolicy2;

    @FindBy(xpath = "//*//*[@name='register']")//signin
    public WebElement signUp1;

    @FindBy(xpath = "//*[@name='add-to-cart']")//AddToCart
    public WebElement addToCart;

    @FindBy(xpath = "//*[name='quantity']")//quantity
    public WebElement quantity;

    @FindBy(xpath = "//*[@class='w-icon-cart'][1]")//cart/sepet
    public WebElement cart;

    @FindBy(xpath = "//*[@class='button wc-forward']")//view cart
    public WebElement viewCart;

    @FindBy(xpath = "//*[@class='button checkout wc-forward']")//checkout
    public WebElement checkout;
    @FindBy(xpath = "//h3")//cartTotals
    public WebElement cartTotals;

    @FindBy(xpath = "//*[@id='select2-calc_shipping_country-container']")//cartTotals
    public WebElement cartTotalsUlke;
    @FindBy(xpath = "//*[@id='select2-calc_shipping_state-container']")//cartTotals
    public WebElement cartTotalsbolge;
    @FindBy(xpath = "//*[@id='calc_shipping_city']")//cartTotals
    public WebElement cartTotalsSehir;
    @FindBy(xpath="//*[@id='calc_shipping_postcode']")
    public WebElement postCode;


    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")//proceed checkout
    public WebElement proceedCheckout;

    @FindBy(xpath = "//h3 Billing details")//proceed checkout
    public WebElement billingDetails;

    @FindBy(xpath = "(//h2)[1] ")//
    public WebElement MyAccountPage;

    //a[text()='My Account']

    @FindBy(xpath = "//*[@id='menu-item-1079']")//
    public WebElement MyAccountlink;

    @FindBy(xpath="(//a[text()='Account details']")
    public WebElement accontDetails;

    @FindBy(xpath="(//*[@id='account_first_name']")
    public WebElement accontFirstName;

    //*[@id='account_first_name']
    @FindBy(xpath="(//*[@id='account_last_name']")
    public WebElement accontLastName;

    @FindBy(xpath="(//*[@id='account_display_name']")
    public WebElement accontDisplayName;

    @FindBy(xpath="(//*[@id='account_email']")
    public WebElement accontEmail;

    @FindBy(xpath="(//*[@for='user_description']")
    public WebElement biography;

    //*[@for='user_description']

    @FindBy(xpath="(//*[@id='password_current']")
    public WebElement currentPassword;
    //*[@id='password_current']

    @FindBy(xpath="(//*[@id='password_1']")
    public WebElement newPassword;

    //*[@id='password_1']

    @FindBy(xpath="(//*[@id='password_2']")
    public WebElement confirmPasssword;


    @FindBy(xpath="(//*[@value='Save changes']")
    public WebElement saveChanges;
    //*[@value='Save changes']

    @FindBy(xpath="//*[@id='calc_shipping_city']")
    public WebElement cityName;

    @FindBy(xpath="//*[@id='calc_shipping']")
    public WebElement updateTotals;
    //*[@name='calc_shipping']
    @FindBy(xpath="//*[@id='billing_first_name']")
    public WebElement billingDetailsFirstName;
    @FindBy(xpath="//*[@id='billing_last_name']")
    public WebElement billingDetailsLastName;
    @FindBy(xpath="//*[@id='billing_company']")
    public WebElement billingDetailsCompanyName;

    @FindBy(xpath="//*[@id='select2-billing_country-container']")
    public WebElement billingDetailsCountryName;

    @FindBy(xpath="//*[@id='billing_address_1']")
    public WebElement billingDetailsAdress;

    @FindBy(xpath="//*[@id='billing_address_2']")
    public WebElement billingDetailsApartmantName;

    @FindBy(xpath="//*[@id='billing_postcode']")
    public WebElement billingDetailsPostCode;

    @FindBy(xpath="//*[@id='billing_phone']")
    public WebElement billingDetailsPhone;

    @FindBy(xpath="//*[@id='select2-billing_state-container']")
    public WebElement billinggDetailsSehir;

    @FindBy(xpath="//*[@id='billing_email']']")
    public WebElement billingDetailsEmail;


    @FindBy(xpath="//*[@id='order_review_heading']")
    public WebElement siparis;

    @FindBy(xpath="//h4[1]']")
    public WebElement odemeSecenegi;

    @FindBy(xpath="//*[@id='payment_method_bacs']")
    public WebElement EFTHavale;

    @FindBy(xpath="//*[@id='payment_method_cod']")
    public WebElement kapidaOdeme;
    @FindBy(xpath="//*[@name='woocommerce_checkout_place_order']")
    public WebElement placeOrder;
    //*[@name='woocommerce_checkout_place_order']

    @FindBy(xpath="//*[@class='quantity-plus w-icon-plus']")
    public WebElement quantityplus;

    @FindBy(xpath="//*[@class='quantity-minus w-icon-minus']")
    public WebElement quantityminus;

    @FindBy(xpath="//*[@name='apply_coupon']")
    public WebElement applyCoupon;
    @FindBy(xpath="//*[@id='coupon_code']")
    public WebElement couponCode;
    @FindBy(xpath="//*[@class='showcoupon']")
    public WebElement enterYourCode;


    // YENİ
    @FindBy(xpath="//*[@value='Sign In']")
    public WebElement signInButton2;
    @FindBy(xpath="(//h2)[1]")
    public WebElement verifyMyAccountProfile;
    @FindBy(partialLinkText = "Account details")
    public WebElement verifyAccountDetails;
    @FindBy(partialLinkText = "Account details")
    public WebElement AccountDetails;
    @FindBy(xpath = "(//h4)[2]")
    public WebElement verifyAccountDetailsProfile;

    @FindBy(id="account_first_name")
    public WebElement firstName;
    @FindBy(css = "*[value='Save changes']")
    public WebElement saveChangesButton;








    //*[@class='showcoupon']







    //@FindBy(xpath="//*[@class='checkout-button button alt wc-forward']")
    //public WebElement proceedCheckout;

    //*[@id='billing_first_name']







//*[@class='checkout-button button alt wc-forward']

    /*
searchbox
(//*[@type='search'])[1]
username
//*[@id='reg_username']

email
//*[@id='reg_email']
//*[@id='reg_password'] password

//*[@id='register-policy']

//*[@type='submit'][1]   signin
//*[@name='add-to-cart']  add to cart

 //*[@name='quantity']   quantity

//*[@class='w-icon-cart'][1] cart bolumu

//*[@class='button wc-forward']  view cart bolumu
//*[@class='button checkout wc-forward'] checkout bolumu
//*[@id='select2-calc_shipping_country-container'] cart totals bolumu ulke

//*[@id='calc_shipping_city']//shipping city sehir bolumu
//*[@id='calc_shipping_city']//shipping city sehir bolumu
//*[@id='calc_shipping_postcode']//postakodu

////h5 // coupon discount
//*[@id='coupon_code']// kupon kod
//*[@name='apply_coupon'] kupon olustur Apply kupon

//*[@class='showcoupon']//Enter your code


//*[@id='billing_first_name']
//*[@id='billing_last_name']
//*[@id='billing_company']
//*[@id='select2-billing_country-container']
//*[@id='billing_address_1']
//*[@id='billing_address_2']
//*[@id='billing_postcode']

//*[@id='billing_city']//town/city
//*[@id='select2-billing_state-container']//province

//*[@id='billing_email']//
//*[@id='billing_email_field']// bu da alanlar icin locate
//*[@id='billing_phone']

//*[@id='order_review_heading']//your orders

//h4[1]// payment Methods
//*[@id='payment_method_bacs']//eft/wire transfer

//*[@id='payment_method_cod']//kapida odeme
     */

//*[@class='quantity-plus w-icon-plus']//plus arti ekleme

    //burasi locateler sayfasi

}

