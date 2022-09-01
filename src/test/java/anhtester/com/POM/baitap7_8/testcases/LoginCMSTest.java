package anhtester.com.POM.baitap7_8.testcases;

import anhtester.com.POM.baitap7_8.pages.LoginCMSPage;
import anhtester.com.common.BaseTestParameters;
import anhtester.com.datatest.ConstantData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginCMSTest extends BaseTestParameters {
    public LoginCMSPage loginCMSPage;

    @BeforeMethod
    public void loginCRMTest() {
        loginCMSPage = new LoginCMSPage(driver);

    } //Truyền driver từ BaseTest sang các class Page

    @Test(priority = 1)
    public void inValidEmail() {
        loginCMSPage.verifyLogIn("abc@gmail.com", "123456");
    }

    @Test(priority = 2)
    public void inValidPassword() {
        loginCMSPage.verifyLogIn("maihaitdc@gmail.com", "123456789");
    }

    @Test(priority = 3)
    public void inValidEmailPassword() {
        loginCMSPage.verifyLogIn("abc@gmail.com", "123456789");
    }

    @Test(priority = 4)
    public void signIn_Valid() {
        loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
    }


}
