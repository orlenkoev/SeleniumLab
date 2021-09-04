package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void startWorks() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.seleniumeasy.com/test/");
        try {
            Thread.sleep(2000);
            WebElement addForm = driver.findElement(By.xpath("//a[text()=\"No, thanks!\"]"));
            wait.until(ExpectedConditions.elementToBeClickable(addForm)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}
