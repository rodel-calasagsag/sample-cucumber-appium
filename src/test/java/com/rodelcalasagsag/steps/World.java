package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.pages.BasePage;
import com.rodelcalasagsag.pages.Options;
import com.rodelcalasagsag.pages.article.ArticlePage;
import com.rodelcalasagsag.pages.explore.ExplorePage;
import com.rodelcalasagsag.pages.explore.SearchWikiModal;
import com.rodelcalasagsag.pages.login.LoginPage;
import io.appium.java_client.AppiumDriver;

public class World {
  public AppiumDriver driver;
  public ArticlePage articlePage;
  public SearchWikiModal searchWikiModal;
  public Options options;
  public LoginPage loginPage;
  public ExplorePage explorePage;
  BasePage basePage;
}
