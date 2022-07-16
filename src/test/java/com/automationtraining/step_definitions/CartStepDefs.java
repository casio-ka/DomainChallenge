package com.automationtraining.step_definitions;

import com.automationtraining.pages.Add2ItemsToCart;
import com.automationtraining.pages.Login;
import com.automationtraining.pages.SignUpAndSignOut;
import com.automationtraining.utilities.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDefs {

    Login log;
    SignUpAndSignOut signUp;
    Add2ItemsToCart add;

    @Given("user is successfully logged to store")
    public void userIsSuccessfullyLoggedToStore() {
        signUp = new SignUpAndSignOut();


        signUp.goTo();
        signUp.signinto.click();
        BrowserUtil.waitFor(4);

        log = new Login();
        log.login("jamesmaina1@gmail.com","anonymous");
        BrowserUtil.waitFor(3);





    }

    @And("user selects item one")
    public void userSelectsItem() {

        add = new Add2ItemsToCart();

        add.womenTab.click();
        BrowserUtil.waitFor(3);

        add.item1.click();
        BrowserUtil.waitFor(1);
        add.continueShopping.click();
        BrowserUtil.waitFor(1);


    }

    @And("item two")
    public void item() {
        add.item2.click();
        BrowserUtil.waitFor(1);
    }

    @Then("There are two items in your cart message is displayed")
    public void thereAreItemsInYourCartMessageIsDisplayed() {

        String cartItems = add.numberOfItems.getText();

        Assert.assertEquals(cartItems, "2");

    }
}
