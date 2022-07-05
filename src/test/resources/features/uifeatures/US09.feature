@US09
Feature: Admin Edit Patient
  Background: opening_medunna_website
    Given Launch browser and navigate to medunna.com
  @TC01_admin_edit_patient
  Scenario: TC01_Admin_Edit_Patient

    Then Admin navigates to the sign in page
    Then Admin signs in
    Then Admin clicks to items&title link
    Then Admin clicks on Patient link
    Then Admin verifies he-she is on Patient page
    Then Admin clicks on »» to go to the last page
    Then Admin clicks on ID
    Then Admin clicks on Edit Button
    Then Admin edits firstname
    Then Admin edits lastname
    Then Admin edits birthdate
    Then Admin edits email
    Then Admin edits phone
    Then Admin edits gender
    Then Admin edits blood group
    Then Admin edits address
    Then Admin edits description
    Then Admin edits user
    Then Admin edits country
    Then Admin edits state-city
    Then Admin verifies A Patient is updated with identifier <patient Id> message

  @TC02_Admin_Delete_Patient
  Scenario: TC02_Admin_Delete_Patient
    Then Admin navigates the sign in page
    Then Admin signs in
    Then Admin clicks to items&title link
    Then Admin clicks on Patient link
    Then Admin verifies he-she is on Patient page
    Then Admin clicks on »» to go to the last page
    Then Admin clicks on ID
    Then Admin clicks on Delete Button
    Then Admin clicks on pop ups delete button
    Then Admin verifies A Patient is deleted with identifier <patient Id> message