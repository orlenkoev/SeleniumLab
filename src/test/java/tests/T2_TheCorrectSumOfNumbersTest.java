package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_TheCorrectSumOfNumbersTest extends BaseTest {
    //    Click on the "Input Forms"
    //    Click on the "Simple Form Demo"
    //    In the "Two Input Fields" form enter a and b values (integers)
    //    Click on the "Get Total" button
    //    Check that "Total a + b = " your expected result
    @Test
    public void checkTheSumOfNumbers() {

        WebElement inputForms = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(inputForms)).click();

        WebElement simpleFormDemo = driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='Simple Form Demo']"));
        wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemo)).click();

        int a = 2;
        int b = 3;
        int result = a + b;
        String firstNumber = String.valueOf(a);
        String secondNumber = String.valueOf(b);

        driver.findElement(By.xpath("//*[@id='sum1']")).sendKeys(firstNumber);
        driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys(secondNumber);

        WebElement getTotal = driver.findElement(By.xpath("//button[text()='Get Total']"));
        wait.until(ExpectedConditions.elementToBeClickable(getTotal)).click();

        String theSumWeReceived = driver.findElement(By.xpath("//*[@id= 'displayvalue']")).getText();

        Assert.assertEquals(Integer.parseInt(theSumWeReceived), result);

    }
}
