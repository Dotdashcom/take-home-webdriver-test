package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.Constants;
import java.io.File;
import java.util.Set;
import static utils.Constants.downloadPath;
import static utils.Constants.uploadPath;

public class Tests extends CommonMethods {
@Test
    public void successLogin(){
    driver.navigate().to(Constants.baseURL+"/login");
    sendText(loginPage.usernameField,"tomsmith");
    sendText(loginPage.passwordField,"SuperSecretPassword!");
    click(loginPage.loginBtn);
    String message = "Welcome to the Secure Area. When you are done click logout below.";
    Assertions.assertEquals(loginPage.subHeader.getText(), message);
}
@Test
    public void failedLogin(){
    driver.navigate().to(Constants.baseURL+"/login");
    sendText(loginPage.usernameField,"notUsername123");
    sendText(loginPage.passwordField,"notPassword@@");
    click(loginPage.loginBtn);
    Assertions.assertTrue(loginPage.errorMsg.isDisplayed());
}
@Test
    public void checkboxes() throws InterruptedException {
    driver.navigate().to(Constants.baseURL+"/checkboxes");
    WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
    WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
    checkbox1.click();
    Thread.sleep(500);
    checkbox1.click();
    Thread.sleep(500);
    boolean isCheckbox1Working = !checkbox1.isSelected();
    checkbox2.click();
    Thread.sleep(500);
    checkbox2.click();
    boolean isCheckbox2Working = checkbox2.isSelected();
    Assertions.assertTrue(isCheckbox1Working&&isCheckbox2Working);
}
@Test
    public void contextMenu()  {
    driver.navigate().to(Constants.baseURL+"/context_menu");
    WebElement box = driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));
    Actions actions = new Actions(driver);
    actions.contextClick(box).build().perform();
    Alert alert = driver.switchTo().alert();
    String alertMessage = alert.getText();
    Assertions.assertEquals("You selected a context menu",alertMessage);

}
@Test
    public void dragAndDrop() throws InterruptedException {
    driver.navigate().to(Constants.baseURL+"/drag_and_drop");
    WebElement boxA= driver.findElement(By.id("column-a"));
    WebElement boxB= driver.findElement(By.id("column-b"));
    Actions actions = new Actions(driver);
    Thread.sleep(1000);
    //actions.dragAndDrop(boxA,boxB).build().perform();
    actions.clickAndHold(boxA).moveToElement(boxB).build().perform();//tried different solutions - does not work on my chrome

    Assertions.assertEquals("A",boxB.getText());
    Assertions.assertEquals("B",boxA.getText());

}
@Test
    public void dropdown() {
    driver.navigate().to(Constants.baseURL+"/dropdown");
    Select dropdown = new Select(driver.findElement(By.id("dropdown")));
    dropdown.selectByVisibleText("Option 1");
    WebElement option1= driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]"));
    Assertions.assertTrue(option1.isSelected());
    dropdown.selectByVisibleText("Option 2");
    WebElement option2 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
    Assertions.assertTrue(option2.isSelected());
}
@Test
    public void dynamicContent() {
    driver.navigate().to(Constants.baseURL + "/dynamic_content");

    String pic1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img")).getAttribute("src");
    String pic2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/img")).getAttribute("src");
    String pic3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/img")).getAttribute("src");
    String text1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
    String text2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]")).getText();
    String text3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]")).getText();

    driver.navigate().refresh();
    driver.navigate().refresh();
    driver.navigate().refresh();

    String newPic1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img")).getAttribute("src");
    String newPic2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/img")).getAttribute("src");
    String newPic3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/img")).getAttribute("src");
    String newText1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
    String newText2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]")).getText();
    String newText3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]")).getText();
    boolean isSame = pic1.equals(newPic1) && pic2.equals(newPic2) && pic3.equals(newPic3) && text1.equals(newText1) && text2.equals(newText2) && text3.equals(newText3);
    Assertions.assertFalse(isSame); //passes when at least 1 element changes
}
@Test
    public void dynamicControls()  {
    driver.navigate().to(Constants.baseURL+"/dynamic_controls");
    WebElement removeBtn = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
    WebDriverWait wait = new WebDriverWait(driver,20);

    click(removeBtn);
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id=\"loading\"]/img"))));
    WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/p"));
    Assertions.assertEquals("It's gone!",message.getText()); //checkbox is gone

    click(removeBtn);
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id=\"loading\"]/img"))));
    WebElement message2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/p"));
    Assertions.assertEquals("It's back!",message2.getText()); //checkbox is present

    WebElement enableField = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
    WebElement enableBtn = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));

    click(enableBtn);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='input-example']/p")));
    WebElement message3 = driver.findElement(By.xpath("//form[@id='input-example']/p"));
    Assertions.assertEquals("It's enabled!",message3.getText());//text box is enabled

    wait.until(ExpectedConditions.elementToBeClickable(enableField));
    click(enableBtn);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='input-example']/p")));
    WebElement message4 = driver.findElement(By.xpath("//form[@id='input-example']/p"));
    Assertions.assertEquals( "It's disabled!",message4.getText());//text box is disabled
}

