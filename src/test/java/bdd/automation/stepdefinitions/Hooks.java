package bdd.automation.stepdefinitions;

import bdd.automation.utils.TestContextSetup;
import io.cucumber.java.After;

public class Hooks {
    
    TestContextSetup testContextSetup;
    
    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
    }
    
    @After
    public void AfterScenario() throws Exception {
        testContextSetup.testBase.getWebDriver().quit();
    }

}
