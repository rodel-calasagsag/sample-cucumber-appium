package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.pages.BasePage;
import com.rodelcalasagsag.pages.explore.ExplorePage;
import com.rodelcalasagsag.pages.login.LoginPage;
import com.rodelcalasagsag.pages.nav.Menu;
import io.appium.java_client.AppiumDriver;

public class World {
  public AppiumDriver driver;
  Menu menu;
  LoginPage loginPage;
  ExplorePage explorePage;
  BasePage basePage;
}
