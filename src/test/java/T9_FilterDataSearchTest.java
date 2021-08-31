import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class T9_FilterDataSearchTest extends BaseTest{
    //        Click on the "Table"
    //        Click on the "Table Data Search"
    //        Enter "Emily John"
    //        Check that following record appears:
    //        4 Bootstrap 3 Emily John in progress
    @Test
    public void checkFilterDataSearch() {

        WebElement table = driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[12]"));
        wait.until(ExpectedConditions.elementToBeClickable(table)).click();

        WebElement tableDataSearch = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//a[text()=\"Table Data Search\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(tableDataSearch)).click();

        driver.findElement(By.xpath("//input[(@id='task-table-filter')]")).sendKeys("Emily John");

        String number = driver.findElement(By.xpath("(//*[@id='task-table']//td)[13]")).getText();
        String numberWeExpect = "4";
        String task = driver.findElement(By.xpath("(//*[@id='task-table']//td)[14]")).getText();
        String taskWeExpect = "Bootstrap 3";
        String assignee = driver.findElement(By.xpath("(//*[@id='task-table']//td)[15]")).getText();
        String assigneeWeExpect = "Emily John";
        String status = driver.findElement(By.xpath("(//*[@id='task-table']//td)[16]")).getText();
        String statusWeExpect = "in progress";

        Assert.assertEquals(number, numberWeExpect);
        Assert.assertEquals(task, taskWeExpect);
        Assert.assertEquals(assignee, assigneeWeExpect);
        Assert.assertEquals(status, statusWeExpect);
    }
}
