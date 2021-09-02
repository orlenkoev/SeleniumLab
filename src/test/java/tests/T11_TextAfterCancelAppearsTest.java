package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class T11_TextAfterCancelAppearsTest extends BaseTest {

    //        Click on the "Alerts & Modals"
    //        Click on the "Javascript Alerts"
    //        In the "Java Script Confirm Box" click on the "Click me!" button
    //        Click on the "Cancel" button in alert window
    //        Check that text "You pressed Cancel!" appears
    @Test
    public void checkTextAfterCancelAppears() {

        WebElement alertsAndModals = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav navbar-right']//a)[5]"));
        wait.until(ExpectedConditions.elementToBeClickable(alertsAndModals)).click();

        WebElement javascriptAlerts = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav navbar-right']//a)[10]"));
        wait.until(ExpectedConditions.elementToBeClickable(javascriptAlerts)).click();

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", "");

        WebElement clickMeButton = driver.findElement(By.xpath("//*[@class='btn btn-default btn-lg' and text()='Click me!']"));
        wait.until(ExpectedConditions.elementToBeClickable(clickMeButton)).click();

        driver.switchTo().alert().dismiss();

        String bodyText = driver.findElement(By.xpath("//*[@id='confirm-demo']")).getText();
        Assert.assertTrue(bodyText.contains("You pressed Cancel!"));

        }
    }



