package org.example.HW_6;


import hw_6.Account_param;
import hw_6.Tests_page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Positive_tests extends Abstract_test {
    @Test
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
