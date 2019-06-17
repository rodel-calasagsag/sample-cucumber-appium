package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.pages.nav.Options;
import cucumber.api.java.en.When;

public class MenuSteps {

  private World world;

  public MenuSteps(World world) {
    this.world = world;
  }

  @When("I open options")
  public void iOpenOptions() {
    if (world.options == null) {
      world.options = Options.get(world.driver);
    }
    world.options.open();
  }
}
