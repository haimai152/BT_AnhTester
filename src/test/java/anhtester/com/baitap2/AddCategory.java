package anhtester.com.baitap2;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AddCategory extends BaseTest {
        @Test(priority = 1)
        public void loginCRM() throws InterruptedException {

            driver.get("https://ecommerce.anhtester.com/");
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
        }
        @Test(priority = 2)
        public void addCategory() throws InterruptedException {

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
            driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("dautay_resized");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(Keys.ENTER);
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//img[@class='img-fit'])[1]")).click();
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

        }

}
