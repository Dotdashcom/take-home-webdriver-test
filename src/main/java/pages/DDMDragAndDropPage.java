package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DDMDragAndDropPage extends DDMBasePage  {
    @FindBy(css = "[id='column-a']")
    protected WebElement placeA;
    @FindBy(css = "[id='column-b']")
    protected WebElement placeB;

    public DDMDragAndDropPage(WebDriver driver)  {
        super(driver);
    }

    public void performDragAndDrop()  {
        Actions mouseActions = new Actions(driver);
        mouseActions.dragAndDropBy(placeA, placeB.getLocation().x, placeB.getLocation().y).build().perform();
    }

    public String placeAText()  {
        return placeA.getText();
    }

    public String placeBText()  {
        return placeB.getText();
    }
}