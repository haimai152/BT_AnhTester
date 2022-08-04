package anhtester.com.POM.pages;

import anhtester.com.utils.WebUI;
import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        WebUI webUI = new WebUI(driver);
      //  WebUI.setDriver(driver);
    }

    public DashboardPage signIn(String email, String password) {
        webUI.waitForElementClickable(loginLinkElement);
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        webUI.waitForElementClickable(loginButton);
        clickLoginButton();

        return new DashboardPage(driver);
    }
    public boolean verifySignIn(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return getErrorMessage().contains("Invalid login credentials");
    }
    public void clickLoginLink() {
//        WebElement loginLink = driver.findElement(loginLinkElement);
//        if(loginLink.isDisplayed()){
//            loginLink.click();
//        }
        webUI.clickElement(loginLinkElement);
    }
    public void enterEmail(String email) {
//        WebElement emailText = driver.findElement(inputEmail);
//        if(emailText.isDisplayed()){
//            emailText.sendKeys(email);
            webUI.setElementText(inputEmail,email);
        }
    public void enterPassword(String password) {
//        WebElement passText = driver.findElement(inputPassword);
//        if(passText.isDisplayed()){
//            passText.sendKeys(password);
//        }
        webUI.setElementText(inputPassword,password);
    }
    public void clickLoginButton() {
//        WebElement loginBut = driver.findElement(loginButton);
//        if(loginBut.isDisplayed()){
//            loginBut.click();
//        }
        webUI.clickElement(loginButton);
    }
    public void popupClose(){
//        System.out.println("driver của popupClose: "+driver);
//        WebElement popupPage = driver.findElement(popup);
//        webUI.waitForElementClickable(popup);
//        popupPage.click();
        webUI.clickElement(popup);

    }
    public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(errorMsgText);
        if (errorMsg.isDisplayed())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }
}
