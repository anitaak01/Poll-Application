package com.example.poll.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "poll_answers")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String residence;
    private String frequency;
    private String quality;

    public Poll() {
    }

    public Poll(String firstName, String lastName, int age, String residence, String frequency, String quality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.residence = residence;
        this.frequency = frequency;
        this.quality = quality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", residence='" + residence + '\'' +
                ", frequency='" + frequency + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }
}
