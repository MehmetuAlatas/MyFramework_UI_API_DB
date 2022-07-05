@US01_UI
Feature: US01_Registration_should_be_available_using SSN_firstname_and_lastname_feature

  Background: set_up
    Given  user navigates to Medunna url
    And user navigates the registration page

  @US01_TestCase1
  Scenario Outline: US1_TC1_valid_ssn_feature
    Then  user provides valid ssn "<ssn>" number
    Then user should not see the error message Your SSN is required or Your SSN is invalid

    Examples: ssn
      | ssn         |
      | 123-45-6789 |
      | 234-56-1234 |
      | 002-23-4532 |
      | 890-12-4567 |
      | 345-67-0001 |

  @US01_TestCase2
  Scenario Outline: US1_TC2_invalid_ssn_feature
    Then  user provides invalid ssn "<ssn>" number
    Then user should see the error message Your SSN is invalid

    Examples: ssn
      | ssn         |
      | 12345-6789  |
      | 234561234   |
      | 002         |
      | 990-1-24567 |
      | 34567-0001  |

  @US01_TestCase3
  Scenario: US1_TC3_blank_ssn_feature
    Then  user leaves ssn box blank
    Then user should see the error message Your SSN is required.

  @US01_TestCase4
  Scenario Outline: US1_TC4_valid_firstname_feature
    Then  user provides valid firstname "<firstname>" that contains any chars
    Then user should not see the error message Your FirstName is required.

    Examples: ssn
      | firstname   |
      | Osman       |
      | 234         |
      | ?           |
      | ###         |
      | 345-67-0001 |

  @US01_TestCase5
  Scenario: US1_TC5_blank_firstname_feature
    Then  user leaves firstname box blank
    Then user should see the error message Your FirstName is required.

  @US01_TestCase6
  Scenario Outline: US1_TC6_valid_lastname_feature
    Then  user provides valid lastname "<lastname>" that contains any chars
    Then user should not see the error message Your LastName is required.

    Examples: ssn
      | lastname    |
      | Sayli       |
      | 234         |
      | ?           |
      | ###         |
      | 345-67-0001 |


  @US01_TestCase7
  Scenario: US1_TC7_blank_lastname_feature
    Then  user leaves lastname box blank
    Then user should see the error message Your LastName is required.