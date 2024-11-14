package com.flashh.tasks.models;

import com.flashh.tasks.enums.Priority;
import com.flashh.tasks.enums.ProjectType;
import com.flashh.tasks.enums.TaskStatus;

public abstract class TaskBase {
    public String name;
    public String description;
    public TaskStatus status;
    public ProjectType projectType;
    public Priority priority;

    public TaskBase(String name, String description, TaskStatus status, ProjectType projectType, Priority priority) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.projectType = projectType;
        this.priority = priority;
    }

    public TaskBase(String name, String description, int status, int projectType, int priority) {
        this.name = name;
        this.description = description;
        switch (status) {
            case 2 -> this.status = TaskStatus.IN_PROGRESS;
            case 3 -> this.status = TaskStatus.COMPLETED;
            default -> this.status = TaskStatus.PENDING;
        }
        switch (projectType) {
            case 2 -> this.projectType = ProjectType.MARKETING;
            case 3 -> this.projectType = ProjectType.SUPPORT;
            default -> this.projectType = ProjectType.DEVELOPMENT;
        }

        switch (priority) {
            case 2 -> this.priority = Priority.MEDIUM;
            case 3 -> this.priority = Priority.HIGH;
            default -> this.priority = Priority.LOW;
        }
    }
}
