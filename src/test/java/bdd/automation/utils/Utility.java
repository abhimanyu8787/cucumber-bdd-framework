package bdd.automation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;

import io.restassured.specification.RequestSpecification;

public class Utility {
    
    private static Map<String, By> mapFromExcel = new HashMap();
    private static RequestSpecification req;
    private static String objectLocatorFile = "src\\test\\resources\\objectLocators\\ObjectLocators.xlsx";
    
    public static String getGlobalProperties(String key) throws IOException {
        FileReader reader = new FileReader("GlobalSettings.properties");
        Properties globalProperties = new Properties();
        globalProperties.load(reader);
        return globalProperties.getProperty(key);
    }

}
