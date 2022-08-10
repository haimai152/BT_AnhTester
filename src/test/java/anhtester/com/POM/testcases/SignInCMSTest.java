package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.SignInCMSPage;
import anhtester.com.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInCMSTest extends BaseTest {
    public SignInCMSPage signInCMSPage;

    @BeforeMethod
    public void signInCRMTest() {
        signInCMSPage = new SignInCMSPage(driver);
       // dashboardPage = new DashboardPage(driver);
    } //Truyền driver từ BaseTest sang các class Page

    @Test(priority = 1)
    public void inValidEmail(){
        signInCMSPage.verifySignIn("abc@gmail.com", "123456");
    }
    @Test(priority = 2)
    public void inValidPassword(){
        signInCMSPage.verifySignIn("maihaitdc@gmail.com", "123456789");
    }
    @Test(priority = 3)
    public void inValidEmailPassword(){
        signInCMSPage.verifySignIn("abc@gmail.com", "123456789");
    }
    @Test(priority = 4)
    public void signIn_Valid(){
      signInCMSPage.signIn("maihaitdc@gmail.com", "123456");
    }


}
