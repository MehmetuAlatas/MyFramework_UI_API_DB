@US1_API
Feature: US01_api_and_DB_validation_feature

  @US1_TestCase8
  Scenario: US01_TC8_valid_Create_registrants_using_api_and_validate
    Given user provides valid body from Swagger
    Given user send post request to url "https://medunna.com/api/register"
    Then verify status code is 201
    And assert email, login, firstname, lastname, ssn with given data in body

  @US1_TestCase9
  Scenario: US01_TC9_invalid_Create_registrants_using_api_and_validate
    Given user send post request to url "https://www.medunna.com/api/users"
    When user provides existing user info body from Swagger
    Then verify status code is "400 Bad Request"
    And assert body of the response

  @US1_TestCase10
  Scenario: US01_TC10_valid_get_all_registrant_information_using_swagger_and_validate_them
    Given user send get request to url "https://www.medunna.com/api/user"
    When user provides ssn  number "ssn" as a query parmeter
    Then verify status code is "200"
    And assert email, login, firstname, lastname, ssn with given data in body

  @US1_TestCase11
  Scenario: US01_TC11_invalid_get_all_registrant_information_using_swagger_and_validate_them
    Given user send get request to url "https://www.medunna.com/api/user"
    When user provides not registered  ssn  number "ssn" as a query parmeter
    Then verify status code is "400 Not Found"