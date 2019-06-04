package com.rodelcalasagsag.base;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

class Config {

  private static final JSONObject config = getConfigJSON();
  public static final String PLATFORM = (String) config.get("platform");
  public static final JSONObject CAPABILITIES = (JSONObject) config.get("capabilities");
  private static final JSONObject APPIUM_SERVER = (JSONObject) (config.get("appiumServer"));
  public static final String APPIUM_HOST = (String) APPIUM_SERVER.get("host");
  public static final int APPIUM_PORT = Integer.parseInt(APPIUM_SERVER.get("port").toString());

  private static JSONObject getConfigJSON() {
    JSONParser parser = new JSONParser();
    String configPath =
        System.getProperty("user.dir") + "/src/test/resources/com/rodelcalasagsag/config.json";

    try {
      return (JSONObject) parser.parse(new FileReader(configPath));
    } catch (IOException | ParseException e) {
      throw new Error(e);
    }
  }
}
