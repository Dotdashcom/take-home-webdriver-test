package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPageObject extends BasePageObject {
    @FindBy(id = "dropdown")
    private WebElement selectElement;
    @FindBy(css = "select option[value='1']")
    private WebElement option1;
    @FindBy(css = "select option[value='2']")
    private WebElement option2;
    private Select select;

    public DropDownPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.select = new Select(selectElement);
    }

    public String selectDropDown1() {
        select.selectByVisibleText(option1Text());
        return select.getFirstSelectedOption().getText();
    }

    public String selectDropDown2() {
        select.selectByVisibleText(option2Text());
        return select.getFirstSelectedOption().getText();
    }

    public String option1Text() {
        return option1.getText();
    }

    public String option2Text() {
        return option2.getText();
    }
}
