@roomApi
Feature: Room CRUD

  @roomApi1
  Scenario: createRoom

    Given user set the roomdata
    And user sends a post request for room
    And user verifies the status code is 201
    And user does assertion the room data

  @roomApi2
  Scenario: getRoom

    Given user sends a get request for room data with 11552 id
    And user deserializes the room data with 11552 id to java
    And user verifies the status code is 200
    And user does assertion the roomType is "TWIN" roomNumber is 777 id is 11552

  @roomApi3
  Scenario: updateRoom

    Given user set the roomdata for updating
    And user sends a put request for room
    And user verifies the status code is 200
    And user does assertion the updated room data

  @roomApi4
  Scenario: deleteRoom

    Given user sends a delete request for room with 132295 id
    And user verifies the status code is 204
