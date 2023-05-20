package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LocaterMuhammedAli {
    // US11-TC01-Adres erişilebilir olmalıdır
    public LocaterMuhammedAli() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")    // US11-TC01-Buton, aktif olamlı ve istenilen pencereye ulaştırabilmeli
    public WebElement signInButton;

    //Pencere görüntülenebilmeli

    //E-mail adresi girilebilmeli
    @FindBy(id = "username")
    public WebElement userNameGir;

    //Şifre girilebilmeli
    @FindBy(id = "password")
    public WebElement sifreGir;

    //Sign in butonu tıklanabilir olmalı
    @FindBy(name = "login")
    public WebElement loginOnay;

    //My account sayfası görüntülenebilmeli

    //My account sayfasında Orders görüntülenebilmeli

    //My account sayfasında Downloads görüntülenebilmeli

    //My account sayfasında address görüntülenebilmeli

    //My account sayfasında account details görüntülenebilmeli

    //My account sayfasında whislist görüntülenebilmeli

    //My account sayfasında Logout görüntülenebilmeli

    //My account sayfasında, Dashboard altında Store Manager görüntülenmeli

    //My account sayfasında, Dashboard altında orders görüntülenmeli

    //My account sayfasında, Dashboard altında downloads görüntülenmeli

    //My account sayfasında, Dashboard altında address görüntülenmeli

    //My account sayfasında, Dashboard altında account details görüntülenmeli

    //My account sayfasında, Dashboard altında wishlist görüntülenmeli

    //My account sayfasında, Dashboard altında Support tickets görüntülenmeli

    //My account sayfasında, Dashboard altında followings görüntülenmeli

    //My account sayfasında, Dashboard altında log out görüntülenmeli

    //Adress seçeneği tıklanabilir olmalı

    //Adres sayfası açılmalı

    //ADD seçeneği tıklanılabilmeli ve Shipping  sayfası açılmalı

    //First name yazı alanına isim girilebilmeli

    //Last name yazı alanına isim girilebilmeli

    //Shipping sayfasındaCountry/Region alanında ülke adı seçilebilmeli

    //Shipping sayfasında Street address alanına adres girilebilmeli

    //Shipping sayfasında Street address alanın 2 satırına adresin devamı girilebilmeli

    //Shipping sayfasında Town / City alanına şehir asmi girilebilmeli

    //Shipping sayfasında State alanına bilgi girilebilmeli

    //Shipping sayfasında ZIP Code alanına bilgi girilebilmeli

    //SAVE ADDRESS butonu tıklanabilir olmalı

    //SAVE ADRDRESS butonuna tıklandıktan sonra adresin kaydedildiği sonucu görüntülenmeli
}