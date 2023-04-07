#Author: abhimanyukumar8787@gmail.com

@Regression
Feature: Validate drag and drop functionality using selenium

  @DragAndDrop
  Scenario: Verify if element is dragged from source and dropped to destination successfully
    Given user is on demosqa demo site
    Then wait till page is loaded
    And fetching the locators
    When click on "DragAndDrop"
    When user drags "High Tatras" and drops image to Trash
    Then verify if "High Tatras" image is successfully dropped in Trash

  