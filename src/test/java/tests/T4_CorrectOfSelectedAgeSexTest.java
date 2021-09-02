package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_CorrectOfSelectedAgeSexTest extends BaseTest {
    //        Click on the "Input Forms"
    //        Click on the "Radio Buttons Demo"
    //        In the "Group Radio Buttons Demo" pick Sex: "Male" and Age Group: 15 to 50
    //        Click on "Get values" button
    //        Check following messages: Sex : Female Age group: 5 - 15
    @Test
    public void checkTheAgeAndSex() {

        WebElement inputForms = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(inputForms)).click();

        WebElement radioButtonsDemo = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Radio Buttons Demo\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(radioButtonsDemo)).click();

        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");

        WebElement maleSex = driver.findElement(By.xpath("(//*[@name='gender'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(maleSex)).click();

        WebElement ageGroup = driver.findElement(By.xpath("(//*[@name='ageGroup'])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(ageGroup)).click();

        WebElement getValuesButton = driver.findElement(By.xpath("//*[@class='btn btn-default' and text() = 'Get values']"));
        wait.until(ExpectedConditions.elementToBeClickable(getValuesButton)).click();

        String theTextWeCheck = "Sex : Female\n" + "Age group: 5 - 15";
        String theTextWeReceived = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();

        Assert.assertEquals(theTextWeReceived, theTextWeCheck);
    }
}
