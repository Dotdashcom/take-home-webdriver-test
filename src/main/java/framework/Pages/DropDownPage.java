package framework.Pages;

import gherkin.lexer.Pa;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropDownPage {

    WebDriver driver;


    public DropDownPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "dropdown")
    WebElement dropdownField;


    public void selectFromDropdown(String visibleText){
        Select dropdown = new Select(dropdownField);
        try {
            dropdown.selectByVisibleText(visibleText);
            Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),visibleText);
        } catch (NoSuchElementException e) {
            Assert.fail("No element with " + visibleText);
        }

    }

}
