package anhtester.com.POM.baitap7_8.testcases;

import anhtester.com.POM.pages.CommonPage;
import anhtester.com.POM.pages.ProductPage;
import anhtester.com.POM.pages.LoginCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.common.BaseTestParameters;
import anhtester.com.datatest.ConstantData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTestParameters {
    public LoginCMSPage loginCMSPage;
    public ProductPage productPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupProductTest() {
        loginCMSPage = new LoginCMSPage(driver);
    }

    @Test
    public void addProductTest() {
        commonPage = loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        productPage = commonPage.clickAddProductMenu();
        productPage.addProduct();
    }
    @Test
    public void editProductTest(){
        commonPage = loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        productPage = commonPage.clickAllProductMenu();
        productPage.editProduct();
    }
}
