import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

//Go to the https://www.seleniumeasy.com/test/
//        Click on the "Table"
//        Click on the "Table Filter"
//        Click on the "Orange" button
//        Check only orange smiles appear
public class WTableFilter extends BaseTest {
    @Test
    public void checkTableFilter() {

        WebElement chooseTable = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[12]"));
        wait.until(ExpectedConditions.elementToBeClickable(chooseTable)).click();

        WebElement tableFilter = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Table Filter \"]"));
        wait.until(ExpectedConditions.elementToBeClickable(tableFilter)).click();

        WebElement orangeButton = driver.findElement(By.xpath("//*[text()='Orange']"));
        wait.until(ExpectedConditions.elementToBeClickable(orangeButton)).click();

        String colorOfFirstSmile = driver.findElement(By.xpath("(//*[@class='pull-right pendiente'])[1]")).getText();
        String colorOfSecondSmile = driver.findElement(By.xpath("(//*[@class='pull-right pendiente'])[2]")).getText();
        String colorWeCheck = "(Orange)";

        Assert.assertEquals(colorOfFirstSmile, colorWeCheck);
        Assert.assertEquals(colorOfSecondSmile, colorWeCheck);
    }
}