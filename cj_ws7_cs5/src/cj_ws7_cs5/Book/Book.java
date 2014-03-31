/*
 * File name: Menu.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 7 (cj_workshop_7)
 * Date     : Mar 28 2014
 */
package cj_ws7_cs5.Book;

import java.io.Serializable;
import java.util.Formatter;

/**
 *
 * @author thienlh
 */
public class Book implements Serializable {

    String title;
    int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString()   {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        return f.format("  %-47s | %c%12d", getTitle(), '$', getPrice()).toString();
    }
}
