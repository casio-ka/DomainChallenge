package com.automationtraining.pages;

import com.automationtraining.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add2ItemsToCart {

    @FindBy(xpath = "xpath = //*[@id=\"homefeatured\"]/li[1]")
    public WebElement item1;

    @FindBy(className = "continue")
    public WebElement continueShopping;

    @FindBy(xpath = "xpath = //*[@id=\"homefeatured\"]/li[2]")
    public WebElement item2;

    @FindBy(xpath = "//span[@class=\"ajax_cart_quantity\"]")
    public WebElement numberOfItems;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    public WebElement womenTab;



    public Add2ItemsToCart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




}
