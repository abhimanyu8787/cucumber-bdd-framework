package bdd.automation.pages;

import org.openqa.selenium.WebDriver;

import bdd.automation.utils.GenericMethods;

public class PersonalInformationManagementPage {
    
    private GenericMethods genericMethods;
    private WebDriver driver;

    public PersonalInformationManagementPage(WebDriver driver) {
        this.driver = driver;
        genericMethods = new GenericMethods();
    }
    
    public void clickAddEmployeeNavigationButton() throws Exception {
        genericMethods.click(driver, "addEmployeeNavigationMenuButton");
    }
    
    public void enterEmployeeName(String employeeName) throws Exception {
        genericMethods.enterText(driver, "employeeNameField", employeeName);
    }
    
    public void enterEmployeeId(String employeeId) throws Exception {
        genericMethods.enterText(driver, "employeeIDField", employeeId);
    }
    
    public void selectEmployeeStatus(String employeeStatus) throws Exception {
        genericMethods.selectfromOrangeHRMDropdown(driver, "employeeStatusDropdownLocator", "employeeStatusDropdownListLocator", employeeStatus);
    }
    
    public void enterSupervisorName(String supervisorName) throws Exception {
        genericMethods.enterText(driver, "supervisorNameField", supervisorName);
    }
    
    public void selectJobTitle(String jobTitle) throws Exception {
        genericMethods.selectfromOrangeHRMDropdown(driver, "jobTitleDropdownLocator", "jobTitleDropdownListLocator", jobTitle);
    }
    
    public void selectSubUnit(String subUnit) throws Exception {
        genericMethods.selectfromOrangeHRMDropdown(driver, "subUnitDropdownLocator", "subUnitDropdownListLocator", subUnit);
    }
    
    public void addEmployeeDetails(String firstName, String middleName, String lastName, String employeeId) throws Exception {
        genericMethods.enterText(driver, "firstNameTextBox", firstName);
        genericMethods.enterText(driver, "middleNameTextBox", middleName);
        genericMethods.enterText(driver, "lastNameTextBox", lastName);
        genericMethods.clickBackspaceButton(driver, "employeeIdTextBox", 4);
        genericMethods.enterText(driver, "employeeIdTextBox", employeeId);
    }
    
    public void enableLoginDetailsToggle() throws Exception {
        genericMethods.click(driver, "loginDetailsToggle");
    }
    
    public void addLoginCredentials(String username, String password) throws Exception {
        genericMethods.enterText(driver, "setUsernameTextBox", username);
        genericMethods.enterText(driver, "setPasswordTextBox", password);
        genericMethods.enterText(driver, "confirmPasswordTextBox", password);
    }
    
    public void saveEmployee() throws Exception {
        genericMethods.click(driver, "saveEmployeeButton");
    }
    
    public void uploadEmployeeProfilePicture(String fileName) throws Exception {
        genericMethods.click(driver, "uploadProfilePictureButton");
        Thread.sleep(2000);
        String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\uploadFiles\\"+fileName;
        String autoItScriptPath = System.getProperty("user.dir")+"\\src\\test\\resources\\AutoIt\\executable\\script.exe";
        genericMethods.uploadFile(filePath, autoItScriptPath);
        Thread.sleep(3000);
    }
    
    public void searchEmployeeDetails(String employeeName, String employeeId) throws Exception {
        genericMethods.enterText(driver, "searchEmployeeNameField", employeeName);
        genericMethods.enterText(driver, "employeeIdTextBox", employeeId);
    }
    
    public void clickSearchEmployeeButton() throws Exception {
        genericMethods.click(driver, "searchEmployeeButtonLocator");
    }
    
    public String getSearchedEmployeeNameFromRecordTable() throws Exception {
        genericMethods.waitForElementToDisplay(driver, "searchedEmployeeFirstNameRecordTable", "5");
        String firstName = genericMethods.getElementText(driver, "searchedEmployeeFirstNameRecordTable");
        String lastName = genericMethods.getElementText(driver, "searchedEmployeeLastNameRecordTable");
        return firstName + " "+ lastName;
    }
    
    public String getSearchedEmployeeIdFromRecordTable() throws Exception {
        return genericMethods.getElementText(driver, "searchedEmployeeIdRecordTable");
    }
    
    

}
