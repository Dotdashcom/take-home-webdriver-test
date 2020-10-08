package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class FileUploadPage extends WebObject {
    public FileUploadPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static FileUploadPage navigateToFileUploadPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/upload", baseUrl);
        driver.get(url);
        return new FileUploadPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public void addFilePathForUpload(String filePath) {
        WebElement upload = driver.findElement(By.xpath(this.xpathForUploadField()));
        upload.sendKeys(filePath);
        driver.findElement(By.xpath(this.xpathForUploadButton())).click();
    }

    public String getUploadedFileName() {
        return driver.findElement(By.xpath(this.xpathForUploadedFile())).getText();
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForUploadField() {
        return "//*[@id=\"file-upload\"]";

    }

    private String xpathForUploadButton() {
        return "//*[@id=\"file-submit\"]";
    }

    private String xpathForUploadedFile() {
        return "//*[@id=\"uploaded-files\"]";
    }
}
