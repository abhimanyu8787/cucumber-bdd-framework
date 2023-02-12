package bdd.automation.stepdefinitions;

import bdd.automation.pages.PersonalInformationManagementPage;
import bdd.automation.utils.TestContextSetup;
import io.cucumber.java.en.Then;

public class PersonalInformationManagementStepDefinitions {
    
    public TestContextSetup testContextSetup;
    public PersonalInformationManagementPage personalInformationManagementPage;
    
    public PersonalInformationManagementStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.personalInformationManagementPage=testContextSetup.pageObjectManager.getPersonalInformationManagementPage();
    }
    
    @Then("user clicks on {string} button in top navigation menu")
    public void user_clicks_on_button_in_top_navigation_menu(String string) throws Exception {
        personalInformationManagementPage.clickAddEmployeeNavigationButton();
    }
    
    @Then("user enters {string} {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName, String employeeId) throws Exception {
        personalInformationManagementPage.addEmployeeDetails(firstName, middleName, lastName, employeeId);
    }

    @Then("toggle create login details")
    public void toggle_create_login_details() throws Exception {
        personalInformationManagementPage.enableLoginDetailsToggle();
    }

    @Then("user provides {string} and {string}")
    public void user_provides_and(String login, String password) throws Exception {
        personalInformationManagementPage.addLoginCredentials(login, password);
    }

    @Then("user uploads profile picture")
    public void user_uploads_profile_picture() throws Exception {
        personalInformationManagementPage.uploadEmployeeProfilePicture("profilePicture.jpg");
    }

    @Then("click on save")
    public void click_on_save() {
        
    }

}
