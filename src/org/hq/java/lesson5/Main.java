package org.hq.java.lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 无排序的Book
        HashSet<BookWithoutComp> hSet =
            new HashSet<BookWithoutComp>();
        BookWithoutComp book1 = new BookWithoutComp(3d);
        BookWithoutComp book2 = new BookWithoutComp(4d);
        BookWithoutComp book3 = new BookWithoutComp(5d);
        BookWithoutComp book4 = new BookWithoutComp(1d);
        BookWithoutComp book5 = new BookWithoutComp(2d);
        hSet.add(book1);
        hSet.add(book2);
        hSet.add(book3);
        hSet.add(book4);
        hSet.add(book5);
        System.out.println("HashSet存储无差别的Book：");
        for (BookWithoutComp book : hSet) {
            System.out.print(book.price + " ");
        }

        // 可排序的Book
        TreeSet<BookComparable> tSet = new TreeSet<BookComparable>();
        BookComparable bk1 = new BookComparable(5d);
        BookComparable bk2 = new BookComparable(2d);
        BookComparable bk3 = new BookComparable(3d);
        BookComparable bk4 = new BookComparable(1d);
        BookComparable bk5 = new BookComparable(4d);
        tSet.add(bk1);
        tSet.add(bk2);
        tSet.add(bk3);
        tSet.add(bk4);
        tSet.add(bk5);
        System.out.println("\n\nTreeSet存储可比较的Book：");
        for (BookComparable book : tSet) {
            System.out.print(book.price + " ");
        }

        // 无排序的Book + 比较器 ==> 可排序
        List<BookWithoutComp> books = new ArrayList<BookWithoutComp>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        System.out.println("\n\n排序前，数组：" + books);
        Collections.sort(books, new BookCompartor());
        System.out.println("排序后，数组：" + books);
    }
}
