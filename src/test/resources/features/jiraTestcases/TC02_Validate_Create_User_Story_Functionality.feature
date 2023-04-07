#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Jira Create User story validations

	Background:
		Given user is on jira login page
    Then wait till page is loaded
    And fetching the locators
    When user successfully logins with valid credentials

  @CreateUserStory
  Scenario: validate create user story scenario
    When user click on "Create" button in navigation menu
    And select project as "AUTOMATION"
    And select issue Type as "Story"
    And select Status as "To Do"
    And enter summary for "TC01_Jira_Create_User_Story"
    And add description for "TC01_Jira_Create_User_Story"
    And select assignee as "randomEmail@gmail.com"
    And enter label as "sultans_of_sprint"
    And select sprint as "AUT Sprint 1"
    And click on "Create" button
    
