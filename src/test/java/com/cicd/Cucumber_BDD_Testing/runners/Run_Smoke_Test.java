package com.cicd.Cucumber_BDD_Testing.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"html:target/cucumber-reports/index.html", "json:target/cucumber.json",
        "rerun:target/failed.txt",
        "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/java/com/cicd/Cucumber_BDD_Testing/features",
        glue = {"com.cicd.Cucumber_BDD_Testing.stepDefinitions", "hooks"},
        tags = "@Smoke",
        dryRun = false
)
public class Run_Smoke_Test extends AbstractTestNGCucumberTests {
}
