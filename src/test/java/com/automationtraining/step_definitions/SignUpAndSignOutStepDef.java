package com.automationtraining.step_definitions;

import com.automationtraining.pages.SignUpAndSignOut;
import com.automationtraining.utilities.BrowserUtil;
import com.automationtraining.utilities.ConfigReader;
import com.automationtraining.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class SignUpAndSignOutStepDef {

    // putting the SignUp variable at class level so that it can be available to all methods
    SignUpAndSignOut signUp;
    Faker faker = new Faker();


    @Given("we are at my store landing page")
    public void we_are_at_my_store_landing_page() {
        signUp = new SignUpAndSignOut();
        signUp.goTo();
        BrowserUtil.waitFor(2);
    }
    @When("user clicks on signIn option")
    public void user_clicks_on_signin_option() {
        signUp.signinto.click();
        BrowserUtil.waitFor(2);
    }
    @When("enters e-mail address")
    public void enters_e_mail_address() {
        signUp.enterEmail(faker.internet().emailAddress());
    }
    @When("clicks create account button")
    public void clicks_create_account_button() {
        signUp.createAccountButton.click();
        BrowserUtil.waitFor(3);
    }
    @Then("user user should be directed to enter metadata page")
    public void user_user_should_be_directed_to_enter_metadata_page() {
        // verify that user is on metadata page by asserting visibility of unique text
        assertTrue(signUp.sampleText.isDisplayed());
        BrowserUtil.waitFor(2);
    }

    @When("user fills all credentials")
    public void userFillsAllCredentials() {
        signUp.radioButton.click();
        signUp.firstName.sendKeys(faker.address().firstName());
        signUp.lastName.sendKeys(faker.address().lastName());
        signUp.password.sendKeys(ConfigReader.read("password"));

        Select daySelectObj = new Select(signUp.dayOfBirth);
        daySelectObj.selectByIndex(2);

        Select monthSelectObj = new Select(signUp.monthOfBirth);
        monthSelectObj.selectByIndex(2);

        Select yearSelectObj = new Select(signUp.yearOfBirth);
        yearSelectObj.selectByIndex(2);

        signUp.company.sendKeys(faker.company().name());
        signUp.addressOne.sendKeys(faker.address().streetAddress());
        signUp.city.sendKeys(faker.address().cityName());

        Select stateSelectObj = new Select(signUp.state);
        stateSelectObj.selectByIndex(2);

        signUp.zipCode.sendKeys("00100");
        signUp.additionalInfo.sendKeys(faker.address().buildingNumber());

        signUp.homePhone.sendKeys(faker.phoneNumber().cellPhone());

        Actions action = new Actions(Driver.getDriver());
        action.click(signUp.alias).pause(2000)
                .keyDown(Keys.CONTROL)
                .sendKeys("A").pause(2000)
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).pause(1000)
                .sendKeys(faker.internet().emailAddress())
                .perform();

        BrowserUtil.waitFor(2);
    }

    @And("clicks register button")
    public void clicksRegisterButton() {
        signUp.submitButtonF.click();
        BrowserUtil.waitFor(2);
    }

    @Then("user is redirected to homePage")
    public void userIsRedirectedToHomePage() {
        assertTrue(signUp.welcomeMessage.isDisplayed());
        BrowserUtil.waitFor(1);
    }

    @And("user can successfully logout when done shopping")
    public void userCanSuccessfullyLogoutWhenDoneShopping() {
        signUp.logout.click();
    }
}
