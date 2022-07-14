package anhtester.com.baitap4;

import anhtester.com.baitap3.BtAssert;
import anhtester.com.common.BaseTest;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;

public class BtAction extends BaseTest {
    BtAssert btassert = new BtAssert();
    String tenCateOfPro = btassert.tenCategory;
    String tenProduct = "Hai_Product";

    @Test(priority = 1)
    public void loginCRM() throws InterruptedException {

        driver.get("https://ecommerce.anhtester.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "AT eCommerce | Automation Testing eCommerce", "Không phải trang ecommerce của Anh Tester");
        driver.findElement(By.xpath("//button[@data-key='website-popup' and @data-value='removed']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@href='https://ecommerce.anhtester.com/users/login']")).click();
        Thread.sleep(1000);
        String login = driver.findElement(By.xpath("//h1[normalize-space()='Login to your account.']")).getText();
        Assert.assertEquals(login, "Login to your account.", "Không phải trang login của ecommerce");

        boolean email = driver.findElement(By.id("email")).isEnabled();
        Assert.assertTrue(email, "Không nhập được email");
        driver.findElement(By.id("email")).sendKeys("maihaitdc@gmail.com");
        Thread.sleep(1000);

        boolean pass = driver.findElement(By.id("email")).isEnabled();
        Assert.assertTrue(pass, "Không nhập được password");
        driver.findElement(By.name("password")).sendKeys("123456");
        Thread.sleep(1000);

        boolean loginButton = driver.findElement(By.id("email")).isEnabled();
        Assert.assertTrue(loginButton, "Login button is inactive");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void SelectAddProduct() throws InterruptedException {
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Add New Product']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void AddProductInformation() throws InterruptedException {

        driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(tenProduct);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[contains(text(),'Computer & Accessories')]")).click();
        Thread.sleep(1000);
        WebElement elementCateName = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"));
        Actions action = new Actions(driver);
        action.sendKeys(elementCateName, tenCateOfPro).build().perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(By.xpath("//div[contains(text(),'Select Brand')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("HP");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='bs-select-2-3']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']")).sendKeys("Pc");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='min_qty']")).clear();
        driver.findElement(By.xpath("//input[@name='min_qty']")).sendKeys("100");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@role='textbox']")).sendKeys("Hai");
        Thread.sleep(1000);

    }

