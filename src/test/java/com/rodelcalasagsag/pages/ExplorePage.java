package com.rodelcalasagsag.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorePage extends PageObject {
  @FindBy(
      xpath =
          "//*[@resource-id='org.wikipedia.alpha:id/search_container']//android.widget.TextView")
  private WebElement searchBtn;

  public ExplorePage(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    waitElement(searchBtn);
  }

  public boolean isDisplayed() {
    return searchBtn.isDisplayed();
  }
}
