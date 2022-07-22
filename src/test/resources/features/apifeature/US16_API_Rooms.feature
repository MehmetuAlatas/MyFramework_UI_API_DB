@roomApi
Feature: Room CRUD

  @roomApi1
  Scenario: getRoom

    Given user sends a get request for room data with 11552 id
    And user deserializes the room data with 11552 id to java
    And user verifies the status code is 200
    And user does assertion the roomType is "TWIN" roomNumber is 777 id is 11552

  @roomApi2
  Scenario: getRoom

    Given user sends a get request for room data with 11552 id
    And user deserializes the room data with 11552 id to java
    And user verifies the status code is 200
    And user does assertion the roomType is "TWIN" roomNumber is 777 id is 11552
