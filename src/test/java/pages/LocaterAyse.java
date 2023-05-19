package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LocaterAyse {


=======
public LocaterAyse(){
    PageFactory.initElements(Driver.getDriver(),this);

}


    @FindBy (xpath = "(//i[@class='w-icon-account'])[1]")
    public WebElement signIn;
   // @FindBy(xpath = "//*[@id=\"header\"]//a[@class='login inline-type']/span")
   // public WebElement signinlink;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement signinButton;

    @FindBy(linkText = "My Account")
    public WebElement myAccount;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;

    @FindBy(xpath = "//a[@class='wcfm_menu_item active']")
    public WebElement products;
    @FindBy(xpath = "//a[@href='https://hubcomfy.com/store-manager/products-manage/']")
    public WebElement addNew;


    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_inventory_head']")
    public WebElement inventory;

    @FindBy(id = "wcfm_products_manage_form_shipping_head")
    public WebElement shipping;
    @FindBy(id= "wcfm_products_manage_form_attribute_head")
    public WebElement attributes;

    @FindBy(id = "wcfm_products_manage_form_linked_head")
    public WebElement linked;
    @FindBy(id = "wcfm_products_manage_form_yoast_head")
    public WebElement seo;

    @FindBy(id = "wcfm_products_manage_form_toptan-urun-gosterme-ayarlari_head")
    public WebElement toptanUrun;

    @FindBy(id = "wcfm_products_manage_form_advanced_head")
    public WebElement advanced;
    //SKU
    @FindBy(xpath = "//input[@id='sku']")
    public WebElement skuBox;
    @FindBy(xpath = "//select[@id='stock_status']")
    public WebElement stockStatus;
    @FindBy(xpath = "(//strong)[17]")
    public WebElement stockStatusTitle;
    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manageStockCheckbox;
    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement stockQtyBox;
    @FindBy(xpath = "//select[@id='backorders']")
    public WebElement allowBackOrderddm;
    @FindBy(xpath = "//input[@id='sold_individually']")
    public WebElement soldIndividually;
    ///Shipping
    @FindBy(xpath = "//input[@id='weight']")
    public WebElement weight;
    @FindBy(xpath = "//input[@id='length']")
    public WebElement dimensionsLength;
    @FindBy(xpath = "//input[@id='width']")
    public WebElement dimensionsWidth;
    @FindBy(xpath = "//input[@id='height']")
    public WebElement dimensionsHeight;
    @FindBy(xpath = "//select[@id='shipping_class']")
    public WebElement shippingClassDdm;
    @FindBy(xpath = "//select[@id='_wcfmmp_processing_time']")
    public WebElement processingTimeDdm;
    //Attributes
    @FindBy(xpath = "//input[@id='attributes_is_active_1']")
    public WebElement attributesColorCheckbox;
    @FindBy(xpath = "(//span[@title='Toggle Block'])[2]")
    public WebElement attributesActiveArrow;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    public WebElement attributesColorDdm;
    @FindBy(xpath = "//input[@id='attributes_is_active_1']")

    public WebElement attributesColorActiveCheckbox;

    @FindBy(xpath = "(//button[text()='Select all'])[1]")
    public WebElement attributesColorSelectAllButton;
    @FindBy(xpath = "(//button[text()='Select none'])[1]")
    public WebElement attributesColourSelectNoneButton;
    @FindBy(xpath = "(//button[text()='Add New'])[1]")
    public WebElement attributesColorAddNewButton;//Buttona tiklayinca alert acildi!!! text gonderebiliyorum Ok ve cancel buttonu var
    @FindBy(xpath = "//input[@id='attributes_is_visible_1']")
    public WebElement attributesVisibleOnTheProductPage1;
    //attributes Size kismi
    @FindBy(xpath = "//input[@id='attributes_is_active_2']")
    public WebElement attributesSizeCheckbox;
    @FindBy(xpath = "(//span[@title='Toggle Block'])[3]")
    public WebElement attributesSizeArrow;
    @FindBy(xpath = "(//*[@aria-live='polite'])[3]")
    public WebElement attributesSizeDdm;
    @FindBy(xpath = "(//button[text()='Select all'])[2]")
    public WebElement attributesSizeSelectAllButton;
    @FindBy(xpath = "(//button[text()='Select none'])[2]")
    public WebElement attributesSizeSelectNoneButton;
    @FindBy(xpath = "(//button[text()='Add New'])[2]")
    public WebElement attributesSizeAddNewButton;
    @FindBy(id = "getAttributesAddAttributeAddName")
    public WebElement addNewProduct;
    @FindBy(xpath = "(//span[@title='Toggle Block'])[4]")
    public WebElement arrow;
    @FindBy(xpath = "//input[@id='attributes_is_visible_2']")
    public WebElement attributesVisibleOnTheProductPage2;
    @FindBy(xpath = "//select[@name='wcfm_attribute_taxonomy']")
    public WebElement attributesAddAttributeDdm;
    @FindBy(xpath = "//button[@class='button wcfm_add_attribute']")
    public WebElement getAttributesAddAttributeAddButton;
    @FindBy(xpath = "//textarea[@id='attributes_value_3']")
    public WebElement getAttributesAddAttributeAddValue;
    @FindBy(xpath = "//input[@id='getAttributesAddAttributeAddName']")
    public WebElement getAttributesAddAttributeAddName;
    @FindBy(xpath = "//input[@id='attributes_is_visible_3']")
    public WebElement attributesVisibleOnTheProductPage;


    //Linked
    @FindBy(xpath = "(//input[@class='select2-search__field'])[4]")
    public WebElement linkedUpSells;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[4]")
    public WebElement linkedCrossSells;
    //seo
    @FindBy(xpath = "//input[@id='yoast_wpseo_focuskw_text_input']")
    public WebElement seoEnterF;
    @FindBy(xpath = "//textarea[@id='yoast_wpseo_metadesc']")
    public WebElement seoMetaDesc;
    //Toplam urun gosterme

    @FindBy(xpath = "//select[@id='piecetype']")
    public WebElement pieceTypeDdm;
    @FindBy(xpath = "//input[@id='unitpercart']")
    public WebElement unitsPerPiece;
    @FindBy(xpath = "//input[@id='minorderqtytr']")
    public WebElement minOrderQuantity;

    //advanced

    @FindBy(xpath = "//input[@id='enable_reviews']")
    public WebElement enableReviews;
    @FindBy(xpath = "//input[@id='menu_order']")
    public WebElement menuOrder;
    @FindBy(xpath = "//textarea[@id='purchase_note']")
    public WebElement purchaseNote;


}