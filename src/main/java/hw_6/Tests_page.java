package hw_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Tests_page extends Abstract_page {
    @FindBy(xpath = (".//*[@accesskey=\"t\"]"))
    private WebElement go_to_test_page;

    @FindBy(css = (".x-tree-ec-icon"))
    private WebElement open_test_three;

    @FindBy(id = ("extdd-13"))
    private WebElement chose_test;

    @FindBy(id = ("extdd-949"))
    private WebElement open_test;

    @FindBy(xpath = (".//div[4]/input"))
    private WebElement create_new_step_button;

    @FindBy(css = (".cke_editable"))
    private WebElement enter_text_field;

    @FindBy(xpath = ("//div[5]/div/input[2]"))
    private WebElement do_update_step_and_exit;

    @FindBy (xpath = ("(//img[@alt='Удалить шаг'])[19]"))
    private WebElement delete_step;

    @FindBy (css = ("#ext-comp-1002 .x-btn-mc"))
    private WebElement confirm_delete;

    @FindBy(css = (".x-tree-elbow-minus"))
    private WebElement close_test_three;




    public Tests_page(WebDriver driver) {
        super(driver);
    }

    public Tests_page to_test_page(){
        go_to_test_page.click();
        return this;
    }
    public Tests_page open_three(){
        open_test_three.click();
        return this;
    }
    public Tests_page chose_test(){
        Actions builder = new Actions(getDriver());
        builder
                .doubleClick(chose_test)
                .build()
                .perform();
        return this;
    }
    public Tests_page open_test(){
        open_test.click();
        return this;
    }
    public Tests_page create_new(){
        create_new_step_button.click();
        return this;
    }
    public Tests_page text_field(){
        enter_text_field.click();
        enter_text_field.sendKeys("Привет");
        return this;
    }
    public Tests_page save_step(){
        do_update_step_and_exit.click();
        return this;
    }
    public Tests_page delete(){
        delete_step.click();
        return this;
    }
    public Tests_page confirm_delete(){
        confirm_delete.click();
        return this;
    }
    public Tests_page close_three(){
        close_test_three.click();
        return this;
    }
}
