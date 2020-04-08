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
    private final String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
