package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragAndDropPage extends Page {
    private static final String COLUMN = "//div[@id='column-%s']";
    private static final String HEADER = "(//div[@id='columns']/div)[%s]/header";

    public DragAndDropPage(ChromeDriver driver) {
        super(driver);
    }

    public void dragColumnToColumn(String column1, String column2) {
        WebElement draggable = elementToBeClickable(By.xpath(String.format(COLUMN, column1)), BasePage.TIMEOUT);
        WebElement droppable = elementToBeClickable(By.xpath(String.format(COLUMN, column2)), BasePage.TIMEOUT);

        jsDragAndDrop(draggable, droppable);
    }

    public String getColumnHeaderText(int column) {
        return visibilityOfElementLocated(By.xpath(String.format(HEADER, column)), BasePage.TIMEOUT).getText();
    }
}
