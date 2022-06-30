package com.netcore.service;

import com.netcore.model.Employee;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class EmployeeService {
    public Jedis connect(){
        Jedis jedis=new Jedis("redis://localhost:6379");
        return jedis;
    }
    public void set(String first_name,String last_name,int salary) {
        Jedis jedis = connect();
        Employee employee = new Employee();
        employee.setFirst_name(first_name);
        employee.setLast_name(last_name);
        employee.setSalary(salary);
        jedis.set("first_name", employee.getFirst_name());
        jedis.set("last_name", employee.getLast_name());
        jedis.set("salary", String.valueOf(employee.getSalary()));
        System.out.println("added successfully");
    }
    public void display() {
        Jedis jedis = connect();
        Set<String> result=jedis.keys("*");
        System.out.println(result);
        for(String values: result){
            System.out.print(jedis.get(values)+",");
        }
        System.out.println();
    }
    public void delete(String first_name){
        Jedis jedis=connect();
        Employee employee=new Employee();
        employee.setFirst_name(first_name);
        jedis.del(employee.getFirst_name());
        System.out.println("Deleted Successfully");
    }
}
