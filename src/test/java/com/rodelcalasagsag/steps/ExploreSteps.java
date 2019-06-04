package com.rodelcalasagsag.steps;

import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ExploreSteps {
  private World world;

  public ExploreSteps(World world) {
    this.world = world;
  }

  @Then("I should be in the explore page")
  public void iShouldBeInTheExplorePage() {
    assertThat(world.explorePage.isDisplayed(), is(true));
  }
}
