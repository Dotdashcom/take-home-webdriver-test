package testbase;

import pages.CheckBoxFactory;
import pages.ContextMenuPageFactory;
import pages.DragAndDropPageFactory;
import pages.DropDownPageFactory;
import pages.DynamicContentPageFactory;
import pages.LoginPageFactory;

public class PageInitializer extends BaseClass {
	
	public static LoginPageFactory loginPage;
	public static CheckBoxFactory checkBoxes;
	public static ContextMenuPageFactory contextMenu;
	public static DragAndDropPageFactory dragger;
	public static DropDownPageFactory dropDowner;
	public static DynamicContentPageFactory dynamicContent;
	
	public static void initialize() {
		
		loginPage = new LoginPageFactory();
		checkBoxes = new CheckBoxFactory();
		contextMenu = new ContextMenuPageFactory();	
		dragger = new DragAndDropPageFactory();
		dropDowner = new DropDownPageFactory();
		dynamicContent = new DynamicContentPageFactory();
		
	}

}
