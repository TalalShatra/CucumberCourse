Feature: Search Function with Scenario Outline

  # Scenario Outline will execute the same scenario with different data
  Scenario Outline: Search items in Opencart website
    Given User navigate to openCart
    When User search for "<Item>" in Opencart
    Then User should see results for "<ResultItem>" in Opencart

    Examples:
      | Item    | ResultItem |
      | Sony    | Sony       |
      | Samsung | Samsung    |
      | Mac     | Mac        |