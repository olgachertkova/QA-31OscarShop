package tests.user;

import helpers.MyDataProviderLogin;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import pages.PageBase;
import tests.TestBase;

public class LoginTests extends TestBase {
    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;
    PageBase pageBase;

    @BeforeMethod
    public void initTest() {
        loginAndRegisterPage = PageFactory.initElements(driver, LoginAndRegisterPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        pageBase = PageFactory.initElements(driver, PageBase.class);
    }

    @Test(dataProvider = "loginValidDataCSV", dataProviderClass = MyDataProviderLogin.class)
    public void loginSuccessTest(String email, String password) {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(email, password);
        loginAndRegisterPage.clickBTNLogIn();
        Assert.assertTrue(homePage.loginSuccessMassageIsDiplayed());
        homePage.logOut();
    }


    @Test(dataProvider = "loginWrongEmailDataCSV", dataProviderClass = MyDataProviderLogin.class)
    public void wrongEmailValidPassTest(String email, String password) {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(email, password);
        loginAndRegisterPage.clickBTNLogIn();

        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());    //FORM Oops! We found some errors - please check the error messages below and try again
        Assert.assertTrue(loginAndRegisterPage.massageWrongFormatIsDisplayed());
        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd()); ////TEXT Oops! We found some errors - please check the error messages below and try again
    }

    //Registered user can't login with incorrect password and valid email
    @Test(dataProvider = "loginWrongPasswDataCSV", dataProviderClass = MyDataProviderLogin.class)
    public void wrongPasswValidEmailTest(String email, String password) {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(email, password);
        loginAndRegisterPage.clickBTNLogIn();
        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());
        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd());
    }

    //Ungegistered user can't login with correct data
    @Test(dataProvider = "UnregisteredUserCantLoginDataCSV", dataProviderClass = MyDataProviderLogin.class)

    public void unregisterUserCantLoginWithCorrectDataTest(String email, String password) {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(email, password);
        loginAndRegisterPage.clickBTNLogIn();
        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());
        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd());

    }
}