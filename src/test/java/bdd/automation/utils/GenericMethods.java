package bdd.automation.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

    private WebElement element = null;
    private WebElement dropdown = null;
    private Select selectList = null;
    private String old_win = null;
    private String latWinHandle;
    private List<WebElement> elementList;

    /**
     * Method to enter text into text field
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param driver 
     *            : WebDriver : driver object
     * @param objectName 
     *            : String : Object Name
     * @param text 
     *            : String : Text value to enter in field
     * @throws Exception
     */
    public void enterText(WebDriver driver, String objectName, String text) throws Exception {
        try {
            element = Utility.readFromExcel(objectName, driver);
            waitForElementToDisplay(driver, objectName, "5");
        } catch (Exception e) {
            String error = e.getMessage();
            throw new Exception("Unable to find " + objectName, e);
        }
        element.clear();
        element.sendKeys(text);
    }
    
    /**
     * Method to clear text of text field
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param driver 
     *            : WebDriver : driver object
     * @param objectName 
     *            : String : Object Name
     * @throws Exception
     */
    public void clearText(WebDriver driver, String objectName) throws Exception {
        try {
            element = Utility.readFromExcel(objectName, driver);
        } catch (Exception e) {
            throw new Exception("Unable to find " + objectName, e);
        }
        element.clear();
    }
    
    /**
     * Method to get text of a WebElement
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param driver
     *            : WebDriver : driver object
     * @param objectName
     *            : String : Object Name
     * @throws Exception
     */
    public String getElementText(WebDriver driver, String objectName) throws Exception {
        try {
            element = Utility.readFromExcel(objectName, driver);
        } catch (Exception e) {
            throw new Exception("Unable to find "+objectName, e);
        }
        return element.getText();
    }
    
    /**
     * Method to open link
     * 
     * @since 11/02/2023
     * @author abhimanyu_kumar
     * @param driver
     *            : WebDriver : driver object
     * @param url
     *            : String : URL for navigation
     */
    public void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    /**
     * Method to perform click operation on a WebElement
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param driver 
     *            : WebDriver : driver object
     * @param objectName 
     *            : String : Object Name
     * @throws Exception
     */
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
    
    /**
     * Method to perform double click operation on a WebElement
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param driver 
     *            : WebDriver : driver object
     * @param objectName 
     *            : String : Object Name
     * @throws Exception
     */
    public void doubleClick(WebDriver driver, String objectName) throws Exception {
        try {
            element = Utility.readFromExcel(objectName, driver);
        } catch (Exception e) {
            throw new Exception("Unable to find" + objectName, e);
        }
        
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }
    
    /**
     * Method to select element from Dropdown by type
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param select_list 
     *            : Select : Select variable
     * @param byType 
     *            : String : Name of by type
     * @param option 
     *            : String : Option to select
     * @throws Exception
     */
    public void selectElementFromDropdownByType(Select select_list, String byType, String option) {
        if(byType.equals("selectByIndex")) {
            int index = Integer.parseInt(option);
            select_list.selectByIndex(index);
        }else if(byType.equals("value")) {
            select_list.selectByValue(option);
        }else if(byType.equals("text")) {
            select_list.selectByVisibleText(option);
        }
    }
    
    /**
     * Method to select element from dropdown list
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param driver
     *            : WebDriver : driver object
     * @param objectName 
     *            : String : Object name
     * @param optionBy 
     *            : String : Name of by type
     * @param option 
     *            : String : Option to select
     * @throws Exception
     */
    public void selectOptionFromDropdown(WebDriver driver, String objectName, String optionBy, String option) throws Exception {
        dropdown = Utility.readFromExcel(objectName, driver);
        selectList = new Select(dropdown);
        if(optionBy.equals("selectByIndex"))
            selectList.selectByIndex(Integer.parseInt(option)-1);
        else if(optionBy.equals("value"))
            selectList.selectByValue(option);
        else if(optionBy.equals("text"))
            selectList.selectByVisibleText(option);
    }
    
    /**
     * Method to select element from dropdown present in Orange HRM website
     * 
     * @since: 12/02/2023
     * @author: abhimanyu_kumar
     * @param driver
     *            : WebDriver : driver object
     * @param dropdownLocator 
     *            : String : Locator of Dropdown which will be clicked to display options
     * @param dropdownElementsLocator 
     *            : String : Locator to Identify the List of Options displayed in the dropdown
     * @param option 
     *            : String : Option to select
     * @throws Exception
     */
    public void selectfromOrangeHRMDropdown(WebDriver driver, String dropdownLocator, String dropdownElementsLocator, String option) throws Exception {
        element = Utility.readFromExcel(dropdownLocator, driver);
        elementList = Utility.readListFromExcel(dropdownElementsLocator, driver);
        for(WebElement element: elementList) {
            if(element.getText().equals(option)) {
                element.click();
                break;
            }
        }
    }

    public void waitForElementToDisplay(WebDriver driver, String objectName, String duration) throws Exception {
        By byEle = Utility.mapFromExcel.get(objectName);
        WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration) * 1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEle));
    }

    public void waitForElementToClick(WebDriver driver, String objectName, String duration) throws Exception {
        By byEle = Utility.mapFromExcel.get(objectName);
        WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration) * 1000));
        wait.until(ExpectedConditions.elementToBeClickable(byEle));
    }
    
    /**
     * Method to execute autoItScript to upload file
     * @param filePath
     *            : String : Location of file which needs to be uploaded
     * @param scriptPath
     *            : String : Location of the autoItScript
     */
    public void uploadFile(String filePath, String scriptPath) {
        System.out.println("Started Execution of AutoIt Script: "+scriptPath);
        System.out.println("Uploading File: "+filePath);
        ProcessBuilder processBuilder = new ProcessBuilder(scriptPath, filePath);
        try {
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
