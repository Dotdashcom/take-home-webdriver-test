package task.pages;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.tests.CheckBoxes;
import task.utilities.Driver;

import java.util.List;

public class CheckBoxesPage {



    @FindBy(css = "input[type='checkbox']:nth-of-type(1)")
    public WebElement checkBox1;

    @FindBy(css = "input[type='checkbox']:nth-of-type(2)")
    public WebElement checkBox2;


    public CheckBoxesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    public void clickCheckBox1() {
        checkBox1.click();
    }

    public void clickCheckBox2() {
        checkBox2.click();
    }

    public boolean isCheckBox1Selected() {
        return checkBox1.isSelected();
    }

    public boolean isCheckBox2Selected() {
        return checkBox2.isSelected();
    }
}
