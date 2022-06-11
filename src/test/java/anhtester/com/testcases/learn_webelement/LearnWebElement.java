package anhtester.com.testcases.learn_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LearnWebElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();// cú pháp cài đặt driver cho chromebrwoser
        driver = new ChromeDriver();// cú pháp khởi tạo driver cho chromebrwoser
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);

        String websiteModule = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).getText();

        System.out.println(websiteModule);

        Thread.sleep(2000);
        driver.quit();
    }
}
