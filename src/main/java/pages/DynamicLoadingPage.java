package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {

    private WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Start']")
    private WebElement startButton;

    @FindBy(xpath = "//div[@id='finish']/h4")
    private WebElement finishField;

    @FindBy(xpath = "//div[@id='loading']")
    private WebElement loadingField;

    @FindBy(linkText ="Example 2: Element rendered after the fact")
    private WebElement loginLink;

    public String getFinishText(){
        loginLink.click();
        startButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(finishField));
        return finishField.getText();
    }
}
