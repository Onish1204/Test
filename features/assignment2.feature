# Author: Varun Gupta
# Date: 13th April 2021
# Description: Assignment
@Assignment
Feature: Validate review functionality
  @Assignment2
  Scenario: Validate review functionality on WalletHub
    Given user navigate to "test_insurance_company" profile
    When user login WalletHub with username "varun1204@gmail.com" and password "Onish@2017"
    And user rate '4' to the company
    And user select "Health Insurance" in Policy dropdown
    And user writes random review of length "200"
    Then verify review feed got updated
    And user navigate to profile page
    And verify visibility of review.
    And User close the application

