package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class IframePage extends WebObject {
    public IframePage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static IframePage navigateToIframePage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/iframe", baseUrl);
        driver.get(url);
        return new IframePage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public void switchToIframe() {
        driver.switchTo().frame(this.idForIframe());
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }

    public void editIframeText(String text){
    WebElement textBox =  driver.findElement(By.xpath(this.xpathForIframeTextBox()));
    textBox.clear();
    textBox.sendKeys(text);
    }

    public String getIframeText(){
        return driver.findElement(By.xpath(this.xpathForIframeTextBox())).getText();
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String idForIframe() {
        return "mce_0_ifr";
    }

    private String xpathForIframeTextBox() {
        return "//*[@id=\"tinymce\"]";
    }
}