@Test
    public void dynamicLoading() {
    driver.navigate().to(Constants.baseURL+"/dynamic_loading/2");
    WebDriverWait wait = new WebDriverWait(driver,20);
    WebElement startBtn = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));

    startBtn.click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
    String message = driver.findElement(By.id("finish")).getText();
    Assertions.assertEquals("Hello World!",message);
}
@Test
    public void download() throws InterruptedException {
    driver.navigate().to(Constants.baseURL+"/download");
    WebElement fileDownload = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]"));
    click(fileDownload);
    Thread.sleep(1000);
    File downloadedFile = new File(downloadPath);
    Assertions.assertTrue(downloadedFile.exists());
    downloadedFile.delete();//removes file so we can retest it



}
@Test
    public void upload()  {
    driver.navigate().to(Constants.baseURL+"/upload");
    WebDriverWait wait = new WebDriverWait(driver,20);
    WebElement chooseFile = driver.findElement(By.id("file-upload"));
    chooseFile.sendKeys(uploadPath);
    WebElement uploadBtn = driver.findElement(By.id("file-submit"));
    click(uploadBtn);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/h3")));
    String message=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
    Assertions.assertEquals("File Uploaded!",message);
}
@Test
    public void floatingMenu()  {
    driver.navigate().to(Constants.baseURL+"/floating_menu");
    WebElement menu = driver.findElement(By.id("menu"));
    WebElement pageBottom = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div"));
    getJSExecutor().executeScript("arguments[0].scrollIntoView(true);",pageBottom);
    Assertions.assertTrue(menu.isDisplayed());
}
@Test
    public void iframe() throws InterruptedException {
    driver.navigate().to(Constants.baseURL+"/iframe");
    WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
    driver.switchTo().frame(iframe);
    Thread.sleep(1000);
    WebElement field = driver.findElement(By.id("tinymce"));
    String input = "Test12345!@#$";
    sendText(field,input);
    String output = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).getText();
    Assertions.assertEquals(input,output);
}
@Test
    public void mouseHover()  {
    driver.navigate().to(Constants.baseURL+"/hovers");
    Actions action = new Actions(driver);

    WebElement picture1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
    WebElement picture1Message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
    action.moveToElement(picture1).perform();
    Assertions.assertTrue(picture1Message.isDisplayed());

    WebElement picture2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
    WebElement picture2Message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"));
    action.moveToElement(picture2).perform();
    Assertions.assertTrue(picture2Message.isDisplayed());

    WebElement picture3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
    WebElement picture3Message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"));
    action.moveToElement(picture3).perform();
    Assertions.assertTrue(picture3Message.isDisplayed());
}
@Test
    public void jsAlert(){
    driver.navigate().to(Constants.baseURL+"/javascript_alerts");

    WebElement buttonAlert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
    click(buttonAlert);
    Alert alert = driver.switchTo().alert();
    String text = alert.getText();
    String expectedText = "I am a JS Alert";
    Assertions.assertEquals(expectedText,text);
    alert.accept();

    WebElement buttonConfirm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
    click(buttonConfirm);
    alert.accept();
    String expectedResult = "You clicked: Ok";
    String result = driver.findElement(By.id("result")).getText();
    Assertions.assertEquals(expectedResult,result);

    WebElement buttonPrompt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
    click(buttonPrompt);
    String toSend = "Test12345!@#$";
    alert.sendKeys(toSend);
    alert.accept();
    String result2 = driver.findElement(By.id("result")).getText();
    String trim =result2.substring(13); // removes You entered:
    Assertions.assertEquals(toSend,trim);
}
@Test
    public void jsError(){
    driver.navigate().to(Constants.baseURL+"/javascript_error");
    LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
    boolean errorExist=false;
    String error = "Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')";
    for (LogEntry log:logs){
        if(log.toString().contains(error)){
            errorExist=true;
            break;
        }
    }
    Assertions.assertTrue(errorExist);
}
@Test
    public void newTab(){
    driver.navigate().to(Constants.baseURL+"/windows");
    WebElement click = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
    String mainHandle = driver.getWindowHandle();
    click(click);
    Set<String> handles =driver.getWindowHandles();
    String actualText="";
    String expectedText="New Window";
    for (String handle:handles){
        if(!handle.equals(mainHandle)){
            driver.switchTo().window(handle);
           actualText= driver.getTitle();
        }
    }
    Assertions.assertEquals(expectedText,actualText);
}
@Test
    public void notification() throws InterruptedException {
    driver.navigate().to(Constants.baseURL+"/notification_message_rendered");
    String expectedText1="Action successful";
    String expectedText2="Action unsuccesful, please try again"; //typo - unsuccessful always fails
    String expectedText3="Action Unsuccessful";
    boolean isExpectedTextShown =false;
    for (int i = 0; i < 10; i++) {
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/notification_message']"));
        clickHere.click();
        WebElement message = driver.findElement(By.id("flash"));
        String messageText=message.getText();
        String messageText2 = messageText.replaceAll("×","");
        String trim = messageText2.trim();
        if (trim.equals(expectedText1) || trim.equals(expectedText2) || trim.equals(expectedText3)) {
            isExpectedTextShown = true;
        }
        Thread.sleep(500);
    }
    Assertions.assertTrue(isExpectedTextShown);
}
}
