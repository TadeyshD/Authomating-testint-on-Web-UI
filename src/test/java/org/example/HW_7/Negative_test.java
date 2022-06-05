package org.example.HW_7;

import hw_6.Add_new_user_page;
import hw_6.Authorization_page;
import hw_6.Forget_password_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Negative_test {
    private static EventFiringWebDriver eventDriver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        // options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));

        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));

        eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    void initMainPage() {
        Assertions.assertDoesNotThrow(() -> eventDriver.navigate().to("http://testlink.testbase.ru/login.php"),
                "Страница не доступна");
        Assertions.assertTrue(true);
    }


    @Test
    @DisplayName("Пользователь забыл пароль")
    @Link("http://testlink.testbase.ru")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь забыл пароль и пытается восстановить аккаунт, вводя неверные данные.")
    void Forget_you_password_invalid() {
        Forget_password_page forget_password_page = new Forget_password_page(eventDriver);
        forget_password_page
                .lost_password()
                .new_login()
                .confirm();
        Assertions.assertTrue(
                eventDriver
                        .findElement(By.xpath("/html/body/div/div[2]/div"))
                        .getText()
                        .equals("Пользователь не найден, пожалуйста, попробуйте еще раз")
        );
    }

    @Test
    @DisplayName("Авторизация с неверным логином")
    @Link("http://testlink.testbase.ru")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Пользователь пытается автрозироваться, вводя неверный логин.")
    void Invalid_authorization_with_invalid_login()
    {
        Authorization_page authorization_page = new Authorization_page(eventDriver);
        authorization_page
                .add_invalid_login()
                .add_password()
                .click_on_auth_button();
        Assertions.assertTrue(
                eventDriver
                        .findElement(By.xpath(".//div[@class=\"user__feedback\"]"))
                        .getText()
                        .equals("Попробуйте снова! Вы ввели неверное имя или пароль!")
        );
    }

    @Test
    @DisplayName("Авторизация с неверным логином")
    @Link("http://testlink.testbase.ru")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Пользователь пытается автрозироваться, вводя неверный пароль.")
    void Invalid_authorization_with_invalid_password() {
        Authorization_page authorization_page = new Authorization_page(eventDriver);
        authorization_page
                .add_login()
                .add_invalid_password()
                .click_on_auth_button();
        Assertions.assertTrue(
                eventDriver
                        .findElement(By.xpath(".//div[@class=\"user__feedback\"]"))
                        .getText()
                        .equals("Попробуйте снова! Вы ввели неверное имя или пароль!")
        );
    }

    @Test
    @DisplayName("Регистрация с неверным паролем")
    @Link("http://testlink.testbase.ru")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Пользователь пытается зарегистрироваться на сайте, используя невалидный пароль.")
    void invalid_registration() {
        Add_new_user_page add_new_user_page = new Add_new_user_page(eventDriver);
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
                eventDriver
                        .findElement(By.cssSelector("body > div > div:nth-child(2)"))
                        .getText()
                        .equals("Ваш пароль не может быть пустым!")
        );
        eventDriver.navigate().to("http://testlink.testbase.ru/login.php");
    }

    @AfterAll
    public static void end_session() {

        if (eventDriver != null) eventDriver.quit();
    }
}