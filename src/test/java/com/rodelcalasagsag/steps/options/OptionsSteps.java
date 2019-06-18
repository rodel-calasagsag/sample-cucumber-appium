package com.rodelcalasagsag.steps.options;

import com.rodelcalasagsag.pages.Options;
import com.rodelcalasagsag.steps.World;
import cucumber.api.java.en.When;

public class OptionsSteps {

  private World world;

  public OptionsSteps(World world) {
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
