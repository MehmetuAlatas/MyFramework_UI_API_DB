@US11
Feature:US11_My_Appointments_Edit_portal_by_Physician

  Background:
    Given Doctor goes to Medunna url
    When Doctor navigates the sign in page
    And Doctor enters his credentials in popup window
    And Doctor clicks on Sign in button
    And Doctor navigates to My Pages segment
    And clicks on My appointments
    And Doctor clicks on Edit button
    And Doctor verifies patient's info
    And id, start and end date, status, physician are present

  @TC01
  Scenario:TC01

    And Doctor fills in required fields, anemnesis, treatment, diagnosis
    And Doctor clicks on Save button
    And Verify appointment is saved successfully
    And close the browser

  @TC02
  Scenario Outline:TC02_04_05

    And Doctor selects and verify status as "<status>" from dropdown can selectable
    And close the browser

    Examples: status
      | status    |
      | CANCELLED |
      | COMPLETED |
      | PENDING   |


  @TC03
  Scenario:TC03

    And Doctor selects status as UNAPPROVED from dropdown
    And Doctor verifies UNAPPROVED cannot be selectable
    And Doctor selects status as COMPLETED from dropdown
    And Doctor leaves blank required fields, anemnesis, treatment, diagnosis
    And Doctor clicks on Save button
    And Doctor verifies This field is required message
    And close the browser

