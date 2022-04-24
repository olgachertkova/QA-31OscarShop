package tests.search_Fields.authorized_user;

import helpers.MyDataProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import pages.ProfilePage;
import pages.SearchPage;
import tests.TestBase;

public class SearchFieldTests extends TestBase {
    LoginAndRegisterPage loginAndRegisterPage;
    HomePage homePage;
    ProfilePage profilePage;
    SearchPage searchPage;

    @BeforeMethod
    public void preCondition() {
        homePage = PageFactory.initElements(driver,HomePage.class);
        loginAndRegisterPage = PageFactory.initElements(driver,LoginAndRegisterPage.class);
        profilePage = PageFactory.initElements(driver,ProfilePage.class);
        searchPage = PageFactory.initElements(driver,SearchPage.class);

        if (homePage.loginAndRegisterBtnIsVisible()){
            homePage.clickToLoginAndRegisterButton();
            loginAndRegisterPage.fillLogEmail("aaaa123@gmail.com");
            loginAndRegisterPage.fillLogPass("aaa12345@");
            loginAndRegisterPage.loginBtnClick();
            Assert.assertTrue(profilePage.islogged());
        }

    }

    @Test(dataProvider = "searchingForExistingProductTest",dataProviderClass = MyDataProvider.class)
    public void testCase_5_07(String item) {
        homePage.fillSearchField(item);
        homePage.clickOnSearchBtn();
        Assert.assertTrue(searchPage.elementCountCheck(searchPage.elementsCount()));
    }

    @Test(dataProvider = "searchingForExistingProductTest",dataProviderClass = MyDataProvider.class)
    public void testCase_5_08(String item) {
        homePage.fillSearchField(item);
        Actions actions = new Actions(driver);
        actions.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
        Assert.assertTrue(searchPage.elementCountCheck(searchPage.elementsCount()));
    }

    @Test(dataProvider = "searchingForSpecificItem",dataProviderClass = MyDataProvider.class)
    public void testCase_5_09(String item) {
        homePage.fillSearchField(item);
        homePage.clickOnSearchBtn();
        Assert.assertTrue(searchPage.itemValueCheck(item));
    }

    @Test(dataProvider = "searchingForSpecificItem",dataProviderClass = MyDataProvider.class)
    public void testCase_5_10(String item) {
        homePage.fillSearchField(item);
        Actions actions = new Actions(driver);
        actions.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
        Assert.assertTrue(searchPage.itemValueCheck(item));
    }

    @Test
    public void testCase_5_11() {
        String item = "aaaaa";
        homePage.fillSearchField(item);
        homePage.clickOnSearchBtn();
        Assert.assertFalse(searchPage.elementCountCheck(searchPage.elementsCount()));
    }

    @Test
    public void testCase_5_12() {
        String item = "aaaaa";
        homePage.fillSearchField(item);
        Actions actions = new Actions(driver);
        actions.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
        Assert.assertFalse(searchPage.elementCountCheck(searchPage.elementsCount()));
        Assert.assertFalse((searchPage.itemValueCheck(item)));
    }


}
