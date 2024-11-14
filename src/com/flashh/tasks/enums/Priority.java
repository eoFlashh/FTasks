package com.flashh.tasks.enums;

public enum Priority {
    LOW("low"),
    MEDIUM("Medium"),
    HIGH("high");

    private final String description;

    Priority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
