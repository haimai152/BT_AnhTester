package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.CommonPage;
import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.SignInCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.datatest.ConstantData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    public SignInCMSPage signInCMSPage;
    public DashboardPage dashboardPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupDashboardTest(){
        signInCMSPage = new SignInCMSPage(driver);

    }
    @Test
    public void testLogout(){
        commonPage = signInCMSPage.signIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        commonPage.logout();
    }
}
