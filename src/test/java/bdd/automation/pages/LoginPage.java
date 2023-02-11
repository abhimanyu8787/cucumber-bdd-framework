package bdd.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import bdd.automation.utils.GenericMethods;
import bdd.automation.utils.Utility;

public class LoginPage {
    
    private GenericMethods genericMethods;
    private WebDriver driver;
    private String validUserName = "Admin";
    private String validPassword = "admin123";
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        genericMethods = new GenericMethods();
    }
    
    public void navigateToLoginPage() throws IOException {
        String url = Utility.getGlobalProperties("applicationUrl");
        genericMethods.navigateToUrl(driver, url);
    }
    
    public void enterValidCredentials() throws Exception {
        genericMethods.enterText(driver, "userNameBox", validUserName);
        genericMethods.enterText(driver, "passwordBox", validPassword);
    }
    
    public void enterUserName(String username) throws Exception {
        genericMethods.enterText(driver, "userNameBox", username);
    }
    
    public void enterPassword(String password) throws Exception {
        genericMethods.enterText(driver, "passwordBox", password);
    }
    
    public void clickOnLogin() throws Exception {
        genericMethods.click(driver, "LoginButton");
    }
    
    public String getInvalidCredentialsErrorMessage() throws Exception {
        return genericMethods.getElementText(driver, "invalidCredentialsMessage");
    }

}
