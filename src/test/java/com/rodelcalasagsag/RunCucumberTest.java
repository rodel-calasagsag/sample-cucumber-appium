package com.rodelcalasagsag;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    tags = "@wip")
public class RunCucumberTest {
  //  @BeforeClass()
  //  public static void startAppiumServer() {
  //    AppiumServerManager.setupServer();
  //  }

  //  @AfterClass
  //  public static void stopAppiumServer() {
  //    AppiumServerManager.tearDownServer();
  //  }
}
