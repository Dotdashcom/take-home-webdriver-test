import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends PageObject
{
    //Elements
    @FindBy(xpath ="//input[@type='checkbox']")
    public List <WebElement> AllCheckboxes;

    public WebElement checkbox;

    public CheckboxesPage(WebDriver driver)
    {
        super(driver);
    }

    public void Checkbox()
    {
        int size = AllCheckboxes.size();
        for (int i = 0; i <size; i++) {
            checkbox = AllCheckboxes.get(i);
            if (checkbox.isSelected())
            {
                System.out.println("Check box" + i +" is already selected");
            }
            else
            {
                checkbox.click();
            }
        }
    }
    public void UnCheckBox()
    {
        int size = AllCheckboxes.size();
        for (int i = 0; i <size; i++) {
            checkbox = AllCheckboxes.get(i);
            if (!checkbox.isSelected())
            {
                System.out.println("Check box" + i +" is already unchecked");
            }
            else
            {
                checkbox.click();
            }
        }

    }
}
