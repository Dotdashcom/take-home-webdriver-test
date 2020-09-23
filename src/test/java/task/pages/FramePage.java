package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {

    @FindBy (xpath = "//body//p")
    public WebElement iconForTextinFrame;

}
