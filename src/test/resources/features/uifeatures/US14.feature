@US_014
Feature:US14_view_edit_inpatients_by_physician

  Background: opening_base_url
    Given doctor is on the Medunna page
    When doctor navigates to sign in page
    And enters his username "edaphysician2@gmail.com" and password "123456" and clicks sing in
    And clicks on My Pages segment
    And clicks on My Inpatients

  @TC_001
  Scenario: TC01_view_inpatient_info_by_physician
    Then verifies ID, Start Date, End Date, Status, Description, Created Date, Room, Appointment and Patient visible


  @TC_002
  Scenario: TC02_update_unapproved_inpatient_info_by_physician
    And clicks edit button on Unapproved patients record
    And updates Description, Created Date, and Status and Room for Unapproved Patient
#    And clicks save button
#    Then verifies In Patient is updated message appeared
#    Then verifies changes are reflected on the patient record

  @TC_003
  Scenario:  TC03_update_staying_inpatient_info_by_physician
#    And clicks edit button on Staying patients record
#    And updates Description, Created Date, and Status and Room for Unapproved Patient for Staying Patient
#    And clicks save button
#    Then verifies In Patient is updated message appeared
#    Then verifies changes are reflected on the patient record

  @TC_004
  Scenario:  TC03_update_discharged_inpatient_info_by_physician
#    And clicks edit button on Discharged patients record
#    And updates Description, Created Date, and Status and Room for Unapproved Patient for Discharged Patient
#    And clicks save button
#    Then verifies In Patient is updated message appeared
#    Then verifies changes are reflected on the patient record

  @TC_005
  Scenario:  TC03_update_cancelled_inpatient_info_by_physician
#    And clicks edit button on Cancelled patients record
#    And updates Description, Created Date, and Status and Room for Unapproved Patient for Cancelled Patient
#    And clicks save button
#    Then verifies In Patient is updated message appeared
#    Then verifies changes are reflected on the patient record



