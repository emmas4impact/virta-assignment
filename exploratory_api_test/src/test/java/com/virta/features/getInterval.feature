Feature: Exploratory Test for Virtual charging station API
  Description: Test API to talk to virtual charging stations to verify their functionality. This single API allows sending
  different commands to the stations and read the values back

   @StationAPI
   Scenario Outline: Get Reporting Interval (Id-Specific)

     Given I hit the url of post station api endpoint
     When I pass the "<stationId>" to endpoint and "<command>" to payload
     Then I receive response code <code>
     And I see the "<field>" as "<result>"

      Examples:

        | stationId | command    | payload   | code | field   | result |
        | 1         | getInterval  | 1       | 200  | result | 0       |
        | 2         | getInterval  | 2       | 200  | result | 1       |
        | 3         | getInterval  | 2       | 200  | result | 20      |
        | 4         | getInterval  | 2       | 200  | result | 60      |
        | 4         | setSession   | 2       | 400  | -     | -       |
        | 5         | getInterval  |  2      | 500  | -     | -       |
