package faridun.Pages;

import faridun.utils.Base;
import faridun.utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OtherPages extends Base {


    @FindBy(xpath = "//*[text()='Checkboxes']")
    public WebElement checkBoxLink;

    public void goToCheckBox() {
        click(checkBoxLink);
    }


    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement checkBox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElement checkBox2;

    public void clickCheckBox(WebElement element) {
        clickCheckbox(element);
    }


    @FindBy(xpath = "//*[text()='Context Menu']")
    public WebElement contextMenuLink;

    @FindBy(xpath = "//div[@id='hot-spot']")
    public WebElement hotSpot;

    public void goContextMenu() {
        click(contextMenuLink);
    }

    public void contextclick() {
        rightClick(hotSpot);
    }

    public void handleAlertAndVerify(String msg) {
        verifyPopup(msg);
    }


    @FindBy(xpath = "//*[text()='Drag and Drop']")
    public WebElement dragAndDropLink;

    @FindBy(xpath = "//div[@id='column-a']")
    public WebElement dragElement;

    @FindBy(xpath = "//div[@id='column-b']")
    public WebElement dropElement;

    public void goDragAndDrop() {
        click(dragAndDropLink);
    }

    public void dragAndDrop(WebElement drag, WebElement drop) {
        Actions actions = new Actions(TestBase.driver);
        actions.dragAndDrop(drag, drop).perform();
    }

    @FindBy(xpath = "//*[text()='Dropdown']")
    public WebElement dropDownLink;

    @FindBy(id = "dropdown")
    public WebElement dropDown;

    public void goDropDownn() {
        click(dropDownLink);
    }

    public String selectDdValue(WebElement element, String textToSelect) {

        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        String value = null;
        for (WebElement el : options) {
            value = el.getText();
            if (el.getText().equals(textToSelect)) {
                select.selectByVisibleText(textToSelect);
                break;
            }

        }
        return value;
    }


    @FindBy(xpath = "//*[text()='Dynamic Content']")
    public WebElement dynamicContentLink;

    public void goDynamicContentLink() {
        click(dynamicContentLink);
    }


}
