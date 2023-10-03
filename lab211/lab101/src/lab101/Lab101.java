/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab101;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab101 {

    /**
     * @param args the command line arguments
     */
    private static int employeeId = 1;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        EmployeeList employeeList = new EmployeeList();
        int choice;
        do {
            System.out.println("Main menu:");
            System.out.println("1. Add employees ");
            System.out.println("2. Update employees");
            System.out.println("3. Remove employees");
            System.out.println("4. Search employees");
            System.out.println("5. Sort employees by salary");
            System.out.println("6. Exit");

            System.out.print("Your option: ");
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Your choice has to be an integer from 1 to 6 !");
                break;
            }

            switch (choice) {
                case 1:
                    Employee newEmployee = new Employee();

                    System.out.println("Enter new employee information:");
                    newEmployee.setId(generateId());
                    System.out.print("First name: ");
                    String firstName = sc.nextLine();
                    newEmployee.setFirstName(firstName);
                    System.out.print("Last name: ");
                    String lastName = sc.nextLine();
                    newEmployee.setLastName(lastName);
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    newEmployee.setPhone(phone);
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    newEmployee.setEmail(email);
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    newEmployee.setAddress(address);
                    System.out.print("Sex: ");
                    String sex = sc.nextLine();
                    newEmployee.setSex(address);
                    System.out.print("Date of birth: ");
                    String dob = sc.nextLine();
                    newEmployee.setDob(dob);
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    newEmployee.setSalary(salary);

                    System.out.print("Agency: ");
                    String agency = sc.nextLine();
                    newEmployee.setAgency(agency);
                    employeeList.addEmployee(newEmployee);
                    break;
                case 2:
                    System.out.println("Enter id of the employee you want to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();
                    boolean check = false;
                    for (int i = 0; i < employeeList.size(); i++) {
                        if (employeeList.get(i).getId() == idToUpdate) {
                            check = true;
                            break;
                        }
                    }
                    if (check == false) {
                        System.out.println("not found");
                        break;
                    } else {
                        Employee employeeToUpdate = employeeList.get(idToUpdate-1);

                        System.out.println("Which field do you want to update: ");
                        System.out.println("1.Id - 2.First name - 3.Last name - 4.Phone - 5.Email - 6.Address - 7.DOB - 8.Sex - 9.Salary - 10.Agency");
                        int choiceToUpdate = sc.nextInt();
                        sc.nextLine();
                        switch (choiceToUpdate) {
                            case 1:
                                System.out.println("New id:");
                                int idNew = sc.nextInt();
                                sc.nextLine();
                                boolean checkid = true;
                                for (int i = 0; i < employeeList.size(); i++) {
                                    if (employeeList.get(i).getId() == idNew) {
                                        checkid = false;

                                    }
                                    if (checkid == true) {
                                        employeeToUpdate.setId(idNew);
                                    } else {
                                        System.out.println("Id existed.");
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("New first name:");
                                employeeToUpdate.setFirstName(sc.nextLine());
                                break;

                            case 3:
                                System.out.println("New last name:");
                                employeeToUpdate.setLastName(sc.nextLine());
                                break;

                            case 4:
                                System.out.println("New phone:");
                                employeeToUpdate.setPhone(sc.nextLine());
                                break;

                            case 5:
                                System.out.println("New email:");
                                employeeToUpdate.setEmail(sc.nextLine());
                                break;

                            case 6:
                                System.out.println("New address:");
                                employeeToUpdate.setAddress(sc.nextLine());
                                break;

                            case 7:
                                System.out.println("New DOB:");
                                employeeToUpdate.setDob(sc.nextLine());
                                break;

                            case 8:
                                System.out.println("New sex:");
                                employeeToUpdate.setSex(sc.nextLine());
                                break;
                            case 9:
                                System.out.println("New salary:");

                                employeeToUpdate.setSalary(sc.nextDouble());
                                sc.nextLine();
                                break;

                            case 10:
                                System.out.println("New agency:");
                                employeeToUpdate.setAgency(sc.nextLine());
                                break;

                            default:
                                System.out.println("Not an option!");
                                break;

                        }
                        employeeList.update( mployeeToUpdate);
                        break;
                    }

                case 3:
                    System.out.println("Enter id of the employee you want to remove: ");
                    int idToRemove = sc.nextInt();
                    sc.nextLine();

                    employeeList.remove(idToRemove);
                    break;
                case 4:
                    System.out.println("Enter name of the employee you want to search: ");
                    String search = sc.nextLine().toLowerCase();
                    employeeList.searchByName(search);
                    break;
                case 5:
                    employeeList.sortBySalary();
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Not an option!");
            }
        } while (choice != 6);
    }

    static int generateId() {
        return employeeId++;
    }

}
