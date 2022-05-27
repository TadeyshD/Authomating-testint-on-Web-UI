package org.example.HW_6;

import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import hw_6.Authorization_page;
import hw_6.Forget_password_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Negative_test {
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
    @AfterAll
    static void end_session(){
        driver.quit();
    }

    @Test
    void Invalid_authorization_with_invalid_login(){
        Authorization_page authorization_page = new Authorization_page(driver);
        authorization_page
                .add_invalid_login()
                .add_password()
                .click_on_auth_button();
        Assertions.assertTrue(
                driver
                        .findElement(By.xpath(".//div[@class=\"user__feedback\"]"))
                        .getText()
                        .equals("Попробуйте снова! Вы ввели неверное имя или пароль!")
        );
    }
    @Test
    void Invalid_authorization_with_invalid_password(){
        Authorization_page authorization_page = new Authorization_page(driver);
        authorization_page
                .add_login()
                .add_invalid_password()
                .click_on_auth_button();
        Assertions.assertTrue(
                driver
                        .findElement(By.xpath(".//div[@class=\"user__feedback\"]"))
                        .getText()
                        .equals("Попробуйте снова! Вы ввели неверное имя или пароль!")
        );
    }
    @Test
    void Forget_you_password_invalid(){
        Forget_password_page forget_password_page = new Forget_password_page(driver);
        forget_password_page
                .lost_password()
                .new_login()
                .confirm();
        Assertions.assertTrue(
                driver
                        .findElement(By.xpath(".//div[@class=\"user__feedback\"]"))
                        .getText()
                        .equals("Пользователь не найден, пожалуйста, попробуйте еще раз")
        );
    }
}
