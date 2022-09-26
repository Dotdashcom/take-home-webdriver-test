package Utilities;


import PageObj.*;

public class PageInitialized extends Driver {

    protected static LoginPageObj lg;
    protected static CheckBoxPageObj cb;
    protected static ContextMenuPageObj cm;
    protected static DragAndDropPageObj dd;
    protected static DropDownPageObj ddp;
    protected static ContentPageObj ct;
    protected static DynamicControlsPageObj dc;
    protected static DynamicLoadingPageObj dl;
    protected static FileDownloadPageObj fd;
    protected static FileUploadPageObj fu;
    protected static FloatingMenuPageObj fm;
    protected static IframePageObj iframe;
    protected static MouseHoverPageObj mh;
    protected static JavaScriptAlertsPageObj jsa;
    protected static OpenInNewTabPageObj op;
    protected static NotificationMessagePageObj nm;

    public static void init() {
        lg = new LoginPageObj();
        cb = new CheckBoxPageObj();
        cm = new ContextMenuPageObj();
        dd = new DragAndDropPageObj();
        ddp = new DropDownPageObj();
        ct = new ContentPageObj();
        dc = new DynamicControlsPageObj();
        dl = new DynamicLoadingPageObj();
        fd = new FileDownloadPageObj();
        fu = new FileUploadPageObj();
        fm = new FloatingMenuPageObj();
        iframe = new IframePageObj();
        mh = new MouseHoverPageObj();
        jsa = new JavaScriptAlertsPageObj();
        op = new OpenInNewTabPageObj();
        nm = new NotificationMessagePageObj();

    }

}
