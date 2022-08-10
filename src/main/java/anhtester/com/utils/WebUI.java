package anhtester.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {
    private static int TIMEOUT = 2;
    private static double STEP_TIME = 0;
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
            Thread.sleep((long) (200 * second));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void logConsole(Object message) {
        System.out.println(message);
    }
    public static void openURL(String url) {
        driver.get(url);
        sleep(STEP_TIME);
        logConsole("Open: " + url);
    }
    public static boolean verifyUrl(String url) {

        return driver.getCurrentUrl().contains(url);
    }
    public static void clearElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        sleep(TIMEOUT);
        driver.findElement(by).clear();
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



    public static void setElementText(By by, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(TIMEOUT);
        driver.findElement(by).sendKeys(value);
    }

    public static void waitForElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static String getElementText(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        String text = driver.findElement(by).getText();
        logConsole("Get text: " + text);
        return text; //Trả về một giá trị kiểu String
    }
    public static Boolean checkElementExist(By by) {
        sleep(2);
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("checkElementExist: " + true + " --- " + by);
            return true;
        } else {
            System.out.println("checkElementExist: " + false + " --- " + by);
            return false;
        }
    }

}
