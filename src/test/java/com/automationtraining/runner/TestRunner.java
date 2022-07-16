package com.automationtraining.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com/automationtraining/step_definitions",
        publish = true,
        plugin = {"pretty", "html:target/cucumber_report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt", // store the failed file into rerun.txt
                "me.jvt.cucumber.report.PrettyReports:target"  // fancy report
        },

        dryRun = false,
        tags = "@bd" )

public class TestRunner {


}
