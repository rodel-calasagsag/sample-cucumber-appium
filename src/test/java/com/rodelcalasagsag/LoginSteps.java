package com.rodelcalasagsag;

import com.rodelcalasagsag.base.BaseSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Platform;

// todo: give ability to run in parallel
public class LoginSteps extends BaseSteps {

  @Before
  public void setupScenario() {
    super.startApp(Platform.ANDROID); // todo: make this data-driven
  }

  @After
  public void tearDownScenario(Scenario scenario) {
    super.stopApp();
  }

  @Given("I am in the login page")
  public void iAmInTheLoginPage() {
    assert true;
  }

  @When("I login with username {string} and password {string}")
  public void iLoginWithUsernameAndPassword(String arg0, String arg1) {
    assert true;
  }

  @Then("I should see the message")
  public void iShouldSeeTheMessage(String msg) {
    assert true;
  }

  @And("I should be in the login page")
  public void iShouldBeInTheLoginPage() {
    assert true;
  }
}
