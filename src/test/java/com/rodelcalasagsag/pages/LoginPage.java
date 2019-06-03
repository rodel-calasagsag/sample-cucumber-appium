package com.rodelcalasagsag.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {

  @FindBy(id = "org.wikipedia.alpha:id/login_button")
  private MobileElement loginBtn;

  @FindBy(id = "org.wikipedia.alpha:id/login_username_text")
  private MobileElement usernameField;

  @FindBy(xpath = "//*[@password='true']")
  private MobileElement passwordField;

  public LoginPage(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    waitElement(loginBtn);
  }

  public ExplorePage login(String username, String password) {
    return typeUsername(username).typePassword(password).submit();
  }

  private ExplorePage submit() {
    loginBtn.click();
    return new ExplorePage(driver);
  }

  private LoginPage typePassword(String password) {
    type(password, passwordField);
    return this;
  }

  private LoginPage typeUsername(String username) {
    type(username, usernameField);
    return this;
  }

  public boolean isDisplayed() {
    return waitElement(loginBtn).isDisplayed();
  }
}
