@US_014
Feature:US14_view_edit_inpatients_by_physician

  Background: opening_base_url
    Given doctor is on the Medunna page

  @TC_001
  Scenario: TC01_view_inpatient_info_by_physician
    When doctor navigates to sign in page
    And enters his username "edaphysician2@gmail.com" and password "123456" and clicks sing in
    And clicks on My Pages segment
    And clicks on My Inpatients
    Then verifies ID, Start Date, End Date, Status, Description, Created Date, Room, Appointment and Patient visible


  @TC_002
  Scenario: TC02_update_inpatient_info_by_physician
    When doctor navigates to sign in page
    And enters his username "edaphysician2@gmail.com" and password "123456" and clicks sing in
    And clicks on My Pages segment
    And clicks on My Inpatients
    And clicks edit button on Unapproved patients record
#    And updates ID, Start Date, End Date, Status, Description, Created Date, Room, Appointment and Patient
#    And clicks save button
#    Then verifies In Patient is updated message appeared
#    Then verifies changes are reflected on the patient record



