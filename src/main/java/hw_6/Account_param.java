package hw_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_param extends Abstract_page{
    @FindBy(xpath = (".//*[@accesskey=\"i\"]"))
        private WebElement param;

    @FindBy(css = ("form:nth-child(1) > .groupBtn > input"))
        private WebElement new_key_button;

    public Account_param(WebDriver driver) {
        super(driver);
    }

    public Account_param go_to_param(){
        param.click();
        return this;
    }
    public Account_param create_new_key_button(){
        new_key_button.click();
        return this;
    }
}
