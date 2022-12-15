import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DropDownPage extends PageObject
{
    //Elements
    @FindBy(id = "dropdown")
    public WebElement dropdown;

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    public void SelectDropDownValue()
    {
        dropdown.click();
        WebElement option1 = driver.findElement(By.cssSelector("option[value='1']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());

        dropdown.click();
        WebElement option2 = driver.findElement(By.cssSelector("option[value='2']"));
        option2.click();
        Assert.assertTrue(option2.isSelected());
    }
}
