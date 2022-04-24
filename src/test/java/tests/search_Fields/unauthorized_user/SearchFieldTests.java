package tests.search_Fields.unauthorized_user;

import helpers.MyDataProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import tests.TestBase;

public class SearchFieldTests extends TestBase {
    HomePage homePage;
    SearchPage searchPage;

    @BeforeMethod
    public void initTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @Test(dataProvider = "searchingForExistingProductTest",dataProviderClass = MyDataProvider.class)
    public void testCase_5_01(String item) {
        homePage.fillSearchField(item);
        homePage.clickOnSearchBtn();
        Assert.assertTrue(searchPage.elementCountCheck(searchPage.elementsCount()));
    }

    @Test(dataProvider = "searchingForExistingProductTest",dataProviderClass = MyDataProvider.class)
    public void testCase_5_02(String item) {
        homePage.fillSearchField(item);
        Actions actions = new Actions(driver);
        actions.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
        Assert.assertTrue(searchPage.elementCountCheck(searchPage.elementsCount()));
    }

    @Test(dataProvider = "searchingForSpecificItem",dataProviderClass = MyDataProvider.class)
    public void testCase_5_03(String item) {
        homePage.fillSearchField(item);
        homePage.clickOnSearchBtn();
        Assert.assertTrue(searchPage.itemValueCheck(item));
    }

    @Test(dataProvider = "searchingForSpecificItem",dataProviderClass = MyDataProvider.class)
    public void testCase_5_04(String item) {
        homePage.fillSearchField(item);
        Actions actions = new Actions(driver);
        actions.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
        Assert.assertTrue(searchPage.itemValueCheck(item));
    }

    @Test
    public void testCase_5_05() {
        String item = "aaaaa";
        homePage.fillSearchField(item);
        homePage.clickOnSearchBtn();
        Assert.assertFalse(searchPage.elementCountCheck(searchPage.elementsCount()));
    }

    @Test
    public void testCase_5_06() {
        String item = "aaaaa";
        homePage.fillSearchField(item);
        Actions actions = new Actions(driver);
        actions.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
        Assert.assertFalse(searchPage.elementCountCheck(searchPage.elementsCount()));
        Assert.assertFalse((searchPage.itemValueCheck(item)));
    }

}
