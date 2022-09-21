package testbase;

import pages.CheckBoxFactory;
import pages.ContextMenuPageFactory;
import pages.LoginPageFactory;

public class PageInitializer extends BaseClass {
	
	public static LoginPageFactory loginPage;
	public static CheckBoxFactory checkBoxes;
	public static ContextMenuPageFactory contextMenu;
	
	public static void initialize() {
		
		loginPage = new LoginPageFactory();
		checkBoxes = new CheckBoxFactory();
		contextMenu = new ContextMenuPageFactory();		
		
	}

}
