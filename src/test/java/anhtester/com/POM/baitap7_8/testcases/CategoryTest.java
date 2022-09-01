package anhtester.com.POM.baitap7_8.testcases;

import anhtester.com.POM.pages.CategoryPage;
import anhtester.com.POM.pages.CommonPage;
import anhtester.com.POM.pages.LoginCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.common.BaseTestParameters;
import anhtester.com.datatest.ConstantData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTestParameters {
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
