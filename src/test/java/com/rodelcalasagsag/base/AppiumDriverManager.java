package com.rodelcalasagsag.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.json.simple.JSONObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AppiumDriverManager {

  public static AndroidDriver createDriver() throws MalformedURLException {
    URL url = AppiumServerManager.getServerURL();
    DesiredCapabilities capabilities = setCapabilities();
    Platform platform = capabilities.getPlatform();
    AndroidDriver driver = new AndroidDriver<AndroidElement>(url, capabilities);
    driver.setFileDetector(new LocalFileDetector());
    driver.manage().timeouts().implicitlyWait(10, SECONDS);
    return driver;
  }

  @SuppressWarnings("unchecked")
  private static DesiredCapabilities setCapabilities() {
    DesiredCapabilities caps = new DesiredCapabilities();
    JSONObject capsJSON = Config.CAPABILITIES;
    capsJSON.forEach(
        (k, v) -> {
          if (k.equals(PLATFORM_NAME)) {
            String platformName = Config.PLATFORM;
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

    return caps;
  }

  public static void quitDriver(AppiumDriver driver) {
    if (driver != null) {
      driver.quit();
    }
  }
}
