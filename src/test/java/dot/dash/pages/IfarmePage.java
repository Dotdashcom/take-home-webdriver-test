package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class IfarmePage {
    public IfarmePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "tinymce")
    public WebElement inputText;

    @FindBy(id = "mce_0_ifr")
    public WebElement framei;
   @FindBy(css = ".tox-notification__dismiss.tox-button")
    public WebElement closeBtn;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    private List<WebElement> pElements;

    public List<String> textsInsideP(){
        return pElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }


}
