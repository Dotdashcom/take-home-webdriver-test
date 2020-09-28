package takehome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.Driver;

public class FileDownloadPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    public FileDownloadPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "File Download")
            private WebElement fileDownloadLInk;
    @FindBy(linkText = "some-file.txt")
            private WebElement someFileTextLink;

    public void clickOnDownloadLink(){
        wait.until(ExpectedConditions.elementToBeClickable(fileDownloadLInk));
        fileDownloadLInk.click();
        wait.until(ExpectedConditions.elementToBeClickable(someFileTextLink));
        someFileTextLink.click();


    }



    }




