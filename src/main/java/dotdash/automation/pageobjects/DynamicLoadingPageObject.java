package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPageObject extends BasePageObject {
    @FindBy(css = "div[id='start'] button")
    private WebElement start;
    @FindBy(id = "finish")
   private WebElement hello;

    public DynamicLoadingPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public DynamicLoadingPageObject clickStart() {
        start.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        return this;
    }

    public boolean isHelloDisplayed() {
        return hello.isDisplayed();
    }
}
