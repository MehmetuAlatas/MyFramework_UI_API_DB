@US13 @smoke
Feature:US13_My_Appointments_Edit_portal_by_Physician

  Background:
    Given Doctor goes to Medunna url
    When Doctor navigates the sign in page
    And Doctor enters his credentials in popup window
    And Doctor clicks on Sign in button
    And Doctor navigates to My Pages segment
    And clicks on My appointments
    And Doctor clicks on First Patient Edit button

  @US13_TC01
  Scenario:TC01

    And Doctor clicks on Show Test Results button
    And Doctor clicks on first patient view results button
    And Verify Test results of Urea, Sodium and Diabetes Medicine
    And close the browser

  @US13_TC02
  Scenario:TC02

    And Doctor clicks on request Inpatient button
    And Doctor verifies the InPatient request done for this appointment
    And Doctor navigates to My Pages segment
    And Doctor clicks My Inpatients button
    And Doctor Verify the Inpatient is existing
    And close the browser
