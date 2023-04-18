package pages;
import org.openqa.selenium.WebDriver;

public class ContextMenuPage {

    private WebDriver driver;

    public static final String url = "/context_menu";

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }
}
