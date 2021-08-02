Feature: Validate Place API's

  Scenario Outline: Verify place is being successfully added by AddPlace API
    Given AddPlace API Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with Post http request
    Then API call is success with status code 200
    And "status" is in response body is "OK"
    And "scope" is in response body is "APP"

    Examples:
      | name      | language | address       |
      | MyHouse   | Bangle   | dhaka,Gulshan |
      | YourHouse | English  | Canada        |