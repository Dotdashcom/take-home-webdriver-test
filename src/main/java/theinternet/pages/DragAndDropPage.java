package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(){
        PageFactory.initElements(driver, this);
    }
    Actions actions = new Actions(driver);
    @FindBy(xpath = "//h3[contains(.,'Drag and Drop')]")
    public WebElement dragAndDropPageHeader;
    @FindBy(id = "column-a")
    public WebElement box1;
    @FindBy(id = "column-b")
    public WebElement box2;
    public boolean validatePageLanding() {
        dragAndDropPageHeader.isDisplayed();
        box1.isDisplayed();
        box2.isDisplayed();
        return true;
    }

    public String getBox1Text() {

        return box1.getText();
    }

    public String getBox2Text() {

        return box2.getText();
    }

    public void dragBox1toBox2() throws InterruptedException {
        actions.dragAndDrop(box1, box2).build().perform();
        Thread.sleep(2000);
    }
}
