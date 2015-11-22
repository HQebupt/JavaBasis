package org.hq.java.lesson5;

public class BookComparable extends Book implements Comparable<Book> {

    public BookComparable(double price) {
        super(price);
    }

    @Override
    public int compareTo(Book o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price == o.price) {
            return 0;
        } else {
            return -1;
        }
    }

}
