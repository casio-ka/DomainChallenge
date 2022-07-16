package com.automationtraining.step_definitions;

import com.automationtraining.pages.Login;
import com.automationtraining.pages.SignUpAndSignOut;
import com.automationtraining.utilities.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class LoginStepDef {

    Login log;
    SignUpAndSignOut signUp;

    @Given("we are on landing page")
    public void we_are_at_my_store_landing_page() {
        signUp = new SignUpAndSignOut();
        signUp.goTo();
        BrowserUtil.waitFor(2);
    }

    @When("user clicks on sign_In option")
    public void user_clicks_on_signin_option() {
        signUp.signinto.click();
        BrowserUtil.waitFor(2);
    }

    @And("user enters correct email and password")
    public void userEntersCorrectEmailAndPassword() {
//        String username = ConfigReader.read("username");
//        String password = ConfigReader.read("password");

        log = new Login();
        log.login("jamesmaina1@gmail.com","anonymous");


        BrowserUtil.waitFor(2);

    }

    @Then("user is logs in successfully")
    public void user_user_should_be_directed_to_enter_metadata_page() {
        // verify that user is on metadata page by asserting visibility of unique text
        assertTrue(signUp.welcomeMessage.isDisplayed());
        BrowserUtil.waitFor(2);
    }
}
