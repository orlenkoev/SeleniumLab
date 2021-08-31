import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import java.util.concurrent.TimeUnit;

public class T8_SelectYesterdayDateTest extends BaseTest{

//    Click on the "Date pickers"
//    Click on the "Bootstrap Date Picker"
//    In the "Date Example" select YESTERDAY date
//    Check that YESTERDAY date appears at the Select Date field
    @Test
    public void checkYesterdayDate() {

        WebElement datePickers = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[9]"));
        wait.until(ExpectedConditions.elementToBeClickable(datePickers)).click();

        WebElement bootstrapDatePicker = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Bootstrap Date Picker\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(bootstrapDatePicker)).click();

        WebElement selectDate = driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-th']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectDate)).click();

        WebElement yesterdayDate = driver.findElement(By.xpath("(//td[@class=\"today day\"]//preceding-sibling::td)[last()]"));
        wait.until(ExpectedConditions.elementToBeClickable(yesterdayDate)).click();

        String theDateWeReceived = driver.findElement(By.xpath("//div[@class='input-group date']/input")).getAttribute("value");

        LocalDate yesterday = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String theDateWeNeed = yesterday.format(formatter);

        Assert.assertEquals(theDateWeNeed, theDateWeReceived);
    }
}
