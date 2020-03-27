package com.base.network.model;

public enum ContactType {
    PHONE("PHONE"),
    MOBILE("MOBILE"),
    HOME_PHONE("Домашній тел."),
    SKYPE("Skype"),
    MAIL("MAIL"),
    LINKEDIN("Профіль Linkedin"),
    GITHUB("Профіль GitHub"),
    STACKOVERFLOW("Профіль Stackoverflow"),
    HOME_PAGE("Домашня сторінка");
    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
