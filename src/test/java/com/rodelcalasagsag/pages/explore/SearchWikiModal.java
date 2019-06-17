package com.rodelcalasagsag.pages.explore;

import com.rodelcalasagsag.pages.BasePage;
import com.rodelcalasagsag.pages.article.ArticlePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchWikiModal extends BasePage {

  @FindBy(id = "org.wikipedia.alpha:id/search_src_text")
  private MobileElement searchField;

  @FindBy(xpath = ".//*[@resource-id='org.wikipedia.alpha:id/page_list_item_title']")
  private List<MobileElement> resultTitles;

  @FindBy(xpath = ".//*[@resource-id='org.wikipedia.alpha:id/page_list_item_container']")
  private List<MobileElement> resultContainer;

  SearchWikiModal(AppiumDriver driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public SearchWikiModal searchWiki(String query) {
    super.type(query, searchField);
    super.pause(2);
    return this;
  }

  public List<String> getResultTitles() {
    List<String> titles = new ArrayList<>();
    resultTitles.forEach(s -> titles.add(s.getText().trim()));
    return titles;
  }

  public ArticlePage selectResultWithTitleAndDescription(String title, String description) {
    boolean found = false;
    for (MobileElement container : resultContainer) {
      String titleXPath = ".//*[@resource-id='org.wikipedia.alpha:id/page_list_item_title']";
      String descXPath = ".//*[@resource-id='org.wikipedia.alpha:id/page_list_item_description']";

      String actualTitle = container.findElementByXPath(titleXPath).getText().trim();
      String actualDesc = container.findElementByXPath(descXPath).getText().trim();

      boolean hasTitle = actualTitle.contains(title);
      boolean hasDesc = actualDesc.contains(actualDesc);

      if (hasTitle && hasDesc) {
        container.click();
        found = true;
        break;
      }
    }

    if (found) {
      return new ArticlePage(driver);
    } else {
      throw new Error(
          "Search result with title \""
              + title
              + "\" and description \""
              + description
              + "\" was not found");
    }
  }
}
