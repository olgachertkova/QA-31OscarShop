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
    public void initTest(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void homePageValidationTest(){
        Assert.assertTrue(homePage.homeLinkIsVisible(), "Home Link");
    }

    @Test
    public void changeLanguageTest(){
        String lang = "ru";
        String expTextGoButton = "Выполнить";
        String expTextBasketButton = "Посмотреть корзину";
        homePage.selectLang(lang);
        homePage.clickOnGoButton();
        Assert.assertEquals(homePage.getTextFromGoButton(), expTextGoButton, "Texts are different!!");
        Assert.assertEquals(homePage.getTextFromBasketButton(), expTextBasketButton, "Texts are different!!");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "readingDataFromFile")
    public void changeLanguageTestDataProvider(String lang, String expTextGoButton){
        homePage.selectLang(lang);
        homePage.clickOnGoButton();
        Assert.assertEquals(homePage.getTextFromGoButton(), expTextGoButton, "Texts are different!!");
    }


}
