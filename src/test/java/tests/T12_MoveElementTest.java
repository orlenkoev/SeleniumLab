package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class T12_MoveElementTest extends BaseTest {

    //        Click on the "List Box"
    //        Click on the "Bootstrap List Box"
    //        Select option "Morbi leo risus"
    //        Click on the ">" button
    //        Check two options with text "Morbi leo risus" on the right side of the list
    @Test
    public void checkMoveElementOnTheRightSide() {

        WebElement listBox = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav navbar-right']//a)[12]"));
        wait.until(ExpectedConditions.elementToBeClickable(listBox)).click();

        WebElement bootstrapListBox = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav navbar-right']//a)[13]"));
        wait.until(ExpectedConditions.elementToBeClickable(bootstrapListBox)).click();

        WebElement morbiLeoRisusOption = driver.findElement(By.xpath("//*[@class='dual-list list-left col-md-5']//li[text()='Morbi leo risus']"));
        wait.until(ExpectedConditions.elementToBeClickable(morbiLeoRisusOption)).click();

        WebElement moveElement = driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-chevron-right']"));
        wait.until(ExpectedConditions.elementToBeClickable(moveElement)).click();

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> list = driver.findElements(By.xpath("//*[@class='well']//*[text()='Morbi leo risus']"));
        Assert.assertTrue(list.size() ==2);

    }
}
