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
    }

    public void clickGeneral(By categoryMenuItem) {
        WebElement clickButtonLink = driver.findElement(categoryMenuItem);
        if (clickButtonLink.isDisplayed()) {
            clickButtonLink.click();
        }
    }
    public void clickAddProduct(){
        clickGeneral(productMenuItem);
        clickGeneral(addNewProduct);
    }
    public void clickAddCategory(){
        clickGeneral(productMenuItem);
        WebUI.waitForElementClickable(categoryMenuItem);
        clickGeneral(categoryMenuItem);
        WebUI.waitForElementClickable(addNewCategory);
        clickGeneral(addNewCategory);
    }
}