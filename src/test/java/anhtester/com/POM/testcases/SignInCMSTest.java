package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.SignInCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.utils.WebUI;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInCMSTest extends BaseTest {
    public SignInCMSPage signInCMSPage;
    public DashboardPage dashboardPage;
    public String emailTest = "maihaitdc@gmail.com";
    public String passTest = "123456";

    @BeforeMethod
    public void signInCRMTest() {
        signInCMSPage = new SignInCMSPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void signIn_Valid() {
        signInCMSPage.popupClose();
        dashboardPage = signInCMSPage.signIn(emailTest, passTest);
      //  Assert.assertFalse(signInCMSPage.verifySignIn(emailTest, passTest), "Incorrect email/password to login");
        //WebUI.sleep(1);
    }
//    @Test(priority = 2)
//    public void addCategoryTest() {
//        dashboardPage.clickAddCategory();
//       // WebUI.sleep(1);
//    }

}
