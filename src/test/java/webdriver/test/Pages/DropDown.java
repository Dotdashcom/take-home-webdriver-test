package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

public class DropDown {

    //local webdriver variable
    private WebDriver driver;



    @FindBy(id="dropdown")
    public WebElement selectDropDownBox;



    //Page Class Constructor
    public DropDown(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);
    }

    public void setSelectDropDownBoxOption(String text) {
        Select select = new Select(selectDropDownBox);
        select.selectByVisibleText(text);
    }

    public String getSelectedValueText() {
        Select select = new Select(selectDropDownBox);
        return select.getFirstSelectedOption().getText();

    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/dropdown");
    }
}
