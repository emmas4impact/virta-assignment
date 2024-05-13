Feature: Exploratory Test for Virtual charging station API
  Description: Test API to talk to virtual charging stations to verify their functionality. This single API allows sending
  different commands to the stations and read the values back

  @StationAPI
  Scenario Outline: Sets interval station reporting values

    Given I hit the url of post station api endpoint
    When I pass the "<stationId>" to endpoint and "<command>" to payload
    Then I receive response code <code>
    And I see the "<field>" as "<result>"

    Examples:
      | stationId | command    | payload | code | field   | result |
      | 1         | setValues  | 1       | 200  | result | FAILED  |
      | 2         | setValues  | 2       | 200  | result | FAILED  |
      | 3         | setValues  | 2       | 200  | result | OK      |
      | 4         | setValues  | 2       | 200  | result | true    |
      | 4         | setWeather | 2        | 400  | -     | -       |
      | 5         | setValues  |  2       | 500  | -     | -         |