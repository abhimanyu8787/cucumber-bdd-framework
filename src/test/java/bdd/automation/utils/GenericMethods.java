package bdd.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
    
    private WebElement element;
    private Select selectList;
    
    public void enterText(WebDriver driver, String objectName, String text) throws Exception {
        try {
            element = Utility.readFromExcel(objectName, driver);
            waitForElementToDisplay(driver, objectName, "5");
        } catch (Exception e) {
            String error = e.getMessage();
            throw new Exception("Unable to find "+objectName, e);
        }
        element.clear();
        element.sendKeys(text);
    }
    
    public void click(WebDriver driver, String objectName) throws Exception {
        try {
            element = Utility.readFromExcel(objectName, driver);
            waitForElementToClick(driver, objectName, "60");
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            String error = e.getMessage();
            throw new Exception("Error While Clicking on " + objectName, e);
        }
    }
    
    public void waitForElementToDisplay(WebDriver driver, String objectName, String duration) throws Exception {
        By byEle = Utility.mapFromExcel.get(objectName);
        WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration)*1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEle));
    }
    
    public void waitForElementToClick(WebDriver driver, String objectName, String duration) throws Exception {
        By byEle = Utility.mapFromExcel.get(objectName);
        WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration)*1000));
        wait.until(ExpectedConditions.elementToBeClickable(byEle));
    }

}
