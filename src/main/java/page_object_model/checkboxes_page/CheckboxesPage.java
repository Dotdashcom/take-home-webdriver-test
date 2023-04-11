package page_object_model.checkboxes_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage extends Base {


    public CheckboxesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public static WebElement checkboxes1;
    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public static WebElement checkboxes2;

    public void clickCheckBoxesOne() {
        clickOnElement(checkboxes1);
    }

    public void clickCheckBoxesTwo() {
        clickOnElement(checkboxes2);
    }

}
