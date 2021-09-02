package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_TheCorrectEnteredTextTest extends BaseTest {

//        Click on the "Input Forms"
//        Click on the "Simple Form Demo"
//        In the "Single Input Field" form enter text "Hello, my name is "
//        Click on the "Show Message" button
//        Check that "Your Message: Hello, my name is " appears under button Show Message
    @Test
    public void checkTextWePrint() {

        WebElement inputForms = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(inputForms)).click();

        WebElement simpleFormDemo = driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='Simple Form Demo']"));
        wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemo)).click();

        String theTextWePrint = "\"Hello, my name is \"";
        driver.findElement(By.xpath("//input[(@id='user-message')]")).sendKeys(theTextWePrint);

        WebElement showMessageButton = driver.findElement(By.xpath("//*[@class='btn btn-default' and text() = 'Show Message']"));
        wait.until(ExpectedConditions.elementToBeClickable(showMessageButton)).click();

        String theTextWeReceived = driver.findElement(By.xpath("//*[@id= 'display']")).getText();

        Assert.assertEquals(theTextWeReceived, theTextWePrint);
    }
}
