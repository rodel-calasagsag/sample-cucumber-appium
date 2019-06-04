package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.pages.nav.Menu;
import cucumber.api.java.en.When;

public class MenuSteps {

  private World world;

  public MenuSteps(World world) {
    this.world = world;
  }

  @When("I open the menu")
  public void iOpenTheMenu() {
    if (world.menu == null) {
      world.menu = Menu.get(world.driver);
    }
    world.menu.open();
  }
}
