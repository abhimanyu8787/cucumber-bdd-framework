package bdd.automation.stepdefinitions;

import bdd.automation.pages.PersonalInformationManagementPage;
import bdd.automation.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

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
    public void click_on_save() throws Exception {
        personalInformationManagementPage.saveEmployee();
    }
    
    @When("user enters  {string} and {string} in Employee Information Section")
    public void user_enters_and_in_employee_information_section(String employeeName, String employeeId) throws Exception {
        personalInformationManagementPage.searchEmployeeDetails(employeeName, employeeId);
    }

    @When("clicks on search button")
    public void clicks_on_search_button() throws Exception {
        personalInformationManagementPage.clickSearchEmployeeButton();
    }

    @Then("verify if {string} and {string} is displayed in records table")
    public void verify_if_and_is_displayed_in_records_table(String name, String employeeId) throws Exception {
        String actualName = personalInformationManagementPage.getSearchedEmployeeNameFromRecordTable();
        String actualId = personalInformationManagementPage.getSearchedEmployeeIdFromRecordTable();
        assertEquals(name, actualName);
        assertEquals(employeeId, actualId);
    }

}
