package com.rodelcalasagsag.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

  protected AppiumDriver driver;
  private WebDriverWait wait;

  public BasePage(AppiumDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }

  public static BasePage getCurrentPage(AppiumDriver driver) {
    return new BasePage(driver);
  }

  protected MobileElement waitElement(WebElement e) {
    return (MobileElement) wait.until(visibilityOf(e));
  }

  protected void type(String s, MobileElement e) {
    e.clear();
    e.sendKeys(s);
  }

  public boolean showsText(String msg) {
    return findElementWithText(msg).isDisplayed();
  }

  protected MobileElement findElementWithText(String s) {
    By xpath = By.xpath("//*[@text=\"" + s.trim() + "\"]");
    return findElementBy(xpath);
  }

  public boolean showsButtonAsEnabled(String buttonText) {
    By xpath = By.xpath(String.format("//*[@text='%s' and @clickable='true']", buttonText));
    return findElementBy(xpath).isEnabled();
  }

  private MobileElement findElementBy(By by) {
    return (MobileElement) wait.until(visibilityOfElementLocated(by));
  }
}
