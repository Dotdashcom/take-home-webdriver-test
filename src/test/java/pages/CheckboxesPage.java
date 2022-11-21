package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckboxesPage extends BasePage {

    WebDriver driver;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='Checkboxes']")
    private WebElement title;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkBoxes;

    public void checkAndUncheckCheckboxes() {

        for (WebElement checkbox : checkBoxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
                Assert.assertFalse(checkbox.isSelected());
                checkbox.click();
                Assert.assertTrue(checkbox.isSelected());
            } else {
                checkbox.click();
                Assert.assertTrue(checkbox.isSelected());
                checkbox.click();
                Assert.assertFalse(checkbox.isSelected());
            }
        }
    }

    public void assertCheckBoxPageIsDisplayed(){
        Assert.assertTrue(elementIsDisplayed(title));
    }
}
