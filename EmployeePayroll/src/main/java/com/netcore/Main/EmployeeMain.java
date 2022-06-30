package com.netcore.Main;

import com.netcore.service.EmployeeService;

import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeService employeeService=new EmployeeService();
        Scanner scanner=new Scanner(System.in);
        int choice;
        do{
            System.out.println("enter your choice");
            System.out.println("1 for add employee");
            System.out.println("2 for display");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter first name");
                    String f_name=scanner.next();
                    System.out.println("enter last name");
                    String l_name=scanner.next();
                    System.out.println("enter gender");
                    String gen=scanner.next();
                    System.out.println("enter city");
                    String city=scanner.next();
                    employeeService.addEmployee(f_name,l_name,gen,city);
                    break;
                case 2:
                    employeeService.display();
                    break;
            }
        }while (choice != 0);
        employeeService.display();
    }
}
