@account
Feature: Login
  I want to login to the app

  Background:
    Given I am in the login page

  Scenario Outline: Login with wrong credentials
    When I login with username "<username>" and password "<password>"
    Then I should see the text
      """
      Incorrect username or password entered.
      Please try again.
      """
    And I should be in the login page
    Examples:
      | username    | password  |
      | wrong_usr   | wrong_pwd |
      | correct_usr | wrong_pwd |

  @trivial
  Scenario Outline: : Login with missing credentials
    When I login with username "<username>" and password "<password>"
    Then I should see the "Log in" button as disabled
    And I should be in the login page
    Examples:
      | username    | password |
      | rcalasagsag |          |
      |             | B#1aBb$6 |

  @smoke
  Scenario: Login with correct credentials
    When I login with username "rcalasagsag" and password "B#1aBb$6"
    Then I should see the text "Logged in successfully!"
    And I should be in the explore page
    When I open the menu
    Then I should see the text "Rcalasagsag"
