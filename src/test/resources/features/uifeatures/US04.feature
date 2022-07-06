@US04_Demir
  Feature:US04_Login_page_should_accessible_only_with_valid_credentials

    Background: opening_base_url
      Given Firstly user goes to Medunna url
      When Then user navigates the sign in page

    @US04_TC_01
    Scenario: TC01_Login_page_should_accessible_only_with_valid_credentials_and_there_should_be_a_remember_me_option_where_user_can_always_use_their_existing_credentials
      And User enters his or her valid username "vusalgasimov" and password "vusalgasimov" in popup window
      And User click to "Remember me" radio button
      Then User clicks "Sign in" button and enter Home page

    @US04_TC_02
    Scenario: TC02_There_should_be_an_empty_username_box_for_get_warning_message
      And User leaves username box blank "" in popup window then click anywhere on the screen.
      Then User verifies there is a warn text only under the Username box what contains "Username cannot be empty!"

    @US04_TC_03
    Scenario: TC03_There_should_be_an_invalid_username_and_password_for_get_warn_text
      And User enters invalid credentials username "abc" password "cba123." in popup window then click Sign in button.
      And User verifies there is a temporary alert message on left top of the page
      Then User verifies there is an warn text above the Username box what contains: "Failed to sign in! Please check your credentials and try again."

    @US04_TC_04
    Scenario: TC03_There_should_be_a_valid_username_and_empty_password_box_for_get_the_caution_message_under_Password_box
      And User enters his or her valid username "vusalgasimov" then clicks Sign in button without go to the password box
      And User verifies there is a warn text under the Password box what contains "Password cannot be empty!"
      And User verifies there is a warn text above the Username box what contains: "Failed to sign in! Please check your credentials and try again."
      Then User verifies there is a temporary alert message because of blank password box on left top of the page

    @US04_TC_05
    Scenario: TC05_There_should_be_valid_username_and_invalid_password_for_get_caution
      And User enters his or her valid username "vusalgasimov" but does not enter valid password "Abc.123" in popup window then click Sign in button.
      And User verifies when password invalid there is a warn text above the Username box what contains: "Failed to sign in! Please check your credentials and try again."
      And User verifies there is a temporary alert message after invalid password on left top of the page

    @US04_TC_06
    Scenario: TC06_Enter_valid_email_after_clicking_(Did you forget your password)_button_to_email_box
      And User enters his or her valid or invalid username "A" to username box and clicks Did you forget your password? button on popup window
      And User enters a valid email address "vusal@gmail.com" which is required @ and .com, .edu etc. extensions and requires at least five characters into the email box.
      And User clicks Reset password button
      Then User verifies there is a temporary alert message on left top of the webpage what contains "Check your emails for details on how to reset your password"

    @US04_TC_07
    Scenario: TC07_User_leaves_blank_email_box_after_clicking_(Did you forget your password)_button
      And User enters his or her valid or invalid username "B" and clicks Did you forget your password? button on popup window
      And User does not enter any character to Email box and clicks Reset password button
      Then User verifies there is a caution text under the email box what contains "Your email is required."

    @US04_TC_08
    Scenario: TC08_User_enters_maximum_four_characters_or_less_in_Email_box_after_clicking_to_Did you forget your password?_button
      And User enters his or her valid or invalid username "C" to username box then clicks Did you forget your password? button on popup window
      And And User enters maximum four characters "abcd" or less in Email box
      And User clicks Reset password button or anywhere on the page
      Then User verifies there is a warning under the email box what contains "Your email is required to be at least 5 characters."

    @US04_TC_09
    Scenario: TC09_There_should_be_an_option_to_update_password_if_forgotten_(Did you forget your password)
      And User enters any username "D" and clicks Did you forget your password? button on popup window
      Then User enters five or more characters "car.blue@fast" which is not contains @ and .com, .edu etc. extensions or does not sort those requirements properly
      And User clicks Reset password button or anywhere on the Account Reset Request page
      Then User verifies there is a warn message under the email box what contains "This field is invalid"

    @US04_TC_10
    Scenario: TC10_There should be an option to navigate to registration page if not registered yet
      And User verifies there is a text "You don't have an account yet?"
      And User clicks Register a new account button
      And User verifies there is a text only under the Username box what contains "Username cannot be empty!"
      And User clicks again Register a new account button
      Then Verify is User on Registration page with URL

    @US04_TC_11
    Scenario: TC11_There should be an option to cancel login
      And User verifies there is a clickable Cancel button and clicks button
      And User verifies there is a warn text under the Username box what contains "Username cannot be empty!"
      And User clicks again Cancel button
      Then User verifies after cancellation right top of the page a dropdown which contains "Sign in" and "Register" buttons.