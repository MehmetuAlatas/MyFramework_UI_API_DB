@US13
Feature:US13_My_Appointments_Edit_portal_by_Physician

#to be arranged wih hooks and before
  @TC01
  Scenario:TC01
    Given Doctor goes to Medunna url
    When Doctor navigates the sign in page
    And Doctor enters his credentials in popup window
    And Doctor clicks on Sign in button
    And Doctor navigates to My Pages segment
    And clicks on My appointments
    And Doctor clicks on OOOOO patient edit button
    And Doctor clicks on request Inpatient button
    And Doctor verifies the InPatient request done for this appointment//A new In Patient is created with identifier 103243
    And Doctor navigates to My Pages segment
    And Doctor clicks My Inpatients button
    And Doctor Verify the test results with Urea, Sodium and diabetes medicine
    And close the browser

  @TC02
  Scenario:TC02

#dependson method to be applied
    Given Doctor goes to Medunna url
    When Doctor navigates the sign in page
    And Doctor enters his credentials in popup window
    And Doctor clicks on Sign in button
    And Doctor navigates to My Pages segment
    And clicks on My appointments
    And Doctor clicks on First Patient Edit button
    And Doctor clicks on Show Test Results button
    And Doctor clicks on first patient view results button
    And Verify Test results of Urea, Sodium and Diabetes Medicine
    And close the browser
