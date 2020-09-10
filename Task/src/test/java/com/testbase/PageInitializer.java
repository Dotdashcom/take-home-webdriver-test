package com.testbase;


import com.pages.*;
import com.utils.CommonMethods;

public class PageInitializer extends CommonMethods{

	public static LoginPageElements login;
	public static CheckboxesPageElements checkBox;
	public static ContextMenuPageElements contextMenu;
	public static DragAndDropPageElements dragAndDrop;
	public static DropdownListPageElements ddpage;
	public static DynamicControlsPageElements dyControl;
	public static DynamicallyLoadedPageElements dLoaded;
	public static FileDownloaderPageElements fileDwnld;
	public static FileUploadPageElements fileUpload;
	public static FloatingMenuPageElements flMenu;
	public static IFramePageElements iFrame;
	public static JavaScriptAlertsPageElements jsClick;
	public static JSErrorPageElements jsError;
	public static NotificationMessagePageElements notifMessage;
	public static NewWindowPageElements newWindow;
	
public static void initialize() {
		
		login=new LoginPageElements();
		checkBox = new CheckboxesPageElements();
		contextMenu = new ContextMenuPageElements();
		dragAndDrop = new DragAndDropPageElements();
		ddpage = new DropdownListPageElements();
		dyControl = new DynamicControlsPageElements();
		dLoaded = new DynamicallyLoadedPageElements();
		fileDwnld = new FileDownloaderPageElements();
		fileUpload = new FileUploadPageElements();
		flMenu = new FloatingMenuPageElements();
		iFrame = new IFramePageElements();
		jsClick = new JavaScriptAlertsPageElements();
		jsError = new JSErrorPageElements();
		notifMessage = new NotificationMessagePageElements();
		newWindow = new NewWindowPageElements();
	}
	
}
