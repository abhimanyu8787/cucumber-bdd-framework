package bdd.automation.stepdefinitions;

import bdd.automation.pages.GlobalsqaDemoSite;
import bdd.automation.pages.GlobalsqaDemoSiteDragAndDrop;
import bdd.automation.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalsqaDemoStepDefinitions {
    
    public TestContextSetup testContextSetup;
    public GlobalsqaDemoSite globalsqaDemoSite;
    public GlobalsqaDemoSiteDragAndDrop globalsDemoSiteDragAndDrop;
    
    public GlobalsqaDemoStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        globalsqaDemoSite = testContextSetup.pageObjectManager.getGlobalsqaDemoSite();
        globalsDemoSiteDragAndDrop = testContextSetup.pageObjectManager.getGlobalsqaDemoSiteDragAndDrop();
    }
    
    @Given("user is on demosqa demo site")
    public void user_is_on_demosqa_demo_site() throws InterruptedException {
        globalsqaDemoSite.navigateToGlobalsqaDemoSite();
        Thread.sleep(5000);
    }

    @When("click on {string}")
    public void click_on(String pageButton) throws Exception {
        //globalsqaDemoSite.clickOnDragAndDrop();
    }

    @When("user drags {string} and drops image to Trash")
    public void user_drags_and_drops_image_to_trash(String imageName) throws Exception {
        globalsDemoSiteDragAndDrop.dragImageToTrash(imageName);
    }

    @Then("verify if {string} image is successfully dropped in Trash")
    public void verify_if_image_is_successfully_dropped_in_trash(String string) {
        
    }

}
