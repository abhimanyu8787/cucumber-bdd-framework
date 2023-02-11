#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Login Functionality Validations

  @LoginFunctionality
  Scenario: validate login functionality with valid username and valid password
    Given user is on login page
    Then wait till page is loaded
    And fetching the locators
    When user enters creadentials "Admin" as "ValidUsername" and "admin123" as "ValidPassword"
    And user clicks on login button
    Then verify if login is successful
    
  @LoginFunctionality
  Scenario: validate login functionality with invalid username and valid password
    Given user is on login page
    Then wait till page is loaded
    And fetching the locators
    When user enters creadentials "Admina$2" as "InvalidUsername" and "admin123" as "ValidPassword"
    And user clicks on login button
    Then verify if "Invalid credentials" error message is displayed
    
  @LoginFunctionality
  Scenario: validate login functionality with valid username and invalid password
    Given user is on login page
    Then wait till page is loaded
    And fetching the locators
    When user enters creadentials "Admin" as "ValidUsername" and "admin$1234" as "InvalidPassword"
    And user clicks on login button
    Then verify if "Invalid credentials" error message is displayed