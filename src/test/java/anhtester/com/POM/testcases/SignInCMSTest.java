package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.LoginCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.datatest.ConstantData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInCMSTest extends BaseTest {
    public LoginCMSPage loginCMSPage;

    @BeforeMethod
    public void signInCRMTest() {
        loginCMSPage = new LoginCMSPage(driver);
    } //Truyền driver từ BaseTest sang các class Page

    @Test(priority = 1)
    public void inValidEmail(){
        loginCMSPage.verifyLogIn("abc@gmail.com", "123456");
    }
    @Test(priority = 2)
    public void inValidPassword(){
        loginCMSPage.verifyLogIn("maihaitdc@gmail.com", "123456789");
    }
    @Test(priority = 3)
    public void inValidEmailPassword(){
        loginCMSPage.verifyLogIn("abc@gmail.com", "123456789");
    }
    @Test(priority = 4)
    public void signIn_Valid(){
      loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
    }


}
