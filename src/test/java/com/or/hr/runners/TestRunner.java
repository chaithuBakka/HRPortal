package com.or.hr.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/ravi/gitProject/HRPortal/src/test/resources/features", // path to feature files
        glue= {"com.or.hr.stepDefinitions"}, // path to the step definitions
        //tags= "@smoketest or @E2E or @Regression",
        tags= "not @ignore",
        monochrome = true, //display the console output in proper readable format
        dryRun = false, // to check the mapping is proper between feature file and step def file
        plugin = { "pretty", "html:target/reports"}) // to generate the html report
public class TestRunner {
}


