package com.or.hr.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue = {"src/com/or/hr/steps"},
        dryRun=false, //dryrun is useful to cross check if every step step deifintion and methods before running
        monochrome=true,
        plugin = {"pretty", "html:test-output"} //only html reports are generated
)
public class Runner {
}


