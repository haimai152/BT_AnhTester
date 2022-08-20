package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.*;
import anhtester.com.common.BaseTest;
import anhtester.com.datatest.ConstantData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    public SignInCMSPage signInCMSPage;
    public ProductPage productPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupProductTest() {
        signInCMSPage = new SignInCMSPage(driver);
    }

    @Test
    public void addProductTest() {
        commonPage = signInCMSPage.signIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        productPage = commonPage.clickAddProductMenu();
        productPage.addProduct();
    }
    @Test
    public void editProductTest(){
        commonPage = signInCMSPage.signIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        productPage = commonPage.clickAllProductMenu();
        productPage.editProduct();
    }
}
