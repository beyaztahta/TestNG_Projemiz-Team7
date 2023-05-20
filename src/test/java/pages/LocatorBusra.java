package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LocatorBusra {


    public LocatorBusra(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[9]/div/div/a[1]/span")
    public WebElement signIn;


    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"signin\"]/form/button")
    public WebElement signInButton;


    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[3]/div/div/form/input[2]")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"product-25781\"]/div[2]/div/form/div/div/div/button")
    public WebElement addCartButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/a/i")
    public WebElement cartIcon;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[2]")
    public WebElement checkOutButton;

    @FindBy(id = "billing_first_name")
    public WebElement firstnameBox;

    @FindBy(xpath = "//*[@id=\"order_review\"]")
    public WebElement reviewOrderButton;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/p")
    public WebElement successfulText;

    @FindBy(xpath = "//*[@id=\"menu-item-1066\"]/a")
    public WebElement myOrdersButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div")
    public WebElement orderScreen;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/a")
    public WebElement enterYourCoupon;

    @FindBy(id = "coupon_code")
    public WebElement couponCodeBox;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[1]/div[1]/button")
    public WebElement couponApplyButton;


}
