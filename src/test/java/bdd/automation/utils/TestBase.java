package bdd.automation.utils;

import java.util.HashMap;
import java.util.Map;
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
                String userDir = System.getProperty("user.dir");
                String downloadPath = userDir + "\\src\\test\\resources\\downloadFiles";
                System.out.println("Download path is being set to: "+downloadPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments(chromeConfig);
                options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("download.default_directory", downloadPath);
                options.setExperimentalOption("prefs", prefs);
                
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
