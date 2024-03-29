package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.*;
import anhtester.com.common.BaseTest;
import anhtester.com.datatest.ConstantData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
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
