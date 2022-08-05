package anhtester.com.POM.pages;

import anhtester.com.utils.WebUI;
import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SignInCMSPage {
    WebDriver driver;
    private  By loginLinkElement = By.xpath("//a[@class='text-reset d-inline-block opacity-60 py-2'][normalize-space()='Login']");
    private By inputEmail = By.id("email");
    private By inputPassword = By.name("password");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");
    private  By popup = By.xpath("//button[@data-key='website-popup' and @data-value='removed']");
    private  By errorMsgText = By.xpath("//span[@data-notify='message']");

    public SignInCMSPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
      //  WebUI.setDriver(driveSr);
    }

    public DashboardPage signIn(String email, String password) {
        WebUI.waitForElementClickable(loginLinkElement);
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        WebUI.waitForElementClickable(loginButton);
        clickLoginButton();

        return new DashboardPage(driver);
    }

    public boolean verifySignIn(String email, String password) {
        WebUI.waitForElementClickable(loginLinkElement);
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        WebUI.waitForElementClickable(loginButton);
        clickLoginButton();
        return getErrorMessage().contains("Invalid login credentials");
    }
    public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(errorMsgText);
        if (errorMsg.isDisplayed())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }
    public void clickLoginLink() {
        WebUI.clickElement(loginLinkElement);
    }
    public void clickLoginButton() {
        WebUI.clickElement(loginButton);
    }
    public void popupClose(){
        WebUI.clickElement(popup);
    }
    public void enterEmail(String email) {
            WebUI.setElementText(inputEmail,email);
        }
    public void enterPassword(String password) {
        WebUI.setElementText(inputPassword,password);
    }


}
