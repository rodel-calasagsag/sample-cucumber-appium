Feature: Login
  I want to login to the app

  Background:
    Given I am in the login page

  Scenario Outline: Login with wrong credentials
    When I login with username "<username>" and password "<password>"
    Then I should see the message
      """
      Incorrect username or password entered.
      Please try again.
      """
    And I should be in the login page
    Examples:
      | username    | password    |
      | wrong_usr   | wrong_pwd   |
      | correct_usr | wrong_pwd   |
      | wrong_usr   | correct_pwd |

  Scenario Outline: : Login with missing credentials
    When I login with username "<username>" and password "<password>"
    Then I should see the "Log in" button as "disabled"
    And I should be in the login page
    Examples:
      | username    | password    |
      | correct_usr |             |
      |             | correct_pwd |