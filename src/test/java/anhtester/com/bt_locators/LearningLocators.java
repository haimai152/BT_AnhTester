package anhtester.com.bt_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearningLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hrm.anhtester.com");
        Thread.sleep(1000);

        //Run Login case
        driver.findElement(By.id("iusername")).sendKeys("admin01");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
        Thread.sleep(5000);

        //bắt xpath của các elements khác trong trang login
     /*   driver.findElement(By.xpath("//div[@class='card-body']//img")).click(); //image AnhTester
        driver.findElement(By.xpath("//h4[@class='mb-3 f-w-600']")).click(); // welcome to HRM system
        driver.findElement(By.xpath("//li[contains(text(),'Employee:')]")).click(); // bullet1: employee ...
        driver.findElement(By.xpath("//li[contains(text(),'Leader:')]")).click(); // bullet2: leader
        driver.findElement(By.xpath("//li[contains(text(),'Admin:')]")).click(); // bullet3: Admin
        driver.findElement(By.xpath("//li[normalize-space()='Client: client01/123456']")).click(); // Client
        driver.findElement(By.xpath("//img[@class='img-fluid']")).click(); //big image on the left side
        //theo yêu cầu của bài tập
        String forgotPass = "//span[normalize-space()='Forgot password?']";
        Thread.sleep(6000);
      */

        // Bắt xpath menu Product
        driver.findElement(By.xpath("(//span[contains(text(),'Dự án')])[1]")).click(); // select Project menu
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='collapsed btn waves-effect waves-light btn-primary btn-sm m-0']")).click(); // Click on Add project

        // elements on the add project form
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Tiêu đề']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Tiêu đề']")).sendKeys("Tiêu đề"); //tiêu đề

        //dropdown Khách hàng
        driver.findElement(By.xpath("//span[@class='select2-selection__placeholder']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@role='searchbox'])[2]")).sendKeys("Lam Nguyen");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@id='select2-client_id-results']//li[contains(@id,'select2-client_id-result')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Giờ ước tính']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Giờ ước tính']")).sendKeys("2"); //giờ
        Thread.sleep(1000);

        //priority
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[normalize-space()='Priority']/following-sibling::span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Cao");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='select2-results']//li[normalize-space()='Cao nhất']")).click();
        Thread.sleep(1000);

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

        driver.findElement(By.xpath("//textarea[@id='summary']")).sendKeys("tóm tắt");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@class='selection']//child::ul")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@role='listbox']//li[normalize-space()='Employee 01']")).click();
        Thread.sleep(1000);

//        int sizeIFrame = driver.findElements(By.tagName("iframe")).size();
//        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
//        Thread.sleep(1000);

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//body")).click();
        driver.findElement(By.xpath("//body")).sendKeys("mô tả");
        Thread.sleep(1000);

        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//span[contains(text(),'Lưu')]")).click();
        Thread.sleep(1000);
    }
}
