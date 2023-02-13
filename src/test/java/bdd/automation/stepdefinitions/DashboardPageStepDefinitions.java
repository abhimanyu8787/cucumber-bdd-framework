package bdd.automation.stepdefinitions;

import org.testng.Assert;

import bdd.automation.pages.DashboardPage;
import bdd.automation.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardPageStepDefinitions {
    
    public TestContextSetup testContextSetup;
    public DashboardPage dashboardPage;
    
    public DashboardPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.dashboardPage=testContextSetup.pageObjectManager.getDashboardPage();
    }
    
    @Then("verify if login is successful")
    public void verify_if_login_is_successful() throws Exception {
        String logoText = dashboardPage.getLogoText();
        Assert.assertEquals(logoText, "Dashboard");
    }
    
    @When("user navigates to PIM tab")
    public void user_navigates_to_pim_tab() throws Exception {
        dashboardPage.navigateToPIM();
    }

}
