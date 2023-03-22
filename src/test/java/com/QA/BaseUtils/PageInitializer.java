package com.QA.BaseUtils;

import com.QA.pages.CheckBoxesPageElements;
import com.QA.pages.ContextMenuPageElements;
import com.QA.pages.DragAndDropPageElements;
import com.QA.pages.DropdownPageElements;
import com.QA.pages.DynamicContentPageElements;
import com.QA.pages.DynamicControlsPageElements;
import com.QA.pages.DynamicLoadingPageElements;
import com.QA.pages.FileDownloadPageElements;
import com.QA.pages.FileUploadPageElements;
import com.QA.pages.FloatingMenuPageElements;
import com.QA.pages.IframePageElements;
import com.QA.pages.JavaScriptAlertsPageElements;
import com.QA.pages.LoginPageElements;
import com.QA.pages.MouseHoverPageElements;
import com.QA.pages.NotificationMessagePageElements;
import com.QA.pages.OpenInNewTabPageElements;


public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static CheckBoxesPageElements checkBox;
	public static ContextMenuPageElements contextMenu;
	public static DragAndDropPageElements dragAndDrop;
	public static DropdownPageElements dropDown;
	public static DynamicContentPageElements dynamicContent;
	public static DynamicControlsPageElements dynamicControls;
	public static DynamicLoadingPageElements dynamicLoading;
	public static FileDownloadPageElements fileDownload;
	public static FileUploadPageElements fileUpload;
	public static FloatingMenuPageElements floatingMenu;
	public static IframePageElements iframe;
	public static MouseHoverPageElements mouse;
	public static JavaScriptAlertsPageElements jsAlert;
	public static OpenInNewTabPageElements newTab;
	public static NotificationMessagePageElements notification;

	public static void initialize() {		

		login = new LoginPageElements();
		checkBox = new CheckBoxesPageElements();
		contextMenu = new ContextMenuPageElements();
		dragAndDrop = new DragAndDropPageElements();
		dropDown = new DropdownPageElements();
		dynamicContent = new DynamicContentPageElements();
		dynamicControls = new DynamicControlsPageElements();
		dynamicLoading = new DynamicLoadingPageElements();
		fileDownload = new FileDownloadPageElements();
		fileUpload = new FileUploadPageElements();
		floatingMenu = new FloatingMenuPageElements();
		iframe = new IframePageElements();
		mouse = new MouseHoverPageElements();
		jsAlert = new JavaScriptAlertsPageElements();	
		newTab = new OpenInNewTabPageElements();
		notification = new NotificationMessagePageElements();
	}

}
