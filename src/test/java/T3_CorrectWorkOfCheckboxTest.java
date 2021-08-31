import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CorrectWorkOfCheckboxTest extends BaseTest {

//        Click on the "Input Forms"
//        Click on the "Checkbox Demo"
//        In the "Multiple Checkbox Demo" click on check boxes with Option 1 and Option 3
//        Verify that checkbox are checked after click
    @Test
    public void checkTheCheckboxAreCheckedAfterClick() {

        WebElement inputForms = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(inputForms)).click();

        WebElement checkBoxDemo = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Checkbox Demo\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxDemo)).click();

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", "");

        WebElement option1 = driver.findElement(By.xpath("(//div[@class='checkbox']//input[@class='cb1-element'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(option1)).click();

        WebElement option3 = driver.findElement(By.xpath("(//div[@class='checkbox']//input[@class='cb1-element'])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(option3)).click();

        Assert.assertTrue(option1.isSelected());
        Assert.assertTrue(option3.isSelected());
    }
}

