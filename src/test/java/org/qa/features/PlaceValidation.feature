Feature: Validate Place API's

  Scenario: Verify place is being successfully added by AddPlace API
    Given AddPlace API Payload
    When user calls "AddPlaceAPI" with Post http request
    Then API call is success with status code 200
    And "status" is in response body is "OK"
    And "scope" is in response body is "APP"