package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage {
    private static final String IFRAME_ENDPOINT = "iframe";

    @FindBy(xpath = "//div[@role='alert']//button//*[local-name()='svg']/*[local-name()='path']")
    private WebElement toxNotificationCloseButton;

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    @FindBy(css = "[title=Formats] span")
    private WebElement paragraphDropDownButton;

    @FindBy(css = "#tox-collection__group h1")
    private WebElement paragraphDropDownHeadingOneOption;

    @FindBy(xpath = "//button[@title='Bold']//span//*[local-name()='svg']/*[local-name()='path']")
    private WebElement boldButton;

    @FindBy(css = "#tinymce p")
    private WebElement textBox;

    @FindBy(xpath = "//body[@id='tinymce']//p/*[1]")
    private WebElement textBoxTextFirstTag;

    public IframePage(WebDriver driver) {
        super(driver);
    }

    public IframePage getIframePage(){
        getDriver(IFRAME_ENDPOINT);

        return this;
    }

    public IframePage switchToIframe(){
        getDriver().switchTo().frame(iframe);

        return this;
    }

    public IframePage switchToParentFrame(){
        getDriver().switchTo().defaultContent();

        return this;
    }

    public IframePage closeNotification(){
        toxNotificationCloseButton.click();

        return  this;
    }

    public IframePage clearAndInputTextInTextBox(String text){
        textBox.clear();
        textBox.sendKeys(text);

        return this;
    }

    public String getTextFromTextBox(){

        return textBox.getText();
    }

    public IframePage highlightAllText(){
        textBox.sendKeys(getPlatformSpecificControlKey(), "a");

        return this;
    }

    public IframePage highlightPartialText(int numberOfCharactersToHighlight){
        textBox.sendKeys(getPlatformSpecificControlKey(), Keys.ARROW_UP);
        getAction().keyDown(Keys.SHIFT).perform();
        for(int i = 0; i < numberOfCharactersToHighlight; i++) {
            getAction().sendKeys(Keys.ARROW_RIGHT).perform();
        }
        getAction().keyUp(Keys.SHIFT);

        return this;
    }

    public IframePage clickBoldButton(){
        boldButton.click();

        return this;
    }

    public String getEnteredTextByNumberOfChars(int numberOfCharacters){

        return textBox.getText().substring(0, numberOfCharacters);
        }

        public String getAttributeOfText(){
            return textBoxTextFirstTag.getTagName();
    }

    public String getFormattingOfSelectedText(String text){

        return textBox.findElement(By.xpath(String.format("*[text()='%s']", text))).getTagName();
    }
}