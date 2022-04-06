package tests.home_page;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.TestBase;


public class HomePageTests extends TestBase {
    HomePage homePage;

    @BeforeMethod
    public void initTest(){
        homePage = new HomePage(driver);
    }

    @Test
    public void homePageValidationTest(){
        Assert.assertTrue(homePage.homeLinkIsVisible(), "Home Link");
    }
}
