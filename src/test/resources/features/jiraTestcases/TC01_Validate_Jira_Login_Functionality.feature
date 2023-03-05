#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Login Functionality Validations

  @JiraLoginScenario
  Scenario: validate login functionality with valid combination of email and password
    Given user is on jira login page
    Then wait till page is loaded
    And fetching the locators
    When user enters valid email as "randomEmail@gmail.com"
    And click on "continue" button on jira login page
    And enter valid password as "randomPassword"
    And click on "login" button on jira login page
    Then verify if login is successful on jira portal for "randomEmail@gmail.com"
    And verify username displayed on jira portal is "random profile name"
    

  