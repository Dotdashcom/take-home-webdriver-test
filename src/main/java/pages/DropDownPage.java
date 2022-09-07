package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tests.TestBase;

public class DropDownPage extends TestBase {
    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement selectOption;

    public DropDownPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public String selectOption1() {
        Select option = new Select(selectOption);
        option.selectByVisibleText("Option 1");
        String option1 = option.getFirstSelectedOption().getText();
        return option1;
    }

    public String selectOption2() {
        Select option = new Select(selectOption);
        option.selectByVisibleText("Option 2");
        String option2 = option.getFirstSelectedOption().getText();
        return option2;
    }

}
