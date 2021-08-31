import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_MultiSelectListDemoTest extends BaseTest {
    //        Click on the "Input Forms"
    //        Click on the "Select Dropdown List"
    //        In the "Multi Select List Demo" select New York and Florida
    //        Click on "Get All Selected" button
    //        Check that text appears: "Options selected are : Florida,New York" (application bug here)
    @Test
    public void checkMultiSelectIsWorking() {

        WebElement inputForms = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(inputForms)).click();

        WebElement selectDropdownList = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Select Dropdown List\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(selectDropdownList)).click();

        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).build().perform();
        driver.findElement(By.xpath("//*[text()='New York']")).click();
        driver.findElement(By.xpath("//*[text()='Florida']")).click();
        action.keyUp(Keys.CONTROL).build().perform();

        WebElement getAllSelectedButton = driver.findElement(By.xpath("//*[@id = 'printAll']"));
        wait.until(ExpectedConditions.elementToBeClickable(getAllSelectedButton)).click();

        String theTextWeCheck = "Options selected are : Florida,New York";
        String theTextWeReceived = driver.findElement(By.xpath("//p[contains (text(), 'Options selected are ')]")).getText();

        Assert.assertEquals(theTextWeReceived, theTextWeCheck);
    }
}

