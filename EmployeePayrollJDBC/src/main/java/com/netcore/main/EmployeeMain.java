package com.netcore.main;



import com.netcore.service.EmployeeService;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) throws SQLException {
        EmployeeService employeeService=new EmployeeService();
        int choice;
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("Enter your choice");
            System.out.println("1 for add,2 for display,3 for update Salary ,4 for delete an employee,0 to exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter first name");
                    String  first_name=scanner.next();
                    System.out.println("Enter last name");
                    String last_name=scanner.next();
                    System.out.println("Enter city");
                    String city=scanner.next();
                    System.out.println("Enter gender");
                    String gender=scanner.next();
                    System.out.println("Enter salary");
                    int salary=scanner.nextInt();
                    employeeService.addEmployee(first_name,last_name,city,gender,salary);
                    break;
                case 2:
                    System.out.println("EMPLOYEES DETAILS ARE :: ");
                    employeeService.display();
                    break;
                case 3:
                    System.out.println("Enter first name to edit salary");
                    String first=scanner.next();
                    System.out.println("Enter new Salary");
                    int new_Salary=scanner.nextInt();
                    employeeService.updateEmployee(first,new_Salary);
                    break;
                case 4:
                    System.out.println("Enter first name to delete");
                    String f=scanner.next();
                    employeeService.deleteEmployee(f);
                    break;
                case 0:
                    System.out.println("EXIT");
            }


        }while (choice != 0);
    }
}