    @Test(priority = 4)
    public void AddProductShipConf() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        Boolean stockText = driver.findElement(By.xpath("//label[normalize-space()='Flat Rate']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (stockText == false) {
            softAssert.assertTrue(stockText, "Flat Rate option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Flat Rate']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(1000);

            Boolean shipCost = driver.findElement(By.xpath("//input[@placeholder='Shipping cost']")).isEnabled();
            softAssert.assertTrue(shipCost, "Shipping cost field is inactive");
            driver.findElement(By.xpath("//input[@placeholder='Shipping cost']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Shipping cost']")).sendKeys("$60");
            Thread.sleep(1000);
        }

        Boolean quantityMul = driver.findElement(By.xpath("//label[normalize-space()='Is Product Quantity Mulitiply']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (quantityMul == false) {
            softAssert.assertTrue(quantityMul, "Status of Today Deal option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Is Product Quantity Mulitiply']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(2000);
        }

        driver.findElement(By.xpath("//input[@name='low_stock_quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='low_stock_quantity']")).sendKeys("200");
        Thread.sleep(1000);

    }

    @Test(priority = 5)
    public void AddProductImage() throws InterruptedException {

        driver.findElement(By.xpath("//div[@data-multiple='true']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("dautay_resized");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='aiz-select-file']//div[1]//div[1]//div[1]//div[1]//img[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//div[contains(text(),'Browse')])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("lake");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@title='lake.jpg'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 6)
    public void AddProductVisiState() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        Boolean stockText = driver.findElement(By.xpath("//label[normalize-space()='Show Stock With Text Only']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (stockText == true) {
            softAssert.assertFalse(stockText, "Stock Text option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Show Stock With Text Only']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(1000);
        }

        Boolean stockHide = driver.findElement(By.xpath("//label[normalize-space()='Hide Stock']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (stockHide == false) {
            softAssert.assertTrue(stockHide, "Hide stock option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Hide Stock']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(1000);
        }

    }

    @Test(priority = 7)
    public void AddProductVideos() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath("//div[contains(text(),'Youtube')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='bs-select-3-0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Video Link']")).sendKeys("https://www.youtube.com/watch?v=JZ9pHBEUWPo");
        Thread.sleep(1000);

        Boolean featured = driver.findElement(By.xpath("//label[normalize-space()='Status']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).isSelected();
        if (featured == false) {
            softAssert.assertTrue(featured, "Featured option is inactive");
            driver.findElement(By.xpath("//label[normalize-space()='Status']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']")).click();
            Thread.sleep(1000);
        }
    }

    @Test(priority = 8)
    public void AddProductVariation() throws InterruptedException {

        Boolean colorsCheckbox = driver.findElement(By.xpath("//div[@class='col-md-1']")).isSelected();
        SoftAssert softAssert = new SoftAssert();
        if (colorsCheckbox == false) {
            softAssert.assertTrue(colorsCheckbox, "Colors option is inactive");
            driver.findElement(By.xpath("//div[@class='col-md-1']")).click();
        }

        driver.findElement(By.xpath("//button[@data-id='colors']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("red");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'DarkRed')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'OrangeRed')]")).click();
        Thread.sleep(1000);

        WebElement elementColors = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.LEFT_CONTROL).sendKeys("a").keyUp(Keys.LEFT_CONTROL).sendKeys(Keys.DELETE).build().perform();
        Thread.sleep(2000);
        action.sendKeys(elementColors, "blue").build().perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(text(),'BlueViolet')]")).click();
        driver.findElement(By.xpath("//button[@data-id='colors']")).click();
        Thread.sleep(1000);

        // Verify selected colors
        String selectedColor = driver.findElement(By.xpath("//div[contains(text(),'3 items selected')]")).getText();
        softAssert.assertEquals(selectedColor, "3 items selected", "selected colors are incorrect");

        driver.findElement(By.xpath("//button[@title='Nothing selected']//div[@class='filter-option-inner']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Fabric");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Fabric']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Fabric']")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Cot");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Cotton']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Cotton']")).click();
        Thread.sleep(1000);

        Boolean todayDeal = driver.findElement(By.xpath("(//label[normalize-space()='Status']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0'])[2]")).isSelected();
        if (todayDeal == false) {
            softAssert.assertTrue(todayDeal, "Status of Today Deal option is inactive");
            driver.findElement(By.xpath("(//label[normalize-space()='Status']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0'])[2]")).click();
            Thread.sleep(1000);
        }
    }

    @Test(priority = 9)
    public void AddProductFlashD_Time_Tax() throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'Choose Flash Title')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Electronic']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='flash_discount']")).clear();
        driver.findElement(By.xpath("//input[@name='flash_discount']")).sendKeys("20");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[contains(text(),'Choose Discount Type')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='bs-select-8-2']//span[@class='text'][normalize-space()='Percent']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Shipping Days']")).sendKeys("5");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Tax']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Tax']")).sendKeys("15");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='form-group col-md-6']//button[@title='Flat']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='bs-select-9-1']//span[@class='text'][normalize-space()='Percent']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public void AddProductPrice() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Unit price']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Unit price']")).sendKeys("100");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Select Date']")).click();
        driver.findElement(By.xpath("//div[@class='drp-calendar left']//td[@data-title='r4c4']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='drp-calendar right']//td[@data-title='r1c3']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Discount']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Discount']")).sendKeys("10");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='col-md-3']//div[@class='filter-option-inner-inner'][normalize-space()='Flat']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Percent']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='External link']")).sendKeys("external link");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='External link button text']")).sendKeys("https://www.youtube.com/watch?v=orJSJGHjBLI");
        Thread.sleep(1000);

//        driver.findElement(By.xpath("//input[@placeholder='Quantity']")).clear();
//        driver.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys("100");
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//input[@placeholder='SKU']")).sendKeys("SKU field");
//        Thread.sleep(1000);

//        driver.findElement(By.xpath("//input[@name='price_Amethyst-Cotton']")).sendKeys("150");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@name='sku_AliceBlue-Cotton']")).sendKeys("sku_AliceBlue-Cotton");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@name='qty_AliceBlue-Cotton']")).sendKeys("10");
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//input[@name='price_AntiqueWhite-Cotton']")).sendKeys("200");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@name='sku_Amethyst-Cotton']")).sendKeys("sku_AliceBlue-Cotton");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@name='qty_AliceBlue-Cotton']")).sendKeys("10");
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//input[@name='price_Aqua-Cotton']")).sendKeys("250");
//        Thread.sleep(1000);
    }

    @Test(priority = 11)
    public void AddProductDes_Spec() throws InterruptedException {
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("This is description of products");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@data-type='document']//div[@class='form-control file-amount'][normalize-space()='Choose File']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("academic");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='la la-file-text']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

    }

    @Test(priority = 12)
    public void AddProductMetaTags() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Hai Meta");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Description of Meta");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[normalize-space()='Meta Image']//following-sibling::div//div[@class='input-group-prepend']//div[normalize-space()='Browse']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("dautay_resized");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='aiz-uploader-all clearfix c-scrollbar-light']//div[1]//div[1]//div[1]//div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(1000);

    }

    @Test(priority = 13)
    public void SaveAndReview() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath("//button[normalize-space()='Save & Publish']")).click();
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));
        Actions action = new Actions(driver);
        action.sendKeys(element, tenProduct).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        String getProName = driver.findElement(By.xpath("(//span[contains(text(),'Hai_Product')])[1]")).getText();
        softAssert.assertEquals(getProName, tenProduct, "This Product is not the added one");
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/span[1]")).click();
        Thread.sleep(2000);

    }
}