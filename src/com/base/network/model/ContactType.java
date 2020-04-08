package com.base.network.model;

public enum ContactType {
    PHONE("PHONE"),
    MOBILE("MOBILE"),
    HOME_PHONE("HOME_PHONE"),
    SKYPE("Skype"),
    MAIL("MAIL"),
    LINKEDIN("Linkedin"),
    GITHUB("GitHub"),
    STACKOVERFLOW("Stackoverflow"),
    HOME_PAGE("HOME_PAGE");
    private final String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
