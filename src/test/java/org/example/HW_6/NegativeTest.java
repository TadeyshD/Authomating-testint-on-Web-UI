package org.example.HW_6;

import hw_6.Add_new_user_page;
import hw_6.Authorization_page;
import hw_6.Forget_password_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class NegativeTest {
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
    void Forget_you_password_invalid(){
        Forget_password_page forget_password_page = new Forget_password_page(driver);
        forget_password_page
                .lost_password()
                .new_login()
                .confirm();
        Assertions.assertTrue(
                driver
                        .findElement(By.xpath("/html/body/div/div[2]/div"))
                        .getText()
                        .equals("Пользователь не найден, пожалуйста, попробуйте еще раз")
        );
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
    void invalid_registration(){
        Add_new_user_page add_new_user_page = new Add_new_user_page(driver);
        add_new_user_page
                .add_new_user()
                .enter_login()
                .enter_invalid_password()
                .repeat_password()
                .enter_first_name()
                .enter_last_name()
                .enter_email()
                .add_user_button();
        Assertions.assertTrue(
                driver
                        .findElement(By.cssSelector("body > div > div:nth-child(2)"))
                        .getText()
                        .equals("Ваш пароль не может быть пустым!")
        );
        driver.navigate().to("http://testlink.testbase.ru/login.php");
    }

    @AfterAll
    static void end_session(){
        driver.quit();
    }
}
