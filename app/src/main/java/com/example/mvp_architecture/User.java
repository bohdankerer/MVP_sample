package com.example.mvp_architecture;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    private String name = null;

    @SerializedName("surname")
    private String surname;

    @SerializedName("age")

    private int age;

    @SerializedName("weight")
    private float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
