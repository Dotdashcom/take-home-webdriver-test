package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.util.List;

public class DropdownPage extends Functions {

    @FindBy(id = "dropdown")
    public WebElement dd;

    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public DropdownPage() {

        PageFactory.initElements(driver, this);

    }



}

