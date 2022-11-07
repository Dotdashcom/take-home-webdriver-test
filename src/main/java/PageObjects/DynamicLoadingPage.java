package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
    public WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Example 1: Element on page that is hidden']")
    private WebElement buttonHidden;
    @FindBy(xpath = "//a[.='Example 2: Element rendered after the fact']")
    private WebElement buttonRendered;

    @FindBy(xpath = "//button[.='Start']")
    private WebElement start;

    @FindBy(xpath = "//div[@id='finish']/h4")
    private WebElement title;



    public void clickButtonStart(){
        Helpers.ClickElement(start);
    }

    public void clickButtonHidden(){
        Helpers.ClickElement(buttonHidden);
    }

    public void clickButtonRendered(){
        Helpers.ClickElement(buttonRendered);
    }
    public boolean validateTitleValue(String text) throws InterruptedException {
        Helpers.WaitForElement(title);
        return title.getText().contains(text);
    }



}
