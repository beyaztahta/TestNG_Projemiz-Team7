package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //    Bu sinif configuration.properties file i okumak icin kullanilir.
    //    yani test clası ile properties arasında getir götür yapar
    //    property file i okumak icin properti objecsi kullanilir
    public static Properties properties;

    //    static block : ilk calisir
    static {
        //        data cekmek istedigim dosyaninin path i
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);//   configuration.property dosyasini acar

            properties = new Properties();//   objeyi oluşturduk atamasını gerçekleştirdik.

            properties.load(fis);//  fis in okuduğu değerleri properties e yükler

            fis.close();//  file input stream'i kapatilir
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    ConfigReader.getProperty("browser"); -> chrome
    //    ConfigReader.getProperty("amazon_url"); -> https://www.amazon.com
    //    ConfigReader.getProperty("username"); -> ali
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        return value;
    }
}
