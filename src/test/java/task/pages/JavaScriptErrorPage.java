package task.pages;

import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

public class JavaScriptErrorPage {

    public JavaScriptErrorPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
