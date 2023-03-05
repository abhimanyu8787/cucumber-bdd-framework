package bdd.automation.stepdefinitions;

import bdd.automation.pages.JiraLoginPage;
import bdd.automation.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JiraLoginPageStepDefinitions {
    
    public TestContextSetup testContextSetup;
    public JiraLoginPage jiraLoginPage;
    
    public JiraLoginPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.jiraLoginPage = testContextSetup.pageObjectManager.getJiraLoginPage();
    }
    
    @Given("user is on jira login page")
    public void user_is_on_jira_login_page() {
        jiraLoginPage.navigateToJiraLoginPage();
    }

    @When("user enters valid email as {string}")
    public void user_enters_valid_email_as(String email) throws Exception {
        jiraLoginPage.enterEmailOnLoginPage(email);
    }

    @When("click on {string} button on jira login page")
    public void click_on_button_on_jira_login_page(String buttonName) throws Exception {
        if(buttonName.equals("continue")) {
            jiraLoginPage.clickContinueOnLoginPage();
        }else if(buttonName.equals("login")) {
            jiraLoginPage.clickLoginButtonOnLoginPage();
        }
    }

    @When("enter valid password as {string}")
    public void enter_valid_password_as(String password) throws Exception {
        jiraLoginPage.enterPasswordOnLoginPage(password);
    }
    
    @When("user successfully logins with valid credentials")
    public void user_successfully_logins_with_valid_credentials() throws Exception {
        jiraLoginPage.enterEmailOnLoginPage("randomEmail@gmail.com");
        jiraLoginPage.clickContinueOnLoginPage();
        jiraLoginPage.enterPasswordOnLoginPage("randomPassword");
        jiraLoginPage.clickLoginButtonOnLoginPage();
    }

}
