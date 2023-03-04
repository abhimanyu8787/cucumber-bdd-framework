package bdd.automation.utils;

import org.openqa.selenium.WebDriver;

import bdd.automation.pages.DashboardPage;
import bdd.automation.pages.GlobalsqaDemoSite;
import bdd.automation.pages.GlobalsqaDemoSiteDragAndDrop;
import bdd.automation.pages.LoginPage;
import bdd.automation.pages.PersonalInformationManagementPage;

public class PageObjectManager {
    
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PersonalInformationManagementPage personalManagementPage;
    private GlobalsqaDemoSite globalsqaDemoSite;
    private GlobalsqaDemoSiteDragAndDrop globalsqaDemoSiteDragAndDrop;
    
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
    
    public GlobalsqaDemoSite getGlobalsqaDemoSite() {
        globalsqaDemoSite = new GlobalsqaDemoSite(driver);
        return globalsqaDemoSite;
    }
    
    public GlobalsqaDemoSiteDragAndDrop getGlobalsqaDemoSiteDragAndDrop() {
        globalsqaDemoSiteDragAndDrop = new GlobalsqaDemoSiteDragAndDrop(driver);
        return globalsqaDemoSiteDragAndDrop;
    }

}
