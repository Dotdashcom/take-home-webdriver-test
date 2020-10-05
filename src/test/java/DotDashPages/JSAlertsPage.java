package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSAlertsPage {

    public WebDriver ldriver;

    public JSAlertsPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture JS Alert button
    @FindBy(xpath="//button[contains(text(),'Click for JS Alert')]")
    WebElement btnJSAlert;

    //Capture JS Confirm button
    @FindBy(xpath="//button[contains(text(),'Click for JS Confirm')]")
    WebElement btnJSConfirm;

    //Capture JS Confirm button
    @FindBy(xpath="//button[contains(text(),'Click for JS Prompt')]")
    WebElement btnJSPrompt;

    //Capture the result button
    @FindBy(id="result")
    public WebElement txtresult;

    //Click on JS Alert button
    public void clkbtnJSAlert()
    {
        btnJSAlert.click();
    }

    //Click on JS Alert button
    public void clkbtnJSConfirm()
    {
        btnJSConfirm.click();
    }

    //Click on JS Alert button
    public void clkbtnJSPrompt()
    {
        btnJSPrompt.click();
    }
    //Get the text from Result webelement
    public String gettxtresult()
    {
        return txtresult.getText();
    }








}
