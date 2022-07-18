@NewApplicant
Feature: Test Registrant Data

  Background: set_up
    Given  user navigates to Medunna url
    And user navigates the registration page


  Scenario Outline: Test new applicants

    Given user provides their ssn id as "<ssn>"
    And user provides their firstname as "<firstname>"
    And user provides their lastname as "<lastname>"
    And user provides their username as "<username>"
    And user provides their email as "<email>"
    And user provides their password as "<password>"
    And user types their password confirmatino as "<passwordconfirm>"
    Then user registers and saves the records

    Examples:Test data for applicants
      | ssn         | firstname | lastname | username | email             | password | passwordconfirm |
      | 313-77-3137 | mehmet    | test     | qa313    | qa313@medunna.com | Qa313    | Qa313           |
      | 313-77-3137 | mehmet    | test     | qa313    | qa313@medunna.com | Qa313    | Qa313           |
      | 313-77-3137 | mehmet    | test     | qa313    | qa313@medunna.com | Qa313    | Qa313           |
      | 313-77-3137 | mehmet    | test     | qa313    | qa313@medunna.com | Qa313    | Qa313           |
      | 313-77-3137 | mehmet    | test     | qa313    | qa313@medunna.com | Qa313    | Qa313           |
