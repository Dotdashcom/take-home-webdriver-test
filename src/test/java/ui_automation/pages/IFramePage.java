package ui_automation.pages;

import io.cucumber.java.bs.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class IFramePage extends BasePage{


    public IFramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement editor;

    @FindBy(xpath = "//div[@class='tox-icon']//..")
    public WebElement crossBtn;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    public WebElement realmsg;



}
