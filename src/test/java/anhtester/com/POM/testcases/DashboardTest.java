package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.CommonPage;
import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.LoginCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.datatest.ConstantData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    public LoginCMSPage loginCMSPage;
    public DashboardPage dashboardPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupDashboardTest(){
        loginCMSPage = new LoginCMSPage(driver);

    }
    @Test
    public void testLogout(){
        commonPage = loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        commonPage.logout();
    }
}
