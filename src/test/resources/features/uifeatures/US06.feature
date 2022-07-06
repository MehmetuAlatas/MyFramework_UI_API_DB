@US06_kerem
Feature:US06_User_settings_should_be_editable_on_Homepage

  Background: user_is_on_Medunna_signin_page
    Given User goes to Medunna url
    When User navigates the sign in page

  @TC01_US06_kerem
  Scenario: TC01_User_verify_firstname_lastname_email_language_is_populated
    And user sends username "testuser01"
    And user sends password "ABCDEF"
    Then user clicks Sign in button
    And verify sign in success
    Then user clicks on user profile
    Then navigates and click Settings from dropdown list
    Then Verify firstname populated
    Then Verify lastname populated
    Then Verify email populated
    Then Verify language populated
    Then User sign out
    Then Close application


  @TC02_US06_kerem
  Scenario: TC02_Verify_firstname_can_update
    And user sends username "testuser01"
    And user sends password "ABCDEF"
    Then user clicks Sign in button
    And verify sign in success
    Then user clicks on user profile
    Then navigates and click Settings from dropdown list
    Then user enters new firstname "Velican" into firstname textbox
    Then User clicks save button
    Then Verify firstname updated
    And User sign out
    Then Close application

@TC03_US06_kerem
  Scenario: TC03_Verify_lastname_can_update
    And user sends username "testuser01"
    And user sends password "ABCDEF"
    Then user clicks Sign in button
    And verify sign in success
    Then user clicks on user profile
    Then navigates and click Settings from dropdown list
    Then user enters new lastname "Alican" into lastname textbox
    Then User clicks save button
    Then Verify lastname updated
    And User sign out
    Then Close application


