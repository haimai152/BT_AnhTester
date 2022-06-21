package anhtester.com.baitap1;

import anhtester.com.common.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class AddCategory extends BaseTest {
    public void testUploadFile2() throws InterruptedException {
        //   driver.get("https://files.fm/");

        Thread.sleep(2000);

        //   By textOnPage = By.xpath("//div[@id='file_select_dragndrop_text']");
        By divFileUpload = By.xpath("//button[normalize-space()='Browse']");
        //  By inputFileUpload = By.xpath("//div[@id='file_select_button']//input[@id='file_upload']");

        String filePath = "C:\\MaiHai\\linhtinh\\hinh_picnic\\dautay_resized.jpg";

        //Click để mở form upload
        driver.findElement(divFileUpload).click();
        Thread.sleep(3);

        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        Thread.sleep(1000);

        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        Thread.sleep(1000);

        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(4000);
    }

    public static void main(String[] args) throws InterruptedException {
        // System.out.println("hello");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
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


//        driver.findElement(By.xpath("//a[normalize-space()='Upload New']")).click();
//        Thread.sleep(1000);
//        AddCategory addCategory = new AddCategory();
//        addCategory.testUploadFile2();
//        driver.findElement(By.xpath("//button[normalize-space()='Browse']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("C:\\MaiHai\\linhtinh\\hinh_picnic\\dautay_resized.jpg");;
//        Thread.sleep(1000);

        driver.findElement(By.xpath("(//div[contains(text(),'Choose File')])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("dautay_resized");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@title='dautay_resized.jpg'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='input-group']//div[normalize-space()='Choose File']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("lake");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@title='lake.jpg'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

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
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        String cateName = driver.findElement(By.xpath("//input[@id='search']")).getAttribute("value");

        driver.findElement(By.xpath("//span[@class='footable-toggle fooicon fooicon-plus']")).click();
        Thread.sleep(1000);

        String st= driver.findElement(By.xpath("(//td[@class='footable-first-visible'])[1]")).getText();
        Thread.sleep(1000);

        if(cateName.equals(st)){
            System.out.println("Category is found: " + cateName);
        }
        else System.out.println("Category is not found");


        driver.quit();
    }
}
