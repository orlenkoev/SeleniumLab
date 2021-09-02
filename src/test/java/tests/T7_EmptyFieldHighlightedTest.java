package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class T7_EmptyFieldHighlightedTest extends BaseTest {

//        Click on the "Input Forms"
//        Click on the "Ajax Form Submit"
//        In the "Ajax Form" click on the "submit button"
//        Check that "Name" field highlighted in red
    @Test
    public void checkEmptyFieldHighlighted() throws InterruptedException {

        WebElement inputForms = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(inputForms)).click();

        WebElement ajaxFormSubmit = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Ajax Form Submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(ajaxFormSubmit)).click();

        WebElement submitButton = driver.findElement(By.xpath("//*[@id = 'btn-submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        Thread.sleep(5000);
        String colorWeHave = driver.findElement(By.xpath("//*[@id='title']")).getCssValue("border-color");
        String colorWeNeed = "rgb(255, 0, 0)";
        Assert.assertEquals(colorWeHave, colorWeNeed);
    }
}
