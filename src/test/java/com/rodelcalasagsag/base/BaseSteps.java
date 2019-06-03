package com.rodelcalasagsag.base;

import io.appium.java_client.AppiumDriver;

public class BaseSteps {

  protected AppiumDriver driver;

  protected void setupDriver() {
    driver = AppiumDriverManager.setupDriver();
  }

  protected void tearDownDriver() {
    if (driver != null) {
      driver.quit();
    }
  }
}
