package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

public class DragAndDropPage {

    private final By header = By.xpath("//h3[text()='Drag and Drop']");
    private final By box1 = By.id("column-a");
    private final By box2 = By.id("column-b");
    private final By box1text = By.xpath("//div[@id='column-a']/header");
    private final By box2text = By.xpath("//div[@id='column-b']/header");

    public DragAndDropPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/drag_and_drop");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public boolean VerifyDragAndDrop() throws InterruptedException {
        UtilitiesManager.ExpectedConditions(box1, "DISPLAYED");
        Actions act = new Actions(DriverManager.getDriver());
        String beforeBox = UtilitiesManager.FindElement(box1text).getText();
        Thread.sleep(5000);
        act.dragAndDrop(UtilitiesManager.FindElement(box1), UtilitiesManager.FindElement(box2)).build().perform();
        Thread.sleep(5000);
        String afterBox = UtilitiesManager.FindElement(box2text).getText();

        return beforeBox.equalsIgnoreCase(afterBox);
    }

}
