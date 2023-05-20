package test;

import org.openqa.selenium.Keys;
import pages.LocaterOguzhan;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;
import static utilities.ReusableMethods.bekle;

public class US08_Oguzhan {

    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        LocaterOguzhan locaterOguzhan = new LocaterOguzhan();

        //kullanici web sitesine gider

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Ürüne tıklar

        locaterOguzhan.urun.click();

        //Favori butonuna tıklar

        locaterOguzhan.favoriurun.click();

        //Wishlist butonuna tıklar

        locaterOguzhan.wishlistbutton.click();

        //Kullanıcı seçtiği ürünleri wishliste görür

        assertTrue(locaterOguzhan.wishlistbutton.isDisplayed());
        bekle(1);

        //Kullanıcı quick view butonunu görüntüler

        assertTrue((locaterOguzhan.quickview.isDisplayed()));
        bekle(1);

        //Kullanıcı quick view butonuna tıklar

        locaterOguzhan.quickviewbutton.click();

        //Kullanıcı quick view'de ürün özelliklerini görüntüler

        assertTrue(locaterOguzhan.qv_urunozellikleri.isDisplayed());
        bekle(1);

        //Kullanıcı Add to cart butonuna tıklar

        locaterOguzhan.addtocard.click();

        //Kullanıc  cart butonuna tıklar

        locaterOguzhan.cart.click();

        //Kullanıcı view cart butonunu görüntüler
        assertTrue(locaterOguzhan.viewcartt.isDisplayed());
        bekle(1);

        //Kullanıcı view cart butonuna tıklar

        locaterOguzhan.viewcart.click();

        //Kullanıcı seçtiği ürünleri sepetinde görüntüler

        assertTrue(locaterOguzhan.sepet.isDisplayed());
        bekle(1);

        //Kullanıcı Proced to checkout butonuna tıklar

        locaterOguzhan.proceedtocheckout.click();

        //Kullanıcı ödeme sayfasını görür

        assertTrue(locaterOguzhan.odemesayfasi.isDisplayed());
        bekle(1);

        //Kullanıcı Firstname alanına isim girer
        //Kullanıcı Lastname alanına soyisiim girer
        locaterOguzhan.firstname.sendKeys(ConfigReader.getProperty("firstname"), Keys.TAB,
                locaterOguzhan.lastname.sendKeys(ConfigReader.getProperty("lastname"),Keys.TAB,
                Keys.TAB,
                        locaterOguzhan.country.sendKeys(ConfigReader.getProperty("country"),Keys.TAB,
                                locaterOguzhan.streetaddress.sendKeys(ConfigReader.getProperty("streetaddress"),Keys.TAB,
        locaterOguzhan.country.sendKeys(ConfigReader.getProperty("country"));





    }

}
