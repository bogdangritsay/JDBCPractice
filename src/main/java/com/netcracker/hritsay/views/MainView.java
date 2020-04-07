package com.netcracker.hritsay.views;

import com.netcracker.hritsay.entities.Employee;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    public void drawMainMenu() {
        System.out.println(
                "Choose the action by number: \n" +
                        "1 - Show all employees\n" +
                        "2 - Show employee by id\n" +
                        "3 - Add new employee\n" +
                        "4 - Delete employee by id\n" +
                        "5 - Exit"
        );
    }

    public static int enterId() {
        do {
            try {
                System.out.println("Enter ID, please: ");
                Scanner sc = new Scanner(System.in);
                int result = sc.nextInt();
                return result;
            } catch(InputMismatchException e) {
                System.out.println("Enter  number for ID, please!");
            }
        } while (true);

    }

    public static Employee enterEemployee() {
        Employee resultEmp = null;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the name: ");
                String name = sc.nextLine();
                System.out.println("Enter the job:");
                String job = sc.nextLine();
                System.out.println("Enter the ID of the manager or 0 if employee hasn't manager: ");
                int mgr = sc.nextInt();
                System.out.println("Enter the hire date : \n Enter the year (YYYY): ");
                int year = sc.nextInt();
                System.out.println("Enter the month (MM): ");
                int month = sc.nextInt();
                System.out.println("Enter the day (DD): ");
                int day = sc.nextInt();
                String date = year + "-" + month + "-" + day;
                Date hireDate = Date.valueOf(date);
                System.out.println("Enter the salary: ");
                float salary = sc.nextFloat();
                System.out.println("Enter the commissions or 0 if employee hasn't commissions: ");
                float comm = sc.nextFloat();

                System.out.println("Enter the number of department: ");
                int dept = sc.nextInt();

                return new Employee(0 , name, job, mgr, hireDate, salary, comm, dept);
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data!");
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect date!");
            }
        } while(true);
    }


}

