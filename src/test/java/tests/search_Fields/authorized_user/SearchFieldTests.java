package tests.search_Fields.authorized_user;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginAndRegisterPage;
import tests.TestBase;

public class SearchFieldTests extends TestBase {
    LoginAndRegisterPage loginAndRegisterPage;

    public SearchFieldTests() {
    }

    @BeforeMethod
    public void preCondition() {
//        this.loginAndRegisterPage = (LoginAndRegisterPage)PageFactory.initElements(this.driver, LoginAndRegisterPage.class);
//        if (this.loginAndRegisterPage.isRegBtnPresent()) {
//            this.loginAndRegisterPage.clickOnRegisterButton();
//            this.loginAndRegisterPage.LoginEmail("aaaa123@gmail.com");
//            this.loginAndRegisterPage.LoginPassword("aaa12345@");
//        }

    }

    @Test
    public void test() {
    }
}
