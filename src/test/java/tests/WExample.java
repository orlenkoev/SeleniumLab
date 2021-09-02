//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class WExample {
//    WebDriver driver;
//
//    @Test
//    public void checkMainPaigeTitleText() {
//
//        //встановлюєм драйвер
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        //відкриваєм сторінку
//        driver.get("https://novaposhta.ua/");
//
//        //знаходимо кнопку "Вхід" і клікаєм на неї
//        WebElement enterButton = driver.findElement(By.xpath("//span[text()='Вхід']"));
//        enterButton.click();
//
//        //беремо title сторінки
//        String titleOfPage = driver.getTitle();
//
//        //зрівнюєм реальну і очікувану
//
//        Assert.assertEquals(titleOfPage, "Бізнес-кабінет - Нова пошта");
//
//        //закриваєм драйвер
//        driver.quit();
//    }
//
//
////    закриваєм в будь-якому випадку
////        @AfterMethod(alwaysRun = true)
////                public void after() {
////            driver.quit();
////        }
//
//
////      чекаєм взагалі
////       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    //чекаєм до чогось
////    WebDriverWait wait = new WebDriverWait(driver, 5); wait.until(ExpectedConditions.)
//}
