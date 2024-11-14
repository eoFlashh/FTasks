package com.flashh.tasks.models;

public class Report {
    public void generateTaskReport(Task[] tasks) {
        for (Task task : tasks) {
            if (task != null) {
                System.out.println("Task: " + task.name);
                System.out.println("Description: " + task.description);
                System.out.println("Status: " + task.status.getDescription());
                System.out.println("Priority: " + task.priority.getDescription());
                System.out.println("Project Type: " + task.projectType.getDescription());
                System.out.println("Assigned Persons:");
                task.listPersons();
                System.out.println("-----------------------------");
            }
        }
    }
}
