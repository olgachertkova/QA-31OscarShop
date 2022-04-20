package tests.user;

import helpers.MyDataProviderLogin;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import pages.PageBase;
import pages.ResetPasswordPage;
import tests.TestBase;

public class LoginTests extends TestBase {
    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;
    PageBase pageBase;
    ResetPasswordPage resetPasswPage;

    @BeforeMethod
    public void initTest() {
        loginAndRegisterPage = PageFactory.initElements(driver, LoginAndRegisterPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        pageBase = PageFactory.initElements(driver, PageBase.class);
        resetPasswPage = PageFactory.initElements(driver, ResetPasswordPage.class);
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


//    @Test(dataProvider = "loginWrongEmailDataCSV", dataProviderClass = MyDataProviderLogin.class)
//    public void wrongEmailValidPassTest(String email, String password) {
//        homePage.openLoginRegForm();
//        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
//        loginAndRegisterPage.fillLoginForm(email, password);
//        loginAndRegisterPage.clickBTNLogIn();
//
//        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());    //FORM Oops! We found some errors - please check the error messages below and try again
//        Assert.assertTrue(loginAndRegisterPage.massageWrongFormatIsDisplayed());//???????????????????? появляющееся сообщениев поле email
//        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd()); ////TEXT Oops! We found some errors - please check the error messages below and try again
//    }

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
    @Test(dataProvider = "unregisteredUserCantLoginDataCSV", dataProviderClass = MyDataProviderLogin.class)

    public void unregisterUserCantLoginWithCorrectDataTest(String email, String password) {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(email, password);
        loginAndRegisterPage.clickBTNLogIn();
        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());
        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd());

    }

    //User enter in to account by pressing on the link "I've forgotten my password".
    @Test(dataProvider = "loginInToAccountByClickingForgottenPasswordDataCSV", dataProviderClass = MyDataProviderLogin.class)

    public void loginInToAccountByClickingForgottenPassword(String email) {
        homePage.openLoginRegForm();

        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());

        loginAndRegisterPage.fillEmailAddress(email);
        loginAndRegisterPage.clickOnLinkForgottenPassword();

        Assert.assertTrue(resetPasswPage.textResetPasswordIsPresent());

        resetPasswPage.fillEmailForResetPassw(email);
        resetPasswPage.sendResetEmail();
        Assert.assertTrue(resetPasswPage.textEmailSendIsPresent());
    }


}
