package com.rodelcalasagsag.pages.article;

import com.rodelcalasagsag.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage extends BasePage {
  @FindBy(id = "org.wikipedia.alpha:id/view_page_title_text")
  private MobileElement title;

  @FindBy(id = "org.wikipedia.alpha:id/view_page_subtitle_text")
  private MobileElement subtitle;

  public ArticlePage(AndroidDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public String getTitle() {
    return title.getText().trim();
  }

  public String getSubTitle() {
    return subtitle.getText().trim();
  }
}
