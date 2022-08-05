package anhtester.com.POM.testcases;

import anhtester.com.POM.pages.DashboardPage;
import anhtester.com.POM.pages.SignInCMSPage;
import anhtester.com.common.BaseTest;
import anhtester.com.utils.WebUI;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInCMSTest extends BaseTest {
    public SignInCMSPage signInCMSPage;
    public DashboardPage dashboardPage;

    @BeforeMethod
    public void signInCRMTest() {
        signInCMSPage = new SignInCMSPage(driver);
        dashboardPage = new DashboardPage(driver);
    } //Truyền driver từ BaseTest sang các class Page

    @Test(priority = 1)
    public void inValidEmail(){
        signInCMSPage.popupClose();
        Assert.assertTrue(signInCMSPage.verifySignIn("abc@gmail.com", "123456"),"Invalid email");
    }
    @Test(priority = 2)
    public void inValidPassword(){
        signInCMSPage.popupClose();
        Assert.assertTrue(signInCMSPage.verifySignIn("maihaitdc@gmail.com", "123456789"),"Invalid password");
    }
    @Test(priority = 3)
    public void inValidEmailPassword(){
        signInCMSPage.popupClose();
        Assert.assertTrue(signInCMSPage.verifySignIn("abc@gmail.com", "123456789"),"Invalid Email and Password");
    }
    @Test(priority = 4)
    public void signIn_Valid(){
        signInCMSPage.popupClose();
        dashboardPage = signInCMSPage.signIn("maihaitdc@gmail.com", "123456");
    }
    @Test(priority = 5)
    public void addCategoryTest() {
        dashboardPage.clickAddCategory();
       // WebUI.sleep(1);
    }

}
