package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.custom_param_types.ElementState;
import com.rodelcalasagsag.pages.BasePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonSteps {

  private World world;

  public CommonSteps(World world) {
    this.world = world;
    world.basePage = new BasePage(world.driver);
  }

  @Then("I should see the text")
  public void iShouldSeeTheTextBlock(String text) {
    assertThat(world.basePage.showsMessage(text), is(true));
  }

  @Then("I should see the {string} button as {state}")
  public void iShouldSeeTheButtonAs(String buttonText, ElementState state) {
    assertThat(world.basePage.showsButtonAsEnabled(buttonText), is(state.isEnabled()));
  }

  @Then("I should see the text {string}")
  public void iShouldSeeTheTextLine(String text) {
    assertThat(world.basePage.showsMessage(text), is(true));
  }

  @When("I scroll down")
  public void iScrollDown() {
    // todo this
  }
}
