package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoading extends BasePage {
    @FindBy(xpath = "//button[contains(text(), 'Start')]")
    public WebElement startButton;
    @FindBy(xpath = "//h4[contains(text(), 'Hello World!')]")
    public WebElement helloWorld;
}
