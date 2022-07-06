@US12
Feature: My_Appointments_Edit_Request_test

  Background: user_navigates_to_base_url
    Given user launches the browser and navigates to url
    When user navigates to sign in page
    Then user types username as "doctor79"
    Then user types password as "doctor"
    Then user clicks sign in button
    Then user clicks on my page
    Then user clicks on my appointments

  Scenario: My_Appointments_Edit_Request_test
    Then user clicks on edit button
    Then user clicks on Request a test
    Then user verifies test types Urea, Creatinine, Sodium Potassium, Total protein, Albumin, Hemoglobin
    Then user clicks on the  Urea checkbox
    Then user clicks on the  Creatinine checkbox
    Then user clicks on the  Sodium checkbox
    Then user clicks on the  Potassium checkbox
    Then user clicks on the  Total Protein checkbox
    Then user clicks on the Albumin checkbox
    Then user clicks on the  Hemoglobin checkbox
    And user clicks on save button
    And user verifies a new Test is created with identifier <id>" message
