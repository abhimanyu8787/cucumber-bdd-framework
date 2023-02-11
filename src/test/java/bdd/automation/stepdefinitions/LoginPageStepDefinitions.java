package bdd.automation.stepdefinitions;

import bdd.automation.pages.LoginPage;
import bdd.automation.utils.TestContextSetup;

public class LoginPageStepDefinitions {
    
    public TestContextSetup testContextSetup;
    public LoginPage loginPage;
    
    public LoginPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.loginPage=testContextSetup.pageObjectManager.getLoginPage();
    }

}
