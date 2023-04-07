package bdd.automation.pages;

import org.openqa.selenium.WebDriver;

import bdd.automation.utils.GenericMethods;

public class JiraLoginPage {
    
    private GenericMethods genericMethods;
    private WebDriver driver;
    
    public JiraLoginPage(WebDriver driver) {
        this.driver = driver;
        genericMethods = new GenericMethods();
    }
    
    public void navigateToJiraLoginPage() {
        genericMethods.navigateToUrl(driver, "https://testautomatica.atlassian.net/login");
    }
    
    public void enterEmailOnLoginPage(String email) throws Exception {
        genericMethods.enterText(driver, "jiraLoginEmailLocator", email);
    }
    
    public void clickContinueOnLoginPage() throws Exception {
        genericMethods.click(driver, "jiraLoginContinueButton");
    }
    
    public void enterPasswordOnLoginPage(String password) throws Exception {
        genericMethods.enterText(driver, "jiraLoginPasswordLocator", password);
    }
    
    public void clickLoginButtonOnLoginPage() throws Exception {
        genericMethods.click(driver, "jiraLoginButton");
    }
    

}
