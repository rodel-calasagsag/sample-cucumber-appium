package com.rodelcalasagsag.pages.explore;

import com.rodelcalasagsag.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorePage extends BasePage {
  @FindBy(id = "org.wikipedia.alpha:id/search_container")
  private MobileElement searchContainer;

  public ExplorePage(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public boolean isDisplayed() {
    return searchContainer.isDisplayed();
  }

  public SearchWikiModal openSearch() {
    searchContainer.click();
    return new SearchWikiModal(driver);
  }
}
