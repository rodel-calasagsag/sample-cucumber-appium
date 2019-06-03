package com.rodelcalasagsag;

import com.rodelcalasagsag.base.BaseSteps;
import com.rodelcalasagsag.pages.login.LoginPage;
import com.rodelcalasagsag.pages.nav.Menu;
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

  @Before
  public void setupScenario() {
    setupDriver(); // todo: make this data-driven
  }

  @After
  public void tearDownScenario(Scenario scenario) {
    tearDownDriver();
  }

  @Given("I am in the login page")
  public void iAmInTheLoginPage() {
    loginPage = Menu.get(driver).goToLoginPage();
  }

  @When("I login with username {string} and password {string}")
  public void iLoginWithUsernameAndPassword(String username, String password) {
    loginPage.login(username, password);
  }

  @Then("I should see the message")
  public void iShouldSeeTheMessage(String msg) {
    assertThat(loginPage.showsMessage(msg), is(true));
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
}
