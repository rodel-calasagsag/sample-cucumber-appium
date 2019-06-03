package com.rodelcalasagsag;

import com.rodelcalasagsag.base.BaseSteps;
import com.rodelcalasagsag.pages.ExplorePage;
import com.rodelcalasagsag.pages.LoginPage;
import com.rodelcalasagsag.pages.Menu;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// todo: give ability to run in parallel
public class LoginSteps extends BaseSteps {

  private LoginPage loginPage;
  private Menu menu;
  private ExplorePage explorePage;

  @Before
  public void setupScenario() {
    setupDriver();
  }

  @After
  public void tearDownScenario(Scenario scenario) {
    tearDownDriver();
  }

  @Given("I am in the login page")
  public void iAmInTheLoginPage() {
    menu = Menu.get(driver);
    loginPage = menu.goToLoginPage();
  }

  @When("I login with username {string} and password {string}")
  public void iLoginWithUsernameAndPassword(String username, String password) {
    explorePage = loginPage.login(username, password);
  }

  @Then("I should see the text")
  public void iShouldSeeTheTextBlock(String text) {
    assertThat(loginPage.showsText(text), is(true));
  }

  @And("I should be in the login page")
  public void iShouldBeInTheLoginPage() {
    assertThat(loginPage.isDisplayed(), is(true));
  }

  @Then("I should see the {string} button as {string}")
  public void iShouldSeeTheButtonAs(String buttonText, String state) {
    boolean enabled = state.equalsIgnoreCase("enabled");
    assertThat(loginPage.showsButtonAsEnabled(buttonText), is(enabled));
  }

  @Then("I should see the text {string}")
  public void iShouldSeeTheTextLine(String text) {
    assertThat(loginPage.showsText(text), is(true));
  }

  @When("I open the menu")
  public void iOpenTheMenu() {
    menu.open();
  }

  @Then("I should be in the explore page")
  public void iShouldBeInTheExplorePage() {
    assertThat(explorePage.isDisplayed(), is(true));
  }
}
