/*
 * File name: Menu.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 7 (cj_workshop_7)
 * Date     : Mar 28 2014
 */
package cj_ws7_cs3.Employee;

import java.util.Formatter;

/**
 *
 * @author thienlh
 */
public class Employee implements Comparable {

    String id;
    String name;
    int salary;

    public Employee(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    //  toString() overriding

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        return f.format(" %-8s | %-41s | %c%9d", getId(), getName(), '$', getSalary()).toString();
    }

    public int compareTo(Object o) {
        return this.getId().compareTo(((Employee) (o)).getId());
    }
}
