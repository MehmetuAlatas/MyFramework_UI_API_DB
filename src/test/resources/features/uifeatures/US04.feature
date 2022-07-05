@US04_Demir
  Feature:US04_Login_page_should_accessible_only_with_valid_credentials

    Background: opening_base_url
      Given User goes to Medunna url
      When User navigates the sign in page

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
