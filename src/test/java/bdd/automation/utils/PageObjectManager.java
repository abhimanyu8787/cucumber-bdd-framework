package bdd.automation.utils;

import org.openqa.selenium.WebDriver;

import bdd.automation.pages.DashboardPage;
import bdd.automation.pages.LoginPage;
import bdd.automation.pages.PersonalInformationManagementPage;

public class PageObjectManager {
    
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PersonalInformationManagementPage personalManagementPage;
    
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    
    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }
    
    public DashboardPage getDashboardPage() {
        dashboardPage = new DashboardPage(driver);
        return dashboardPage;
    }
    
    public PersonalInformationManagementPage getPersonalInformationManagementPage() {
        personalManagementPage = new PersonalInformationManagementPage(driver);
        return personalManagementPage;
    }

}
