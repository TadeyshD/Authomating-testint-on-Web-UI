package hw_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.framework.qual.TargetLocations;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

public class test_1 {
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
        WebElement webElement4 = action.findElement(By.xpath(".//*[@accesskey=\"q\"]"));
        webElement4.click();
        action.quit();

    }
}
