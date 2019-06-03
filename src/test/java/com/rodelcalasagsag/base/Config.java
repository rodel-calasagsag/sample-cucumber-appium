package com.rodelcalasagsag.base;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

class Config {

  private static final JSONObject config = getConfigJSON();
  private static final JSONObject appiumServer = (JSONObject) config.get("appiumServer");

  private static JSONObject getConfigJSON() {
    JSONParser parser = new JSONParser();
    String configPath =
        System.getProperty("user.dir") + "/src/test/resources/com/rodelcalasagsag/config.json";

    try {
      return (JSONObject) parser.parse(new FileReader(configPath));
    } catch (IOException | ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  static String appiumHost() {
    return (String) appiumServer.get("host");
  }

  static int appiumPort() {
    return Integer.parseInt(appiumServer.get("port").toString());
  }

  static JSONObject capabilities() {
    return (JSONObject) config.get("capabilities");
  }
}
