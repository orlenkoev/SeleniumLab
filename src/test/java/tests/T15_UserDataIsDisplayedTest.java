package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class T15_UserDataIsDisplayedTest extends BaseTest{
    //        Click on the "Others"
    //        Click on the "Dynamic Data Loading"
    //        Click on the "Get New User" button
    //        Check that image with men or woman appears
    //        Check that First Name and Last Name not empty
    @Test
    public void checkUserDataIsDisplayed()  {

        WebElement othersColumn = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav navbar-right']//a)[16]"));
        wait.until(ExpectedConditions.elementToBeClickable(othersColumn)).click();

        WebElement dynamicDataLoading = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav navbar-right']//a)[18]"));
        wait.until(ExpectedConditions.elementToBeClickable(dynamicDataLoading)).click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", "");

        WebElement getNewUserButton = driver.findElement(By.xpath("//button[text()='Get New User']"));
        wait.until(ExpectedConditions.elementToBeClickable(getNewUserButton)).click();

        WebElement userPhoto = driver.findElement(By.xpath("//div[@id='loading']/img"));
        Assert.assertTrue(userPhoto.isEnabled());

        WebElement firstName = driver.findElement(By.xpath("//div[@id='loading']/br[2]"));
        WebElement lastName = driver.findElement(By.xpath("//div[@id='loading']/br[4]"));
        Assert.assertTrue(firstName.isEnabled());
        Assert.assertTrue(lastName.isEnabled());

    }
}
