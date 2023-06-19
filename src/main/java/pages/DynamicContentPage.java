package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {

    private WebDriver driver;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='click here']")
    private WebElement clickHereLink;

    @FindBy(xpath = "//div[@id='content']/div[1]/div[@class='large-10 columns']")
    private WebElement columnOneField;

    @FindBy(xpath = "//div[@id='content']/div[2]/div[@class='large-10 columns']")
    private WebElement columnTwoField;

    @FindBy(xpath = "//div[@id='content']/div[3]/div[@class='large-10 columns']")
    private WebElement columnThreeField;

    public void clickOnClickHere(){
        clickHereLink.click();
    }

    public String getColumnOneFieldText(){
        return columnOneField.getText();
    }

    public String getColumnTwoFieldText(){
        return columnTwoField.getText();
    }

    public String getColumnThreeFieldText(){
        return columnThreeField.getText();
    }

}
