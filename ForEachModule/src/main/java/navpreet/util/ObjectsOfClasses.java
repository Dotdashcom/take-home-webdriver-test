package navpreet.util;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import navpreet.pageobjects.CheckBoxesPageObject;
import navpreet.pageobjects.ContextMenuPageObject;
import navpreet.pageobjects.DragAndDropPageObject;
import navpreet.pageobjects.DropDownPageObject;
import navpreet.pageobjects.DynamicContentPageObject;
import navpreet.pageobjects.DynamicControlsPageObject;
import navpreet.pageobjects.DynamicLoadingPageObjects;
import navpreet.pageobjects.FileDownloadPageObjects;
import navpreet.pageobjects.FileUploadPageObjects;
import navpreet.pageobjects.FloatingMenuPageObjects;
import navpreet.pageobjects.IFramePageObjects;
import navpreet.pageobjects.JavaScriptAlertsPageObjects;
import navpreet.pageobjects.JavaScriptErrorPageObjects;
import navpreet.pageobjects.MouseHoverPageObjects;
import navpreet.pageobjects.MultipleWindowsPageObjects;
import navpreet.pageobjects.NotificationMessagePageObjects;
import navpreet.pageobjects.SignInPageObjects;


public class ObjectsOfClasses extends Driver{

	public WebDriver driver;
	public SignInPageObjects spo;
	public CheckBoxesPageObject cbpo;
	public ContextMenuPageObject cmpo;
	public DragAndDropPageObject ddpo;
	public DropDownPageObject drop;
	public DynamicContentPageObject dynamic_content;
    public DynamicControlsPageObject dynamic_controls;
    public DynamicLoadingPageObjects dlpo;
    public FileDownloadPageObjects fdpo;
    public FileUploadPageObjects fupo;
    public FloatingMenuPageObjects fmpo;
    public IFramePageObjects ifpo;
    public MouseHoverPageObjects mhpo;
    public JavaScriptAlertsPageObjects japo;
    public MultipleWindowsPageObjects mwpo;
    public JavaScriptErrorPageObjects jepo;
    public NotificationMessagePageObjects nmpo;
	
	public void GetDriver() throws IOException
	{
		driver=initialize();
	}

	public SignInPageObjects launchSignInApplication() throws IOException
	{
		GetDriver();
	    spo= new SignInPageObjects(driver);
		return spo;
	}
	
	public CheckBoxesPageObject checkBoxApplication() throws IOException
	{
		GetDriver();
	    cbpo= new CheckBoxesPageObject(driver);
		return cbpo;
	}
	
	public ContextMenuPageObject contextMenuApplication() throws IOException
	{
	    GetDriver();
	    cmpo= new ContextMenuPageObject(driver);
		return cmpo;
	}
	
	public DragAndDropPageObject dragAndDropApplication() throws IOException
	{
		GetDriver();
	    ddpo= new DragAndDropPageObject(driver);
		return ddpo;
	}
	
	 public DropDownPageObject dropDownApplication() throws IOException 
	 {
		 GetDriver();
		 drop = new DropDownPageObject(driver);
		 return drop;
	 }
	
	 public DynamicContentPageObject dynamicContentApplication() throws IOException
	 {
		 GetDriver();
		 dynamic_content= new DynamicContentPageObject(driver);
		 return dynamic_content;
	 }
	 
	 public DynamicControlsPageObject dynamicControlsApplication() throws IOException
	 {
		 GetDriver();
		 dynamic_controls= new DynamicControlsPageObject(driver);
		 return dynamic_controls;
	 }
	 
	 public FileDownloadPageObjects fileDownloadApplication() throws IOException
	 {
		 GetDriver();
		 fdpo=new FileDownloadPageObjects(driver);
		 return fdpo;
	 }
	 
	 public FileUploadPageObjects fileUploadApplication() throws IOException
	 {
		 GetDriver();
		 fupo=new FileUploadPageObjects(driver);
		 return fupo;
	 }
	 
	 public DynamicLoadingPageObjects dynamicLoadingApplication() throws IOException
	 {
		 GetDriver();
		 dlpo=new DynamicLoadingPageObjects(driver);
		 return dlpo;
	 }
	 
	 public FloatingMenuPageObjects floatingMenuApplication() throws IOException
	 {
		 GetDriver();
		 fmpo=new FloatingMenuPageObjects(driver);
		 return fmpo;
	 }
	 
	 public IFramePageObjects iFrameApplication() throws IOException
	 {
		 GetDriver();
		 ifpo= new IFramePageObjects(driver);
		 return ifpo;
	 }
	 
	 public JavaScriptAlertsPageObjects javaScriptAlertsApplication() throws IOException
	 {
		 GetDriver();
		 japo=new JavaScriptAlertsPageObjects(driver);
		 return japo;
	 }
	 
	 public JavaScriptErrorPageObjects javaScriptErrorApplication() throws IOException
	 {
		 GetDriver();
		 jepo=new JavaScriptErrorPageObjects(driver);
		 return jepo;
	 }
	 
	 public MouseHoverPageObjects mouseHoverApplication() throws IOException
	 {
		 GetDriver();
		 mhpo=new MouseHoverPageObjects(driver);
		return mhpo;
	 }
	 
	 public MultipleWindowsPageObjects multipleWindowsApplication() throws IOException
	 {
		 GetDriver();
		 mwpo=new MultipleWindowsPageObjects(driver);
		 return mwpo;
	 }
	
	 public NotificationMessagePageObjects notificationMessagesApplication() throws IOException
	 {
		 GetDriver();
		 nmpo=new NotificationMessagePageObjects(driver);
		 return nmpo;
	 }
}
