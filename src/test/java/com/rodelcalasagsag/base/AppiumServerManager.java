package com.rodelcalasagsag.base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.URL;

class AppiumServerManager {

  private static AppiumDriverLocalService appiumService;

  static void setupServer() {
    if (appiumService == null || !appiumService.isRunning()) {
      AppiumServiceBuilder builder = new AppiumServiceBuilder();
      builder.withIPAddress(Config.appiumHost()).usingPort(Config.appiumPort());
      appiumService = AppiumDriverLocalService.buildService(builder);
      appiumService.start();
    }
  }

  static URL getServerURL() {
    return appiumService.getUrl();
  }

  static void tearDownServer() {
    if (appiumService.isRunning()) {
      appiumService.stop();
    }
  }
}
