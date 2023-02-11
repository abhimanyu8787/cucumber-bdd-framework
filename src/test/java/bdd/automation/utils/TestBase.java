package bdd.automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    
    private WebDriver driver;
    
    public WebDriver getWebDriver() throws Exception {
        if(driver == null) {
            ExecutionMode executionMode = ExecutionMode.valueOf(Utility.getGlobalProperties("ExecutionMode"));
            switch (executionMode) {
            case Local: {
                WebDriverManager.chromedriver().setup();
                String[] chromeConfig = {"--ignore-certificate-errors", "--ignore-ssl-errors=yes","--no-sandbox",
                        "start-maximized"};
                
                ChromeOptions options = new ChromeOptions();
                options.addArguments(chromeConfig);
                options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                
                driver = new ChromeDriver(options);
                break;
            }
            default:
                throw new Exception("Unhandled Execution Mode!");
            }
            
            //String applicationUrl = Utility.getGlobalProperties("applicationUrl");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //driver.get(applicationUrl);
            return driver;
        }
        return driver;
    }
    

}
