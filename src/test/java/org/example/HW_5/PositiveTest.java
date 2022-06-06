package org.example.HW_5;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PositiveTest extends AbstractTest {
    @Test
    void create_new_API_key(){
        WebElement webElement1 = getDriver().findElement(By.xpath(".//*[@accesskey=\"i\"]"));
        webElement1.click();
        getDriver()
                .switchTo()
                .parentFrame();
        getDriver()
                .switchTo()
                .frame(1);
        WebElement webElement2 = getDriver().findElement(By.cssSelector("form:nth-child(1) > .groupBtn > input"));
        webElement2.click();
        getDriver()
                .switchTo()
                .parentFrame();
        getDriver()
                .switchTo()
                .frame(0);
    }
    @Test
    void create_new_step() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath(".//*[@accesskey=\"t\"]"));
        webElement1.click();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(1)
                .switchTo()
                .frame(0);
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".x-tree-ec-icon"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.id("extdd-13"));
        Actions builder = new Actions(getDriver());
        builder
                .doubleClick(webElement3)
                .build()
                .perform();
        WebElement webElement4 = getDriver().findElement(By.xpath("//*[@id=\"extdd-1006\"]"));
        webElement4.click();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(1);
        WebElement webElement5 = getDriver().findElement(By.xpath(".//div[4]/input"));
        webElement5.click();
        Thread.sleep(3000);
        getDriver()
                .switchTo()
                .frame(0);
        WebElement webElement6 = getDriver().findElement(By.cssSelector(".cke_editable"));
        webElement6.click();
        webElement6.sendKeys("Привет");
        getDriver()
                .switchTo()
                .parentFrame();
        WebElement webElement7 = getDriver().findElement(By.xpath("//div[5]/div/input[2]"));
        webElement7.click();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(0);
        WebElement webElement8 = getDriver().findElement(By.cssSelector(".x-tree-elbow-minus"));
        webElement8.click();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(0);
    }
    @Test
    void create_new_step_and_finish_him() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath(".//*[@accesskey=\"t\"]"));
        webElement1.click();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(1)
                .switchTo()
                .frame(0);
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".x-tree-ec-icon"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.id("extdd-13"));
        Actions builder = new Actions(getDriver());
        builder
                .doubleClick(webElement3)
                .build()
                .perform();
        WebElement webElement4 = getDriver().findElement(By.xpath("//*[@id=\"extdd-1006\"]"));
        webElement4.click();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(1);
        WebElement webElement5 = getDriver().findElement(By.xpath(".//div[4]/input"));
        webElement5.click();
        Thread.sleep(3000);
        getDriver()
                .switchTo()
                .frame(0);
        WebElement webElement6 = getDriver().findElement(By.cssSelector(".cke_editable"));
        webElement6.click();
        webElement6.sendKeys("Привет");
        getDriver()
                .switchTo()
                .parentFrame();
        WebElement webElement7 = getDriver().findElement(By.xpath("//div[5]/div/input[2]"));
        webElement7.click();
        WebElement webElement8 = getDriver().findElement(By.xpath("(//img[@alt='Удалить шаг'])[19]"));
        webElement8.click();
        WebElement webElement9 = getDriver().findElement(By.cssSelector("#ext-comp-1002 .x-btn-mc"));
        webElement9.click();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(0);
        WebElement webElement10 = getDriver().findElement(By.cssSelector(".x-tree-elbow-minus"));
        webElement10.click();
        WebElement webElement11 = getDriver().findElement(By.cssSelector(".x-tree-elbow-end-minus"));
        webElement11.click();
        getDriver()
                .switchTo()
                .parentFrame()
                .switchTo()
                .parentFrame()
                .switchTo()
                .frame(0);
    }
}
