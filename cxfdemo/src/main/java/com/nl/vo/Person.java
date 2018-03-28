package com.nl.vo;

public class Person {
    private Integer peopleId;
    private String peopleName;
    private Integer status;
    private String description;

    public Person() {
    }

    public Person(String peopleName) {
        this.peopleName = peopleName;
    }

    public Person(String peopleName, Integer status, String description) {
        this.peopleName = peopleName;
        this.status = status;
        this.description = description;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
