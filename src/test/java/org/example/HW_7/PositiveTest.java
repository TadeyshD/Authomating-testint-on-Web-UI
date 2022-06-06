package org.example.HW_7;


import hw_6.Account_param;
import hw_6.Tests_page;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PositiveTest extends AbstractTest {
    @Test
    @DisplayName("Создание нового API ключа")
    @Link("http://testlink.testbase.ru")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создаём новый API ключ для авторизированного пользователя")
    void create_new_API_key(){
        Account_param account_param = new Account_param(getDriver());
        account_param.go_to_param();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(1);
        account_param.create_new_key_button();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(0);
    }
    @Test
    @DisplayName("Создание нового шага тест-кейса")
    @Link("http://testlink.testbase.ru")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Создаём новый шаг в существующем тест-кейсе, после чего удаляем его. " +
            "Примечание: в силе специфики сайта, тест постоянно слетает. " +
            "У всех шагов каждого тест-кейса примерно раз в сутки меняется ID.")
    void create_new_step_and_finish_him() throws InterruptedException {
        Tests_page tests_page = new Tests_page(getDriver());
        tests_page
                .to_test_page();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(1)
                .switchTo()
                .frame(0);
        tests_page
                .open_three()
                .chose_test()
                .open_test();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(1);
        tests_page
                .create_new();
        Thread.sleep(3000);
        getDriver().switchTo().frame(0);
        tests_page
                .text_field();
        getDriver()
                .switchTo()
                .parentFrame();
        tests_page
                .save_step()
                .delete()
                .confirm_delete();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(0);
        tests_page
                .close_three();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(0);
    }
}
