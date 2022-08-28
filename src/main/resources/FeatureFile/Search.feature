Feature: Search Functionality
# All the steps in Background will get executed before each scenario
  # Background keyword works like @BeforeMethod annotation in TestNG
  Background:
    Given User navigate to website
    And User go to Search page

  Scenario: Search for Cucumber
    When User Search for Cucumber
    Then  All the results should be displayed for Cucumber

  Scenario: Search for SDET
    When User Search for SDET
    Then All the results should be displayed for SDET