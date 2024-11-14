package com.flashh.tasks.models;

public abstract class PersonBase {
    private String name;
    private String email;
    private int age;

    public PersonBase(String name, String email, String age) {
        this.name = name;
        if (validateEmail(email)) {
            this.email = email;
            try {
                this.age = Integer.parseInt(age);
            } catch (NumberFormatException e) {
                this.age = -1;
                System.out.println("Invalid age value. Age must be a valid number.");
            }
            System.out.println("Person created");
        } else {
            this.email = "";
            System.out.println("Invalid email address");
        }
    }

    public boolean validateEmail(String email) {
        return email.contains("@");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
