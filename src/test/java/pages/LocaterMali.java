package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class LocaterMali {
   public LocaterMali() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement signInInputMail;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement signInInputPassword;

    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManagerButton;
    @FindBy(xpath = "//h2[text()='Store Manager']")
    public WebElement storeManagerTitle;

   @FindBy(xpath = "(//span[@class='wcfmfa fa-cube'])[1]")
   public WebElement productButton;

    @FindBy(xpath = "//a[@href='https://hubcomfy.com/store-manager/products-manage/']")
    public WebElement addNewButton;

    @FindBy(xpath = "//span[text()='Manage Product']")
    public WebElement manageProductText;

    @FindBy(id = "product_type")
    public WebElement ddMunuSimpleVariable;

    @FindBy(xpath = "//*[@id='is_virtual']")
    public WebElement checkboxVirtual;

    @FindBy(id = "is_downloadable")
    public WebElement checkboxDownloadable;

   @FindBy(id = "regular_price")
   public WebElement priceBox;
   @FindBy(id = "sale_price")
   public WebElement salePriceBox;

   @FindBy(id = "pro_title")
    public WebElement titleProduct;

    @FindBy(id = "featured_img_display")
    public WebElement bigImg;
    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement smallImg1;
    @FindBy(id = "gallery_img_gimage_1_display")
    public WebElement smallImg2;
    @FindBy(xpath = "(//span[@title='Add New Block'])[1]")
    public WebElement addsmallImg;

    @FindBy(id = "__wp-uploader-id-1")
    public WebElement selectFile;
    @FindBy(id = "__wp-uploader-id-4")
    public WebElement selectFile2;

    @FindBy(id = "description_ifr")
    public WebElement descriptionIF;
   @FindBy(id = "excerpt_ifr")
    public WebElement shortdescriptionIF;

    @FindBy(xpath = "//body[@data-id='description']")
    public WebElement description;
    @FindBy(xpath = "//body[@data-id='excerpt']")
    public WebElement shortDescription;

    @FindBy(xpath = "//button[text()='Select']")
    public WebElement selectButton;
    @FindBy(id = "(//iframe)[1]")
    public WebElement uploadIframe;
    @FindBy(xpath = "//input[@value='229']")
    public WebElement checkboxAcc;

    @FindBy(id= "wcfm_products_simple_submit_button")
    public WebElement submitButton;
   @FindBy(xpath = "(//button[@id='menu-item-upload'])[2]")
   public WebElement uploadFileButton;
    @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
    public WebElement addToGalaryButton;

    @FindBy(xpath = "//*[text()='Published']")
    public WebElement publishedText;
    @FindBy(xpath = "(//*[contains(text(),'Successfully Published.')])[2]")
    public WebElement lanetText;
    @FindBy(xpath = "(//a[text()='İsimlikli Dolma Kalem'])[1]")
    public WebElement publishedProductName;
    @FindBy(xpath = "(//img)[4]")
    public WebElement pictureProduct;
   @FindBy(xpath = "(//bdi)[1]")
   public WebElement price;

    @FindBy(xpath = "(//span[@class='instock'])[1]")
    public WebElement ınStock;
    @FindBy(xpath = "//div[text()='Attributes']")
    public WebElement attributesButton;

    @FindBy(id= "attributes_is_active_1")
    public WebElement colorCheckBox;
    @FindBy(id= "attributes_is_active_2")
    public WebElement sizeCheckBox;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    public WebElement colorInputBox;
    @FindBy(xpath = "//select[@id='attributes_value_2']")
    public WebElement sizeInputDDM;

   @FindBy(xpath = "(//li[@class='select2-selection__choice'])[2]")
   public WebElement sizeText;
    @FindBy(xpath = "//strong[text()='Catalog visibility:']")
    public WebElement catalogVisibility;

 @FindBy(xpath = "(//button[text()='Add New'])[1]")
 public WebElement addNewColorButton;
 @FindBy(xpath = "(//button[text()='Add New'])[2]")
 public WebElement addNewSizeButton;
 @FindBy(xpath = "//div[text()='Variations']")
 public WebElement variationButton;

 @FindBy(xpath = "(//select[@class='wcfm-select wcfm_ele wcfm_half_ele default_attribute_ele attribute_ele variable attribute_ele_old'])[1]")
 public WebElement variationColor;
 @FindBy(xpath = "(//select[@class='wcfm-select wcfm_ele wcfm_half_ele default_attribute_ele attribute_ele variable attribute_ele_old'])[2]")
 public WebElement variationsize;

 @FindBy(xpath = "//input[@value=\"446\"]")
 public WebElement checkBoxAdidas;
 @FindBy(xpath = " //input[@value=\"298\"]\n")
 public WebElement checkboxApple;
 @FindBy(xpath = "//input[@value=\"519\"]")
 public WebElement checkboxElektronik;

 @FindBy(xpath = "//*[@id=\"wcfm-products\"]/tbody/tr[1]/td[12]/a[2]")
 public WebElement viewButton;
 @FindBy(xpath = "//h1[@class='product_title entry-title']")
 public WebElement publishedTitle;


























}
