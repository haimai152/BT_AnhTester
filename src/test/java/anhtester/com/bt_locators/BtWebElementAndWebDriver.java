package anhtester.com.bt_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BtWebElementAndWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hrm.anhtester.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Run Login case
        driver.findElement(By.id("iusername")).sendKeys("admin01");

        driver.findElement(By.name("password")).sendKeys("123456");

        driver.findElement(By.xpath("//span[@class='ladda-label']")).click();

        Thread.sleep(2000);
        // click menu task
        driver.findElement(By.xpath("//span[normalize-space()='Tasks']")).click();
        Thread.sleep(2000);

        //click task
        driver.findElement(By.xpath("//a[@href='https://hrm.anhtester.com/erp/tasks-grid']")).click();
        Thread.sleep(2000);

        //click thêm task
        driver.findElement(By.xpath("//nav[@class='navbar m-b-30 p-10']//span[normalize-space()='Chế độ xem :']//following-sibling::a[3]")).click();
        Thread.sleep(2000);

        // elements on the add task form
        driver.findElement(By.xpath("//input[@placeholder='Tiêu đề']")).sendKeys("Tiêu đề"); //tiêu đề

        //ngày tháng bắt đầu
        driver.findElement(By.xpath("//label[contains(text(),'Ngày bắt đầu')]/following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='22']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
        Thread.sleep(1000);

        //ngày tháng kết thúc
        driver.findElement(By.xpath("//label[contains(text(),'Ngày kết thúc')]//following-sibling::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[contains(text(),'30')])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();
        Thread.sleep(1000);

        // Estimated hour
        driver.findElement(By.xpath("//input[@placeholder='Giờ ước tính']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Giờ ước tính']")).sendKeys("2"); //giờ
        Thread.sleep(1000);

        //dropdown project
        driver.findElement(By.xpath("//span[@class='select2-selection__rendered']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Dự án");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='select2-results']//li[normalize-space()='Tiêu đề dự án']")).click();
        Thread.sleep(2000);

        //tóm tắt
        driver.findElement(By.xpath("//textarea[@id='summary']")).sendKeys("tóm tắt công việc phải ít nhất 60 ký tự. tóm tắt công việc phải ít nhất 60 ký tự.");
        Thread.sleep(1000);

        //        int sizeIFrame = driver.findElements(By.tagName("iframe")).size();
//        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
//        Thread.sleep(1000);

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//body")).click();
        driver.findElement(By.xpath("//body")).sendKeys("mô tả công việc phải ít nhất 100 ký tự. mô tả công việc phải ít nhất 100 ký tự.");
        Thread.sleep(1000);

        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//span[contains(text(),'Lưu')]")).click();
        Thread.sleep(1000);

    }
}
