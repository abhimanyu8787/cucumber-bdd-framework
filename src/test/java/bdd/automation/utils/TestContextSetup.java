package bdd.automation.utils;

public class TestContextSetup {
    
    public TestBase testBase;
    public PageObjectManager pageObjectManager;
    
    public TestContextSetup() throws Exception {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.getWebDriver());
    }

}
