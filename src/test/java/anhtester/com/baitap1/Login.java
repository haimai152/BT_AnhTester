package anhtester.com.baitap1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println("hello");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce.anhtester.com/login");

        Thread.sleep(1000);

        //Tìm element bằng thuộc tính
        driver.findElement(By.id("email")).sendKeys("maihaitdc@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(1000);
        //Tìm element bằng Xpath tương đối
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
