package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UploadPage extends BasePage {
    private By chooseFileButton = By.id("file-upload");
    private By submitButton = By.id("file-submit");
    private By message = By.xpath("//*[@id=\"content\"]/div/h3");

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String path){
        wait.until(ExpectedConditions.elementToBeClickable(chooseFileButton));
        getElement(chooseFileButton).sendKeys(path);
    }

    public void clickSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        getElement(submitButton).click();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
        return getMessage(message);
    }
}
