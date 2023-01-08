package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import model.base.BasePage;

import java.util.List;

public class CheckboxesPage extends BasePage {

    private static final String CHECKBOXES_ENDPOINT = "checkboxes";

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxesList;

    @FindBy(xpath = "//input[@type='checkbox' and @checked = '']")
    private List<WebElement> selectedCheckboxesList;

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    private WebElement checkboxOne;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    private WebElement checkboxTwo;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public CheckboxesPage getCheckboxesPage() {
        getDriver(CHECKBOXES_ENDPOINT);

        return this;
    }

    public CheckboxesPage clickCheckboxOne() {
        checkboxOne.click();

        return this;
    }

    public CheckboxesPage clickCheckboxTwo() {
        checkboxTwo.click();

        return this;
    }

    public boolean isCheckboxOneSelected() {

        return checkboxOne.isSelected();
    }

    public boolean isCheckboxTwoSelected() {

        return checkboxTwo.isSelected();
    }

    public int getSelectedCheckboxListSize() {

        return selectedCheckboxesList.size();
    }
}