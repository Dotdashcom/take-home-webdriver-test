package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DynamicControlsPage {

    WebDriver webDriver;
    String dynamicControlsPageUrl = "http://localhost:7080/dynamic_controls";
    String checkBoxXpath = "//*[@id='checkbox']";
    String textBoxXpath = "//input[@type='text']";
    String removeButtonXpath = "//button[text()='Remove']";
    String addButtonXpath = "//button[text()='Add']";
    String enableButtonXpath = "//button[text()='Enable']";
    String disableButtonXpath = "//button[text()='Disable']";
    
    

    public DynamicControlsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(dynamicControlsPageUrl);
    }

    public void clickRemoveButton(){
        webDriver.findElement(By.xpath(removeButtonXpath)).click();
        WebDriverWait wait= new WebDriverWait(webDriver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(checkBoxXpath)));
    }

    public void clickAddButton(){
        webDriver.findElement(By.xpath(addButtonXpath)).click();
        WebDriverWait wait= new WebDriverWait(webDriver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkBoxXpath)));
    }

    public void clickEnableButton(){
        webDriver.findElement(By.xpath(enableButtonXpath)).click();
        WebDriverWait wait= new WebDriverWait(webDriver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(disableButtonXpath)));
    }

    public void clickDisableButton(){
        webDriver.findElement(By.xpath(disableButtonXpath)).click();
        WebDriverWait wait= new WebDriverWait(webDriver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(enableButtonXpath)));
    }


    public boolean hasCheckBox(){
        return webDriver.findElements(By.xpath(checkBoxXpath)).size()>0;
    }

    public boolean isTextBoxEnabled(){
        return webDriver.findElement(By.xpath(textBoxXpath)).getAttribute("disabled") == null;
    }
}
