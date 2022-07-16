package com.automationtraining.pages;

import com.automationtraining.utilities.ConfigReader;
import com.automationtraining.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpAndSignOut {

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    public WebElement signinto;

    @FindBy(id = "email_create")
    public WebElement emailForm;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(xpath = "//h3[text()='Your personal information']")
    public WebElement sampleText;

    @FindBy(xpath = "(//input[@name='id_gender'])[1]")
    public WebElement radioButton;

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement dayOfBirth;

    @FindBy(id = "months")
    public WebElement monthOfBirth;

    @FindBy(id = "years")
    public WebElement yearOfBirth;

    // Your Address

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement addressOne;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//select[@id='id_state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement zipCode;

    @FindBy(id = "id_country")
    public WebElement country;

    @FindBy(id = "other")
    public WebElement additionalInfo;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement homePhone;

    @FindBy(xpath = "//input[@id='alias']")
    public WebElement alias;

    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement submitButtonF;

    @FindBy(xpath = "//p[contains(text(), 'Welcome to your account')]")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//a[@title='Log me out']")
    public WebElement logout;


    public SignUpAndSignOut() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void goTo() {
        Driver.getDriver().navigate().to(ConfigReader.read("mystore_url"));
    }


    public void enterEmail(String email){
        emailForm.sendKeys(email);
    }





}
