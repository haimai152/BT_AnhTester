package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.CategoryPage;
import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.SignInCMSPage;
import anhtester.com.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    public SignInCMSPage signInCMSPage;
    public DashboardPage dashboardPage;
    public CategoryPage categoryPage;

    @BeforeMethod
    public void setupCategoryTest() {
        signInCMSPage = new SignInCMSPage(driver);
    }

    @Test
    public void addCategoryTest() {
        dashboardPage = signInCMSPage.signIn("maihaitdc@gmail.com", "123456");
        categoryPage = dashboardPage.openCategory();
        categoryPage.addCategory();

    }

}
