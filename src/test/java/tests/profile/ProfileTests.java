package tests.profile;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProfilePage;
import tests.TestBase;

public class ProfileTests extends TestBase {
    ProfilePage profilePage;
    HomePage homePage;

    @BeforeMethod
    public void initTest(){
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void changePasswordTest(){


    }




}
