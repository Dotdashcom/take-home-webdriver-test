import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragDropPage extends PageObject
{
    //Elements
    @FindBy(id = "column-a")
    public WebElement ElementA;

    @FindBy(id = "column-b")
    public WebElement ElementB;

    public DragDropPage(WebDriver driver) {
        super(driver);
    }

    public void DragandDrop()
    {
        Actions action = new Actions(driver);
        action.dragAndDrop(ElementB, ElementA ).build().perform();

        String ElementA_value = ElementA.getText();
        String ElementB_value = ElementB.getText();

        Assert.assertEquals(ElementA_value,"A");
        Assert.assertEquals(ElementB_value,"B");

    }
}
