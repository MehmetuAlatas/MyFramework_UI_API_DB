@us_10
Feature: US_10_Doctor_Sees_My_Appointments

  Background: user_navigates_to_base_url
    Given user launches the browser and navigates to url

  @us_10_tc_01
  Scenario: US_10_My_Appointments
    When user navigates to sign in page
    Then user types username as "doctor79"
    Then user types password as "doctor"
    Then user clicks sign in button
    Then user clicks on my page
    Then user clicks on my appointments
    Then user verifies appointments list
    Then user verifies time slots

  @us_10_tc_02
  Scenario: US_10_My_Appointments
    When user navigates to sign in page
    Then user types username as "doctor79"
    Then user types password as "doctor"
    Then user clicks sign in button
    Then user clicks on my page
    Then user clicks on my appointments
    Then user verifies patient id
    Then user verifies start date
    Then user verifies end date
    Then user verifies status








