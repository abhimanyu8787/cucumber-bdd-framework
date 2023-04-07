#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Add Employee Functionality Validation
	
	Background:
		Given user is on login page
    Then wait till page is loaded
    And fetching the locators
    
	
  @AddEmployee
  Scenario Outline: Verify if admin user is able to add employee successfully
  	When user enters creadentials "Admin" as "ValidUsername" and "admin123" as "ValidPassword"
    And user clicks on login button
  	And user navigates to PIM tab
  	Then user clicks on "Add Employee" button in top navigation menu
  	And user enters "<first name>" "<middle name>" "<last name>" and "<employee id>"
  	And toggle create login details
  	And user provides "<username>" and "<password>"
  	And user uploads profile picture
  	And click on save
  	
  Examples:
  |	first name	|	middle name	|	last name	|	employee id	|	username		| password				|
  |	Anubhi			| Singh				| Tomar			| 9876				| anubhiTomar	|	anubhiTomar-6		|
  
  @AddEmployee
  Scenario Outline: Verify if the added employee is reflected in the employee list
  	When user enters creadentials "Admin" as "ValidUsername" and "admin123" as "ValidPassword"
    And user clicks on login button
  	And user navigates to PIM tab
  	And user enters  "<name>" and "<employeeId>" in Employee Information Section
  	And clicks on search button
  	Then verify if "<name>" and "<employeeId>" is displayed in records table
  	
  Examples:
  |name								|employeeId	|
  |Anubhi Singh Tomar	|9876				|
  	
  @AddEmployee
  Scenario Outline: Verify if login is successfull with new credentials
  	When user enters creadentials "<username>" as "ValidUsername" and "<password>" as "ValidPassword"
    And user clicks on login button
    Then verify if login is successful
    And "<firstName>" and "<lastName>" is displayed as profile name
    
   Examples:
   |username		|password				|firstName	|lastName	|
   |anubhiTomar	|anubhiTomar-6	|Anubhi			|Tomar		|
  
    
