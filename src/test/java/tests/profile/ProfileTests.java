package tests.profile;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import pages.ProfilePage;
import tests.TestBase;

public class ProfileTests extends TestBase {
    ProfilePage profilePage;

    @BeforeMethod
    public void initTest(){

        profilePage = PageFactory.initElements(driver, ProfilePage.class);
    }




}
