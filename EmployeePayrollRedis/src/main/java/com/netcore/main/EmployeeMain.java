package com.netcore.main;

import com.netcore.service.EmployeeService;

import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        EmployeeService employeeService=new EmployeeService();
        int choice;
        do{
            System.out.println("Enter your choice");
            System.out.println("1 for insert/update,2 for display,3 for delete,0 for exit");
            choice=scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter first name");
                    String first_name = scanner.next();
                    System.out.println("Enter last name");
                    String last_name = scanner.next();
                    System.out.println("Enter salary");
                    int salary = scanner.nextInt();
                    employeeService.set(first_name, last_name, salary);
                    break;
                case 2:
                    employeeService.display();
                    break;
                case 3:
                    System.out.println("Enter key to delete");
                    String key = scanner.next();
                    employeeService.delete(key);
                    break;
                case 0:
                    System.out.println("EXIT");
            }

        }while (choice != 0);
    }
}
