package pageObjects;

import org.openqa.selenium.WebDriver;

import com.theInternetPages.CheckBoxesPage;
import com.theInternetPages.ContextMenuPage;
import com.theInternetPages.DragDropPage;
import com.theInternetPages.DropDownPage;
import com.theInternetPages.DynamicContentPage;
import com.theInternetPages.DynamicControlPage;
import com.theInternetPages.DynamicLoadingPage;
import com.theInternetPages.FileDownloadPage;
import com.theInternetPages.FileUploadPage;
import com.theInternetPages.FloatingMenuPage;
import com.theInternetPages.IframePage;
import com.theInternetPages.JavaScriptsAlertsPage;
import com.theInternetPages.JavaScriptsErrorPage;
import com.theInternetPages.LoginPage;
import com.theInternetPages.MouseHoverPage;
import com.theInternetPages.NewTabPage;
import com.theInternetPages.NotificationsPage;
import com.theInternetUtilities.CommonActions;

public class PageObjects {

	WebDriver obj_Driver;
	LoginPage obj_LoginPage;
	CheckBoxesPage obj_CheckBoxesPage;
	ContextMenuPage obj_ContextMenuPage;
	DragDropPage obj_DragDropPage;
	DropDownPage obj_DropDownPage;
	DynamicContentPage obj_DynamicContentPage;
	DynamicControlPage obj_DynamicControlPage;
	DynamicLoadingPage obj_DynamicLoadingPage;
	FileDownloadPage obj_FileDownloadPage;
	FileUploadPage obj_FileUploadPage;
	CommonActions obj_CommonActions;
	FloatingMenuPage obj_FloatingMenuPage;
	IframePage obj_IframePage;
	MouseHoverPage obj_MouseHoverPage;
	JavaScriptsAlertsPage obj_JavaScriptsAlertsPage;
	JavaScriptsErrorPage obj_JavaScriptsErrorPage;
	NewTabPage obj_NewTabPage;
	NotificationsPage obj_NotificationsPage;
	
	public PageObjects(WebDriver driver) {
		this.obj_Driver = driver;
	}
	
	public LoginPage getLoginPage() {
		if(obj_LoginPage==null)
			obj_LoginPage = new LoginPage(obj_Driver);
		return obj_LoginPage;
	}
	
	public CheckBoxesPage getCheckBoxesPage() {
		
		if(obj_CheckBoxesPage==null)
			obj_CheckBoxesPage = new CheckBoxesPage(obj_Driver);
		return obj_CheckBoxesPage;
	}
	
public ContextMenuPage getContextMenuPage() {
		
		if(obj_ContextMenuPage==null)
			obj_ContextMenuPage = new ContextMenuPage(obj_Driver);
		return obj_ContextMenuPage;
	}

public DragDropPage getDragDropPage() {
	
	if(obj_DragDropPage==null)
		obj_DragDropPage = new DragDropPage(obj_Driver);
	return obj_DragDropPage;
}



public DropDownPage getDropDownPage() {
	
	if(obj_DropDownPage==null)
		obj_DropDownPage = new DropDownPage(obj_Driver);
	return obj_DropDownPage;
}

public DynamicContentPage getDynamicContentPage() {

if(obj_DynamicContentPage==null)
	obj_DynamicContentPage = new DynamicContentPage(obj_Driver);
return obj_DynamicContentPage;
}

public DynamicControlPage getDynamicControlPage() {

if(obj_DynamicControlPage==null)
	obj_DynamicControlPage = new DynamicControlPage(obj_Driver);
return obj_DynamicControlPage;
}

public DynamicLoadingPage getDynamicLoadingPage() {

if(obj_DynamicLoadingPage==null)
	obj_DynamicLoadingPage = new DynamicLoadingPage(obj_Driver);
return obj_DynamicLoadingPage;
}

public FileDownloadPage getFileDownloadPage() {

if(obj_FileDownloadPage==null)
	obj_FileDownloadPage = new FileDownloadPage(obj_Driver);
return obj_FileDownloadPage;
}

public FileUploadPage getFileUploadPage() {

if(obj_FileUploadPage==null)
	obj_FileUploadPage = new FileUploadPage(obj_Driver);
return obj_FileUploadPage;
}

public CommonActions getCommonActions() {

if(obj_CommonActions==null)
	obj_CommonActions = new CommonActions();
return obj_CommonActions;
}

public FloatingMenuPage getFloatingMenuPage() {

if(obj_FloatingMenuPage==null)
	obj_FloatingMenuPage = new FloatingMenuPage(obj_Driver);
return obj_FloatingMenuPage;
}

public IframePage getIframePage() {

if(obj_IframePage==null)
	obj_IframePage = new IframePage(obj_Driver);
return obj_IframePage;
}
public MouseHoverPage getMouseHoverPage() {

if(obj_MouseHoverPage==null)
	obj_MouseHoverPage = new MouseHoverPage(obj_Driver);
return obj_MouseHoverPage;
}
public JavaScriptsAlertsPage getJavaScriptsAlertsPage() {

if(obj_JavaScriptsAlertsPage==null)
	obj_JavaScriptsAlertsPage = new JavaScriptsAlertsPage(obj_Driver);
return obj_JavaScriptsAlertsPage;
}
public JavaScriptsErrorPage getJavaScriptsErrorPage() {

if(obj_JavaScriptsErrorPage==null)
	obj_JavaScriptsErrorPage = new JavaScriptsErrorPage(obj_Driver);
return obj_JavaScriptsErrorPage;
}
public NewTabPage getNewTabPage() {

if(obj_NewTabPage==null)
	obj_NewTabPage = new NewTabPage(obj_Driver);
return obj_NewTabPage;
}
public NotificationsPage getNotificationsPage() {

if(obj_NotificationsPage==null)
	obj_NotificationsPage = new NotificationsPage(obj_Driver);
return obj_NotificationsPage;
}
}
