package hw_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tests_page extends Abstract_page {
    @FindBy(xpath = ("\".//*[@accesskey=\\\"t\\\"]\""))
    private WebElement go_to_test_page;

    @FindBy(css = (".x-tree-ec-icon"))
    private WebElement open_test_three;

    @FindBy(css = ("#extdd-13 > img.x-tree-ec-icon.x-tree-elbow-plus"))
    private WebElement chose_test;

    @FindBy(id = ("extdd-945"))
    private WebElement open_test;

    @FindBy(xpath = (".//div[4]/input"))
    private WebElement create_new_step_button;




    public Tests_page(WebDriver driver) {
        super(driver);
    }
}
