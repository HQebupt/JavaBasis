package org.hq.java.lesson5;

import java.util.Comparator;

public class BookCompartor implements Comparator<BookWithoutComp> {

    @Override
    public int compare(BookWithoutComp o1, BookWithoutComp o2) {
        if (o1.price > o2.price) {
            return 1;
        } else if (o1.price == o2.price) {
            return 0;
        } else {
            return -1;
        }
    }


}
