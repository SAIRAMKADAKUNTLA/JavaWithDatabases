package com.netcore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    private String first_name;
    private String last_name;
    private String gender;
    private String city;

    public Employee(String first_name, String last_name, String gender, String city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.city = city;
    }

    public Employee() {

    }
}
