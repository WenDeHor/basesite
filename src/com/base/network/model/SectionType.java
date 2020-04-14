package com.base.network.model;

public enum SectionType {
    OBJECTIVE("Позиція"),
    PERSONAL("Особисті дані"),
    ACHIEVEMENT("Досягнення"),
    QUALIFICATIONCE("Кваліфікація"),
    EXPERIENCE("Досвід роботи"),
    EDUCATION("Освіта");
    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
