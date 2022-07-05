@TC01_ktu
Feature: US02_Username_and_email_registration

  Background: opening_medunna
    Given Go to Medunna url and navigates the register page

  @SO_US002_TC01_Username_OK
  Scenario Outline: TC01_Medunna_Register_User_Test1
    When user write "<username>" on Username Textbox
    Then Assert that Username Label is grey color
#    Then close the application

    Examples: test_data
      |SSN|First Name|Last Name|username|email|new password|new passwor confirmation|
      |247-41-3983|ali|desidero|alidesidero1112|anamur3333@gmail.com|asd456|asd456|
#      |247-41-3983|ali|desidero|alidesi?dero1112|anamur3333@gmail.com|asd456|asd456|


  @SO_US002_TC01_Username_invalid
  Scenario Outline: TC01_Medunna_Register_User_Test2
#    When user write invalid "<username>" on Username Textbox
    When user write "<username>" on Username Textbox
    Then Assert that Username Label is red color
#    Then close the application

    Examples: test_data2
      |SSN|First Name|Last Name|username|email|new password|new passwor confirmation|
#      |247-41-3983|ali|desidero||anamur3333@gmail.com|asd456|asd456|
      | 247-41-3983 | ali        | desidero  |          | anamur3333@gmail.com | asd456       | asd456                   |


  @SO_US002_TC01_email_OK
  Scenario Outline: TC01_Medunna_Register_User_Test3
    When user write "<email>" on Email Textbox
    Then Assert that Email Label is grey color
#    Then close the application

    Examples: test_data3
      |SSN|First Name|Last Name|username|email|new password|new passwor confirmation|
      |247-41-3983|ali|desidero|alidesidero1112|anamur3333@gmail.com|asd456|asd456|
#      |247-41-3983|ali|desidero|alidesi?dero1112|anamur3333@gmail.com|asd456|asd456|

  @SO_US002_TC01_email_invalid
  Scenario Outline: TC01_Medunna_Register_User_Test4
    When user write "<email>" on Email Textbox
    Then Assert that Email Label is red color
#    Then close the application

    Examples: test_data5
      | SSN         | First Name | Last Name | username        | email               | new password | new passwor confirmation |
      | 247-41-3983 | ali        | desidero  | alidesidero1112 | anamur3333gmail.com | asd456       | asd456                   |
      | 247-41-3983 | ali        | desidero  | alidesidero1112 | anamur3333@gmailcom | asd456       | asd456                   |
      | 247-41-3983 | ali        | desidero  | alidesidero1112 |                     | asd456       | asd456                   |
#      |247-41-3983|ali|desidero|alidesi?dero1112|anamur3333@gmail.com|asd456|asd456|

  @SO_US002_TC01_registration_saved
  Scenario Outline: TC01_Medunna_Register_User_Test5
    When user write "<SSN>" on SSN Textbox
    When user write "<First Name>" on First Name Textbox
    When user write "<Last Name>" on Last Name Textbox
    When user write new "<username>" on Username Textbox
    When user write new "<email>" on Email Textbox
    When user write "<new password>" on New Password Textbox
    When user write "<new password>" on New Password Conformation Textbox
    When user click register button
    Then verify Registration saved message is diplayed

#    Then close the application

    Examples: test_data5
      |SSN|First Name|Last Name|username|email|new password|new passwor confirmation|
      |247-41-3983|ali|desidero|alidesidero1112|anamur3333gmail.com|asd456|asd456|
#      |247-41-3983|ali|desidero|alidesi?dero1112|anamur3333@gmail.com|asd456|asd456|


  @SO_US002_TC01_registration_with_already_registered_username
  Scenario Outline: TC01_Medunna_Register_User_Test6
    When user write "<SSN>" on SSN Textbox
    When user write "<First Name>" on First Name Textbox
    When user write "<Last Name>" on Last Name Textbox
    When user write in-use "<username>" on Username Textbox
    When user write new "<email>" on Email Textbox
    When user write "<new password>" on New Password Textbox
    When user write "<new password>" on New Password Conformation Textbox
    When user click register button
    Then verify username is already registered message is diplayed

#    Then close the application

    Examples: test_data6
      |SSN|First Name|Last Name|username|email|new password|new passwor confirmation|
      |247-41-3983|ali|desidero|alidesid@ero1112|anamur3333gmail.com|asd456|asd456|
#      |247-41-3983|ali|desidero|alidesi?dero1112|anamur3333@gmail.com|asd456|asd456|

  @SO_US002_TC01_registration_with_already_registered_email
  Scenario Outline: TC01_Medunna_Register_User_Test7
    When user write "<SSN>" on SSN Textbox
    When user write "<First Name>" on First Name Textbox
    When user write "<Last Name>" on Last Name Textbox
    When user write new "<username>" on Username Textbox
    When user write in-use "<email>" on Email Textbox
    When user write "<new password>" on New Password Textbox
    When user write "<new password>" on New Password Conformation Textbox
    When user click register button
    Then verify email is already registered message is diplayed

#    Then close the application

    Examples: test_data7
      |SSN|First Name|Last Name|username|email|new password|new passwor confirmation|
      |247-41-3983|ali|desidero|alidesidero1112|staff@email.com|asd456|asd456|
#      |247-41-3983|ali|desidero|alidesi?dero1112|anamur3333@gmail.com|asd456|asd456|