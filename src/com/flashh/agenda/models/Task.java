package com.flashh.agenda.models;
import com.flashh.agenda.enums.TaskStatus;

public class Task extends TaskBase implements Attributable, StatusUpdatable {
    public Person[] persons;

    public Task(String name, String description, int status, int projectType, int priority, int taskLimit) {
        super(name, description, status, projectType, priority);

        if (taskLimit > 0) {
            persons = new Person[taskLimit];
        } else {
            persons = new Person[5];
        }
    }

    @Override
    public void addPerson(Person person) {
        boolean added = false;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null) {
                persons[i] = person;
                added = true;
                System.out.printf("%s added in task%n", person.getName());
                break;
            }
        }
        if (!added) {
            System.out.println("The task already has the maximum number of people");
        }
    }

    @Override
    public void removePerson(String name) {
        boolean found = false;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && persons[i].getName().equals(name)) {
                persons[i] = null;
                found = true;
                System.out.println(name + " removed from task");
                break;
            }
        }
        if (!found) {
            System.out.println("This task has no one or this person is not in it");
        }
    }

    public void listPersons() {
        for (Person person : persons) {
            if (person != null) {
                System.out.println(person.getName());
            }
        }
    }

    @Override
    public void setStatus(int status) {
        switch (status) {
            case 1 -> this.status = TaskStatus.PENDING;
            case 2 -> this.status = TaskStatus.IN_PROGRESS;
            case 3 -> this.status = TaskStatus.COMPLETED;
            default -> System.out.println("Invalid status");
        }
    }
}
