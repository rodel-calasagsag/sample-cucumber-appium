package com.rodelcalasagsag.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

  private static final String PAGE_CONTAINER_ID = "org.wikipedia.alpha:id/fragment_main_view_pager";
  protected AndroidDriver driver;
  private WebDriverWait wait;

  public BasePage(AndroidDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  protected MobileElement waitElement(MobileElement e) {
    return (MobileElement) wait.until(visibilityOf(e));
  }

  protected void type(String s, MobileElement e) {
    e.clear();
    e.sendKeys(s);
  }

  public boolean showsMessage(String msg) {
    return findElementWithText(msg).isDisplayed();
  }

  private MobileElement findElementWithText(String s) {
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

  protected void pause(int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void scrollDown() {
    String str =
        "new UiScrollable(new UiSelector().resourceId(\""
            + PAGE_CONTAINER_ID
            + "\"))"
            + ".scrollForward()"
            + ".getChildByDescription(new UiSelector().index(0),\"\",false);";
    driver.findElementByAndroidUIAutomator(str);
  }
}
