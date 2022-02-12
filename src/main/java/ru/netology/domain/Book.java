package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int price, String auyhor) {
        super(id, name, price);
        this.author = auyhor;
    }

    public String getAuyhor() {
        return author;
    }

    public void setAuyhor(String auyhor) {
        this.author = auyhor;
    }
}
