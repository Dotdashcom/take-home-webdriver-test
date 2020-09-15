package webdrivertestpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownList{
    WebDriver driver;

    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement dropDownElement;

    public DropDownList(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String dropDownList(){
        Select sc = new Select(dropDownElement);
        sc.selectByVisibleText("Option 1");
        WebElement element = sc.getFirstSelectedOption();
        String text = element.getText();
        return text;

    }
}
