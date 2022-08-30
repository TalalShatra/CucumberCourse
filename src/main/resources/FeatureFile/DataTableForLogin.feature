Feature: Login Function Email Input Test

  Scenario: Test Email Input
    Given Navigate to demoWebShop
    When User enter invalid email address
      | 1234567  |
      | jskssks  |
      | @$%#@*   |
      | 12d#@h   |

    Then User should see a warning