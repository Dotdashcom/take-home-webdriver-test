package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage {

    @FindBy (xpath = "(//button[@type='button'])[1]")
    public WebElement removeBtn;

    @FindBy (xpath = "//button[.='Add']")
    public WebElement addBtn;

    @FindBy (id = "message")
    public WebElement addMessage;
    @FindBy (id = "checkbox")
    public WebElement checkbox;

    @FindBy (xpath = "(//button[@type='button'])[2]")
    public WebElement enableBtn;

    @FindBy (xpath = "//button[.='Disable']")
    public WebElement disableBtn;

    @FindBy (id = "loading")
    public WebElement loadingBar2;

    @FindBy (id = "message")
    public WebElement removeConfirmation;



}
