package bdd.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"bdd.automation.stepdefinitions"},
monochrome = true, tags = "@Regression", plugin = {
        "html:target/cucumberReports/testReport.html","json:target/cucumberReports/testReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {
    
    

}
