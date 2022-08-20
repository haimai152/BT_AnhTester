package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.CategoryPage;
import anhtester.com.POM.pages.CommonPage;
import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.SignInCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.datatest.ConstantData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    public SignInCMSPage signInCMSPage;
    public CategoryPage categoryPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupCategoryTest() {
        signInCMSPage = new SignInCMSPage(driver);
    }

    @Test
    public void addCategoryTest() {
        commonPage = signInCMSPage.signIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        categoryPage = commonPage.openCategory();
        categoryPage.addCategory();
    }

}
