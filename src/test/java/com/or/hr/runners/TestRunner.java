package com.or.hr.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
        glue= {"com.or.hr.stepDefinitions"},
        tags= "@smoketest or @E2E or @Regression",
        monochrome = true,
        plugin = { "pretty", "html:target/reports"})
public class TestRunner {
}


