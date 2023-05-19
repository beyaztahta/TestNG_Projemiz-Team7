package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LocaterOguzhan {

    public LocaterOguzhan(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//*[@class='product-media'])[1]")
    public WebElement urun;

    @FindBy(xpath = "(//*[@class=\"add_to_wishlist single_add_to_wishlist\"])[1]")
    public WebElement favoriurun;

    @FindBy(xpath = "//*[@class=\"w-icon-heart\"]")
    public WebElement wishlistbutton;

    @FindBy(xpath = "//*[@class=\"btn btn-quickview btn-outline btn-default btn-rounded btn-sm mr-lg-2\"]")
    public WebElement quickview;

    @FindBy(xpath = "//*[@class=\"btn btn-quickview btn-outline btn-default btn-rounded btn-sm mr-lg-2\"]")
    public WebElement quickviewbutton;

    @FindBy(xpath = "//*[@id=\"product-13182\"]/div[2]")
    public WebElement qv_urunozellikleri;

    @FindBy(xpath = "//*[@id=\"product-13182\"]/div[2]/div/form/button")
    public WebElement addtocard;

    @FindBy(xpath = "(//*[@class='w-icon-cart'])[1]")
    public WebElement cart;

    @FindBy(xpath = "(//*[@class=\"button wc-forward\"])")
    public WebElement viewcartt;

    @FindBy(xpath = "(//*[@class=\"button wc-forward\"])")
    public WebElement viewcart;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[2]/div[1]/form/table/tbody")
    public WebElement sepet;

    @FindBy(xpath = "//*[@class=\"checkout-button button alt wc-forward\"]")
    public WebElement proceedtocheckout;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div")
    public WebElement odemesayfasi;

    @FindBy(xpath = "(//*[@class=\"input-text \"])[1]")
    public WebElement firstname;

    @FindBy(xpath = "(//*[@class=\"input-text \"])[2]")
    public WebElement lastname;

    @FindBy(xpath = "(//*[@class=\"select2-selection__rendered\"])[1]")
    public WebElement country;

    @FindBy(xpath = "(//*[@class=\"input-text \"])[4]")
    public WebElement streetaddress;

    @FindBy(xpath = "(//*[@class=\"input-text \"])[6]")
    public WebElement postcode;

    @FindBy(xpath = "(//*[@class=\"input-text \"])[7]")
    public WebElement city;

    @FindBy(xpath = "(//*[@class=\"select2-selection__placeholder\"])")
    public WebElement province;

    @FindBy(xpath = "(//*[@class=\"input-text \"])[9]")
    public WebElement email;

    @FindBy(xpath = "(//*[@class=\"button alt\"])")
    public WebElement placeorder;







































}
