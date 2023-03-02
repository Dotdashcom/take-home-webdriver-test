package enums;

public enum Headers {

    CHECKBOXES("Checkboxes"),
    CONTENT_MENU("Context Menu"),
    DRAG_AND_DROP("Drag and Drop"),
    DROPDOWN("Dropdown List"),
    DYNAMIC_CONTENT("Dynamic Content"),
    DYNAMICALLY_LOADED_PAGE_ELEMENT("Dynamically Loaded Page Elements");

    private final String name;

    Headers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
