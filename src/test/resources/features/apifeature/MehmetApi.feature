@Api
Feature: Test Api registrant data

  @api1
  Scenario: getApi mehmet

    Given user sends a get request for users data
    And user deserializes the users data to java
    And user analyses the response for existing some specific data
    Then user saves the users data to correspondent files and validates

  @api2
  Scenario: mehmet updates the user with api

    Given user sends a post request for create a new user
    And user deserializes the response to java
    Then user saves the users data to correspondent files

  @api3
  Scenario: user manipulate the messages

    Given user sends a get request for messages
    Then user deserializes the response to java for messages
    And user manipulate the messages and does assertion

  @api4
  Scenario: user manipulate the messages
#    And Doctor verifies patient's info
#    And id, start and end date, status, physician are present
    Given user sends a get request for patients info
    Then user deserializes the response to java for patients info

#    And Doctor fills in required fields, anemnesis, treatment, diagnosis
#    And Doctor clicks on Save button
#    And Verify appointment is saved successfully
#    And close the browser
#    And Doctor selects and verify status as "<status>" from dropdown can selectable
#    And close the browser
#
#    Examples: status
#      | status    |
#      | CANCELLED |
#      | COMPLETED |
#      | PEND
#
#    And Doctor selects status as UNAPPROVED from dropdown
#    And Doctor verifies UNAPPROVED cannot be selectable
#    And Doctor selects status as COMPLETED from dropdown
#    And Doctor leaves blank required fields, anemnesis, treatment, diagnosis
#    And Doctor clicks on Save button
#    And Doctor verifies This field is required message
#    And close the browser


