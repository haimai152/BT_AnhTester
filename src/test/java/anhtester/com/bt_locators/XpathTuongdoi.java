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
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
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

        driver.findElement(By.xpath("//div[@class='card-header']//following-sibling::a[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//input[@name='file'])[1]")).click();
        Thread.sleep(2000);
//
//        By inputFileUpload = By.xpath("//div[@class='custom-file']//input[@name='file']");
//        driver.findElement(inputFileUpload).sendKeys(System.getProperty("user.dir") + "MaiHai\\linhtinh\\hinh_picnic\\dautay_resized.jpg");
//        Thread.sleep(4000);

        driver.findElement(By.xpath("//input[@placeholder='Tên']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Tên']")).sendKeys("Hai");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Họ']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Họ']")).sendKeys("Mai");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='ID nhân viên']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='ID nhân viên']")).clear();

        driver.findElement(By.xpath("//input[@placeholder='ID nhân viên']")).sendKeys("123456789");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Số liên lạc']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Số liên lạc']")).sendKeys("987654321");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='form-group']//span[@data-select2-id='19']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Female");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='listbox']//li[normalize-space()='Female']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("maihaitdc@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Tên người dùng']")).sendKeys("HaiMai");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']")).sendKeys("MaiHai12345");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Office Shift')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Office");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='listbox']//li[normalize-space()='Office Shift 01']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Vai trò')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Admin");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='listbox']//li[normalize-space()='Admin']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Khoa')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("QA");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='listbox']//li[normalize-space()='QA']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Chỉ định')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Automation");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='listbox']//li[normalize-space()='Automation']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Tổng lương']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Tổng lương']")).sendKeys("20");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Tỷ lệ hàng giờ']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Tỷ lệ hàng giờ']")).sendKeys("123");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(text(),'Mỗi tháng')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Mỗi tháng");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@role='listbox']//li[normalize-space()='Mỗi tháng']")).click();
        Thread.sleep(2000);



        driver.findElement(By.xpath("//span[contains(text(),'Lưu')]")).click();
        Thread.sleep(2000);



        driver.quit();
    }
}
