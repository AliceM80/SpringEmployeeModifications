package com.dci.exercises.mvcAnnotations.domain;

public final class Employee {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String position;


    public Employee(String id, String firstName, String lastName, Integer age, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}
