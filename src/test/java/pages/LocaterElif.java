package pages;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class LocaterElif {

    public LocaterElif() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //US14....
    //TC01
    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement myAccountButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='rememberme']")
    public WebElement rememberMe;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInLogin;

    @FindBy(xpath = "//a[normalize-space()='Store Manager']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "//span[normalize-space()='Products']")
    public WebElement productsButton;

    @FindBy(xpath = "//span[contains(text(),'Add New')]")
    public WebElement addNewButton;

    @FindBy(xpath = "//select[@id='product_type']")
    public WebElement simpleProductDropDown;

    //TC02
    @FindBy(id = "featured_img_display")
    public WebElement newFiles;

    @FindBy(id = "__wp-uploader-id-1")
    public WebElement selectFiles;

    //TC03
    @FindBy(id = "pro_title")
    public WebElement productTitle;

    @FindBy(xpath = "//*[@class='wcfm_product_manager_content_fields']")
    public WebElement empty;

    @FindBy(xpath = "(//iframe)[1]")
    public WebElement shortDescription;

    @FindBy(xpath = "//*[@id='tinymce']//p")
    public WebElement shortDescriptionTextBox;

    @FindBy(xpath = "(//iframe)[2]")
    public WebElement description;

    @FindBy(xpath = "//*[@id='tinymce']//p")
    public WebElement descriptionTextBox;

    //TC04
    @FindBy(xpath = "//strong[text()='Categories']")
    public WebElement categories;

    @FindBy(id = "product_cats_checklist")
    public WebElement categoriesPart;

    @FindBy(xpath = "//*[@data-super_parent='406']")
    public WebElement appoinment;

    @FindBy(xpath = "//p[normalize-space()='+Add new category']")
    public WebElement addNewCategory;

    @FindBy(id = "wcfm_new_cat")
    public WebElement categoryName;

    @FindBy(xpath = "//*[@data-taxonomy='product_cat']")
    public WebElement categoryAddClick;

    @FindAll({@FindBy(xpath = "//*[@id='product_cats_checklist']//li//span")})
    public List<WebElement> categoriesList;

    //TC05
    @FindBy(xpath = "//p[normalize-space()='+Add new Product brands']")
    public WebElement productBrandsLink;

    @FindAll({@FindBy(xpath = "//*[@id='product_brand']//li//span")})
    public List<WebElement>productBrandsList;

    @FindBy(xpath = "//input[@value='446']")
    public WebElement adidas;

    @FindBy(xpath = "//input[@id='wcfm_new_product_brand']")
    public WebElement productCategoryName;

    @FindBy(xpath = "//button[@data-taxonomy='product_brand']")
    public WebElement productAddClick;

    //TC06

    @FindBy(xpath = "//p[@class='description wcfm_full_ele wcfm_side_tag_cloud wcfm_fetch_tag_cloud']")
    public WebElement tagsClick;

    @FindBy(xpath = "//textarea[@id='product_tags']")
    public WebElement tagsTextBox;

    @FindAll({@FindBy(xpath = "//p[@class='description wcfm_full_ele wcfm_side_tag_cloud wcfm_fetch_tag_cloud']//ul")})
    public List<WebElement>tagsList;

    //TC07
    @FindBy(xpath = "//strong[normalize-space()='Catalog visibility:']")
    public WebElement catalogVisibility;

    @FindBy(xpath = "//select[@id='catalog_visibility']")
    public WebElement catalogVisibilityDropDown;


     //US03...............
    //AC1---TC01,TC02,TC03,TC04,TC05

    @FindBy(id="reg_username")
    public WebElement registerUsername;

    @FindBy(id="reg_email")
    public WebElement registermail;

    @FindBy(id="reg_password")
    public WebElement registerpassword;

    @FindBy(id = "register-policy")
    public WebElement registerBox;

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerSignIn;//register click

    @FindBy(xpath = "//button[text()='Sign Up']")
    public WebElement registerSignUp;
    @FindBy(linkText = "Addresses")
    public WebElement addresses;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement billingAdressesAdd;

    @FindBy(xpath = "//button[@name='save_address']")//saveadress butonu ile dogrulama,ayni zamanda save address butonu.
    public WebElement billingAdressesPage;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement billingFirstName;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement billingLastName;

    @FindBy(id = "billing_company")
    public WebElement billingCompanyName;

    @FindBy(id = "billing_country")
    public WebElement billingCountryRegion;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement billingStreetAddress;

    @FindBy(xpath = "//input[@id='billing_address_2']")
    public WebElement billingStreetAddress2;

   @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement billingTownCity;

    @FindBy(id = "billing_state")
    public WebElement billingState;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement billingZipCode;

    @FindBy(xpath = "//input[@id='billing_phone']")
    public WebElement billingPhoneNumber;

    @FindBy(id = "billing_email")
    public WebElement billingEmailVerify;

    @FindBy(xpath = "//li[contains(@class,'alert alert-simple alert-icon alert-close-top alert-danger')]")
    public WebElement billingFirstNameAlert;// first name alanı bos bırakıldıgında gelen alert.

    @FindBy(xpath = "//div[@role='alert']")//first name alanı 50 karakter gırildiginde gelen alert.
    public WebElement billing50FirstNameAlert;

    @FindBy(xpath = "//p[contains(text(),'The following addresses will be used on the checko')]")
    public WebElement  registrationPageText;//"Billing Address" kismina bilgilerin eklendigine dair text...



}
