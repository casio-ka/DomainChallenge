package com.automationtraining.utilities;

import org.openqa.selenium.By;

public class MyStoreUtil {

    // creating a method to open my store application

    public static void openMyStore(){
        Driver.getDriver().get(ConfigReader.read("mystore_url"));
    }

    public static void login(String username, String password){
        // click sign-in
        Driver.getDriver().findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        // enter username
        Driver.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(username);
        // enter password
        Driver.getDriver().findElement(By.xpath("//input[@id='passwd']")) .sendKeys(password);
        // click login
        Driver.getDriver().findElement(By.xpath("//button[@id='SubmitLogin']")).click();


    }

    public static boolean loginErrorMsgVisible(){

        boolean elementFound =
                BrowserUtil.checkVisibilityOfElement(By.xpath("//span[. ='Invalid Login or Password.']"),2);
        return elementFound ;
    }

}
