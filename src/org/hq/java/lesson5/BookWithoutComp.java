package org.hq.java.lesson5;

public class BookWithoutComp extends Book {

    public BookWithoutComp(double price) {
        super(price);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "" + this.price;
    }

}
