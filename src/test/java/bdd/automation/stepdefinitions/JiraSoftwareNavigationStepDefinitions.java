package bdd.automation.stepdefinitions;

import static org.junit.Assert.*;

import bdd.automation.pages.JiraSoftwareNavigation;
import bdd.automation.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JiraSoftwareNavigationStepDefinitions {
    
    public TestContextSetup testContextSetup;
    public JiraSoftwareNavigation jiraSoftwareNavigation;
    
    public JiraSoftwareNavigationStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.jiraSoftwareNavigation = testContextSetup.pageObjectManager.getJiraSoftwareNavigation();
    }
    
    @Then("verify if login is successful on jira portal for {string}")
    public void verify_if_login_is_successful_on_jira_portal(String emailAddress) throws Exception {
        jiraSoftwareNavigation.clickOnProfileIcon();
        String actualEmailDisplayed = jiraSoftwareNavigation.getEmailFromProfileMenu();
        assertEquals(emailAddress, actualEmailDisplayed);
    }
    
    @Then("verify username displayed on jira portal is {string}")
    public void verify_username_displayed_on_jira_portal_is(String userName) throws Exception {
        String actualProfileName = jiraSoftwareNavigation.getProfileName();
        assertEquals(userName, actualProfileName);
    }
    
    @When("user click on {string} button in navigation menu")
    public void user_click_on_button_in_navigation_menu(String buttonName) throws Exception {
        if(buttonName.equals("Create")) {
            jiraSoftwareNavigation.clickCreateButton();
        }
    }

    @When("select project as {string}")
    public void select_project_as(String string) {
        
    }

    @When("select issue Type as {string}")
    public void select_issue_type_as(String string) {
        
    }

    @When("select Status as {string}")
    public void select_status_as(String string) {
        
    }

    @When("enter summary for {string}")
    public void enter_summary_for(String testCaseName) throws Exception {
        jiraSoftwareNavigation.enterSummary(testCaseName);
    }

    @When("add description for {string}")
    public void add_description_as(String testCaseName) throws Exception {
        jiraSoftwareNavigation.enterDescription(testCaseName);
    }

    @When("select assignee as {string}")
    public void select_assignee_as(String string) throws Exception {
        jiraSoftwareNavigation.selectAssigneeAsMyself();
    }

    @When("enter label as {string}")
    public void enter_label_as(String string) {
        
    }

    @When("select sprint as {string}")
    public void select_sprint_as(String string) {
        
    }

    @When("click on {string} button")
    public void click_on_button(String buttonName) throws Exception {
        jiraSoftwareNavigation.clickCreateButtonToConfirm();
    }
    

}
