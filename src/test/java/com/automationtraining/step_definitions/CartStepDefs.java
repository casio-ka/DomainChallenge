package com.automationtraining.step_definitions;

import com.automationtraining.pages.Add2ItemsToCart;
import com.automationtraining.pages.Login;
import com.automationtraining.pages.SignUpAndSignOut;
import com.automationtraining.utilities.BrowserUtil;
import com.automationtraining.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CartStepDefs {

    Add2ItemsToCart add = new Add2ItemsToCart();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Given("user is successfully logged to store")
    public void userIsSuccessfullyLoggedToStore() {

        add = new Add2ItemsToCart();
        add.go_To();
        BrowserUtil.waitFor(3);
        add.signin_to.click();
        BrowserUtil.waitFor(3);
        add.loginAccess();
        BrowserUtil.waitFor(3);
        add.womenTab.click();
        BrowserUtil.waitFor(3);


    }

    @And("user selects item one")
    public void userSelectsItem() {

        add = new Add2ItemsToCart();

        add.item1.click();
        BrowserUtil.waitFor(1);

        actions.moveToElement(add.item1);
        BrowserUtil.waitFor(1);
        actions.moveToElement(add.addToCart);
        BrowserUtil.waitFor(1);
        add.addToCart.click();
        BrowserUtil.waitFor(5);

        add.continueShopping.click();
        BrowserUtil.waitFor(1);


    }

    @And("item two")
    public void item() {
        add.item2.click();
        BrowserUtil.waitFor(1);
        actions.moveToElement(add.addToCart2);
        BrowserUtil.waitFor(1);
        add.addToCart2.click();
        BrowserUtil.waitFor(5);

    }

    @Then("There are two items in your cart message is displayed")
    public void thereAreItemsInYourCartMessageIsDisplayed() {

        String cartItems = add.numberOfItems.getText();

        Assert.assertEquals(cartItems, "2");

    }
}
