package org.example.HW_6;


import hw_6.Authorization_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Abstract_test {
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
    Authorization_page authorization_page = new Authorization_page(getDriver());
    authorization_page
            .add_login()
            .add_password()
            .click_on_auth_button();
    getDriver()
            .switchTo()
            .frame(0);
}

    @AfterEach
    void exit(){
       Authorization_page authorization_page = new Authorization_page(getDriver());
       authorization_page
               .exit();
    }

    @AfterAll
    static void end_session(){
       driver.quit();
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
