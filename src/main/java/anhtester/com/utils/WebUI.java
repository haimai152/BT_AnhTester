package anhtester.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUI {
    private static int TIMEOUT = 2;
    private static WebDriver driver;

    public WebUI(WebDriver driver) {
        WebUI.driver = driver;
    }
 /*
    public static WebDriver setDriver(WebDriver driver){
        WebUI.driver = driver;
        return driver;
    }
  */
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (500 * second));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(TIMEOUT);
        driver.findElement(by).click();
    }

    public static void clickElement(By by, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(TIMEOUT);
        driver.findElement(by).click();
    }

    public static boolean verifyUrl(String url) {

        return driver.getCurrentUrl().contains(url);
    }

    public static void setElementText( By by, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(TIMEOUT);
        driver.findElement(by).sendKeys(value);
    }

    public static void waitForElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


}
