package api_Common_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
 
public class ConfigFileManager {
 
   public static Properties prop;
 

    public static void readProperties() { 
        prop = new Properties();
        String basePath = System.getProperty("user.dir") + "\\Configuration\\";
        String configFilePath1 = basePath + "Config_Prescribed_Event.Properties";
        String configFilePath2 = basePath + "Config_Prescribed_ReserveSale_Events.Properties";
        String configFilePath3 = basePath + "config1.Properties"; // Optional third file

        loadProperties(configFilePath1);
        loadProperties(configFilePath2);
        loadProperties(configFilePath3);
    }
 
    private static void loadProperties(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}