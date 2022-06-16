package anhtester.com.baitap1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddCategory {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println("hello");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ecommerce.anhtester.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@data-key='website-popup' and @data-value='removed']")).click();
        Thread.sleep(1000);

        //Run Login case
        driver.findElement(By.xpath("//a[@href='https://ecommerce.anhtester.com/users/login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("maihaitdc@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hai_Computer");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[contains(text(),'No Parent')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Computer");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Computer & Accessories']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("123");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@title='Physical']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[normalize-space()='Digital']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//div[contains(text(),'Choose File')])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("C:\\MaiHai\\linhtinh\\hinh_picnic\\dautay_resized.jpg");;
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//div[contains(text(),'Choose File')])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("C:\\MaiHai\\linhtinh\\hinh_picnic\\dautay_resized.jpg");;
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("meta title");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("meta description");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@title='Nothing selected']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("size");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@role='option']//span[normalize-space()='Size']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Hai_Computer");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='search']")).submit();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@class='footable-toggle fooicon fooicon-plus']")).click();
        Thread.sleep(1000);

        driver.quit();
    }
}
