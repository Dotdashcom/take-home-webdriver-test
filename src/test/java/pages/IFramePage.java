package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends BasePage {

    @FindBy(id = "mce_0_ifr")
    public WebElement targetFrame;

    @FindBy(id = "tinymce")
    public WebElement inputArea;


}
