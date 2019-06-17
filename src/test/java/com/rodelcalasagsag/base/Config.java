package com.rodelcalasagsag.base;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

class Config {

  private static final JSONObject config = getConfigJSON();
  static final String PLATFORM = (String) config.get("platform");
  static final JSONObject CAPABILITIES = (JSONObject) config.get("capabilities");
  private static final JSONObject APPIUM_SERVER = (JSONObject) (config.get("appiumServer"));
  static final String APPIUM_HOST = (String) APPIUM_SERVER.get("host");
  static final int APPIUM_PORT = Integer.parseInt(APPIUM_SERVER.get("port").toString());
  static final String APPIUM_LOG_LEVEL = (String) APPIUM_SERVER.get("logLevel");

  private static JSONObject getConfigJSON() {
    JSONParser parser = new JSONParser();
    String configPath = System.getProperty("user.dir") + "/src/test/resources/config.json";

    try {
      return (JSONObject) parser.parse(new FileReader(configPath));
    } catch (IOException | ParseException e) {
      throw new Error(e);
    }
  }
}
