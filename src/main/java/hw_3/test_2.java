package hw_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class test_2 {
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
        try {
            webElement1.sendKeys("Test_Dude");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }
        WebElement webElement2 = action.findElement(By.xpath(".//*[@id=\"tl_password\"]"));
        webElement2.click();
        try {
            webElement2.sendKeys("ARRB6XGri4us7j!");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }
        WebElement webElement3 = action.findElement(By.xpath(".//*[@id=\"tl_login_button\"]"));
        webElement3.click();
        action.switchTo().frame(0);
        WebElement webElement4 = action.findElement(By.xpath(".//*[@accesskey=\"i\"]"));
        webElement4.click();
        action.switchTo().parentFrame();
        action.switchTo().frame(1);
        WebElement webElement5 = action.findElement(By.cssSelector("form:nth-child(1) > .groupBtn > input"));
        webElement5.click();
        action.switchTo().parentFrame();
        action.switchTo().frame(0);
        WebElement webElement6 = action.findElement(By.xpath(".//*[@accesskey=\"q\"]"));
        webElement6.click();
        action.quit();
    }
}
