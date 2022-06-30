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
            System.out.println("1 for insert,2 for display,3 for update salary,4 for delete,0 for exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter first name");
                    String  first_name=scanner.next();
                    System.out.println("Enter last name");
                    String last_name=scanner.next();
                    System.out.println("Enter salary");
                    int salary=scanner.nextInt();
                    employeeService.insert(first_name,last_name,salary);
                    break;
                case 2:
                    System.out.println("Total documents are ::");
                    employeeService.display();
                    break;
                case 3:
                    System.out.println("Enter first name to update");
                    String  f_name=scanner.next();
                    System.out.println("Enter new salary");
                    int new_salary=scanner.nextInt();
                    employeeService.update(f_name,new_salary);
                    break;
                case 4:
                    System.out.println("Enter first name to delete document");
                    String  f=scanner.next();
                    employeeService.delete(f);
                    break;
                case 0:
                    System.out.println("EXIT");
                    break;
            }

        }while (choice !=0);

    }
}
