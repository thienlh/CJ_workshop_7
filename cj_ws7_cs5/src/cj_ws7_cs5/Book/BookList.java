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

/**
 *
 * @author thienlh
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class BookList extends Vector<Book> {

    Scanner sc = new Scanner(System.in);
    //  Constructor

    public BookList() {
        super();
    }
    //  Add new Book to the list

    public void add() {
        String newTitle;
        int newPrice;
        boolean duplicated = false;

        //  Enter new title and price
        System.out.print("-----> Enter name of the book : ");
        newTitle = sc.nextLine().toUpperCase();
        System.out.print("-----> Enter price of the book: $");
        newPrice = Integer.parseInt(sc.nextLine());

        this.add(new Book(newTitle, newPrice));
        System.out.println("\n#      The book [" + newTitle + "] has been added!\n");
    }
    //  Print the Book list

    public void print() {
        int L = this.size();
        if (L == 0) {
            System.out.println("\n                      THE LIST IS EMPTY!\n");
        } else {
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("                          BOOK LIST");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                    TITLE                         |      PRICE");
            System.out.println("-------------------------------------------------------------------");
            for (Book b : this) {
                System.out.println(b);
            }
            System.out.println();
        }
    }
    //  Load data from file

    public void loadDataFromFile(String fileName) {
        try {
            File f = new File(fileName);
            int count = 0;
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String detail;  //  Detail of a line

            while ((detail = br.readLine()) != null) {
                //  Split detail -> elements
                StringTokenizer stk = new StringTokenizer(detail, ",");
                String title = stk.nextToken().toUpperCase();
                int price = Integer.parseInt(stk.nextToken());
                //  Create a book using constructor
                Book b = new Book(title, price);
                //  Addsing book to the list
                this.add(b);
                count++;
            }
            System.out.println("\n#      "+count+" book(s) have been loaded from file!\n");
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("\n#      There are a problem while reading file!\n");
        }
    }
//  Save to file

    public void saveDataToFile(String fileName) {
        if (this.size() == 0) {
            System.out.println("\n                      THE LIST IS EMPTY!\n");
            return;
        }
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (Book b : this) {
                pw.println(b.getTitle() + "," + b.getPrice());
            }

            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("\n#      There are a problem while writing to file. Nothing changed!\n");
        }
    }
}
