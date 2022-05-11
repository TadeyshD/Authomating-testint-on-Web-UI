package hw_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class test_3 {
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
        action.switchTo().parentFrame();
        action.switchTo().frame(1);
        action.switchTo().frame(0);
        WebElement webElement5 = action.findElement(By.cssSelector(".x-tree-ec-icon"));
        webElement5.click();
        WebElement webElement6 = action.findElement(By.cssSelector("#extdd-13 > .x-tree-ec-icon"));
        webElement6.click();
        action.switchTo().parentFrame();
        action.switchTo().frame(0);
        WebElement webElement7 = action.findElement(By.id("extdd-861"));
        webElement7.click();
        WebElement webElement8 = action.findElement(By.cssSelector("div > input:nth-child(1)"));
        webElement8.click();
        action.switchTo().frame(0);
        WebElement webElement9 = action.findElement(By.cssSelector(".cke_editable"));
        webElement9.click();
        webElement9.sendKeys("<p>Новый шаг для меня, не для человечества, просьба не путать</p>");
        action.switchTo().parentFrame();
        action.switchTo().frame(0);
        WebElement webElement10 = action.findElement(By.cssSelector(".x-tree-elbow-minus"));
        webElement10.click();
        WebElement webElement11 = action.findElement(By.cssSelector(".x-tree-elbow-end-minus"));
        webElement11.click();
        action.switchTo().parentFrame();
        action.switchTo().parentFrame();
        action.switchTo().frame(0);
        WebElement webElement12 = action.findElement(By.xpath(".//*[@accesskey=\"q\"]"));
        webElement12.click();
        action.quit();
    }
}

