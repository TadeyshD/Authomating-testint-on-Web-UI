package hw_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class test_4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); //заходим в браузер под "инкогнито".
        options.addArguments("start-maximized");
        //options.addArguments("--headless"); //создаёт сессию без открытог окна браузера.

        WebDriver action = new ChromeDriver(options);
        action.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //Неявные ожиданияНеявные ожидания конфигурируют экземпляр драйвера периодически проверять наличие искомогоэлемента в течение обозначенного времени без выброса исключений. Прописывается в начале.
        action.get("https://google.com");
        action.navigate().to("http://testlink.testbase.ru/login.php");
        WebElement webElement1 = action.findElement(By.xpath(".//*[@id=\"tl_login\"]"));
        webElement1.click();
        webElement1.sendKeys("Test_Dude");
        WebElement webElement2 = action.findElement(By.xpath(".//*[@id=\"tl_password\"]"));
        webElement2.click();
        webElement2.sendKeys("ARRB6XGri4us7j!");
        WebElement webElement3 = action.findElement(By.xpath(".//*[@id=\"tl_login_button\"]"));
        webElement3.click();
        action.switchTo().frame(0);
        WebElement webElement4 = action.findElement(By.xpath(".//*[@accesskey=\"t\"]"));
        webElement4.click();
        action.switchTo().parentFrame().switchTo().frame(1).switchTo().frame(0);
        WebElement webElement5 = action.findElement(By.cssSelector(".x-tree-ec-icon"));
        webElement5.click();
        WebElement webElement6 = action.findElement(By.cssSelector("#extdd-10 > .x-tree-ec-icon"));
        webElement6.click();
        WebElement webElement7 = action.findElement(By.cssSelector("#extdd-864"));
        webElement7.click();
        action.switchTo().parentFrame().switchTo().frame(1);
        WebElement webElement8 = action.findElement(By.xpath(".//div[4]/input"));
        webElement8.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.switchTo().frame(0);
        WebElement webElement9 = action.findElement(By.cssSelector(".cke_editable"));
        webElement9.click();
        webElement9.sendKeys("Привет");
        action.switchTo().parentFrame();
        WebElement webElement10 = action.findElement(By.cssSelector(".workBack:nth-child(16) #do_update_step_and_exit"));
        webElement10.click();
        WebElement webElement11 = action.findElement(By.xpath("(//img[@alt='Удалить шаг'])[19]"));
        webElement11.click();
        WebElement webElement12 = action.findElement(By.cssSelector("#ext-comp-1002 .x-btn-mc"));
        webElement12.click();
        action.switchTo().parentFrame().switchTo().frame(0);
        WebElement webElement13 = action.findElement(By.cssSelector(".x-tree-elbow-minus"));
        webElement13.click();
        WebElement webElement14 = action.findElement(By.cssSelector(".x-tree-elbow-end-minus"));
        webElement14.click();
        action.switchTo().parentFrame().switchTo().parentFrame().switchTo().frame(0);
        WebElement webElement15 = action.findElement(By.xpath(".//*[@accesskey=\"q\"]"));
        webElement15.click();
        action.quit();
    }
}

