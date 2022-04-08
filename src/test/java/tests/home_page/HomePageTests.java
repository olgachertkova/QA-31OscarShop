package tests.home_page;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.TestBase;


public class HomePageTests extends TestBase {
    HomePage homePage;

    @BeforeMethod
    public void initTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void homePageValidationTest() {
        Assert.assertTrue(homePage.homeLinkIsVisible(), "Home Link");
    }

    @Test
    public void changeLanguageTest(){
       String lang = "ru";
       String expText = "Выполнить";
       homePage.selectLang(lang);
       homePage.clickOnGo();
       Assert.assertEquals(homePage.getTextFromGoBtn(),expText,"Text is changed");

    }


}
