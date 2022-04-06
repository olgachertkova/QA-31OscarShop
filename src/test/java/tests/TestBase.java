package tests;

import helpers.APIHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static helpers.APIHelper.thisIsStaticMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        //       System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
//        driver.navigate().to("http://selenium1py.pythonanywhere.com/en-gb/");
        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
