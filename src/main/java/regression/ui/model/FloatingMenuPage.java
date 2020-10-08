package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public final class FloatingMenuPage extends WebObject {
    public FloatingMenuPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static FloatingMenuPage navigateToFloatingMenuPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/floating_menu", baseUrl);
        driver.get(url);
        return new FloatingMenuPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public String getMenuPosition(){
        return driver.findElement(By.xpath(this.xpathForMenu())).getAttribute("style");
    }

    public void scrollToEndOfPage(){
        driver.findElement(By.xpath(this.xpathForPageBody())).sendKeys(Keys.CONTROL, Keys.END);
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForMenu() {
        return "//*[@id=\"menu\"]";
    }

    private String xpathForPageBody() {
        return "//body";
    }
}
