package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPage
{

    public NewWindowPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy( how = How.CSS , using = "a[href='/windows/new']")
    WebElement clickHere;

    public void clickOnClickHere()
    {
        clickHere.click();
    }
}
