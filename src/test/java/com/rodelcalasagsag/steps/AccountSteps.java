package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.pages.nav.Menu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// todo: give ability to run in parallel
public class AccountSteps {

  private World world;

  public AccountSteps(World world) {
    this.world = world;
  }

  @Given("I am in the login page")
  public void iAmInTheLoginPage() {
    world.loginPage = Menu.get(world.driver).goToLoginPage();
  }

  @When("I login with username {string} and password {string}")
  public void iLoginWithUsernameAndPassword(String username, String password) {
    world.explorePage = world.loginPage.login(username, password);
  }

  @And("I should be in the login page")
  public void iShouldBeInTheLoginPage() {
    assertThat(world.loginPage.isDisplayed(), is(true));
  }
}
