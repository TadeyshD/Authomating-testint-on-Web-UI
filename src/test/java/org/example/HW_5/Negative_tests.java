package org.example.HW_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Negative_tests {
    private static WebDriver driver;
    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://google.com");
        driver.navigate().to("http://testlink.testbase.ru/login.php");
    }
    @Test
    void invalid_authorisation(){
        WebElement webElement1 = driver.findElement(By.xpath(".//*[@id=\"tl_login\"]"));
        webElement1.click();
        webElement1.sendKeys("Invalid_login");
        WebElement webElement2 = driver.findElement(By.xpath(".//*[@id=\"tl_password\"]"));
        webElement2.click();
        webElement2.sendKeys("ARRB6XGri4us7j!");
        WebElement webElement3 = driver.findElement(By.xpath(".//*[@id=\"tl_login_button\"]"));
        webElement3.click();
        String s = driver.findElement(By.xpath(".//div[@class=\"user__feedback\"]")).getText();
        Assertions.assertTrue(s.equals("Попробуйте снова! Вы ввели неверное имя или пароль!"));
    }
    @Test
    void forget_you_password_invalid(){
    WebElement webElement1 = driver.findElement(By.id("tl_lost_password"));
    webElement1.click();
    WebElement webElement2 = driver.findElement(By.id("login"));
    webElement2.click();
    webElement2.sendKeys("1432432154541");
    WebElement webElement3 = driver.findElement(By.xpath(".//input[@name='editUser']"));
    webElement3.click();
    String s = driver.findElement(By.xpath(".//div[@class=\"user__feedback\"]")).getText();
    Assertions.assertTrue(s.equals("Пользователь не найден, пожалуйста, попробуйте еще раз"));
    }
    @AfterAll
    static void end_session(){
        driver.quit();
    }

}
