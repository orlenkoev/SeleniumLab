//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//public class WExample2 {
//
//    //виносимо драйвер
//    WebDriver driver;
//
//    @Test
//    public void testFirst() throws InterruptedException {
//        //встановлюєм драйвер
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//
//        //на все вікно
//        driver.manage().window().maximize();
//
//        //відкриваємо сторінку
//        driver.get("https://novaposhta.ua/");
//
//        //чекаєм 5сек до чого: 1,2,3,4 і клікаємо
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//
//        //1 вхід
//        WebElement enterButton = wait
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='logo_in']//span")));
//        enterButton.click();
//        //2 зареєструватись
//        WebElement signUpButton = wait.until(ExpectedConditions
//                .elementToBeClickable(By.xpath("//a//span[@class='mat-button-wrapper']")));
//        signUpButton.click();
//        //3 вибір мови
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='selectIcon']")))
//                .click();
//        //4 обираємо мову
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Русский']")))
//                .click();
//
//        //беремо актуальний текст
//        String actualText = driver.findElement(By.xpath("//h1[@class='infoScreen_title']")).getText();
//
//        //зрівнюємо
//        Assert.assertEquals(actualText, "Welcome to Nova Poshta");
//    }
//
////    @AfterMethod(alwaysRun = true)
////    public void after() {
////        driver.quit();
////    }
//
//}