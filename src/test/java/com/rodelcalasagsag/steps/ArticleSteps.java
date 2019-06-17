package com.rodelcalasagsag.steps;

import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ArticleSteps {

  private World world;

  public ArticleSteps(World world) {
    this.world = world;
  }

  @Then("I should see an article with title {string} and subtitle {string}")
  public void iShouldSeeAnArticleWithTitleAndSubtitle(String title, String subtitle) {
    assertThat(world.articlePage.getTitle(), equalTo(title));
    assertThat(world.articlePage.getSubTitle(), equalTo(subtitle));
  }
}
