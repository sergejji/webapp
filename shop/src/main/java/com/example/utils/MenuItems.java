package com.example.utils;

public class MenuItems {
    private String title;
    private String path;
    private boolean isExternal;
    public MenuItems(String title, String path) {
        this.title = title;
        this.path = path;
        this.isExternal = false;
    }

    public MenuItems(String title, String path, boolean isExternal) {
        this.title = title;
        this.path = path;
        this.isExternal = isExternal;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public boolean isExternal() {
        return isExternal;
    }
}
