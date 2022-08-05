package anhtester.com.POM.pages;

import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    WebDriver driver;

    private By productMenuItem = By.xpath("//span[normalize-space()='Products']");
    private By addNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By categoryMenuItem = By.xpath("//span[normalize-space()='Category']");
    private By addNewCategory = By.xpath("//span[normalize-space()='Add New category']");

    public DashboardPage(WebDriver driver) {

        this.driver= driver;
        new WebUI(driver);
    }

    public void clickAddProduct(){
        WebUI.waitForElementClickable(productMenuItem);
        WebUI.clickElement(productMenuItem);

        WebUI.waitForElementClickable(addNewProduct);
        WebUI.clickElement(addNewProduct);
    }
    public void clickAddCategory(){
        WebUI.waitForElementClickable(productMenuItem);
        WebUI.clickElement(productMenuItem);

        WebUI.waitForElementClickable(categoryMenuItem);
        WebUI.clickElement(categoryMenuItem);

        WebUI.waitForElementClickable(addNewCategory);
        WebUI.clickElement(addNewCategory);

    }
}