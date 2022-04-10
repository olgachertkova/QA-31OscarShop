package tests.user;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import tests.TestBase;

public class LoginTests extends TestBase {
    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;

    @BeforeMethod
    public void initTest() {
        loginAndRegisterPage = PageFactory.initElements(driver, LoginAndRegisterPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test//(dataProvider = "loginValidDataCSV", dataProviderClass = MyDataProvider.class)
    public void loginSuccessTest(String email, String password) {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(email, password);
        loginAndRegisterPage.clickBTNLogIn();
        Assert.assertTrue(homePage.loginSuccessMassageIsDiplayed());
        homePage.logOut();
    }

        //Registered user can't login with wrong email and valid password
    @Test  //(dataProvider = "loginWrongEmailDataCSV", dataProviderClass = MyDataProvider.class)
    public void wrongEmailValidPassTest(String email, String password) {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(email,password);
        loginAndRegisterPage.clickBTNLogIn();

        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());    //FORM Oops! We found some errors - please check the error messages below and try again
       // Assert.assertTrue(loginAndRegisterPage.massageWrongFormatIsDisplayed());
        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd()); ////TEXT Oops! We found some errors - please check the error messages below and try again
    }


//    @Test   //Registered user can't login with incorrect password and valid email
//    public void wrongPasswValidEmailTest() {
//        homePage.openLoginRegForm();
//        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
//        loginAndRegisterPage.fillLoginForm(User.builder().email("zaitsevaooops2022@gmail").password("ZPthgie").build());
//        loginAndRegisterPage.clickBTNLogIn();
//        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());
//        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd());
//    }
}
