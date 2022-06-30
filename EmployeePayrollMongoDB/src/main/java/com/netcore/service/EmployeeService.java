package com.netcore.service;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.netcore.model.Employee;
import org.bson.Document;

import java.util.Iterator;


public class EmployeeService {
    public MongoDatabase connect() {
        com.mongodb.MongoClient mongoClient=new MongoClient("localhost",27017);
        MongoDatabase mongoDatabase=mongoClient.getDatabase("details");
        return mongoDatabase;
    }
    public void display(){
        MongoCollection<Document> collection = connect().getCollection("employee");
        FindIterable<Document> result=collection.find();
        Iterator it=result.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
    public void insert(String first_name,String last_name,int salary){
        MongoCollection<Document> employeeCollection = connect().getCollection("employee");
        Employee employee=new Employee();
        employee.setFirst_name(first_name);
        employee.setLast_name(last_name);
        employee.setSalary(salary);
        Document document1=new Document();
        document1.append("first_name",employee.getFirst_name());
        document1.append("last_name",employee.getLast_name());
        document1.append("salary",employee.getSalary());
        employeeCollection.insertOne(document1);
        System.out.println("Inserted successfully");
    }
    public void update(String first_name,int salary){
        MongoCollection<Document> employeeCollection = connect().getCollection("employee");
        Employee employee=new Employee();
        employee.setFirst_name(first_name);
        employee.setSalary(salary);
        employeeCollection.updateOne(Filters.eq("first_name",employee.getFirst_name()), Updates.set("salary",employee.getSalary()));
        System.out.println("Updated Successfully");

    }
    public void delete(String first_name){
        MongoCollection<Document> employeeCollection = connect().getCollection("employee");
        Employee employee=new Employee();
        employee.setFirst_name(first_name);
        employeeCollection.deleteOne(Filters.eq("first_name",employee.getFirst_name()));
        System.out.println("Deleted successfully");
    }
}