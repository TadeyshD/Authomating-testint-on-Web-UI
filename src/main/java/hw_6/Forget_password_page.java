package hw_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Forget_password_page extends Abstract_page{
    @FindBy(id =("tl_lost_password"))
    private WebElement lost_password;

    @FindBy (id = ("login"))
    private WebElement new_login_invalid;

    @FindBy (xpath = (".//input[@name='editUser']"))
    private WebElement confirm;

    public Forget_password_page lost_password(){
        lost_password.click();
        return this;
    }

    public Forget_password_page new_login(){
        new_login_invalid.click();
        new_login_invalid.sendKeys("1432432154541");
        return this;
    }

public Forget_password_page confirm(){
        confirm.click();
        return this;
}

    public Forget_password_page(WebDriver driver) {
        super(driver);
    }


}
