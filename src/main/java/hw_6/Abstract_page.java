package hw_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

public class Abstract_page {
    private WebDriver driver;

    public Abstract_page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    protected WebDriver getDriver(){
        return this.driver;
    }
}
