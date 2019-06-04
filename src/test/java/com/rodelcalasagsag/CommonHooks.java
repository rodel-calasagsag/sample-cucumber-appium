package com.rodelcalasagsag;

import com.rodelcalasagsag.base.AppiumDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonHooks {

  private World world;

  public CommonHooks(World world) {
    this.world = world;
  }

  @Before
  public void setupDriver() {
    world.driver = AppiumDriverManager.createDriver();
  }

  @After
  public void tearDownDriver(Scenario scenario) {
    AppiumDriverManager.quitDriver(world.driver);
  }
}
