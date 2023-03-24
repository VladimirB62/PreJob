Feature: Smoke Test with Checking Presence of elements
  Scenario: Check presence and validation of all elements on both pages
    Given Navigate to Home Page
    When Check title
    And Check Telegram QR-code
    And Check Telegram Link
    And I choose profession
    Then Main Page Title displayed

    When I check videos
    And I check video Titles
    And I check filters
    And I choose Parameters
    Then Results are displayed

    When I check results matching
    And check paging
    And click JoinToUs Button
    Then I'm redirected to Telegram

