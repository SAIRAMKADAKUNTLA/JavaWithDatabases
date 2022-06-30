package com.netcore.service;

import com.netcore.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeService {

    public Connection getConnect(){
        String url="jdbc:mysql://localhost:3306/employeeDetails";
        String user="root";
        String password="admin";
        try {
            Connection connection= DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void display() throws SQLException {
        String display_query="SELECT * FROM employees";
        Connection connection= getConnect();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(display_query);
        ArrayList<Employee>list=new ArrayList<>();
        while(resultSet.next()){
            Employee employee=new Employee();
            employee.setFirst_name(resultSet.getString("first_name"));
            employee.setLast_name(resultSet.getString("last_name"));
            employee.setGender(resultSet.getString("gender"));
            employee.setCity(resultSet.getString("city"));
            employee.setSalary(resultSet.getInt("salary"));
            list.add(employee);
        }
        Iterator<Employee> emp=list.iterator();
        while (emp.hasNext()){
            Employee employee=emp.next();
            System.out.println(employee);
        }
    }
    public void addEmployee(String first_name,String last_name,String city,String gender,int salary) throws SQLException {
        String addQuery="INSERT INTO employees(first_name,last_name,city,gender,salary)"+"VALUES(?,?,?,?,?)";
        Connection connection=getConnect();
        PreparedStatement statement=connection.prepareStatement(addQuery);
        Employee employee=new Employee();
        employee.setFirst_name(first_name);
        employee.setLast_name(last_name);
        employee.setCity(city);
        employee.setGender(gender);
        employee.setSalary(salary);
        statement.setString(1,employee.getFirst_name());
        statement.setString(2, employee.getLast_name());
        statement.setString(3,employee.getCity());
        statement.setString(4, employee.getGender());
        statement.setInt(5,employee.getSalary());
        int check=statement.executeUpdate();
        statement.close();
        connection.close();
        if(check == 1){
            System.out.println("Employee added successfully");
        }   else{
            System.out.println("enter again");
        }
    }
    public void updateEmployee(String first_name,int salary) throws SQLException {
        String updateQuery="UPDATE employees SET salary=? WHERE first_name=?";
        Connection connection=getConnect();
        PreparedStatement statement=connection.prepareStatement(updateQuery);
        Employee employee=new Employee();
        employee.setFirst_name(first_name);
        employee.setSalary(salary);
        statement.setString(2,employee.getFirst_name());
        statement.setInt(1,employee.getSalary());
        int check=statement.executeUpdate();
        statement.close();
        connection.close();
        if(check == 1){
            System.out.println("Salary updated successfully");
        }
        else{
            System.out.println("first name is incorrect");
        }
    }
    public void deleteEmployee(String first_name) throws SQLException {
        String deleteQuery="DELETE FROM employees WHERE first_name=?";
        Connection connection=getConnect();
        PreparedStatement statement=connection.prepareStatement(deleteQuery);
        Employee employee=new Employee();
        employee.setFirst_name(first_name);
        statement.setString(1,employee.getFirst_name());
        int check=statement.executeUpdate();
        statement.close();
        connection.close();
        if(check == 1){
            System.out.println("Employee deleted successfully");
        }
        else{
            System.out.println("first name is incorrect");
        }
    }
}
