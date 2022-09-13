package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class DynamicContentPage extends WebObject {
    public DynamicContentPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static DynamicContentPage navigateToDynamicContentPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/dynamic_content", baseUrl);
        driver.get(url);
        return new DynamicContentPage(driver);
    }

    public String getTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public DynamicContentPage clickLink(){
        WebElement link = driver.findElement(By.xpath(this.xpathForClickHereLink()));
        link.click();
        return this;
    }

    public String getDynamicContent1(){
        return getDynamicContent(1);
    }

    public String getDynamicContent2(){
        return getDynamicContent(2);
    }

    public String getDynamicContent3(){
        return getDynamicContent(3);
    }

    private String getDynamicContent(int number){
        return driver.findElement(By.xpath(this.xpathForDynamicContentOption(number))).getText();
    }

    public DynamicContentPage refreshPage(){
        this.refreshWebPage();
        return this;
    }

    private String xpathForClickHereLink() {

        return "//*[@href and text()= \"click here\"]";
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForDynamicContentOption(int number) {

        return String.format("(//*[@class=\"large-10 columns\"])[%s]", number);
    }

}
