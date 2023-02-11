package bdd.automation.stepdefinitions;

import java.io.IOException;

import bdd.automation.pages.LoginPage;
import bdd.automation.utils.TestContextSetup;
import bdd.automation.utils.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinitions {
    
    public TestContextSetup testContextSetup;
    public LoginPage loginPage;
    
    public LoginPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.loginPage=testContextSetup.pageObjectManager.getLoginPage();
    }
    
    @Given("user is on login page")
    public void user_is_on_login_page() throws IOException {
        loginPage.navigateToLoginPage();
    }

    @Then("wait till page is loaded")
    public void wait_till_page_is_loaded() {
        
    }

    @Then("fetching the locators")
    public void fetching_the_locators() {
        Utility.fetchLocator();
        System.out.println("Fetched the Locators");
    }

    @When("user enters creadentials {string} as {string} and {string} as {string}")
    public void user_enters_creadentials_as_and_as(String username, String validityOfUsername, String password, String validityOfPassword) throws Exception {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickOnLogin();
    }

    @Then("verify if login is successful")
    public void verify_if_login_is_successful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
