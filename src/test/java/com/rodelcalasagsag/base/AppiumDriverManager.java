package com.rodelcalasagsag.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;

import java.net.URL;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

class AppiumDriverManager {

  static AppiumDriver setupDriver() {
    URL url = AppiumServerManager.getServerURL();
    DesiredCapabilities capabilities = setupCapabilities();
    AppiumDriver driver;

    switch (capabilities.getPlatform()) {
      case ANDROID:
        driver = new AndroidDriver<>(url, capabilities);
        break;
      case IOS:
        driver = new IOSDriver<>(url, capabilities);
        break;
      default:
        throw new Error(
            "Platform was neither ANDROID nor IOS: " + capabilities.getPlatform().toString());
    }

    driver.setFileDetector(new LocalFileDetector());
    return driver;
  }

  private static DesiredCapabilities setupCapabilities() {
    DesiredCapabilities caps = new DesiredCapabilities();
    setCapabilitiesFromConfig(caps);

    return caps;
  }

  private static void setCapabilitiesFromConfig(DesiredCapabilities caps) {
    JSONObject capsJSON = Config.capabilities();
    capsJSON.forEach(
        (k, v) -> {
          if (k.equals(PLATFORM_NAME)) {
            String platformName = Config.platform();
            caps.setCapability(k.toString(), platformName);
            JSONObject platformNameJSON = (JSONObject) v;
            JSONObject osJSON = (JSONObject) platformNameJSON.get(platformName.toLowerCase());
            osJSON.forEach(
                (osKey, osVal) -> {
                  String strOsVal = osVal.toString();
                  if (osKey.equals("app")) {
                    strOsVal = System.getProperty("user.dir").concat(strOsVal);
                  }
                  caps.setCapability(osKey.toString(), strOsVal);
                });
          } else {
            caps.setCapability(k.toString(), v.toString());
          }
        });
  }
}
