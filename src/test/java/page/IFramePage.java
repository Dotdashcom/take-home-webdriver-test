package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramePage extends PageObject {
    private WebElement editor = null;

    public IFramePage(WebDriver driver) {
        super(driver);
        driver.switchTo().frame(frameId);
        editor = driver.findElement(By.id(editorId));
    }

    String frameId = "mce_0_ifr";
    String editorId = "tinymce";

    public void inputEditor(String input) {
        editor.sendKeys(input);
    }

    public void clearEditor() {
        editor.clear();
    }

    public String getEditorText() {
        return editor.getText();
    }
}
