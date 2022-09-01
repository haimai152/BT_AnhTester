package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.CategoryPage;
import anhtester.com.POM.pages.CommonPage;
import anhtester.com.POM.pages.LoginCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.datatest.ConstantData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    public LoginCMSPage loginCMSPage;
    public CategoryPage categoryPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupCategoryTest() {
        loginCMSPage = new LoginCMSPage(driver);
    }

    @Test
    public void addCategoryTest() {
        commonPage = loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        categoryPage = commonPage.openCategory();
        categoryPage.addCategory();
    }

}
