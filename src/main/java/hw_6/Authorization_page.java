package hw_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Authorization_page extends Abstract_page{
@FindBy(xpath = ".//*[@id=\"tl_login\"]")
    private WebElement login_field;

@FindBy(xpath = "\".//*[@id=\\\"tl_password\\\"]\"")
    private WebElement password_field;

@FindBy(xpath = ".//*[@id=\"tl_login_button\"]")
    private WebElement authorization_button;

@FindBy(xpath = ".//*[@accesskey=\"q\"]")
    private WebElement exit_button;

    public Authorization_page(WebDriver driver){
        super(driver);
    }
    public Authorization_page add_login(){
    login_field.click();
    //login_field.sendKeys("Test_Dude");
    return this;
    }

    public Authorization_page add_password(){
        password_field.click();
        //password_field.sendKeys("ARRB6XGri4us7j!");
        return this;
    }
    public Authorization_page click_on_auth_button(){
        authorization_button.click();
        return this;
    }
    public Authorization_page exit(){
        exit_button.click();
        return this;
    }
}
