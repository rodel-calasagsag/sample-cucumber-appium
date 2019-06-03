package com.rodelcalasagsag.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseSteps {

  protected RemoteWebDriver driver;

  protected void startApp(Platform platform) {
    AppiumServerManager.setupServer();
    driver = AppiumDriverManager.setupDriver(platform);
  }

  protected void stopApp() {
    tearDownDriver();
    AppiumServerManager.tearDownServer();
  }

  private void tearDownDriver() {
    if (driver != null) {
      driver.quit();
    }
  }
}
