package tests.user;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import tests.TestBase;

import static helpers.DataHelper.randomNumeric;

public class RegistrationTests extends TestBase {
    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;
    String password = "Qwe123456!";
    String email= "testemail" + randomNumeric(3) + "@gmail.com";

    @BeforeMethod
    public void initTest(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginAndRegisterPage = PageFactory.initElements(driver, LoginAndRegisterPage.class);
    }


    @Test
    public void registrationPositiveTest(){
        homePage.clickToLoginAndRegisterButton();
        Assert.assertTrue(loginAndRegisterPage.loginAndRegistrationFormIsOpened());
        loginAndRegisterPage.fillEmailField(email);
        loginAndRegisterPage.fillPasswordField(password);
        loginAndRegisterPage.fillConfirmPasswordField(password);
        loginAndRegisterPage.clickOnRegisterButton();
        Assert.assertTrue(homePage.registerSuccessMessageIsDisplayed());
    }
}
