package anhtester.com.baitap3;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BtAssert extends BaseTest {
    public String tenCategory = "Hai_Computer";
    @Test(priority = 1)
    public void loginCRM() throws InterruptedException {

        driver.get("https://ecommerce.anhtester.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title,"AT eCommerce | Automation Testing eCommerce","Không phải trang ecommerce của Anh Tester");
        driver.findElement(By.xpath("//button[@data-key='website-popup' and @data-value='removed']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@href='https://ecommerce.anhtester.com/users/login']")).click();
        Thread.sleep(1000);
        String login = driver.findElement(By.xpath("//h1[normalize-space()='Login to your account.']")).getText();
        Assert.assertEquals(login,"Login to your account.","Không phải trang login của ecommerce");

        boolean email = driver.findElement(By.id("email")).isEnabled();
        Assert.assertTrue(email,"Không nhập được email");
        driver.findElement(By.id("email")).sendKeys("maihaitdc@gmail.com");
        Thread.sleep(1000);

        boolean pass = driver.findElement(By.id("email")).isEnabled();
        Assert.assertTrue(pass,"Không nhập được password");
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(1000);

        boolean loginButton = driver.findElement(By.id("email")).isEnabled();
        Assert.assertTrue(loginButton,"Login button is inactive");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void openCategory() throws InterruptedException {

        String product = driver.findElement(By.xpath("//span[normalize-space()='Products']")).getText();
        Assert.assertEquals(product,"Products","It's not Product menu");
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        Thread.sleep(1000);

        String category = driver.findElement(By.xpath("//span[normalize-space()='Category']")).getText();
        Assert.assertEquals(category,"Category","It's not Category menu");
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);

        Boolean addCategory = driver.findElement(By.xpath("//span[normalize-space()='Category']")).isEnabled();
        Assert.assertTrue(addCategory,"Add New category button is disable");
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void addCategory() throws InterruptedException {


        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(tenCategory);
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']//div[1]//div[1]//div[1]//div[1]//img[1]")).click();
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

        Boolean luu = driver.findElement(By.xpath("//button[normalize-space()='Save']")).isEnabled();
        Assert.assertTrue(luu,"Save button is disable");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(1000);

    }

    @Test(priority = 4)
    public void ktCategory() throws InterruptedException {

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(tenCategory);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        String st= driver.findElement(By.xpath("(//td[@class='footable-first-visible'])[1]")).getText();
        Assert.assertEquals(st,tenCategory,"Tên Category sai");

        driver.findElement(By.xpath("//span[@class='footable-toggle fooicon fooicon-plus']")).click();

        String parentCate = driver.findElement(By.xpath("(//td[contains(text(),'Computer & Accessories')])[1]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(parentCate,"Computer & Accessories", "Parent Category không đúng");

        String orderLevel = driver.findElement(By.xpath("(//td[contains(text(),'123')])[2]")).getText();
        softAssert.assertEquals(orderLevel,"123", "Order Level không đúng");

    }
}
