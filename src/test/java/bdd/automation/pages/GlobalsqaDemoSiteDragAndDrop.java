package bdd.automation.pages;

import org.openqa.selenium.WebDriver;

import bdd.automation.utils.GenericMethods;

public class GlobalsqaDemoSiteDragAndDrop {
    
    private WebDriver driver;
    private GenericMethods genericMethods;
    
    public GlobalsqaDemoSiteDragAndDrop(WebDriver driver) {
        this.driver = driver;
        genericMethods = new GenericMethods();
    }
    
    public void dragImageToTrash(String imageName) throws Exception {
        genericMethods.switchFrame(driver, "frameLocator");
        genericMethods.dragAndDropElement(driver, "sourceImageLocator", "destiantionTrashLocator");
    }
    
    

}
