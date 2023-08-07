package com.ems.controller;

import com.ems.dao.*;
import com.ems.domain.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO dao = new DAOImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter option 1 for Administrator view");
        System.out.println("Enter option 2 for Employee view");
        int option = sc.nextInt();

        if (option == 1) {
            System.out.println("Administrator view");
            System.out.println("Enter option 1 to add an employee");
            System.out.println("Enter option 2 to delete an employee");
            System.out.println("Enter option 3 to update employee details");
            System.out.println("Enter option 4 to search an employee by id");
            System.out.println("Enter option 5 to view all employees");
            int z = sc.nextInt();
            while (z > 0) {
                if (z == 1) {
                    Employee emp = new Employee();
                    System.out.println("Enter emp id:");
                    emp.setEid(sc.nextInt());
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter employee name:");
                    emp.setEname(sc.nextLine());
                    System.out.println("Enter age of the employee:");
                    emp.setAge(sc.nextInt());
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter employee phone number:");
                    emp.setContactNumber(sc.nextLine());
                    boolean b = dao.addEmployee(emp);
                    if (b) {
                        System.out.println("Employee added successfully");
                    } else {
                        System.out.println("Failed to add employee");
                    }
                    break;
                } else if (z == 2) {
                    System.out.println("Enter employee ID to delete:");
                    int deleteId = sc.nextInt();
                    boolean deleted = dao.deleteEmployee(deleteId);
                    if (deleted) {
                        System.out.println("Employee deleted successfully");
                    } else {
                        System.out.println("Failed to delete employee");
                    }
                    break;
                } else if (z == 3) {
                    System.out.println("Enter employee ID to update:");
                    int updateId = sc.nextInt();
                    Employee updatedEmployee = dao.getEmployeeById(updateId);
                    if (updatedEmployee != null) {
                        System.out.println("Employee details:");
                        System.out.println("ID: " + updatedEmployee.getEid());
                        System.out.println("Name: " + updatedEmployee.getEname());
                        System.out.println("Age: " + updatedEmployee.getAge());
                        System.out.println("Contact: " + updatedEmployee.getContactNumber());

                        System.out.println("Enter new employee name:");
                        sc.nextLine();
                        updatedEmployee.setEname(sc.nextLine());
                        System.out.println("Enter new age:");
                        updatedEmployee.setAge(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Enter new contact number:");
                        updatedEmployee.setContactNumber(sc.nextLine());

                        boolean updated = dao.updateEmployee(updatedEmployee);
                        if (updated) {
                            System.out.println("Employee details updated successfully");
                        } else {
                            System.out.println("Failed to update employee details");
                        }
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                } else if (z == 4) {
                    System.out.println("Enter employee ID to search:");
                    int searchId = sc.nextInt();
                    Employee searchedEmployee = dao.getEmployeeById(searchId);
                    if (searchedEmployee != null) {
                        System.out.println("Employee found:");
                        System.out.println("ID: " + searchedEmployee.getEid());
                        System.out.println("Name: " + searchedEmployee.getEname());
                        System.out.println("Age: " + searchedEmployee.getAge());
                        System.out.println("Contact: " + searchedEmployee.getContactNumber());
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                } else if (z == 5) {
                    List<Employee> allEmployees = dao.getAllEmployees();
                    if (!allEmployees.isEmpty()) {
                        System.out.println("All Employees:");
                        for (Employee employee : allEmployees) {
                            System.out.println("ID: " + employee.getEid());
                            System.out.println("Name: " + employee.getEname());
                            System.out.println("Age: " + employee.getAge());
                            System.out.println("Contact: " + employee.getContactNumber());
                            System.out.println();
                        }
                    } else {
                        System.out.println("No employees found");
                    }
                    break;
                } else {
                    System.out.println("Invalid option");
                    break;
                }
            }
        } else if (option == 2) {
            System.out.println("Employee view");
            System.out.println("Enter option 1 to search an employee by id");
            System.out.println("Enter option 2 to view all employees");
            int y = sc.nextInt();
            while (y > 0) {
                if (y == 1) {
                    System.out.println("Enter employee ID to search:");
                    int searchId = sc.nextInt();
                    Employee searchedEmployee = dao.getEmployeeById(searchId);
                    if (searchedEmployee != null) {
                        System.out.println("Employee found:");
                        System.out.println("ID: " + searchedEmployee.getEid());
                        System.out.println("Name: " + searchedEmployee.getEname());
                        System.out.println("Age: " + searchedEmployee.getAge());
                        System.out.println("Contact: " + searchedEmployee.getContactNumber());
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;
                } else if (y == 2) {
                    List<Employee> allEmployees = dao.getAllEmployees();
                    if (!allEmployees.isEmpty()) {
                        System.out.println("All Employees:");
                        for (Employee employee : allEmployees) {
                            System.out.println("ID: " + employee.getEid());
                            System.out.println("Name: " + employee.getEname());
                            System.out.println("Age: " + employee.getAge());
                            System.out.println("Contact: " + employee.getContactNumber());
                            System.out.println();
                        }
                    } else {
                        System.out.println("No employees found");
                    }
                    break;
                } else {
                    System.out.println("Invalid option");
                    break;
                }
            }
        } else {
            System.out.println("Invalid option");
        }

        sc.close();
    }
}
