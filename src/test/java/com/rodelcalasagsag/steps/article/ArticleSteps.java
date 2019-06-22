package com.rodelcalasagsag.steps.article;

import com.rodelcalasagsag.steps.World;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ArticleSteps {

  private World world;

  public ArticleSteps(World world) {
    this.world = world;
  }

  @Then("I should be in the article page with title {string} and subtitle {string}")
  public void iShouldBeInTheArticlePageWithTitleAndSubtitle(String title, String subtitle) {
    assertThat(world.articlePage.getTitle(), equalTo(title));
    assertThat(world.articlePage.getSubTitle(), equalTo(subtitle));
  }
}
