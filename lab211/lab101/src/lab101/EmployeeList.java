/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class EmployeeList {

    Scanner sc = new Scanner(System.in);
    List<Employee> employeeList = new ArrayList<>();

    void addEmployee(Employee e) {
        employeeList.add(e);
        System.out.println("Added!");
    }

    public int size() {
        return employeeList.size();
    }

    public Employee get(int index) {
        return employeeList.get(index);
    }

    void update( Employee employeeToUpdate) {

        employeeList.set(employeeToUpdate.getId() - 1, employeeToUpdate);
        System.out.println("Updated.");

    }

    void remove(int idToRemove) {
        Employee employeeToRemove = employeeList.stream()
                .filter(e -> e.getId() == idToRemove)
                .findFirst()
                .orElse(null);
        if (employeeToRemove == null) {
            System.out.println("Not found!");
            return;
        } else {
            employeeList.remove(employeeToRemove);
            System.out.println("Removed.");
        }
    }

    void searchByName(String search) {

        List<Employee> matchingEmployees = employeeList.stream()
                .filter(e -> e.getFirstName().toLowerCase().contains(search) || e.getLastName().toLowerCase().contains(search))
                .collect(Collectors.toList());
        if (matchingEmployees.isEmpty()) {
            System.out.println("Not found.");
        } else {
            System.out.println("List of employees with name " + search + ":");
            for (Employee e : matchingEmployees) {
                System.out.println(e.toString());
            }
        }
    }

    void sortBySalary() {
        Collections.sort(employeeList, Comparator.comparing(Employee::getSalary));
        System.out.println("Sorted by salary: ");
        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }
    }
}
