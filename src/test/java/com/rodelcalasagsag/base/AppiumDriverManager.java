package com.rodelcalasagsag.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

class AppiumDriverManager {

  static RemoteWebDriver setupDriver(Platform platform) {
    URL url = AppiumServerManager.getServerURL();
    DesiredCapabilities capabilities = setupCapabilities(platform);
    RemoteWebDriver driver;

    switch (platform) {
      case ANDROID:
        driver = new AndroidDriver<>(url, capabilities);
        break;
      case IOS:
        driver = new IOSDriver<>(url, capabilities);
        break;
      default:
        throw new Error("Platform was neither ANDROID nor IOS: " + platform.toString());
    }

    driver.setFileDetector(new LocalFileDetector());
    return driver;
  }

  private static DesiredCapabilities setupCapabilities(Platform platform) {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setPlatform(platform);
    setCapabilitiesFromConfig(caps, platform);

    return caps;
  }

  private static void setCapabilitiesFromConfig(DesiredCapabilities caps, Platform platform) {
    JSONObject capsJSON = Config.capabilities();
    capsJSON.forEach(
        (k, v) -> {
          if (k.equals(PLATFORM_NAME)) {
            JSONObject platformNameJSON = (JSONObject) v;
            JSONObject osJSON =
                (JSONObject) platformNameJSON.get(platform.toString().toLowerCase());
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
