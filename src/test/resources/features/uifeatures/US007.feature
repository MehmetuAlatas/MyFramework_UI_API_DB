@TC01_alim
Feature: US007_view_make_an_appointment

  Background: medunna_appointment_page


    Given user goes to Medunna url
    And user clicks on Get Started button

    And user enters valid first name
    And user enters valid last name
    And user enters valid ssn
    And user enters valid email
    And user enters valid phone number

  Scenario:TC01_user_enters_appointment_date

    And user enters valid appointment date
    And user clicks on Send and Appointment Request
    Then verify user can make an appointment successfully