package Main.Package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage {
    private WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    private By box1 = By.xpath("//div[@id='column-a']");
    private By box2 = By.xpath("//div[@id='column-b']");

}
