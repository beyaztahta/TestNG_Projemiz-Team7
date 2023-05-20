package test.US_15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.*;

public class TC_07 {
    @Test
    public void tc_07() {
        LocaterAyse locaterAyse = new LocaterAyse();
        //kullanici web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //signin tusuna basar
        locaterAyse.signIn.click();
        //kullanici mail adresini girer, passwordunu girer ve sign in buttonuna tiklar
        locaterAyse.email.sendKeys(ConfigReader.getProperty("ayse"), Keys.TAB, ConfigReader.getProperty("passAyse"), Keys.ENTER);
        bekle(5);
        //kullanici sayfanin en altina gider
        scrollEnd();
        bekle(2);
        //kullanici my account linkine tiklar
        locaterAyse.myAccount.click();
        //kullanici sol kisimdaki Store Manager'a tiklar
        locaterAyse.storeManager.click();
        //Kullanci sol bolumdeki Products buttonuna gider
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        hover(locaterAyse.products);
        //Kullanici Add New Linkine tiklar
        click(locaterAyse.addNew);

        //Kullanici sayfayi asagiya indirir
        scrollEnd();
        actions.sendKeys(Keys.PAGE_UP, Keys.ARROW_DOWN).perform();

        //kullanici Toptan Urun Gosterme Ayarlarini tiklar
        click(locaterAyse.toptanUrun);
        //Kullanici Piece Type dropdown menuyu tiklar
        locaterAyse.pieceTypeDdm.click();
        //Kullanici ddm deki piece secenegini tiklar
        Select select = new Select(locaterAyse.pieceTypeDdm);
        select.selectByVisibleText("Piece");
        bekle(2);
        System.out.println(select.getFirstSelectedOption().getText());
        assertEquals(select.getFirstSelectedOption().getText(), locaterAyse.pieceTypeDdm.getAttribute("value"));
        //Kullanici ddm deki carton secenegini tiklar
        select.selectByVisibleText("Carton");
        bekle(2);
        assertEquals(select.getFirstSelectedOption().getText(), "Carton");
        //Kullanici ddm deki kg secenegini tiklar
        select.selectByVisibleText("Kg");
        bekle(2);
        assertEquals(select.getFirstSelectedOption().getText(), "Kg");
        //Kullanici units per piece kutucuguna deger girer
        locaterAyse.unitsPerPiece.clear();
        locaterAyse.unitsPerPiece.sendKeys("12");
        bekle(2);
        //Kullanici girdigi degeri gorur
        assertEquals(locaterAyse.unitsPerPiece.getAttribute("value"), "12");
        //kullanici min order quantity bolumune deger girer
        locaterAyse.minOrderQuantity.clear();
        locaterAyse.minOrderQuantity.sendKeys("12");
        bekle(2);
        //kullanici girdigi degeri gorur
        assertEquals(locaterAyse.minOrderQuantity.getAttribute("value"), "12");

    }
}