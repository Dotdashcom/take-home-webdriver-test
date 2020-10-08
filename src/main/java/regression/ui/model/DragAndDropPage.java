package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class DragAndDropPage extends WebObject {
    public DragAndDropPage(WebDriver driver) throws Exception {
        super(driver);
        // Waits for page to load
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static DragAndDropPage navigateToDragAndDropPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/drag_and_drop", baseUrl);
        driver.get(url);
        return new DragAndDropPage(driver);
    }

    public String getTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public String getBoxALetter() {
        return driver.findElement(By.xpath(this.xpathForBoxLetter(this.xpathForBoxA()))).getText();
    }

    public String getBoxBLetter() {
        return driver.findElement(By.xpath(this.xpathForBoxLetter(this.xpathForBoxB()))).getText();
    }

    public void dragAndDropBoxAtoBoxB() {
        WebElement boxA = driver.findElement(By.xpath(this.xpathForBoxA()));
        WebElement boxB = driver.findElement(By.xpath(this.xpathForBoxB()));
        this.dragAndDrop(boxA, boxB);
    }

    public void dragAndDropBoxBtoBoxA() {
        WebElement boxA = driver.findElement(By.xpath(this.xpathForBoxA()));
        WebElement boxB = driver.findElement(By.xpath(this.xpathForBoxB()));
        this.dragAndDrop(boxB, boxA);
    }

    private String xpathForBoxA() {
        return "//*[@id=\"column-a\"]";
    }

    private String xpathForBoxB() {
        return "//*[@id=\"column-b\"]";
    }

    private String xpathForBoxLetter(String xpathForBox) {
        return String.format("%s/header", xpathForBox);
    }

    private String xpathForPageTitle() {
        return "//h3";
    }
}
