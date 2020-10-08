package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class MouseHoverPage extends WebObject {
    public MouseHoverPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static MouseHoverPage navigateToMouseHoverPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/hovers", baseUrl);
        driver.get(url);
        return new MouseHoverPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public void mouseOverImage1() throws Exception {
        WebElement image1 = driver.findElement(By.xpath(this.xpathForImage(1)));
        this.mouseOverElement(image1);
        this.waitForElementVisibility(By.xpath(this.xpathForImage(1)));
    }

    public void mouseOverImage2() throws Exception {
        WebElement image1 = driver.findElement(By.xpath(this.xpathForImage(2)));
        this.mouseOverElement(image1);
        this.waitForElementVisibility(By.xpath(this.xpathForImage(2)));
    }

    public void mouseOverImage3() throws Exception {
        WebElement image1 = driver.findElement(By.xpath(this.xpathForImage(3)));
        this.mouseOverElement(image1);
        this.waitForElementVisibility(By.xpath(this.xpathForImage(3)));
    }

    public boolean isInfoDisplayedForImage(int number){
        return driver.findElement(By.xpath(this.xpathForImageCaption(number))).isDisplayed();
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForImage(int number){
        return String.format("(//*[@id=\"content\"]//img)[%s]",number);
    }

    private String xpathForImageCaption(int number){
        return String.format("(//*[@id=\"content\"]//img)[%s]/following::div[1]",number);
    }
}
