@search @search-wiki
Feature: Search

  @smoke
  Scenario Outline: Search wiki from Explore page
    Given I am in the explore page
    When I search wikipedia for "<query>"
    Then I should see search wiki results containing "<query>"
    When I select the search result with title "<query>" and description "<subtitle>"
    Then I should see an article with title "<query>" and subtitle "<subtitle>"
    Examples:
      | query             | subtitle                                       |
      | Avengers: Endgame | 2019 superhero film produced by Marvel Studios |