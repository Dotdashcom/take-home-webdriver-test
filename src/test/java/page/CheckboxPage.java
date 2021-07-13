package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends PageObject {

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/form[1]/input[1]")
    private WebElement checkbox1;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/form[1]/input[2]")
    private WebElement checkbox2;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void performCheckbox1ButtonClick() {
        this.checkbox1.click();
    }

    public void performCheckbox2ButtonClick() {
        this.checkbox2.click();
    }

    public boolean Checkbox1ButtonCheck() {
        return this.checkbox1.isSelected();
    }

    public boolean Checkbox2ButtonCheck() {
        return this.checkbox2.isSelected();
    }
}
