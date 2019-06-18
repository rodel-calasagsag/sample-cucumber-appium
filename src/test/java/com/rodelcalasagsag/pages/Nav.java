package com.rodelcalasagsag.pages;

import com.rodelcalasagsag.pages.explore.ExplorePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Nav extends BasePage {

  @AndroidFindBy(accessibility = "Explore")
  private MobileElement exploreButton;

  private Nav(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public static Nav get(AppiumDriver driver) {
    return new Nav(driver);
  }

  public ExplorePage clickExplore() {
    exploreButton.click();
    return new ExplorePage(driver);
  }
}
