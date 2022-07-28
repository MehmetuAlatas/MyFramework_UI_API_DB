@db_read
  Feature: database

    @db_login_name
    Scenario: read user information
      Given user connectts to the database
      And user gets the "*" from "jhi_user" table
      # Select * from jhi_user
      And user read all of the "login" column data
      And verify "jhi_user" table "login" column contains "muratdoctor"
      # And verify "country" table "name column contains "senegal"
      # And verify "c_test_item" table "name column contains "Potassium"

      Then close the database connection

