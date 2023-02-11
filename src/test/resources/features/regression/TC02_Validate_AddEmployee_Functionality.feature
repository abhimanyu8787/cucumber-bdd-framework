#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Add Employee Functionality Validation
	
	Background:
		Given user is on login page
    Then wait till page is loaded
    And fetching the locators
    When user enters creadentials "Admin" as "ValidUsername" and "admin123" as "ValidPassword"
    And user clicks on login button
	
  @AddEmployee
  Scenario Outline: Verify if admin user is able to add employee successfully
  	When user navigates to PIM tab
  	Then user clicks on "Add Employee" button in top navigation menu
  	And user enters "<first name>" "<middle name>" "<last name>" and <employee id>
  	And toggle create login details
  	And user provides "<username>" and "<password>"
  	And user uploads profile picture
  	And click on save
  	
  Examples:
  |	first name	|	middle name	|	last name	|	employee id	|	username		| password				|
  |	Anubhi			| Singh				| Tomar			| 2568				| anubhiTomar	|	anubhiTomar@06	|
  	
  
    
