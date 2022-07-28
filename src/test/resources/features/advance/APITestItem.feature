Feature: api test item creation

  @ApiTestItem
  Scenario Outline: api test item creation
    * user sets the necessary path parameters
    * user sets the expected data "<name>", "<description>", "<price>", "<defMinVal>", "<defMaxVal>"
    * user send the post request and gets the response
    * user validates all api records

    Examples: test data
      |name|description|price|defMinVal|defMaxVal|
      |H1bAc6|3 AYLIK SEKER|599|1       |15       |