package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static helpers.PageActionHelper.takeScreenShot;

public class TestBase {
    public WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m, Object[] p){
        logger.info("Start test: " + m.getName());
        if(p.length != 0) {
            logger.info(" --> With data: " + Arrays.asList(p));
        }
    }

    @BeforeMethod
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
//        driver.navigate().to("http://selenium1py.pythonanywhere.com/en-gb/");
//        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {
        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
            logger.info("Screenshot: " + takeScreenShot(driver));
        }
        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");

        driver.close();
        driver.quit();
    }
}
