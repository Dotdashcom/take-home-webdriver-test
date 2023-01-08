package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class DragandDrop {
    public WebDriver driver;



    public DragandDrop(WebDriver dr) {
        this.driver = dr;
        PageFactory.initElements(driver, this);
    }


    //    @FindBy(id = "column-a")
    @FindBy(xpath = "//div[@id='columns']/div[1]")
    WebElement aclm;

    //    @FindBy(id = "column-b")
    @FindBy(xpath = "//div[@id='columns']/div[2]")
    WebElement bclm;


    public WebElement Columna() {
        return aclm;
    }

    public WebElement Columnb() {
        return bclm;
    }


}
