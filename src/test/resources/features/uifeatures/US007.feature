
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

 Scenario:TC02_user_enters_appointment_date
 And user clicks calendar button on Appointment DateTime box
 And user clicks on clear
 And user does not enter any date
 And user clicks Send and Appointment Request
 Then verify user can not make an appointment successfully

  Scenario:TC03_user_enters_appointment_date
  When user enters a older date
  And user sees Appointment date can not be past date! warning on date field
  And user clicks Send and Appointment Request
  And verify user can not make an appointment successfully

  Scenario:TC04_user_enters_appointment_date
  When user clicks calendar button on Appointment DateTime box
  And user clicks on today error message
  And user should not see any error message
  And user clicksSend and Appointment Request
  Then verify user can make an appointment successfully

  Scenario:TC05_user_enters_appointment_date
  And user clicks calendar button on Appointment DateTime box
  And user enters valid month
  And user enter valid day
  And user does not enter year
  And user clicksSend and Appointment Request
  And verify user can make an appointment successfully

  Scenario:TC06_user_enters_appointment_date
  When user clicks calendar button on Appointment DateTime box
  And user enters invalid month
  And verify that user is on day field

  Scenario:TC07_user_enters_appointment_date
  When user clicks calendar button on Appointment DateTime box
  And user clicks on up arrow
  And verify that user is navigated to previous month

  Scenario:TC08_user_enters_appointment_date
  And user enters valid future date
  And user verifies that correct date is displayed

  Scenario:TC09_user_enters_appointment_date
  When user clicks calendar button on Appointment DateTime box
  And user clicks on Month Year button
  And user clicks on next year
  And user chooses month
  And user chooses day
  And user sees correct choosen month, day, and year
  And user clicks Send and Appointment Request
  Then verify user can make an appointment successfully

  Scenario:TC010_user_enters_appointment_date
  And user enter vaid date using forward slash
  And user clicks Send and Appointment Request
  Then verify user can make an appointment successfully

  Scenario:TC011_user_enters_appointment_date
  When user enters letters on date box
  And user does not see any change on date
  And user clicks Send and Appointment Request
  Then verify user can make an appointment successfully

  Scenario:TC012_user_enters_appointment_date
  When user enters symbols date box
  And user clicks Send and Appointment Request
  Then verify user can make an appointment successfully

  Scenario:TC013_user_enters_appointment_date
  And user enters symbols date box
 Then user clicks on upper arrow and select older date