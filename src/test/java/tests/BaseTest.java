package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void startWorks() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
        @AfterTest(alwaysRun = true)
        public void quitDriver() {
            driver.quit();
    }
}
