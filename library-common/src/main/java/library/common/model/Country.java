package library.common.model;

public enum  Country {
    POLAND("PL");

    private final String shortcut;

    private Country(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return this.shortcut;
    }
}
