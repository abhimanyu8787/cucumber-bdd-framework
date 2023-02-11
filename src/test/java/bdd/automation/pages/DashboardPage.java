package bdd.automation.pages;

import org.openqa.selenium.WebDriver;

import bdd.automation.utils.GenericMethods;

public class DashboardPage {
    
    private GenericMethods genericMethods;
    private WebDriver driver;
    
    public DashboardPage(WebDriver driver) {
        this.driver=driver;
        genericMethods = new GenericMethods();
    }
    
    public String getLogoText() throws Exception {
        return genericMethods.getElementText(driver, "DashboardPageLogo");
    }

}
