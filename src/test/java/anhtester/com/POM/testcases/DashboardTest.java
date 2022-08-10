package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.SignInCMSPage;
import anhtester.com.common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    public SignInCMSPage signInCMSPage;
    public DashboardPage dashboardPage;

    @BeforeMethod
    public void setupDashboardTest(){
        signInCMSPage = new SignInCMSPage(driver);

    }
    @Test
    public void testLogout(){
        dashboardPage = signInCMSPage.signIn("maihaitdc@gmail.com","123456");
        dashboardPage.logout();
    }
}
