package tests.home_page;

import helpers.MyDataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.TestBase;


public class HomePageTests extends TestBase {
    HomePage homePage;

    @BeforeMethod
    public void initTest(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void homePageValidationTest(){
        Assert.assertTrue(homePage.homeLinkIsVisible(), "Home Link");
    }

    @Test(dataProvider = "languageCheck", dataProviderClass = MyDataProvider.class)
    public void changeLanguageTest(String lang, String expTextGoButton){
       // String expTextBasketButton = "Посмотреть корзину";
        logger.info("Test starts with data-->"+lang+"-->"+expTextGoButton);
        homePage.selectLang(lang);
        homePage.clickOnGoButton();
        Assert.assertEquals(homePage.getTextFromGoButton(), expTextGoButton, "Texts are different!!");
        //Assert.assertEquals(homePage.getTextFromBasketButton(), expTextBasketButton, "Texts are different!!");
    }


}
