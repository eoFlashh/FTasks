package com.flashh.agenda.main;

import com.flashh.agenda.models.Person;
import com.flashh.agenda.models.Report;
import com.flashh.agenda.models.Task;

import java.util.Scanner;

public class Main {
    public static void displayMenu() {
        System.out.println("Task Management System");
        System.out.println("-----------------------------");
        System.out.println("1. List all tasks");
        System.out.println("2. Create a new task");
        System.out.println("3. Show task information");
        System.out.println("4. Add person to task");
        System.out.println("5. Remove person from task");
        System.out.println("6. List persons in a task");
        System.out.println("7. Change task status");
        System.out.println("8. Generate Task Report");
        System.out.println("9. Create a new person");
        System.out.println("10. Exit");
    }

    public static void executeMenu() {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[10];
        int taskCount = 0;
        Person[] persons = new Person[10];
        int personCount = 0;

        while (true) {
            displayMenu();
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    if (taskCount == 0) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < taskCount; i++) {
                            System.out.println("Task " + (i + 1) + ": " + tasks[i].name);
                        }
                    }
                    break;
                case "2":
                    System.out.println("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    System.out.println("Enter status (1: Pending, 2: In Progress, 3: Completed): ");
                    int status = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter project type (1: Development, 2: Marketing, 3: Support): ");
                    int projectType = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter priority (1: Low, 2: Medium, 3: High): ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    Task newTask = new Task(taskName, taskDescription, status, projectType, priority, 5);
                    tasks[taskCount++] = newTask;
                    System.out.println("Task created successfully.");
                    break;
                case "3":
                    System.out.println("Enter task number to show information: ");
                    int taskNumber = Integer.parseInt(scanner.nextLine());
                    if (taskNumber > 0 && taskNumber <= taskCount) {
                        Task taskToShow = tasks[taskNumber - 1];
                        System.out.println("Task Name: " + taskToShow.name);
                        System.out.println("Description: " + taskToShow.description);
                        System.out.println("Status: " + taskToShow.status.getDescription());
                        System.out.println("Project Type: " + taskToShow.projectType.getDescription());
                        System.out.println("Priority: " + taskToShow.priority.getDescription());
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case "4":
                    if (personCount == 0) {
                        System.out.println("No people available to add to tasks.");
                    } else {
                        System.out.println("Enter person's name to add to task: ");
                        String personName = scanner.nextLine();
                        boolean foundPerson = false;

                        for (int i = 0; i < personCount; i++) {
                            if (persons[i].getName().equalsIgnoreCase(personName)) {
                                if (taskCount > 0) {
                                    tasks[0].addPerson(persons[i]);
                                    foundPerson = true;
                                    System.out.println(personName + " added to the task.");
                                } else {
                                    System.out.println("No tasks available to add a person.");
                                    foundPerson = true;
                                }
                                break;
                            }
                        }

                        if (!foundPerson) {
                            System.out.println("Person not found.");
                        }
                    }
                    break;
                case "5":
                    if (personCount == 0) {
                        System.out.println("No people available to remove from tasks.");
                    } else {
                        System.out.println("Enter person's name to remove from task: ");
                        String personNameToRemove = scanner.nextLine();
                        boolean foundPerson = false;

                        for (int i = 0; i < personCount; i++) {
                            if (persons[i].getName().equalsIgnoreCase(personNameToRemove)) {
                                if (taskCount > 0) {
                                    tasks[0].removePerson(personNameToRemove);
                                    foundPerson = true;
                                    System.out.println(personNameToRemove + " removed from the task.");
                                } else {
                                    System.out.println("No tasks available to remove a person.");
                                    foundPerson = true;
                                }
                                break;
                            }
                        }

                        if (!foundPerson) {
                            System.out.println("Person not found.");
                        }
                    }
                    break;
                case "6":
                    if (taskCount > 0) {
                        tasks[0].listPersons();
                    } else {
                        System.out.println("No tasks available.");
                    }
                    break;
                case "7":
                    if (taskCount > 0) {
                        tasks[0].setStatus(2);
                    } else {
                        System.out.println("No tasks available to change status.");
                    }
                    break;
                case "8":
                    Report report = new Report();
                    report.generateTaskReport(tasks);
                    break;
                case "9":
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter age: ");
                    String age = scanner.nextLine();
                    persons[personCount++] = new Person(name, email, age);
                    break;
                case "10":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        executeMenu();
    }
}