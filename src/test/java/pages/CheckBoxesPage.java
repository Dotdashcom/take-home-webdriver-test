package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBoxesPage extends BasePage {

    private By checkBox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    private By checkBox2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

    public CheckBoxesPage(WebDriver driver){
        super(driver);
    }

    public void resetCheckBoxes() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkBox1));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkBox2));

        if(isCheckBox1Selected())
            getElement(checkBox1).click();

        if(isCheckBox2Selected())
            getElement(checkBox2).click();
    }

    public void clickCheckBox1() {
        getElement(checkBox1).click();
    }

    public void clickCheckBox2() {
        getElement(checkBox2).click();
    }

    public boolean isCheckBox1Selected() {
        return getElement(checkBox1).isSelected();
    }

    public boolean isCheckBox2Selected() {
        return getElement(checkBox2).isSelected();
    }

}
