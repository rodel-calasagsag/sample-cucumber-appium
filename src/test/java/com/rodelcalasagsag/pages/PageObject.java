package com.rodelcalasagsag.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageObject {

  protected AppiumDriver driver;
  private WebDriverWait wait;

  public PageObject(AppiumDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }

  protected MobileElement waitElement(WebElement e) {
    return (MobileElement) wait.until(visibilityOf(e));
  }

  protected void type(String s, MobileElement e) {
    e.clear();
    e.sendKeys(s);
  }

  public boolean showsMessage(String msg) {
    return waitElementWithText(msg).isDisplayed();
  }

  protected MobileElement waitElementWithText(String s) {
    By byXPath = By.xpath("//*[@text=\"" + s.trim() + "\"]");
    return waitElementWithLocator(byXPath);
  }

  public boolean showsButtonAsEnabled(String buttonText) {
    By byXPath = By.xpath(String.format("//*[@text='%s' and @clickable='true']", buttonText));
    return waitElementWithLocator(byXPath).isEnabled();
  }

  private MobileElement waitElementWithLocator(By by) {
    return (MobileElement) wait.until(visibilityOfElementLocated(by));
  }
}
