Feature: Opencart Search Functionality

  Scenario: Search for Sony
    Given User navigate to openCart website
    When  User search "Sony"
    Then  User see results "Sony"

  Scenario: Search for Samsung
    Given User navigate to openCart website
    When  User search "Samsung"
    Then  User see results "Samsung"

  Scenario: Search for Mac
    Given User navigate to openCart website
    When  User search "Mac"
    Then  User see results "Mac"