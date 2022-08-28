Feature: Search Function

  Background:
    Given User navigate to website
    And User go to Search page

  Scenario: User search  for Sony
# when user search for "" --> this is our step and we can pass any data between double quote
    When User search for "Sony"
    Then All the results should be displayed for "Sony"


  Scenario: User search  for Samsung
    When User search for "Samsung"
    Then All the results should be displayed for "Samsung"


  Scenario: User search  for HP
    When User search for "HP"
    Then All the results should be displayed for "HP"
