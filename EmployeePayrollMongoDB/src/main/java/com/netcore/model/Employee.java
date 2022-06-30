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
    private int salary;
}
