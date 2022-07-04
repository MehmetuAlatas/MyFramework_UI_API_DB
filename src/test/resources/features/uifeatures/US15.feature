@TC01_asim
Feature: US15_Create_Edit_Delete_By_Admin

    Scenario: TC01_Create_Patient_By_Admin_Login
      Given Admin goes to Medunna url
      Then Admin navigates the sign in page
      And Admin enters his username "team84_asim" and "asim123" in popup window and clicks sign in button
      And  Admin navigates to Items and Titles segment and clicks on patient
      And Admin clicks on Create a new Patient button
      And Admin enters All the credentials SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and State
      And Then click on save button
      And Verify new patient created pop up
