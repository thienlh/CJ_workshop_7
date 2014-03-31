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

import java.util.Scanner;
import java.util.Vector;

public class Menu extends Vector<String> {

    public Menu() {
        super();
    }
    //  Get user choice

    public int getUserChoice() {
        int L = this.size();
        for (int i = 0; i < L; i++) {
            System.out.println("*   " + (i + 1) + "\t" + this.get(i));
        }
        System.out.println("*******************************************************************");
        System.out.print("-----> Please choose an option: ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
