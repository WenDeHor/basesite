package com.base.network.model;

public enum ContactType {
    PHONE("PHONE"),
    MOBILE("MOBILE"),
    HOME_PHONE("HOME_PHONE"),
    SKYPE("Skype") {
        @Override
        public String toHtml0(String value) {
            return "<a href='skype:'>" + value + "'> " + value + "</a>";
        }
    },
    MAIL("MAIL") {
        @Override
        public String toHtml0(String value) {
            return "<a href='mailto:'>" + value + "'> " + value + "</a>";
        }
    },
    LINKEDIN("Linkedin"),
    GITHUB("GitHub"),
    STACKOVERFLOW("Stackoverflow"),
    HOME_PAGE("HOME_PAGE");
    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toHtml(String value) {
        return (value == null) ? "" :toHtml0(value);
    }
    protected String toHtml0(String value) {
        return title + ": " + value;
    }
}
