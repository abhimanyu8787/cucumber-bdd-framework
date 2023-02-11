package bdd.automation.utils;

import org.openqa.selenium.WebDriver;

import bdd.automation.pages.DashboardPage;
import bdd.automation.pages.LoginPage;

public class PageObjectManager {
    
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    
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

}
