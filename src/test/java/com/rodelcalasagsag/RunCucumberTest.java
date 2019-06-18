package com.rodelcalasagsag;

import com.rodelcalasagsag.base.AppiumServerManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    tags = "@smoke")
public class RunCucumberTest {
  @BeforeClass
  public static void startAppiumServer() {
    AppiumServerManager.setupServer();
  }

  @AfterClass
  public static void stopAppiumServer() {
    AppiumServerManager.tearDownServer();
  }
}
