package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T14_JQueryListBoxTest extends BaseTest {

//        Click on the "List Box"
//        Click on the "JQuery List Box"
//        Select option: Alice, Laura, Giovanna
//        Click on the "Add" button
//        Check two options Alice, Laura, Giovanna appears on the right side of the list
    @Test
    public void checkJQueryListBox() {

        WebElement listBox = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav navbar-right']//a)[12]"));
        wait.until(ExpectedConditions.elementToBeClickable(listBox)).click();

        WebElement jQueryListBox = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav navbar-right']//a)[14]"));
        wait.until(ExpectedConditions.elementToBeClickable(jQueryListBox)).click();

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).build().perform();
        driver.findElement(By.xpath("//div[@class='col-sm-5']//*[text()='Alice']")).click();
        driver.findElement(By.xpath("//div[@class='col-sm-5']//*[text()='Laura']")).click();
        driver.findElement(By.xpath("//div[@class='col-sm-5']//*[text()='Giovanna']")).click();
        action.keyUp(Keys.CONTROL).build().perform();

        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

        String namesAppearsOnTheRightSide = driver.findElement(By.xpath("//*[@class='form-control pickListSelect pickListResult']")).getText();
        Assert.assertTrue(namesAppearsOnTheRightSide.contains("Alice\nLaura\nGiovanna"));
    }
}
