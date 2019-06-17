package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.pages.BasePage;
import com.rodelcalasagsag.pages.article.ArticlePage;
import com.rodelcalasagsag.pages.explore.ExplorePage;
import com.rodelcalasagsag.pages.explore.SearchWikiModal;
import com.rodelcalasagsag.pages.login.LoginPage;
import com.rodelcalasagsag.pages.nav.Options;
import io.appium.java_client.AppiumDriver;

public class World {
  public AppiumDriver driver;
  ArticlePage articlePage;
  SearchWikiModal searchWikiModal;
  Options options;
  LoginPage loginPage;
  ExplorePage explorePage;
  BasePage basePage;
}
