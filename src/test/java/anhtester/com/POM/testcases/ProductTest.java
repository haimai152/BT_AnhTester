package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.CategoryPage;
import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.ProductPage;
import anhtester.com.POM.pages.SignInCMSPage;
import anhtester.com.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    public SignInCMSPage signInCMSPage;
    public DashboardPage dashboardPage;
    public ProductPage productPage;

    @BeforeMethod
    public void setupProductTest() {
        signInCMSPage = new SignInCMSPage(driver);
    }

    @Test
    public void addProductTest() {
        dashboardPage = signInCMSPage.signIn("maihaitdc@gmail.com", "123456");
        productPage = dashboardPage.openProduct();
        productPage.addProduct();
    }
}
