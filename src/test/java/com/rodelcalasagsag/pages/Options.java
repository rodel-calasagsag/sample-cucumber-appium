package com.rodelcalasagsag.pages;

import com.rodelcalasagsag.pages.login.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Options extends BasePage {

  @FindBy(id = "org.wikipedia.alpha:id/menu_overflow_button")
  private MobileElement menuBtn;

  @FindBy(xpath = "//*[@text='Log in to Wikipedia']")
  private MobileElement loginItem;

  private Options(AndroidDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public static Options get(AndroidDriver driver) {
    return new Options(driver);
  }

  public LoginPage goToLoginPage() {
    open();
    loginItem.click();
    return new LoginPage(driver);
  }

  public Options open() {
    menuBtn.click();
    return this;
  }
}
