@search
Feature: Search wiki

  Background:
    Given I am in the explore page

  @smoke
  Scenario Outline: Search wiki from search box in explore page
    When I search wikipedia for "<query>"
    Then I should see search wiki results containing "<query>"
    When I select the search result with title "<query>" and description "<subtitle>"
    Then I should be in the article page with title "<query>" and subtitle "<subtitle>"
    Examples:
      | query             | subtitle                                       |
      | Avengers: Endgame | 2019 superhero film produced by Marvel Studios |

  @wip
  Scenario Outline: Search wiki from search icon in explore page
    When I scroll down
    And I tap on the search icon
    And I search wikipedia for "<query>"
    Then I should see search wiki results containing "<query>"
    Examples:
      | query     |
      | Toy Story |