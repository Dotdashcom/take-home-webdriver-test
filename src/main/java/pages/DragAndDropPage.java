package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {

    private WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='columns']//div[@id='column-a']")
    private WebElement fieldA;

    @FindBy(xpath = "//div[@id='columns']//div[@id='column-b']")
    private WebElement fieldB;

    public void dragAndDrop(){
        Actions actions= new Actions(driver);
        actions.dragAndDrop(fieldA,fieldB).perform();
    }

    public String getTextFromFieldB(){
        String fieldBText=fieldB.getText();
        return fieldBText;
    }
}
