package bdd.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Utility {
    
    private static Map<String, By> mapFromExcel = new HashMap();
    private static String objectLocatorFile = "src\\test\\resources\\objectLocators\\ObjectLocators.xlsx";
    
    public static String getGlobalProperties(String key) throws IOException {
        FileReader reader = new FileReader("GlobalSettings.properties");
        Properties globalProperties = new Properties();
        globalProperties.load(reader);
        return globalProperties.getProperty(key);
    }
    
    public static void fetchLocator() {
        try {
            File testFile = new File(objectLocatorFile);
            FileInputStream ios = new FileInputStream(testFile);
            XSSFWorkbook workbook = new XSSFWorkbook(ios);
            for(int i = 0; i< workbook.getNumberOfSheets() - 2; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                String locator = null;
                String value = null;
                String param = null;
                
                Iterator<Row> rowIterator = sheet.iterator();
                while(rowIterator.hasNext()) {
                    Row row = (Row) rowIterator.next();
                    param = row.getCell(0).getStringCellValue();
                    locator = row.getCell(1).getStringCellValue();
                    value = row.getCell(2).getStringCellValue();
                    mapFromExcel.put(param, get_element_object(locator, value));
                }
            }
            workbook.close();
            ios.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static WebElement readFromExcel(String param, WebDriver driver) throws Exception {
        try {
            return driver.findElement((By) mapFromExcel.get(param));
        } catch (Exception e) {
            throw new Exception(param + "not found");
        }
    }
    
    public static By get_element_object(String locName, String locValue) {
        if(locName.equalsIgnoreCase("XPATH")) {
            return By.xpath(locValue);
        }
        if(locName.equalsIgnoreCase("ID")) {
            return By.id(locValue);
        }
        if(locName.equalsIgnoreCase("CLASSNAME")) {
            return By.className(locValue);
        }
        if(locName.equalsIgnoreCase("NAME")) {
            return By.name(locValue);
        }
        if(locName.equalsIgnoreCase("CSS")) {
            return By.cssSelector(locValue);
        }
        if(locName.equalsIgnoreCase("LINK")) {
            return By.linkText(locValue);
        }
        if(locName.equalsIgnoreCase("PARTIALLINK")) {
            return By.partialLinkText(locValue);
        }
        if(!locValue.isEmpty()) {
            By.cssSelector("*[" + locName + "='" + locValue + "']");
        }
        return null;
    }

}
