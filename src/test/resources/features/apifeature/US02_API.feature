@US02_ktu_API
Feature: US02_Username_and_email_registration
@US002_TC08_API_POST_Registrant
Scenario: TC01_Medunna_Register_User_Test8
Given user provides POST body from Swagger
Given user send post request to api url
Then verify response status code is 201
And assert email and  login with given data in body

