package com.rodelcalasagsag.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu extends PageObject {

  @FindBy(id = "org.wikipedia.alpha:id/menu_overflow_button")
  private MobileElement menuBtn;

  @FindBy(xpath = "//*[@text='Log in to Wikipedia']")
  private MobileElement loginItem;

  private Menu(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    waitElement(menuBtn);
  }

  public static Menu get(AppiumDriver driver) {
    return new Menu(driver);
  }

  public LoginPage goToLoginPage() {
    open();
    loginItem.click();
    return new LoginPage(driver);
  }

  public Menu open() {
    menuBtn.click();
    return this;
  }
}
