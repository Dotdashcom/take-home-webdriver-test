package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;



public class DynamicControl {

    //local webdriver variable
    private WebDriver driver;

    @FindBy(xpath = "(//button)[1]")
    public WebElement removeAddButton;


    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement inputCheckBox;


    @FindBy(xpath = "(//button)[2]")
    public WebElement enableDisableButton;

    @FindBy(css = "#input-example input")
    public WebElement inputField;


    //Page Class Constructor
    public DynamicControl(WebDriver driver) {

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void clickRemoveButton() {

        removeAddButton.click();

    }

    public void clickAddButton() {


        removeAddButton.click();


    }

    public void clickEnableButton() {
        enableDisableButton.click();

    }

    public void clickDisableButton() {
        enableDisableButton.click();

    }


    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/dynamic_controls");
    }
}
