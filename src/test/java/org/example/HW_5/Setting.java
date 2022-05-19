package org.example.HW_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Setting {
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

    @BeforeEach
    void authorization(){
        WebElement webElement1 = getDriver().findElement(By.xpath(".//*[@id=\"tl_login\"]"));
        webElement1.click();
        webElement1.sendKeys("Test_Dude");
        WebElement webElement2 = getDriver().findElement(By.xpath(".//*[@id=\"tl_password\"]"));
        webElement2.click();
        webElement2.sendKeys("ARRB6XGri4us7j!");
        WebElement webElement3 = getDriver().findElement(By.xpath(".//*[@id=\"tl_login_button\"]"));
        webElement3.click();
        getDriver().switchTo().frame(0);
    }
    @AfterEach
    void exit(){
        getDriver().findElement(By.xpath(".//*[@accesskey=\"q\"]")).click();
    }
    @AfterAll
    static void end_session(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
