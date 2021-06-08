package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPageObject extends BasePageObject {
    @FindBy(css = "form input:nth-of-type(1)")
    private WebElement box1;
    @FindBy(css = "form input:nth-of-type(2)")
    private WebElement box2;

    public CheckBoxPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getBox1() {
        return box1;
    }

    public WebElement getBox2() {
        return box2;
    }

    public CheckBoxPageObject clickBox1() {
        this.getBox1().click();
        return this;
    }

    public CheckBoxPageObject clickBox2() {
        this.getBox2().click();
        return this;
    }

    public boolean isBox1Selected() {
        return this.getBox1().isSelected();
    }

    public boolean isBox2Selected() {
        return this.getBox2().isSelected();
    }
}
