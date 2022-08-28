Feature: Zero Bank Function

  Scenario Outline: Add new Payee Functionality Test
    Given Navigate to Zero Bank web page
    And Login to your account in Zero Bank
    When navigate to Pay Bills page
    And add New Payee "<name>"
    Then you should see a message

    Examples:
      | name  |
      | Frank |
      | 123   |


  Scenario Outline: Purchase Foreign Currency Functionality Test
    Given Navigate to Zero Bank web page
    And Login to your account in Zero Bank
    When navigate to Pay Bills page
    And add Purchase foreign currency "<amount>"
    Then you should see Success message

    Examples:
      | amount |
      | 100    |

  Scenario Outline: Transfer Funds Functionality Test
    Given Navigate to Zero Bank web page
    And Login to your account in Zero Bank
    When navigate to Transfer Funds page
    And transfer Funds "<amount>"
    Then you should see Success Transfer message

    Examples:
      | amount |
      | 100    |