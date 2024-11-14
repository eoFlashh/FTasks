package com.flashh.agenda.enums;

public enum ProjectType {
    DEVELOPMENT("development"),
    MARKETING("marketing"),
    SUPPORT("support");

    private final String description;

    private ProjectType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
