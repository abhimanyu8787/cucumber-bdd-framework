package bdd.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import bdd.automation.utils.GenericMethods;

public class JiraSoftwareNavigation {

    private GenericMethods genericMethods;
    private WebDriver driver;

    public JiraSoftwareNavigation(WebDriver driver) {
        this.driver = driver;
        genericMethods = new GenericMethods();
    }

    public void clickOnProfileIcon() throws Exception {
        genericMethods.waitForElementToClick(driver, "profileIconLocator", "10");
        genericMethods.click(driver, "profileIconLocator");
    }

    public String getProfileName() throws Exception {
        return genericMethods.getElementText(driver, "nameLocatorInProfile");
    }

    public String getEmailFromProfileMenu() throws Exception {
        return genericMethods.getElementText(driver, "emailIdLocatorInProfile");
    }

    public void clickCreateButton() throws Exception {
        genericMethods.waitForElementToClick(driver, "createButtonLocator", "10");
        genericMethods.click(driver, "createButtonLocator");
    }

    public void enterSummary(String testCaseName) throws Exception {
        String summary = genericMethods.readDataFromExcel("testData.xlsx", "Jira", testCaseName, "summary");
        genericMethods.scrollToElement(driver, "summaryBoxLocator");
        genericMethods.enterText(driver, "summaryBoxLocator", summary);
    }

    public void enterDescription(String testCaseName) throws Exception {
        String description = genericMethods.readDataFromExcel("testData.xlsx", "Jira", testCaseName, "description");
        genericMethods.scrollToElement(driver, "descriptionBoxLocator");
        genericMethods.enterText(driver, "descriptionBoxLocator", description);
    }

    public void selectAssigneeAsMyself() throws Exception {
        genericMethods.scrollToElement(driver, "asigneeBoxLocator");
        genericMethods.click(driver, "assignItToMeLocator");
    }
    
    public void clickCreateButtonToConfirm() throws Exception {
        genericMethods.click(driver, "createButtonLocator2");
    }

}
