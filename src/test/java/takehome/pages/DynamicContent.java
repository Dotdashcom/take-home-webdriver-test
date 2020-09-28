package takehome.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.Driver;


public class DynamicContent {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @FindBy(xpath = "/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[1]/div[2]")
    private WebElement firstMessage;
    @FindBy(xpath = "/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[2]/div[2]")
    private WebElement secondMessage;
    @FindBy(xpath = "/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[3]/div[2]")
    private WebElement thirdMessage;
    @FindBy(linkText = "Dynamic Content")
    WebElement dynamicContentLink;


    public String getContentText(String textNumber){

        String message="/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div['"+ textNumber+"']/div[2]";
        WebElement element = Driver.getDriver().findElement(By.xpath(message));

        return element.getText();

    }
    public void clickOnDynamicContentLink(){
        wait.until(ExpectedConditions.elementToBeClickable(dynamicContentLink));
        dynamicContentLink.click();
    }


    public  DynamicContent() {
        PageFactory.initElements(Driver.getDriver(), this);






//        Driver.getDriver().findElement(By.linkText("Dynamic Content")).click();
//
//        List<WebElement> imagesBeforeRefresh = Driver.getDriver().findElements(By.xpath("//div[@id='content']//img"));
//        List<WebElement> textBlocksBeforeRefresh = Driver.getDriver().findElements(By.xpath("//div[@class='large-10 columns']"));
//
//        List<String> imagesBeforeRefreshTextList = new ArrayList<>();
//        List<String> textBlocksBeforeRefreshTextList = new ArrayList<>();
//
//        imagesBeforeRefresh.forEach(p -> imagesBeforeRefreshTextList.add(p.getAttribute("src")));
//        textBlocksBeforeRefresh.forEach(p -> textBlocksBeforeRefreshTextList.add(p.getText()));
//
//        Driver.getDriver().navigate().refresh();
//
//        List<WebElement> imagesAfterRefresh = Driver.getDriver().findElements(By.xpath("//div[@id='content']//img"));
//        List<WebElement> textBlocksAfterRefresh = Driver.getDriver().findElements(By.xpath("//div[@class='large-10 columns']"));
//
//        for (int index = 0; index < imagesBeforeRefresh.size(); index++) {
//            String imgBefore = imagesBeforeRefreshTextList.get(index);
//            WebElement imgAfter = imagesAfterRefresh.get(index);
//            String textBefore = textBlocksBeforeRefreshTextList.get(index);
//            WebElement textAfter = textBlocksAfterRefresh.get(index);
//
//            Assertion.assertEquals(imgBefore, imgAfter.getAttribute("src"), "Image is the same!");
//            Assert.assertNotEquals(textBefore, textAfter.getText(), "Text is the same!");
//        }
   }

}
