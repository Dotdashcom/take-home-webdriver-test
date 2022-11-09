package pages;

import org.openqa.selenium.By;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

public class ContextMenuPage {

    private final By header = By.xpath("//h3[text()='Context Menu']");
    private static final By contextBox = By.id("hot-spot");

    public ContextMenuPage navigatetoContextmenupage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/context_menu");
        return this;
    }

    public boolean contextMenuHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public static String VerifyContextMenu() {
        return UtilitiesManager.ContextMenuClick(contextBox);
    }

}
