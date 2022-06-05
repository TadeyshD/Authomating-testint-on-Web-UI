package hw_6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_new_user_page extends Abstract_page {
    @FindBy (id = ("tl_sign_up"))
    private WebElement add_new_user;

    @FindBy(id = ("login"))
    private WebElement enter_login;

    @FindBy(id = ("password"))
    private WebElement enter_invalid_password;

    @FindBy(id = ("password2"))
    private WebElement repeat_password;

    @FindBy(id = ("firstName"))
    private WebElement enter_first_name;

    @FindBy(id = ("lastName"))
    private WebElement enter_last_name;

    @FindBy(id = ("email"))
    private WebElement enter_email;

    @FindBy(xpath = ("//*[@id=\"signup\"]/div[7]"))
    private WebElement add_user_button;

    public Add_new_user_page add_new_user(){
        add_new_user.click();
        return this;
    }

    public Add_new_user_page enter_login(){
        enter_login.click();
        enter_login.sendKeys("Anton_ZH");
        return this;
    }

    public Add_new_user_page enter_invalid_password(){
        enter_invalid_password.click();
        enter_invalid_password.sendKeys("  ");
        return this;
    }

    public Add_new_user_page repeat_password(){
        repeat_password.click();
        repeat_password.sendKeys("  ");
        return this;
    }

    public Add_new_user_page enter_first_name(){
        enter_first_name.click();
        enter_first_name.sendKeys("Anton");
        return this;
    }

    public Add_new_user_page enter_last_name(){
        enter_last_name.click();
        enter_last_name.sendKeys("Zhiznevskiy");
        return this;
    }

    public Add_new_user_page enter_email(){
        enter_email.click();
        enter_email.sendKeys("blabla@rambler.ru");
        return this;
    }

    public Add_new_user_page add_user_button(){
        add_user_button.click();
        return this;
    }

    public Add_new_user_page(WebDriver driver) {
        super(driver);
    }
}
