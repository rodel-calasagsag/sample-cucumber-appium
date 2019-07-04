@search
Feature: Search

  Background:
    Given I am in the explore page

  @smoke
  Scenario Outline: Search wiki using search text box in header
    When I search wikipedia for "<query>" using the search text box in header
    Then I should see search wiki results containing "<query>"
    When I select the search result with title "<query>" and description "<subtitle>"
    Then I should be in the article page with title "<query>" and subtitle "<subtitle>"
    Examples:
      | query             | subtitle                                       |
      | Avengers: Endgame | 2019 superhero film produced by Marvel Studios |

  @smoke
  Scenario Outline: Search wiki from search icon in explore page
    When I scroll down
    And I search wikipedia for "<query>" using the search icon
    Then I should see search wiki results containing "<query>"
    Examples:
      | query     |
      | Toy Story |