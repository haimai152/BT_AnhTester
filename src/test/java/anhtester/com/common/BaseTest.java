package anhtester.com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver = new ChromeDriver();

   public void createDrive(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://hrm.anhtester.com");

    }
  public void closeDrive(){

        driver.close();

    }
}
