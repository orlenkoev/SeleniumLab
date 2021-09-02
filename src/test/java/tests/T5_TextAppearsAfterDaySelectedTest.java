package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class T5_TextAppearsAfterDaySelectedTest extends BaseTest {
    //        Click on the "Input Forms"
    //        Click on the "Select Dropdown List"
    //        In the "Select List Demo" select "Friday"
    //        Check that text "Day selected :- Friday" appears
    @Test
    public void checkDaySelected() {
        WebElement inputForms = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(inputForms)).click();

        WebElement selectDropdownList = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Select Dropdown List\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(selectDropdownList)).click();

        WebElement selectForm = driver.findElement(By.xpath("//*[@id='select-demo']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectForm)).click();

        WebElement pickFriday = driver.findElement(By.xpath("//*[text() = 'Friday']"));
        wait.until(ExpectedConditions.elementToBeClickable(pickFriday)).click();

        String theTextWeCheck = "Day selected :- Friday";
        String theTextWeReceived = driver.findElement(By.xpath("//p[@class='selected-value']")).getText();

        Assert.assertEquals(theTextWeReceived, theTextWeCheck);
    }
}
