Feature: Login
  I want to login to the app

  Background:
    Given I am in the login page

  Scenario Outline: Login with wrong credentials
    When I login with username "<username>" and password "<password>"
    Then I should see the message
      """
      Incorrect username or password entered
      Please try again
      """
    And I should be in the login page
    Examples:
      | username  | password  |
      | wrong-usr | wrong-pwd |
#      | correct-usr | wrong-pwd   |
#      | wrong-usr   | correct-pwd |

#  Scenario Outline: : Login with missing credentials
#    When I login with username "<username>" and password "<password>"
#    Then I should see the login button as disabled
#    And I should be in the login page
#    Examples:
#      | username    | password    |
#      | correct-usr |             |
#      |             | correct-pwd |
