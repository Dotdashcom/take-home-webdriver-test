package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxes {
    public CheckBoxes(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy( linkText = "Checkboxes")
    WebElement checkBox;

    @FindBy(xpath = "//input[@type='checkbox'][1]")
    WebElement checkBox1;

    @FindBy(xpath = "//input[@type='checkbox'][2]")
    WebElement checkBox2;

    @FindBy(xpath = "//h3")
    WebElement header;



    public void checkBoxClick() throws InterruptedException {
        checkBox.click();
        Thread.sleep(1000);
        checkBox1.click();
        checkBox2.click();
    }

    public String getHeader(){
        return header.getText().trim();
    }
}
