package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LocaterMuhammedAli {

    public LocaterMuhammedAli() {
// USER STORY 11 --------------------------------------------------------------------------------------------
    PageFactory.initElements(Driver.getDriver(), this);}   // US11-TC01-Adres erişilebilir olmalıdır.

    @FindBy(xpath = "//*[text()='Sign In']")                    // US11-TC01-Buton, aktif olamlı ve istenilen pencereye ulaştırabilmeli
    public WebElement signInButton;

                                                                //Pencere görüntülenebilmeli


    @FindBy(id = "username")                                    //E-mail adresi girilebilmeli
    public WebElement userNameGir;
    @FindBy(id = "password")                                    //Şifre girilebilmeli
    public WebElement sifreGir;
    @FindBy(name = "login")                                     //Sign in butonu tıklanabilir olmalı
    public WebElement loginOnay;
    @FindBy(id = "menu-item-1079")                              //My account sayfası görüntülenebilmeli
    public WebElement MyAccountTikla;
    @FindBy(xpath = "(//*[text()='Orders'])[2]")                //My account sayfasında Orders görüntülenebilmeli
    public WebElement OrdersGorulmeli;
    @FindBy(xpath = "(//*[text()='Downloads'])[2]")             //My account sayfasında Downloads görüntülenebilmeli
    public WebElement MyAccount_Download_Gorulmeli;
    @FindBy(xpath = "(//*[text()='Addresses'])[2]")             //My account sayfasında addresses görüntülenebilmeli
    public WebElement AddressesVarmi;
    @FindBy(xpath = "(//*[text()='Account details'])[2]")       //My account sayfasında account details görüntülenebilmeli
    public WebElement Account_detailsVarmi;
    @FindBy(xpath = "(//*[text()='Wishlist'])[3]")              //My account sayfasında whislist görüntülenebilmeli
    public WebElement WishlistVarmi;
    @FindBy(xpath = "(//*[text()='Logout'])[2]")                //My account sayfasında Logout görüntülenebilmeli
    public WebElement LogoutVarmi;
    @FindBy(xpath = "(//*[text()='Store Manager'])[1]")         //My account sayfasında, Dashboard altında Store Manager görüntülenmeli
    public WebElement DashboardAltindaStore_ManagerVarmi;
    @FindBy(xpath = "(//*[text()='Orders'])[1]")                //My account sayfasında, Dashboard altında orders görüntülenmeli
    public WebElement DashboardAltindaOrdersVarmi;
    @FindBy(xpath = "(//*[text()='Downloads'])[1]")             //My account sayfasında, Dashboard altında downloads görüntülenmeli
    public WebElement DashboardAltindaDownloadsVarmi;
    @FindBy(xpath = "(//*[text()='Addresses'])[1]")             //My account sayfasında, Dashboard altında address görüntülenmeli
    public WebElement DashboardAltindaAddressesVarmi;
    @FindBy(xpath = "(//*[text()='Account details'])[1]")       //My account sayfasında, Dashboard altında account details görüntülenmeli
    public WebElement DashboardAltindaAccount_detailsVarmi;
    @FindBy(xpath = "(//*[text()='Wishlist'])[2]")              //My account sayfasında, Dashboard altında wishlist görüntülenmeli
    public WebElement DashboardAltindaWishlistVarmi;
    @FindBy(xpath = "(//*[text()='Support Tickets'])[1]")       //My account sayfasında, Dashboard altında Support tickets görüntülenmeli
    public WebElement DashboardAltindaSupport_TicketslistVarmi;
    @FindBy(xpath = "(//*[text()='Followings'])[1]")            //My account sayfasında, Dashboard altında followings görüntülenmeli
    public WebElement DashboardAltindaFollowingslistVarmi;
    @FindBy(xpath = "(//*[text()='Logout'])[1]")                //My account sayfasında, Dashboard altında log out görüntülenmeli
    public WebElement DashboardAltindaLogoutlistVarmi;


// USER STORY 13

    @FindBy(xpath = "(//*[text()='Addresses'])[1]")               //Adress seçeneği tıklanabilir olmalı
    public WebElement AdresSecenegiTik;
    @FindBy(xpath = "//*[@class='icon-box-title text-normal']")   //Adres sayfası açılmalı
    public WebElement AdresSayfasiAc;
    @FindBy(xpath = "//*[text()='Edit Your Shipping Address']")   //EDIT YOUR SHIPPING ADDRESS seçeneği tıklanılabilmeli
    public WebElement ShippingAdresADD_Tikla;
    @FindBy(id = "shipping_first_name")                           //First name yazı alanına isim girilebilmeli
    public WebElement FirstNameAlaninaIsimGir;
    @FindBy(id = "shipping_last_name")                            //Last name yazı alanına isim girilebilmeli
    public WebElement LastNameAlaninaIsimGir;
    @FindBy(id = "select2-shipping_country-container")            //Country/Region alanında ülke adı seçilebilmeli
    public WebElement CountrRegionAlaniUlkeSec;
    @FindBy(id = "shipping_address_1")                             //Street address alanının 1. satırına adres girilebilmeli
    public WebElement StreatAddressAlaninaAdresGir;
    @FindBy(id = "shipping_address_2")                             //Street address alanının 2. satırına adresin devamı girilebilmeli
    public WebElement StreatAddress2AlaninaAdresGir;
    @FindBy(id = "shipping_city")                                  //Town / City alanına şehir asmi girilebilmeli
    public WebElement TownCityAlaninaSehirGir;
                                                                  //State alanına bilgi girilebilmeli

    @FindBy(id = "shipping_postcode")                              //ZIP Code alanına bilgi girilebilmeli
    public WebElement ZipCodeAlaninaBilgiGir;
    @FindBy(xpath = "//*[@name='save_address']")                  //SAVE ADDRESS butonu tıklanabilir olmalı
    public WebElement SaveaddressButonuTikla;
    @FindBy(xpath = "//*[@role()='alert']")                  //SAVE ADRDRESS butonuna tıklandıktan sonra adresin kaydedildiği sonucu görüntülenmeli
    public WebElement KayitliSayfaGoruntule;
}