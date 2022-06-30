package com.netcore.service;

import com.netcore.model.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeService {
    ArrayList<Employee> list = new ArrayList<>();

    public void addEmployee(String first_name, String last_name,
                            String gender, String city) {
        list.add(new Employee(first_name,last_name,gender,city));
    }
    public void display(){
        Iterator<Employee>emp=list.iterator();
        while (emp.hasNext()){
            Employee employee=emp.next();
            System.out.println(employee);
        }
    }

}
