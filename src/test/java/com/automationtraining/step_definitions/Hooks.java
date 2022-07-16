package com.automationtraining.step_definitions;

import com.automationtraining.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before("@bd")
    public void setUpDriver(){
        // Using an implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After("@bd")
    public void tearDown(Scenario scenario){

        // checking if scenario is failed or not
        if (scenario.isFailed()){
            // to take screenshot of failed scenario
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte [] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "failed scenario");
        }



        // closing the browser at the end.
        Driver.closeBrowser();

    }
}
