@US09
Feature: Staff Edit Patient
  Background: opening_medunna_website
    Given Launch browser and navigate to medunna.com
    Then Staff navigates to the sign in page
    Then Staff signs in
    Then Staff clicks on My Pages link
    Then Staff clicks on Search Patient link
    Then Staff enters the patient SSN number

  @TC01_staff_edit_patient
  Scenario: TC01_Admin_Edit_Patient
    Then Staff clicks on Edit Button
    Then Staff edits firstname
    Then Staff edits lastname
    Then Staff edits birthdate
    Then Staff edits email
    Then Staff edits phone
    Then Staff edits gender
    Then Staff edits blood group
    Then Staff edits address
    Then Staff edits description
    Then Staff edits user
    Then Staff edits country
    Then Staff edits state-city
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message