/*
 * File name: Menu.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 7 (cj_workshop_7)
 * Date     : Mar 28 2014
 */
package cj_ws7_cs3;

import cj_ws7_cs3.Employee.EmpList;
import java.util.Scanner;

/**
 *
 * @author thienlh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String contine = "y"; //  Prompt user for continue or quit program
        boolean changed = false;    //  The data have changed yet?
        String fileName = "employee.dat";
        String confirm = "n";

        Menu menu = new Menu();
        menu.add("Add new employee.                                         *");
        menu.add("Remove an employee.                                       *");
        menu.add("Promote an employee.                                      *");
        menu.add("Employee list.                                            *");
        menu.add("Save data to file.                                        *");
        menu.add("Quit.                                                     *");
        int userChoice = 0;
        EmpList list = new EmpList();
        //  Load data from file
        list.loadDataFromFile(fileName);

        do {
            do {
                System.out.println("*******************************************************************");
                System.out.println("*                       EMPLOYEE MAGAGER                          *");
                System.out.println("*******************************************************************");
                try {
                    userChoice = menu.getUserChoice();
                } catch (Exception ex) {
                    System.out.println("\n---------------------------WRONG INPUT!----------------------------\n\t+ Option must be an integer number!\n");
                    userChoice = 7;
                }
                switch (userChoice) {
                    case 1:
                        try {
                            list.add();
                            changed = true;
                        } catch (Exception ex) {
                            System.out.println("\n---------------------------WRONG INPUT!----------------------------\n\t+ Salary must be integer value!\n\t+ Adding failed!\n");
                        }
                        break;
                    case 2:
                        list.remove();
                        changed = true;
                        break;
                    case 3:
                        try {
                            list.promote();
                            changed = true;
                        } catch (Exception ex) {
                            System.out.println("\n---------------------------WRONG INPUT-----------------------------\n\t+ Salary must be integer value!\n\t+ Promote failed!\n");
                        }
                        break;
                    case 4:
                        list.print();
                        break;
                    case 5:
                        do {
                            System.out.print("-----> Do you want to SAVE? (Y/n): ");
                            Scanner sc = new Scanner(System.in);
                            confirm = sc.nextLine();
                        } while (contine.equals(""));
                        if (confirm.substring(0, 1).equalsIgnoreCase("y")) {
                            list.saveDataToFile(fileName);
                            changed = false;
                            System.out.println("\n#      Changes is saved to file!\n");
                        }
                        break;
                }
            } while (userChoice >= 1 && userChoice < 6);
            do {
                System.out.print("-----> Do you want to QUIT? (Y/n): ");
                Scanner sc = new Scanner(System.in);
                contine = sc.nextLine();
            } while (contine.equals(""));
        } while (contine.substring(0, 1).equalsIgnoreCase("n"));
        System.out.println("\n--------------------HAVE A NICE DAY. GOODBYE!----------------------");
    }
}
