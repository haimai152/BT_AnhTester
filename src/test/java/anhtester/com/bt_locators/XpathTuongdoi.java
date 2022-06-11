package anhtester.com.bt_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathTuongdoi {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://hrm.anhtester.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Thread.sleep(1000);
        //Run Login case
        driver.findElement(By.id("iusername")).sendKeys("admin01");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
        Thread.sleep(5000);

//Locating element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.xpath("//a[@href='https://hrm.anhtester.com/erp/staff-list']"));

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://hrm.anhtester.com/erp/staff-list']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@class='btn waves-effect waves-light btn-primary btn-sm m-0 collapsed']")).click();
        Thread.sleep(5000);
        //chưa làm xong, buồn ngủ quá, đi ngủ mai học thầy ơi :D
        driver.quit();
    }
}
