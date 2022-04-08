package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import java.lang.reflect.Method;

import static helpers.APIHelper.thisIsStaticMethod;

public class TestBase {
    public WebDriver driver;
    public static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setDriver() {
        //       System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
//        driver.navigate().to("http://selenium1py.pythonanywhere.com/en-gb/");
//        driver.manage().window().fullscreen();
    }


    @AfterSuite
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @BeforeMethod
    public  void startTest(Method m){
        logger.info("Start of the test--->"+m.getName());
    }
    @AfterMethod
    public  void stopTest(Method m){
        logger.info("The end of the test--->"+m.getName());
    }
}
