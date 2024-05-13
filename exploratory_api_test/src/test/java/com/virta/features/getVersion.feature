@allure.Exploratory.epic:API
Feature: Exploratory Test for Virtual charging station API
  Description: Test API to talk to virtual charging stations to verify their functionality. This single API allows sending
  different commands to the stations and read the values back

  @StationAPI
  Scenario Outline: Retrieve station current version (Id-Specific)
    Given I hit the url of post station api endpoint
    When I pass the "<stationId>" to endpoint and "<command>" to payload
    Then I receive response code <code>
    And I see the "<field>" as "<result>"


    Examples:
      | stationId | command   | payload | code | field   | result |
      | 1         | getVersion | 1       | 200  | result | 1.5    |
      | 2         | getVersion | 2       | 200  | result | 1.6    |
      | 3         | getVersion | 2       | 200  | result | 1.6    |
      | 4         | getVersion | 2       | 200  | result | 1.7    |
      | 4         | getTemperature | 2   | 400  | -     | -    |
      | 5         | getVersion | 2       | 500  | -     | -    |
