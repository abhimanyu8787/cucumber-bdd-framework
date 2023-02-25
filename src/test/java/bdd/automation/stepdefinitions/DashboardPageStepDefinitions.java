package bdd.automation.stepdefinitions;


import bdd.automation.pages.DashboardPage;
import bdd.automation.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

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
        assertEquals(logoText, "Dashboard");
    }
    
    @When("user navigates to PIM tab")
    public void user_navigates_to_pim_tab() throws Exception {
        dashboardPage.navigateToPIM();
    }

}
