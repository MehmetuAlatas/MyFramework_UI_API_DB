@Api
Feature: Test Api registrant data

  @api1
  Scenario: getApi mehmet

    Given user sends a get request for users data
    And user deserializes the users data to java
    Then user saves the users data to correspondent files and validates

  @api2
  Scenario: mehmet updates the user with api

    Given user sends a post request for create a new user
    And user deserializes the response to java
    Then user saves the users data to correspondent files




