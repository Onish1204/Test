# Author: Varun Gupta
# Date: 13th April 2021
# Description: Assignment
@Assignment
Feature: Validate facebook login functionality

  @Assignment1
  Scenario: Validate facebook login with given credentials
    Given user navigate to facebook application
    When user login facebook with username "varun1204@gmail.com" and password "Mutri@2010"
    Then user post message "Hello World"
    And User close the application