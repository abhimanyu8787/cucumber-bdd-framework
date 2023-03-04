package bdd.automation.pages;

import org.openqa.selenium.WebDriver;

import bdd.automation.utils.GenericMethods;

public class GlobalsqaDemoSite {
    
    private GenericMethods genericMethods;
    private WebDriver driver;
    
    public GlobalsqaDemoSite(WebDriver driver) {
        this.driver = driver;
        genericMethods = new GenericMethods();
    }
    
    public void navigateToGlobalsqaDemoSite() {
        genericMethods.navigateToUrl(driver, "https://www.globalsqa.com/demo-site/draganddrop/");
    }
    
    public void clickOnDragAndDrop() throws Exception {
        genericMethods.scrollToElement(driver, "dragAndDropButton");
        genericMethods.click(driver, "dragAndDropButton");
        Thread.sleep(2000);
        genericMethods.click(driver, "closeAdPopUpLocator");
    }

}
