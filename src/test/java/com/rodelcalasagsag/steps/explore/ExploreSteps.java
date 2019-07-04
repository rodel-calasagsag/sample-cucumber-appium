package com.rodelcalasagsag.steps.explore;

import com.rodelcalasagsag.pages.Nav;
import com.rodelcalasagsag.steps.World;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ExploreSteps {
  private World world;

  public ExploreSteps(World world) {
    this.world = world;
  }

  @Then("I should be in the explore page")
  public void iShouldBeInTheExplorePage() {
    assertThat(world.explorePage.isDisplayed(), is(true));
  }

  @Given("I am in the explore page")
  public void iAmInTheExplorePage() {
    world.explorePage = Nav.get(world.driver).clickExplore();
  }

  @When("I search wikipedia for {string} using the search text box in header")
  public void iSearchWikipediaForUsingTheSearchTextBoxInHeader(String query) {
    world.searchWikiModal = world.explorePage.openSearch().searchWiki(query);
  }

  @Then("I should see search wiki results containing {string}")
  public void iShouldSeeSearchWikiResultsContaining(String query) {
    assertThat(world.searchWikiModal.getResultTitles(), hasItems(containsString(query)));
  }

  @When("I select the search result with title {string} and description {string}")
  public void iSelectTheSearchResultWithTitleAndDescription(String title, String description) {
    world.articlePage =
        world.searchWikiModal.selectResultWithTitleAndDescription(title, description);
  }

  @And("I search wikipedia for {string} using the search icon")
  public void iSearchWikipediaForUsingTheSearchIcon(String query) {
    world.searchWikiModal = world.explorePage.tapSearchIcon().searchWiki(query);
  }
}
