Feature: Google Search

  Scenario: Search for Cucumber in Google
    Given User navigate to Google
    When User Search for Cucumber in Google
    Then User should see Cucumber in Google